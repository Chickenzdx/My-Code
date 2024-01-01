package com.sxt.obj;

import com.sxt.GamePanel;
import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlaneObj extends GameObj{

	public PlaneObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame,'w');
		
		this.frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
		        if (e.getKeyChar() == 'w') {
		        	if(PlaneObj.super.y>=40)
		        		PlaneObj.super.y-=20;
		        	PlaneObj.super.setImg(GameUtils.planeImg);
					PlaneObj.super.direction=e.getKeyChar();
		        } else if (e.getKeyChar() == 'a') {
		        	if(PlaneObj.super.x>=20)
		        		PlaneObj.super.x-=20;
		        	PlaneObj.super.setImg(GameUtils.planeImg3);
					PlaneObj.super.direction=e.getKeyChar();
		        } else if (e.getKeyChar() == 's') {
		        	if(PlaneObj.super.y<=800-height-20)
		        		PlaneObj.super.y+=20;
		        	PlaneObj.super.setImg(GameUtils.planeImg2);
					PlaneObj.super.direction=e.getKeyChar();
		        } else if (e.getKeyChar() == 'd') {
		        	if(PlaneObj.super.x<=800-width-20)
		        		PlaneObj.super.x+=20;
		        	PlaneObj.super.setImg(GameUtils.planeImg4);
					PlaneObj.super.direction=e.getKeyChar();
		        }
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		});
	}
	
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		for(int i=0;i<GameUtils.enemyObjList.size();i++){
			EnemyObj enemy1Obj=GameUtils.enemyObjList.get(i);
			if(this.getRec().intersects(enemy1Obj.getRec())){
				enemy1Obj.setX(-100);
				enemy1Obj.setY(-100);
				this.x=350;
				this.y=550;
				GameUtils.removeList.add(enemy1Obj);
				GamePanel.changeLevel(3);
			}
		}
		for(int i=0;i<GameUtils.enemyBulletObjList.size();i++){
			EnemyBulletObj enemy2BulletObj=GameUtils.enemyBulletObjList.get(i);
			if(this.getRec().intersects(enemy2BulletObj.getRec())){
				enemy2BulletObj.setX(-100);
				enemy2BulletObj.setY(-100);
				this.x=350;
				this.y=550;
				GameUtils.removeList.add(enemy2BulletObj);
				GamePanel.changeLevel(3);
			}
		}
		


	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
