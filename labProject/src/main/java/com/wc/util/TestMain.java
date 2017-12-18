package com.wc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class TestMain {

	public static void main(String[] args) throws IOException {
		/*InputStream is= TestMain.class.getClassLoader().getResourceAsStream("test.txt");
		File file = new File("F:\\pictures");
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] tt = new byte[1024];
		int b = 0;
		while((b=is.read(tt)) != -1){
			System.out.println("字符个数是:"+b);
			String str = new String(tt,"utf-8");
			System.out.println("输出字符串是:"+str);
			
		}*/
		//字符流
		/*FileWriter fw = new FileWriter("F:\\pictures\\test1.txt");
		fw.write("oqhgfklasbhgkj\n");
		fw.write("quwheiqt");
		fw.close();
		
		String filePath = "F:\\pictures\\test1.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		String line;
		line = bufferedReader.readLine();
		while(line != null){
			System.out.println(line);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();*/
		char ch;
		int data;
			FileInputStream fis = new FileInputStream(FileDescriptor.in);
			FileOutputStream fos = new FileOutputStream("F:\\pictures\\test1.txt");
			System.out.println("请输入一串字符串以#号结束\n");
			while((ch=(char)fis.read()) !='#')
				fos.write(ch);
				fis.close();
				fos.close();
				FileInputStream fi = new FileInputStream("F:\\pictures\\test1.txt");
				FileOutputStream fo = new FileOutputStream(FileDescriptor.out);
				while(fi.available() > 0){
					data = fi.read();
					fo.write(data);
				}
				fi.close();
				fo.close();
	}

}
