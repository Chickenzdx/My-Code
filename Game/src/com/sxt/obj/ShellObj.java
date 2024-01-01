package com.sxt.obj;

import com.sxt.GamePanel;
import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class ShellObj extends GameObj{

	public ShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame,char direction) {
		super(img, width, height, x, y, speed, frame,direction);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		if(direction=='s')
			y+=speed;
		else if(direction=='w')
			y-=speed;
		else if(direction=='a')
			x-=speed;
		else if(direction=='d')
			x+=speed;

		if(y<0){
			GameUtils.removeList.add(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
