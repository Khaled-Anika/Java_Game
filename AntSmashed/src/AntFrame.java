
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
        JLabel lvl;
        int score=0;
    KeyLisPanel keyLisPanel;
	JMenuBar bar;
	JMenu file;
	JMenuItem play,pause,exit;
	//public int i,mouseX,mouseY;
	int i=0;
	JLabel lblFirst;
	JTextField txtScore;
	int bool=0;
	int play1=0;
        double time=0;
        boolean newrun=true;
	int j=0;
	
	public AntFrame() {
		//this.mouseX=this.mouseY=50;
		rand = new Random();
		
		//JTextField txtScore=new JTextField(12);
                JLabel time=new JLabel();
                
                
                this.add(time);
              
		//this.setLayout(null);
		//this.setLocation(0, 10);
		//this.add(txtScore);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
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
                                                newrun=false;
                                                keyLisPanel.timer+=System.currentTimeMillis()-time;
                                                
						while(bool==0){
                                                    keyLisPanel.txtfield2.setText(Integer.toString(j));
                                                    keyLisPanel.time.setText(Double.toString((System.currentTimeMillis()-keyLisPanel.timer)/1000));
                                                    if((int)((System.currentTimeMillis()-keyLisPanel.timer)/1000)==60||j==5)
                                                    {
                                                      keyLisPanel.timer=System.currentTimeMillis();
                                                      JOptionPane.showMessageDialog(rootPane, "Game Over\n Score: "+keyLisPanel.a);
                                                      bool=1;
                                                      dispose();
                                                      
                                                      AntFrame tabFrame = new AntFrame();
		                                      tabFrame.setVisible(true);
                                                    }
                                                    
							if(keyLisPanel.ant1<600){
							i=rand.nextInt()%10;
							if(i>2){
							keyLisPanel.ant1 +=i;
                                                        if (keyLisPanel.antY == 40)
                                                        {
                                                            keyLisPanel.antY+=15;
                                                        }
                                                        else keyLisPanel.antY-=15;
                                                        
							}
							else keyLisPanel.ant1 +=5;
							}
							else {keyLisPanel.ant1=-50;j++;}
							// System.out.println("random="+i) ;
							
							if(keyLisPanel.ant3<600){
							i=rand.nextInt()%10;
							if(i>2){
							keyLisPanel.ant3 +=i;
							}
							else keyLisPanel.ant3 +=5;
							}
							else {keyLisPanel.ant3=-50;j++;}
							
							if(keyLisPanel.ant5<600){
							i=rand.nextInt()%10;
							if(i>2){
							keyLisPanel.ant5 +=i;
							}
							else keyLisPanel.ant5 +=5;
							}
							else {keyLisPanel.ant5=-50;j++;}
							
							if(keyLisPanel.ant2>-50){
							i=rand.nextInt()%10;
							if(i>2){
							keyLisPanel.ant2 -=i;
							}
							else keyLisPanel.ant2-=5;
							}
                                                        else { keyLisPanel.ant2=600;j++;}
							
							if(keyLisPanel.ant4>-50){
							i=rand.nextInt()%10;
							if(i>2){
							keyLisPanel.ant4 -=i;
							}
							else keyLisPanel.ant4-=5;
							}
							else {keyLisPanel.ant4=600;j++;}
							
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
                                                        System.out.println(j);
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
                                               if(newrun)
                                                    return;
						bool=1;
						play1--;
                                                 
                                                time=System.currentTimeMillis();
                                                
					}
				}  );
				t1.start();
	
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
