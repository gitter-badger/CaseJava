package com.yhd.union.init_data;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by luohao4 on 2015/12/11.
 */
public class GenerateUUSQL {

    /***
     * 表头如下：渠道名,TrackU,帐号类型
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(InitConf.getRes("uuid.csv")));
        java.util.List<String[]> data = reader.readAll();
        String sql = "select %s seq, %s id, id rid, audit_process ap from union_db.union_user_info where id = ";
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
            if ("0".equals(data.get(i)[1])) {
                sqlMerge.append(String.format("select %s seq, %s id, '' rid, '' ap", data.get(i)[0], data.get(i)[1]) + " from union_db.union_user_info where id = 771 /** " + (data.get(i)[0]) + " **/");
            } else {
                sqlMerge.append(String.format(sql, data.get(i)[0], data.get(i)[1]) + data.get(i)[1] + " /** " + (data.get(i)[0]) + " **/");
            }
            sqlFile = new File(InitConf.getRes("uu/" + j + ".sql"));
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
