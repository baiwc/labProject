package com.wc.util;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * 这是一个监听器类，实现了ActionListener接口
 * 
 * @author lzj
 * 
 */
public class BallListener implements java.awt.event.ActionListener,
		MouseListener {
	Random rand = new Random();
	BallFrame bf;
	private int x, y;
	MyArrayList<BallThread> al = new MyArrayList<BallThread>();

	// 重写构造方法
	public BallListener(BallFrame bf) {
		this.bf = bf;
	}

	// 重写监听器的事件处理方法
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("创建")) {
			System.out.println("=======================" + str);
			BallThread ball = new BallThread(rand.nextInt(700),//随机的圆心的位置 x,y
					rand.nextInt(700), 20, 8, 8, bf, al);//40表示球的直径
			ball.start();
			al.add(ball);
		} else if (str.equals("启动")) {
			for (int i = 0; i < al.size(); i++) {
				BallThread ball = al.get(i);
				ball.stateFlag = false;
			}

		} else if (str.equals("暂停")) {
			for (int i = 0; i < al.size(); i++) {
				BallThread ball = al.get(i);
				ball.stateFlag = true;
			}

		} else if (str.equals("删除")) {
			BallThread ball = al.get(al.size()-1);
			al.delete(al.size()-1);
			ball.flag = true;
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// x = e.getX();
		// y = e.getY();
		// for (int i = 0; i < al.size(); i++) {
		// int ox = al.get(i).getX() + al.get(i).getSize() / 2;
		// int oy = al.get(i).getY() + al.get(i).getSize() / 2;
		// System.out.println("delete");
		// if (Math.sqrt(Math.abs(x-ox) * Math.abs(x - ox) + Math.abs(y - oy) *
		// Math.abs(y - oy)) <= al.get(
		// i).getSize() / 2) {
		// al.delete(i);
		// al.get(i).flag = true;
		// }
		// }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
