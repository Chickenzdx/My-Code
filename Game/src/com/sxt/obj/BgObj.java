package com.sxt.obj;

import java.awt.*;

public class BgObj extends GameObj{

	public BgObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y+=speed;
		if(y>=0){
			y=-1800;
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
