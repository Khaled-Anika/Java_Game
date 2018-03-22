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
public class KeyLisPanel extends JPanel {
	int mouseX,mouseY;
    int antX = 14, antUpY1=-50,antUpY2=-50,antUpY3=-50, antDwnY1=600,antDwnY2=600; // cartoon initial position
	
	int sx1=0, sy1=0, sx2=50, sy2; // for moving image
	//int sTemp;
	JPanel jPanel;
	
	
	BufferedImage buffImage, buffAntAlive1,buffAntAlive2,buffAntDie;
	String path, aliveAntPath,aliveAnt_rotated_Path,dieAntPath;
	public KeyLisPanel() {
		this.setLocation(20, 25);
		this.setSize(350,575);
		this.mouseX=this.mouseY=50;
		this.path = "/image/back.jpg";
		this.aliveAntPath = "/image/antalive.png";
                this.aliveAnt_rotated_Path = "/image/antalive.png";
                this.dieAntPath = "/image/dieant.PNG";
		try {
			buffImage = ImageIO.read(getClass().getResource(this.path));
			
			buffImage.getWidth();
			sy2= buffImage.getHeight();
			
			 buffAntAlive1 = ImageIO.read(getClass().getResource(this.aliveAntPath));
                         buffAntAlive2 = ImageIO.read(getClass().getResource(this.aliveAnt_rotated_Path));
                          buffAntDie = ImageIO.read(getClass().getResource(this.dieAntPath));
		} catch (IOException e) {			
			System.out.println("Can not load Image");
			e.printStackTrace();			
		}
		
		//addLisToPanel();
		this.setFocusable(true);
        this.requestFocusInWindow();
		
this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
//				System.out.println(e.getX());
//				System.out.println(e.getY());
//				x= e.getX(); y = e.getY();
//				repaint();
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
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
             System.out.println("mouse clicked");
    
				
				mouseX = e.getX();
				mouseY = e.getY();
				System.out.println("x="+mouseX);
				System.out.println("y="+mouseY);
			
				if((mouseX>=antX &&mouseX <=antX+40) && (mouseY<=antUpY1+40 && mouseY>=antUpY1-30)){
					antUpY1=-50;
				}
				else if((mouseX>=antX+140 &&mouseX <=antX+180) && (mouseY<=antUpY2+40 && mouseY>=antUpY2-30)){
					antUpY2=-50;
				}
				else if((mouseX>=antX+280 &&mouseX <=antX+320) && (mouseY<=antUpY3+40 && mouseY>=antUpY3-30)){
					antUpY3=-50;
				}
				else if((mouseX>=antX+70 &&mouseX <=antX+110 && mouseY<=antDwnY1+40 && mouseY>=antDwnY1-30)){
					antDwnY1=600;
				}
				else if((mouseX>=antX+210 &&mouseX <=antX+250) && (mouseY<=antDwnY2+40 && mouseY>=antDwnY2-30)){
					antDwnY2=600;
				}
				
				//x +=5;
//				if(radious<5){
//					radious+=5;
//				}else if(radious >=5){
//					radious -=5;
//				}
				
				repaint();          
            }   
	} );   
			}
		

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(buffImage,0, 30, this.getWidth(), this.getHeight(), sx1, sy1, sx2, sy2, null);
		//g.drawImage(buffImage, 5, 5, this.getWidth() - 20, this.getHeight() - 5, null);
              //  g.drawImage(buffAntDie, x, y, 40, 50, null);
		        g.drawImage(buffAntAlive1, antX, antUpY1, 40, 50, null);
//                g.drawImage(buffAntAlive2, antX+70, antDwnY1, 40, 50, null);
//                g.drawImage(buffAntAlive1, antX+140, antUpY2, 40, 50, null);
//                g.drawImage(buffAntAlive2, antX+210,antDwnY2, 40, 50, null);
//                g.drawImage(buffAntAlive1, antX+280,antUpY3, 40, 50, null);
		System.out.println("image draw");
		
	}

}
    
//}
