package com.sxt;

import com.sxt.obj.*;
import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//This class is the main game panel that extends from JPanel.
//I read the code and watched the open source author's very detailed instructional videos.
//I took a small part of what I wanted and then deleted the rest.
//Below I'll explain what I took from the open source code and what I changed
//Open source code come from  https://b23.tv/Q1ztbpG
public class GamePanel extends JPanel {
	GameWin win;
	// Game state variable.(Directly copy from the open source code)
	public static int state = 1;
	//Background object, plane object, and other variables.(Directly copy from the open source code)
	//Among these variables, I have removed some variables from the open source code base
	//Like LittleBoss1、LittleBoss2、BossObj and WaringObj
	BgObj bgObj;
	Image offScreenImage = null;
	PlaneObj planeObj;
	int count=1;
	public static int planeindex=0;
	public static int score=0;
	//Constructor the game panel.(Directly copy from the open source code)
	public GamePanel(GameWin win) {
		this.setVisible(true);
		this.setSize(800, 800);
		// Initialize background and plane(I mean character, I directly copy the name from the open source code).
		bgObj = new BgObj(GameUtils.bdImg, 0, -1800, 2);
		planeObj = new PlaneObj(GameUtils.planeImg, 37, 41, 350, 550, 0, win);
		// Add objects to the game object list.
		GameUtils.gameObjList.add(bgObj);
		GameUtils.gameObjList.add(planeObj);
		planeindex=GameUtils.gameObjList.indexOf(planeObj);



	}
	// Override the paint method.(Directly copy from the open source code)
	//Initial elements such as backgrounds, explosions
	//planes, bosses and prompt text to start the game were removed from the open source code，
	//Draw elements and text from the start of the game directly on gImage
	//Small change in if() condition
	@Override
	public void paint(Graphics g) {
		// Check if offScreenImage is null and create it.
		if (offScreenImage == null) {
			offScreenImage = createImage(800, 800);
		}
		// Create graphics for the off-screen image.
		Graphics gImage = offScreenImage.getGraphics();
		gImage.fillRect(0, 0, 800, 800);
		// Check the game state
		if (state == 1||state==2) {

			// Render game objects and display level and enemy information.
			for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
				GameUtils.gameObjList.get(i).paintSelf(gImage);
			}
			GameUtils.gameObjList.removeAll(GameUtils.removeList);
			count++;
			GameUtils.drawWord(gImage,"Level:"+state,Color.GRAY,40,30,100);
			GameUtils.drawWord(gImage,"Enemy Remain:"+(GameUtils.enemyNum-score),Color.GRAY,40,30,140);
		}
		if(state==3){
			// Game over
			state=5;
			gImage.drawImage(GameUtils.bdImg,0,0,null);
			GameUtils.drawWord(gImage,"Game Over",Color.RED,30,300,300);
			int option = JOptionPane.showConfirmDialog(win, "Game Over! Do you want to restart?", "Game Over", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				changeLevel(1);
			} else {
				System.exit(0);
			}
		}
		if(state==4){
			// Game clear state.
			state=5;
			gImage.drawImage(GameUtils.bdImg,0,0,null);
			GameUtils.drawWord(gImage,"Game Clear!",Color.GREEN,30,300,300);
			int option = JOptionPane.showConfirmDialog(win, "Game Clear! Do you want to restart?", "Game Clear", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				changeLevel(1);
			} else {
				System.exit(0);
			}
		}
		// Draw the off-screen image on the main graphics.

		g.drawImage(offScreenImage, 0, 0, null);
	}
	// Method to create game objects.(Directly copy from the open source code)
	//Cancel all different level of bullets
	//I create only one kind of bullets and controls the direction according to planeObj.getDirection()
	void createObj() {
		// Create shell objects for shooting.
		if (count % 15 == 0) {
			GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, 14, 29, planeObj.getX(), planeObj.getY(), 5, win,planeObj.getDirection()));
			GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
		}
		// Create enemy objects and their bullets.
		if (count % 15 == 0) {
			if(count%60==0)
				GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg4, 24, 32, (int) ((Math.random() * 10) * 80), 0, 3, win,'s'));
			// Additional cases for different enemy types and directions.
			else if(count%60==15)
				GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg3, 24, 32, (int) ((Math.random() * 10) * 80), 800, 3, win,'w'));
			else if(count%60==30)
				GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg2, 32, 24, 0, (int) ((Math.random() * 10) * 80), 3, win,'d'));
			else if(count%60==45)
				GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg, 32, 24, 800,(int) ((Math.random() * 10) * 80), 3, win,'a'));

			GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() - 1));
			// Create enemy bullets based on enemy positions.
			if(GameUtils.enemyObjList.size()>0&&state==2){
				int x=(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1)).getX();
				int y=(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1)).getY();
				char direction=(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1)).getDirection();
				GameUtils.enemyBulletObjList.add(new EnemyBulletObj(GameUtils.enemybulletImg,14,25,x,y,5,win,direction));
				GameUtils.gameObjList.add(GameUtils.enemyBulletObjList.get(GameUtils.enemyBulletObjList.size()-1));
			}
		}

	}
	// Method to change the game level.(I made some changes here)
	public static void changeLevel(int level) {
		state=level;
		score=0;
		// Clear lists and remove objects for a clean start.
		GameUtils.removeList.addAll(GameUtils.shellObjList);
		GameUtils.shellObjList.clear();
		GameUtils.removeList.addAll(GameUtils.enemyBulletObjList);
		GameUtils.enemyBulletObjList.clear();
		GameUtils.removeList.addAll(GameUtils.enemyObjList);
		GameUtils.enemyObjList.clear();
		GameUtils.gameObjList.removeAll(GameUtils.removeList);
		GameUtils.removeList.clear();

	}

}