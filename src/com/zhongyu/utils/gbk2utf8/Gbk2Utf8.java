package com.zhongyu.utils.gbk2utf8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 
 * @author ZYHU
 *
 */

public class Gbk2Utf8 {
 
    public static void main(String[] args) {
    	//需要转码的GBK格式文件夹
        File f1 = new File("D:/src");
        //转码成UTF-8的目标文件夹
        File f2 = new File("D:/src2");
        try {
            new Gbk2Utf8().copyFile(f1, f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private String type = ".java";
     
    private void copyFile(File f1, File f2) throws FileNotFoundException, IOException {
        if(f1.isDirectory()) {
            f2.mkdir();
            File[] fs = f1 .listFiles();
            for (File subF : fs) {
                //递归遍历目录
                copyFile(subF, new File(f2, subF.getName()));
            }
        } else if (f1.isFile() && f1.getName().endsWith(type )) {
            //对java文件进行转码
        	parse2Utf8(f1, f2);
        } else {
            //对非java文件直接复制
            copyData(f1, f2);
        }
    }
     
    /**
     * 
     * @param f1 父文件
     * @param f2 复制出的子文件
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void copyData(File f1, File f2) throws FileNotFoundException, IOException{
         
        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2, false);
         
        byte[] bytes = new byte[1024];
        int temp = 0;
        while (-1 != (temp = fis.read(bytes))) {
            fos.write(bytes, 0, temp);
        }
         
        fos.flush();
         
        if(null != fis) {
            fis.close();
        }
        if(null != fos) {
            fos.close();
        }
    }
     
    /**
     * 该方法引用 杰克思勒(Jacksile)的文章：Eclipse修改编码后乱码解决之后作了小修改
     * 原码地址 https://www.cnblogs.com/tufujie/p/5137564.html
     * 
     * @author Internet
     * 
     */
    private void parse2Utf8(File file, File destFile) throws IOException {
        StringBuffer msg = new StringBuffer();
        // 读写对象
        PrintWriter ps = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destFile.getAbsolutePath(), false), "utf8"));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "gbk"));
 
        // 读写动作
        String line = br.readLine();
        while (line != null) {
            msg.append(line).append("\r\n");
            line = br.readLine();
        }
        ps.write(msg.toString());
        br.close();
        ps.flush();
        ps.close();
    }
}