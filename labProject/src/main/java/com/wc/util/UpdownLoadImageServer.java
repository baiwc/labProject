package com.wc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UpdownLoadImageServer implements Runnable {

	private Socket s;
	
	 public UpdownLoadImageServer(Socket s) {
		 this.s = s;
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 1;
		System.out.println(s.getInetAddress().getHostAddress()+"is connecting...");
		String ip = s.getInetAddress().getHostAddress();
		try {
			InputStream is= s.getInputStream();
			File fd = new File("F:\\pictures");
			File fp = new File(fd,ip+"time"+count+".jpg");
			if(fp.exists()){
				fp = new File(fd,ip + "time" +(count++) +".jpg");
				FileOutputStream fos = new FileOutputStream(fp);
				byte image[] = new byte[1024];
				int length = 0;
				while((length = is.read(image)) != -1){
					fos.write(image, 0, length);
				}
				OutputStream os = s.getOutputStream();
				os.write("<font color='red'> 上传成功！</font>".getBytes());
				fos.close();
				s.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(1111);
			while(true){
				Socket socket = serverSocket.accept();
				new Thread(new UpdownLoadImageServer(socket)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
