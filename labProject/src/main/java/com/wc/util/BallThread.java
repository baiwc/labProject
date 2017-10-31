package com.wc.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class BallThread extends Thread {
	
	private int x, y, size, movex, movey;

	private BallFrame bf;
	
	private Graphics graphics;
	
	boolean stateFlag = false;// 声明布尔类型的变量表示状态
	
	boolean flag = false;
	
	Random rand = new Random();
	
	MyArrayList<BallThread> al;
	
	BallThread ball;
	
	private int a = rand.nextInt(255);//返回一个大于等于0小于255的随机参数颜色参数
	
	private int b = rand.nextInt(255);
	
	private int c = rand.nextInt(255);
	
	// 重写构造方法
	public BallThread(int x, int y, int size, int movex, int movey,
			BallFrame bf, MyArrayList al) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.movex = movex;
		this.movey = movey;
		this.bf = bf;
		graphics = this.bf.getGraphics();
		this.al = al;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/*private Image img = new javax.swing.ImageIcon("images\\doge.gif")
			.getImage();*/
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// 重写run方法
	public void run() {
		while (!flag) {
			System.out.println();
			if (stateFlag) {// 若stateFlag为true，执行continue，进行空循环，不执行下面的语句；否则，执行下面的语句
				continue;
			}
			
			graphics.setColor(Color.WHITE);
			graphics.fillOval(x, y, size, size);
			// g.fillRect(x, y, size, size);
			x += movex;
			y += movey;
			graphics.setColor(new Color(a, b, c));
			graphics.fillOval(x, y, size, size);
			// g.drawImage(img, x, y, size, size, null);

			if (x > (700 - size/2) && movex > 0) {
				movex = -movex;
			}
			if (y > (700 - size/2) && movey > 0) {
				movey = -movey;
			}
			if (x < 2 && movex < 0) {
				movex = -movex;
			}
			if (y < 25 && movey < 0) {
				movey = -movey;
			}
			// 碰撞处理，比较圆心之间距离，遍历数组队列，找出当前球与其他球的圆心距离
			for (int i = 0; i < al.size(); i++) {
				ball = al.get(i);
				if (this == ball) {
					continue;
				}
				int xx = Math.abs(this.x - ball.x);
				int yy = Math.abs(this.y - ball.y);
				int xy = (int) Math.sqrt(xx * xx + yy * yy);
				int tempx = 0;
				int tempy = 0;
				//boolean changeFlag =true;
				if (xy <= (this.size / 2 + ball.size / 2 )) {//两个小球相交
					tempx = this.movex;
					tempy = this.movey;
					this.movex = ball.movex;
					this.movey = ball.movey;
					ball.movex = tempx;
					ball.movey = tempy;//两个小球的路径方向交换一下
//					changeFlag = false;

				}
			}

			try {
				Thread.sleep(100);// 休眠0.01秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
