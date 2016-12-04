package com.tank.client;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.net.www.content.audio.x_aiff;

public class Bullet extends JLabel{
	String orientation;
	public Bullet(int x,int y,String orientation){
		this.setIcon(new ImageIcon("img/tankmissile.gif"));
		this.setLocation(x, y);
		this.setSize(85,45);
		this.orientation=orientation;
	}
	public void moveBullet(int w,int h)throws Exception{
		Point p=this.getLocation();
		switch (orientation) {
		case "up":
			if(p.y+30<=0)
				throw new Exception();
			p.translate(0, -5);
			break;
		case "down":
			if(p.y-30>=h)
				throw new Exception();
			p.translate(0, +5);
			break;
		case "left":
			if(p.x+30<=0)
				throw new Exception();
			p.translate(-5, 0);
			break;
		case "right":
			if(p.x-30>=w)
				throw new Exception();
			p.translate(+5, 0);
			break;
		default:
			break;
		}
		this.setLocation(p);
	}
}
