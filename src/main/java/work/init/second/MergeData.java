package work.init.second;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by luohao4 on 2015/12/11.
 */
public class MergeData {

    /***
     * 表头如下：渠道名,TrackU,帐号类型
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        File results = new File(InitConf.getRes("/qq/result"));
        if (!results.exists()) {
            return;
        }
        CSVReader reader;
        List<String[]> rows = new ArrayList<String[]>();
        for (File file : results.listFiles()) {
            reader = new CSVReader(new FileReader(file));
            for (String[] strings : reader.readAll()) {
                String track = StringUtils.trim(strings[0]);
                if (StringUtils.isEmpty(track)) {
                    continue;
                }
                rows.add(new String[]{
                        strings[0],
                        strings[1],
                        strings[2],
                        emptyToZero(strings[3]),
                        auditProcess(strings[4]),
                        isEnable(strings[5]),
                });
            }
        }
        CSVWriter writer = new CSVWriter(new FileWriter(InitConf.getRes("/result2.csv")));
        writer.writeAll(rows);
        writer.flush();
    }

    private static String auditProcess(String code) {
        if(null == code || "null".equals(code)){
            return "";
        }
        if ("0".equals(code)) {
            return "资料待完善";
        }
        if ("1".equals(code)) {
            return "待审核";
        }
        if ("2".equals(code) || "3".equals(code)) {
            return "审核中";
        }
        if ("100".equals(code)) {
            return "审核通过";
        }
        if ("101".equals(code)) {
            return "合规通过";
        }
        if ("200".equals(code)) {
            return "审核驳回";
        }
        if ("201".equals(code)) {
            return "合规驳回";
        }
        return code;
    }

    private static String isEnable(String code) {
        if (null == code || "null".equals(code) || "0".equals(code)) {
            return "帐号已停用";
        } else {
            return "帐号可用";
        }
    }

    private static String emptyToZero(String code) {
        if (null == code || "null".equals(code)) {
            return "0";
        }
        return code;
    }

}
