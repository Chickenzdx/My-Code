package com.sxt.obj;

import com.sxt.GamePanel;
import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj{

	public EnemyObj(Image img, int width, int height, int x, int y, double speed, GameWin frame,char direction) {
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
		for(int i=0;i<GameUtils.shellObjList.size();i++){
			ShellObj shellObj =GameUtils.shellObjList.get(i);
			if(this.getRec().intersects(shellObj.getRec())){
				shellObj.setX(-100);
				shellObj.setY(-100);
				this.setX(-200);
				this.setY(-200);
				GameUtils.removeList.add(shellObj);
				GameUtils.removeList.add(this);
				GamePanel.score+=1;
				if(GamePanel.score==GameUtils.enemyNum) {
					if(GamePanel.state==1) {
						GamePanel.changeLevel(2);
					}
					else if(GamePanel.state==2) {
						GamePanel.changeLevel(4);
					}
				}
			}
		}

		if(this.y>800){
			GameUtils.removeList.add(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}


}
