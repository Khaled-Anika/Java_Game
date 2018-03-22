/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HASAN_pc
 */
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Time;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.glass.events.MouseEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class AntFrame extends JFrame{
	Random rand;
    KeyLisPanel keyLisPanel;
	JMenuBar bar;
	JMenu file;
	JMenuItem play,pause,exit;
	//public int i,mouseX,mouseY;
	int i;
	JLabel lblFirst;
	JTextField txtScore;
	int bool=0;
	int play1=0;
	
	
	public AntFrame() {
		//this.mouseX=this.mouseY=50;
		rand = new Random();
		
		JTextField txtScore=new JTextField(12);
		//this.setLayout(null);
		this.setLocation(0, 10);
		this.add(txtScore);
		this.setSize(350, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)	;		
		this.setResizable(false);
		this.keyLisPanel = new KeyLisPanel();
		
		this.add(this.keyLisPanel);
		addMenuToFrame();
	}

	private void addMenuToFrame() {
		
		this.bar = new JMenuBar(); 
		this.file = new JMenu("Menu");
		this.play = new JMenuItem("Play");
		this.setJMenuBar(this.bar);
		
		this.bar.add(this.file);
		this.file.add(this.play);
		
		this.pause = new JMenuItem("pause");
		this.setJMenuBar(this.bar);
		this.bar.add(this.file);
		this.file.add(this.pause);
		
		this.exit = new JMenuItem("exit");
		this.setJMenuBar(this.bar);
		this.bar.add(this.file);
		this.file.add(this.exit);
		
		this.play.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				play1++;
				if(play1==1){
				Thread t = new Thread(new Runnable() {	
					@Override
					public void run() {
						bool=0;
						while(bool==0){
							if(keyLisPanel.antUpY1<600){
							i=rand.nextInt()%5;
							if(i>2){
							keyLisPanel.antUpY1 +=i;
							}
							else keyLisPanel.antUpY1 +=2;
							}
							else keyLisPanel.antUpY1=-50;
							// System.out.println("random="+i) ;
							
							if(keyLisPanel.antUpY2<600){
							i=rand.nextInt()%5;
							if(i>2){
							keyLisPanel.antUpY2 +=i;
							}
							else keyLisPanel.antUpY2 +=2;
							}
							else keyLisPanel.antUpY2=-50;
							
							if(keyLisPanel.antUpY3<600){
							i=rand.nextInt()%5;
							if(i>2){
							keyLisPanel.antUpY3 +=i;
							}
							else keyLisPanel.antUpY3 +=2;
							}
							else keyLisPanel.antUpY3=-50;
							
							if(keyLisPanel.antDwnY1>-50){
							i=rand.nextInt()%5;
							if(i>2){
							keyLisPanel.antDwnY1 -=i;
							}
							else keyLisPanel.antDwnY1 -=2;
							}
							else keyLisPanel.antDwnY1=600;
							
							if(keyLisPanel.antDwnY2>-50){
							i=rand.nextInt()%5;
							if(i>2){
							keyLisPanel.antDwnY2 -=i;
							}
							else keyLisPanel.antDwnY2 -=2;
							}
							else keyLisPanel.antDwnY2=600;
							
							//public void wait(); 
                           // System.out.println("random="+i) ;
							//keyLisPanel.x +=1;//keyLisPanel.x +=1;
							//keyLisPanel. +=5;
							//if(keyLisPanel.antUpY1>=20)
							keyLisPanel.repaint();
							try {
								
								Thread.sleep(50);
								
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}                                    
						}
					}
                                        
				}
                                );	
				t.start();		 
				}
               	}
		});
        this.pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				Thread t1 = new Thread(new Runnable() {	
					@Override
					public void run() {
						bool=1;
						play1--;
					}
				}  );
				t1.start();
		//bool=0;
//			suspend();
//       	}
//
//			private void suspend() {
//				// TODO Auto-generated method stub
//				
		}
}); 
		
        this.exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				Thread t = new Thread(new Runnable() {
//					
//					@Override
//					public void run() {
//						System.exit(0);
//					}
//		
//				}
//                        );
//		
//		
//		t.start();
				System.exit(0);
       	}
});
	
	
	}
    
}
