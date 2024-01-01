package com.sxt.utils;

import com.sxt.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
	public static Image bdImg= Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
	public static Image planeImg= Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
	public static Image planeImg2= Toolkit.getDefaultToolkit().getImage("imgs/plane2.png");
	public static Image planeImg3= Toolkit.getDefaultToolkit().getImage("imgs/plane3.png");
	public static Image planeImg4= Toolkit.getDefaultToolkit().getImage("imgs/plane4.png");
	public static Image shellImg= Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
	public static Image enemyImg= Toolkit.getDefaultToolkit().getImage("imgs/enemy1.png");
	public static Image enemyImg2= Toolkit.getDefaultToolkit().getImage("imgs/enemy2.png");
	public static Image enemyImg3= Toolkit.getDefaultToolkit().getImage("imgs/enemy3.png");
	public static Image enemyImg4= Toolkit.getDefaultToolkit().getImage("imgs/enemy4.png");
	public static Image enemybulletImg= Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
	public static List<ShellObj> shellObjList=new ArrayList<>();
	public static List<EnemyObj> enemyObjList=new ArrayList<>();
	public static List<EnemyBulletObj> enemyBulletObjList=new ArrayList<>();
	public static List<GameObj> gameObjList=new ArrayList<>();
	public static List<GameObj> removeList=new ArrayList<>();
	public static int enemyNum=15;

	public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
		gImage.setColor(color);
		gImage.setFont(new Font("仿宋",Font.BOLD,size));
		gImage.drawString(str,x,y);
	}


}
