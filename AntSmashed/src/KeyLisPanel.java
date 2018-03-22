import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.*;

public class KeyLisPanel extends JPanel {
	int mouseX,mouseY,radious;
        double timer=0;
        
    int antY = 40, ant1=-50,ant2=600,ant3=-50, ant4=600,ant5=-50; // cartoon initial position
	//String Score="";
	int sx1=0, sy1=0, sx2=50, sy2; // for moving image
      //  ImageIcon icon = new ImageIcon(image);  
	//JLabel imageLabel = new JLabel(icon);
        // imageLabel.setSize(image.getWidth(null);
       //  image.getHeight(null));
        String s="0"; 
        int a=0;
        Graphics g;
	JTextField txtfield,time,txtfield2;
	BufferedImage buffImage, buffAntAlive1,buffAntAlive2,buffAntDie;
	String path, aliveAntPath,aliveAnt_rotated_Path,dieAntPath;
	public KeyLisPanel() {   
            txtfield=new JTextField(8);
            time=new JTextField(8);
            txtfield2=new JTextField(8);
             FlowLayout flow=new FlowLayout();
            JLabel scoreLabel = new JLabel("Score: ");
            JLabel tLabel = new JLabel("Time: ");
            JLabel scoreLabel1 = new JLabel("Missed: ");
            this.add(scoreLabel);
            this.add(txtfield);
            this.add(tLabel);
            this.add(time);
           this.add(scoreLabel1);
           this.add(txtfield2);
            time.setEditable(false);
            txtfield.setEditable(false);
            txtfield2.setEditable(false);
           

                s = String.valueOf(a);
                txtfield.setText(s);                      
		this.mouseX=this.mouseY;
		this.path = "/image/back.jpg";
		this.aliveAntPath = "/image/phpRotated.png";
                this.aliveAnt_rotated_Path = "/image/rcvRotated.png";
                this.dieAntPath = "/image/dieant.PNG";
		try {
			buffImage = ImageIO.read(getClass().getResource(this.path));
			
			sx1=buffImage.getHeight();
			sy1= buffImage.getWidth();
			
			 buffAntAlive1 = ImageIO.read(getClass().getResource(this.aliveAntPath));
                         buffAntAlive2 = ImageIO.read(getClass().getResource(this.aliveAnt_rotated_Path));
                          buffAntDie = ImageIO.read(getClass().getResource(this.dieAntPath));
		} catch (IOException e) {			
			System.out.println("Can not load Image");
			e.printStackTrace();			
		}
		//addLisToPanel();
//		this.setFocusable(true);
//        this.requestFocusInWindow();
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void mousePressed(MouseEvent e) {
                            mouseX = e.getX();
				mouseY = e.getY();
                                
				System.out.println("x="+mouseX);
				System.out.println("y="+mouseY);
                                
                                
				if(mouseX>=ant1 &&mouseX <=ant1+50 && mouseY>= antY && mouseY<=antY+40){
					ant1=-50;
                                         s = String.valueOf(++a);
                                         txtfield.setText(s);          
				}
				else if(mouseX>=ant3 &&mouseX <=ant3+50 &&  mouseY>= antY+120 && mouseY<=antY+160){
					ant3=-50;
                                         s = String.valueOf(++a);
                                         txtfield.setText(s);
				}
				else if(mouseX>=ant5 &&mouseX <=ant5+50 &&  mouseY>= antY+240 && mouseY<=antY+280){
					ant5=-50;
                                         s = String.valueOf(++a);
                                         txtfield.setText(s);
				}
				else if(mouseX>=ant2 &&mouseX <=ant2+50 && mouseY>=antY+60 && mouseY<=antY+100){
					ant2=600;
                                         s = String.valueOf(++a);
                                         txtfield.setText(s);
				}
                                else if(mouseX>=ant4 &&mouseX <=ant4+50 &&mouseY>=antY+180 && mouseY<=antY+220){
					ant4=600;
                                         s = String.valueOf(++a);
                                         txtfield.setText(s);
				}
////				mouseX +=5;
////				if(radious<5){
////					radious+=5;
////				}else if(radious >=5){
////					radious -=5;
////				}
//				
		repaint();
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void mouseClicked(MouseEvent e) {	
                         
//				
		
//				
//            
//            
           }   
	} );   
			}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffImage,0, 30, this.getWidth(), this.getHeight(), null);
		//g.drawImage(buffImage, 5, 5, this.getWidth() - 5, this.getHeight() - 5, null);
                //g.drawImage(buffAntDie, x, y, 40, 50, null);
		g.drawImage(buffAntAlive1, ant1,antY, 50, 40, null);
                g.drawImage(buffAntAlive2, ant2,antY+60, 50, 40, null);
                g.drawImage(buffAntAlive1, ant3,antY+120, 50, 40, null);
                g.drawImage(buffAntAlive2, ant4,antY+180, 50, 40, null);
                g.drawImage(buffAntAlive1, ant5,antY+240, 50, 40, null);
		System.out.println("image draw");
//                if(mouseX>=ant1 &&mouseX <=ant1+50 && mouseY>= antY && mouseY<=antY+40){
//                   g.drawImage(buffAntDie, ant1,antY, 50, 40, null);
//                }
		}
}