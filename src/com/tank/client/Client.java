package com.tank.client;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class Client extends JFrame implements KeyListener{
	JPanel panel = new JPanel();
	JPanel gamearea = new JPanel();
	JPanel tankpanel =  new JPanel();//坦克+名字放在一个panel中
	JLabel myname = new JLabel("name");//坦克下方的名字
	JLabel mytank = new JLabel(new ImageIcon("img/enemy3U.gif"));//我的坦克图像
	
	private int tankspeed=6; //坦克移动速度
	private String orientation="up";//坦克当先朝向
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("\u5766\u514B\u5927\u6218");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 600);
		setSize(600, 600);
		getContentPane().setLayout(null);
		
		setLocationRelativeTo(null);//窗口居中显示
		

		panel.setBorder(new TitledBorder(null, "\u6E38\u620F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setForeground(Color.RED);
		panel.setBounds(398, 0, 189, 552);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbcount_1 = new JLabel("\u6E38\u620F\u4EBA\u6570");
		lbcount_1.setBounds(15, 30, 80, 20);
		panel.add(lbcount_1);
		
		JLabel lbcount_2 = new JLabel("\u51FB\u8D25\u4EBA\u6570");
		lbcount_2.setBounds(15, 70, 80, 20);
		panel.add(lbcount_2);
		
		JLabel name = new JLabel("\u6211");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.BLUE);
		name.setFont(new Font("微软雅黑", Font.BOLD, 22));
		name.setBounds(15, 115, 160, 30);
		panel.add(name);
		
		JLabel lbcount_3 = new JLabel("\u4F60\u7684\u79EF\u5206");
		lbcount_3.setBounds(15, 174, 80, 20);
		panel.add(lbcount_3);
		
		JLabel lbcount_4 = new JLabel("50");
		lbcount_4.setForeground(Color.GREEN);
		lbcount_4.setFont(new Font("宋体", Font.PLAIN, 45));
		lbcount_4.setBounds(15, 207, 80, 80);
		panel.add(lbcount_4);
		
		JLabel lb_hp = new JLabel("HP:");
		lb_hp.setForeground(Color.RED);
		lb_hp.setFont(new Font("宋体", Font.PLAIN, 20));
		lb_hp.setBounds(15, 317, 80, 30);
		panel.add(lb_hp);
		
		JProgressBar hpbar = new JProgressBar();
		hpbar.setToolTipText("HP");
		hpbar.setBounds(15, 371, 160, 30);
		panel.add(hpbar);
		
		JButton btnagain = new JButton("\u91CD\u65B0\u5F00\u59CB");
		btnagain.setToolTipText("\u5F00\u59CB\u6E38\u620F");
		btnagain.setBounds(15, 485, 113, 27);
		panel.add(btnagain);
		
		JButton btnstart = new JButton("\u5F00\u59CB\u6E38\u620F");
		btnstart.setBounds(15, 525, 113, 27);
		panel.add(btnstart);
		gamearea.setBorder(new LineBorder(Color.BLUE));
		

		gamearea.setBounds(15, 15, 380, 540);
		getContentPane().add(gamearea);
		gamearea.setLayout(null);
		
		this.addKeyListener(this);
		btnagain.addKeyListener(this);
		btnstart.addKeyListener(this);
		

		tankpanel.setBounds(180, 200, 35, 34);
		gamearea.add(tankpanel);
		tankpanel.setLayout(null);
		myname.setBounds(0, 10, 34, 15);
		tankpanel.add(myname);
		myname.setHorizontalAlignment(SwingConstants.CENTER);
		myname.setForeground(Color.RED);
		mytank.setBounds(0, 0, 35,34 );
		tankpanel.add(mytank);
		//随机设置坦克位置
		int tank_x=(int)(Math.random()*328);
		int tank_y=(int)(Math.random()*511);
		tankpanel.setLocation(tank_x, tank_y);
		//设置背景颜色
		gamearea.setBackground(Color.black);
		//开始子弹线程
		new ThreadBullet().start();
	}

	
	

	//是否出线
	public void outline(String d)throws Exception{
		Point player_1=tankpanel.getLocation();
		switch (d) {
		case "w":
			if(player_1.y<5)
				throw new Exception();
			break;
		case "a":
			if(player_1.x<5)
				throw new Exception();
			break;
		case "s":
			if(player_1.y>511)
				throw new Exception();
			break;
		case "d":
			if(player_1.x>328)
				throw new Exception();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			
			Point tankloc=tankpanel.getLocation();
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				mytank.setIcon(new ImageIcon("img/enemy3U.gif"));
				outline("w");
				tankloc.translate(0, -tankspeed);
				orientation="up";
				break;
			case KeyEvent.VK_A:
				mytank.setIcon(new ImageIcon("img/enemy3L.gif"));
				outline("a");
				tankloc.translate(-tankspeed, 0);
				orientation="left";
				break;
			case KeyEvent.VK_S:
				mytank.setIcon(new ImageIcon("img/enemy3D.gif"));
				outline("s");
				tankloc.translate(0, tankspeed);
				orientation="down";
				break;
			case KeyEvent.VK_D:
				mytank.setIcon(new ImageIcon("img/enemy3R.gif"));
				outline("d");
				tankloc.translate(tankspeed, 0);
				orientation="right";
				break;
			case KeyEvent.VK_J:
				switch (orientation) {
				case "up":
					Bullet bullet_1=new Bullet(tankloc.x+8, tankloc.y-32,"up");
					bullets.add(bullet_1);
					gamearea.add(bullet_1);
					gamearea.updateUI();
					break;
				case "down":
					Bullet bullet_2=new Bullet(tankloc.x+8, tankloc.y+20,"down");
					bullets.add(bullet_2);
					gamearea.add(bullet_2);
					gamearea.updateUI();
					break;
				case "left":
					Bullet bullet_3=new Bullet(tankloc.x-15, tankloc.y-3,"left");
					bullets.add(bullet_3);
					gamearea.add(bullet_3);
					gamearea.updateUI();
					break;
				case "right":
					Bullet bullet_4=new Bullet(tankloc.x+35, tankloc.y-6,"right");
					bullets.add(bullet_4);
					gamearea.add(bullet_4);
					gamearea.updateUI();
					break;
				default:
					break;
				}
			default:
				break;
			}
			tankpanel.setLocation(tankloc.x, tankloc.y);
		} catch (Exception e2) {
		}
	}
	Vector<Bullet> bullets=new Vector<Bullet>();
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	/**
	 * 子弹的位置移动
	 * @author Administrator
	 *
	 */
	class ThreadBullet extends Thread{
		public void run() {
			while (true) {
				Vector<Bullet> bullet1 = (Vector<Bullet>) bullets.clone();
				for (Bullet bullet : bullet1) {
					try {
						bullet.moveBullet(380, 540);
					} catch (Exception e) {
						bullets.remove(bullet);
						gamearea.remove(bullet);
					}
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


