package com.sxt.obj;

import com.sxt.GamePanel;
import com.sxt.GameWin;

import java.awt.*;

public class GameObj {
	Image img;
	int width;
	int height;
	int x;
	int y;
	double speed;
	char direction;
	GameWin frame;

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public char getDirection() {
		return direction;
	}
	

	public GameObj(Image img, int width, int height, int x, int y, double speed, GameWin frame,char direction) {
		this.img = img;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.frame = frame;
		this.direction=direction;
	}

	public GameObj(Image img, int x, int y, double speed) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public void paintSelf(Graphics g){
		g.drawImage(img,x,y,null);
	}
	public Rectangle getRec(){
		return new Rectangle(x,y,width,height);
	}

}
