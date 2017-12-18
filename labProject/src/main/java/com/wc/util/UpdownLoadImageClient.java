package com.wc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UpdownLoadImageClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.6.193",1111);
		
		if(args.length == 0){
			System.err.println("请指定一个合法的图片");
			return;
		}
		if(args[0].endsWith(".wmf") || args[0].endsWith(".jpg") || args[0].endsWith(".jpeg")||args[0].endsWith(".gif") || args[0].endsWith(".ai") || args[0].endsWith("pdg")){
			File fd = new File(args[0]);
			FileInputStream fis = new FileInputStream(fd);
			OutputStream os = s.getOutputStream();
			byte []image = new byte[1024];
			int len = 0;
			while((len=fis.read(image)) != -1){
				while(len != -1){
					os.write(image,0,len);
				}	
			}
			s.shutdownOutput();
			InputStream is = s.getInputStream();
			byte[] re = new byte[1024];
			len = is.read(re);
			System.out.println(new String(re,0,len));
			fis.close();
			os.close();
		}else{
			 System.err.println("非法的图片文件输入！");
		}
	}
	
	

}
