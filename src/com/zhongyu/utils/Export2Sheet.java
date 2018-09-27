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
	private static String projectUri = "D:\\svn\\JDTest\\JD_Z32_Test\\JDPF_Q4B3C_Test\\JDPF_Q4B3C_ABC_TestSuites";
	private static String oUri = "D:\\sheet.txt";
  
	public static void main(String[] args){
		File iFile = new File(projectUri);
		File oFile = new File(oUri );
		try {
			new Export2Sheet().readFile(iFile, oFile);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String category;
	
	private void readFile(File iFile, File oFile) throws IOException{
		if (iFile.isDirectory()) {
			File[] fileList = iFile.listFiles();
			for (File file : fileList) {
				new Export2Sheet().readFile(file, oFile);
			}
		}else if (iFile.isFile() && iFile.getName().endsWith(".java")) {
			export(iFile, oFile);
		}else{
			return;
		}
	}
	
	private void export(File iFile, File oFile) throws IOException{
		StringBuffer msg = new StringBuffer();

		boolean isAuthor = false;
		boolean isTestCase = false;
		boolean isDate = false;
		
        PrintWriter ps = new PrintWriter(new OutputStreamWriter(new FileOutputStream(oFile.getAbsolutePath(), true), "utf8"));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(iFile.getAbsolutePath()), "gbk"));
        
        String line = br.readLine();
        while (line != null) {
        	if(line.contains("@Author")){        
        		line = line.substring(line.indexOf("@Author") + 7);
        		msg.append(line).append("\t");
        		isAuthor = true;
        		System.out.println(line);
        	}else if(line.contains("@TestCase")){
        		if(!isAuthor) msg.append("\t");
        		line = line.substring(line.indexOf("@TestCase") + 9);
        		msg.append(line).append("\t");
        		isAuthor = true;
        		isTestCase = true;
        		System.out.println(line);
        	}else if(line.contains("@Data")){
        		if(!isAuthor) msg.append("\t");
        		if(!isTestCase) msg.append("\t");
        		line = line.substring(line.indexOf("@Data") + 5);
        		msg.append(line).append("\t");
        		isAuthor = true;
        		isTestCase = true;
        		isDate = true;
        		System.out.println(line);
        	}
        	else if(line.contains("@SuppressWarnings")){
        		msg.append("\n");
        		isAuthor = false;
        		isTestCase = false;
        		isDate = false;
        		break;
        	}
        	line = br.readLine();
        }
        ps.write(msg.toString());
        br.close();
        ps.flush();
        ps.close();
	}

}
