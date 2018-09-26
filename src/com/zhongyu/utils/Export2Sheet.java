package com.zhongyu.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Export2Sheet {
	private static String iUri = "D:\\T_JKPF_API_DisplayICON_Normal_01.java";
	private static String oUri = "D:\\sheet.txt";

	public static void main(String[] args){
		File iFile = new File(iUri);
		File oFile = new File(oUri );
		try {
			new Export2Sheet().export(iFile, oFile);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void export(File iFile, File oFile) throws IOException{
		StringBuffer msg = new StringBuffer();

        PrintWriter ps = new PrintWriter(new OutputStreamWriter(new FileOutputStream(oFile.getAbsolutePath(), false), "utf8"));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(iFile.getAbsolutePath()), "gbk"));
        
        String line = br.readLine();
        while (line != null) {
        	
        	if(line.contains("@")){
        		msg.append(line).append("\r\n");
        		System.out.println(line);
        	}
            line = br.readLine();
        }
        ps.write(msg.toString());
        br.close();
        ps.flush();
        ps.close();
	}

}
