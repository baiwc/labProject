package com.wc.util;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BallFrame extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BallFrame df = new BallFrame();// 創建DrawFrame對象  
	        df.iniUI();// 調用iniUI方法  
	}
	
	public void iniUI(){
		this.setSize(700,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.getContentPane().setBackground(Color.white);
		this.setLocationRelativeTo(null);
		
		FlowLayout fl = new FlowLayout();
		this.setLayout(fl);
		this.setVisible(true);
		
		JButton jbuAdd = new JButton("创建");
		JButton jbuStart = new JButton("启动");
		JButton jbuStop = new JButton("暂停");
		JButton jbuDelete = new JButton("删除");
		
		this.add(jbuStop);
		this.add(jbuStart);
		this.add(jbuAdd);
		this.add(jbuDelete);
		
		BallListener ballListener = new BallListener(this);
		jbuAdd.addActionListener(ballListener);
		jbuStart.addActionListener(ballListener);
		jbuStop.addActionListener(ballListener);
		jbuDelete.addActionListener(ballListener);
		jbuAdd.setFocusable(false);
		jbuStop.setFocusable(false);
		jbuStart.setFocusable(false);
		jbuDelete.setFocusable(false);
		this.addMouseListener(ballListener);
	}

}
