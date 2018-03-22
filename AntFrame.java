
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AntFrame extends JFrame{
	Random rand;
    KeyLisPanel keyLisPanel;
	JMenuBar bar;
	JMenu file;
	JMenuItem play,pause,exit;
     //   DrawPanel_Smash draw;
	int i,x,y;
	
	public AntFrame() {
		rand = new Random();
		this.setSize(350, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)	;		
		this.setResizable(false);
		this.keyLisPanel = new KeyLisPanel();
               // this.draw = new DrawPanel_Smash();
		
		this.add(this.keyLisPanel);
		
		addMenuToFrame();
		
	
	}

	private void addMenuToFrame() {
		this.bar = new JMenuBar(); 
                this.file = new JMenu("Menu");
		this.play = new JMenuItem("Play");
                this.exit = new JMenuItem("Exit");
		this.setJMenuBar(this.bar);
		
		this.bar.add(this.file);
		this.file.add(this.play);
                this.file.add(this.exit);
		
		this.play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Thread t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						while(true){
							if(keyLisPanel.antUpY1<600){
							i=rand.nextInt()%10;
							if(i>5){
							keyLisPanel.antUpY1 +=i;
							}
							else keyLisPanel.antUpY1 +=5;
							}
							else keyLisPanel.antUpY1=-50;
							 System.out.println("random="+i) ;
							
							if(keyLisPanel.antUpY2<600){
							i=rand.nextInt()%10;
							if(i>5){
							keyLisPanel.antUpY2 +=i;
							}
							else keyLisPanel.antUpY2 +=5;
							}
							else keyLisPanel.antUpY2=-50;
							
							if(keyLisPanel.antUpY3<600){
							i=rand.nextInt()%10;
							if(i>5){
							keyLisPanel.antUpY3 +=i;
							}
							else keyLisPanel.antUpY3 +=5;
							}
							else keyLisPanel.antUpY3=-50;
							
							if(keyLisPanel.antDwnY1>-50){
							i=rand.nextInt()%10;
							if(i>5){
							keyLisPanel.antDwnY1 -=i;
							}
							else keyLisPanel.antDwnY1 -=5;
							}
							else keyLisPanel.antDwnY1=600;
							
							if(keyLisPanel.antDwnY2>-50){
							i=rand.nextInt()%10;
							if(i>5){
							keyLisPanel.antDwnY2 -=i;
							}
							else keyLisPanel.antDwnY2 -=5;
							}
							else keyLisPanel.antDwnY2=600;
							
							 
                           // System.out.println("random="+i) ;                            //keyLisPanel.x +=1;
							//keyLisPanel. +=5;
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
		});
                
                   this.exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Thread t = new Thread(new Runnable() {
                            public void run(){
                                System.exit(0);
                            }
                        });
                        t.start();
                    }
                });
    
        }                       
}                    
                           
                           
                           
                            

