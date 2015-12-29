package com.yhd.union.init_data;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohao4 on 2015/12/11.
 */
public class CheckData {

    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(InitConf.getRes("vendor.csv")));
        List<String> sources = new ArrayList<String>();
        for (String[] strings : reader.readAll()) {
            sources.add(strings[1]);
        }
        reader = new CSVReader(new FileReader(InitConf.getRes("result.csv")));
        List<String> targets = new ArrayList<String>();
        for (String[] strings : reader.readAll()) {
            targets.add(strings[1]);
        }
        StringBuffer buffer = new StringBuffer();
        for (String source : sources) {
            if(targets.contains(source)){
                continue;
            }
            if(buffer.length() > 0){
                buffer.append(",\r\n");
            }
            buffer.append(source);
        }
        FileWriter writer = new FileWriter(InitConf.getRes("ss.txt"));
        writer.write(buffer.toString());
        writer.flush();
    }

}
