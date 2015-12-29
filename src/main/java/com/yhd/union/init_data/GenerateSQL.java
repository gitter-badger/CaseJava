package com.yhd.union.init_data;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by luohao4 on 2015/12/11.
 */
public class GenerateSQL {

    /***
     * 表头如下：渠道名,TrackU,帐号类型
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(InitConf.getRes("ids.csv")));
        java.util.List<String[]> data = reader.readAll();
        String sql = "select %s, track_u, to_char(last_login_time, 'YYYY-MM-DD HH24:MI:ss') last_login_time,union_user_info_id, audit_process, is_enable from user_data2.alliance_user_info where track_u = ";
        File sqlFile;
        FileWriter writer = null;
        StringBuffer sqlMerge = new StringBuffer();
        for (int i = 1, j = 1; i < data.size(); i++) {
            if (i % 199 == 0) {
                String queryParams = sqlMerge.toString();
                sqlMerge = new StringBuffer();
                writer.write(queryParams.trim());
                writer.flush();
                j++;
            }
            if (sqlMerge.length() > 0) {
                sqlMerge.append("\r\n" + " union \r\n");
            }
            sqlMerge.append(String.format(sql, i + 1) + data.get(i)[0] + " /** " + (i + 1) + "**/");
            sqlFile = new File(InitConf.getRes("qq/" + j + ".sql"));
            if (!sqlFile.exists()) {
                sqlFile.createNewFile();
                writer = new FileWriter(sqlFile);
                writer.flush();
            }
        }
        String queryParams = sqlMerge.toString();
        writer.write(queryParams.trim());
        writer.flush();
    }

}
