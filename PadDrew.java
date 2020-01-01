package paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;


	public class PadDrew extends JComponent{
		Image image;
	Graphics2D graphics2D;
	String fonts;
	int x2, y2, x1, y1,w,h,xx1,yy1,i=0,size=8;
	MouseMotionAdapter mouse;
	MouseAdapter mouseA;
	public PadDrew(){
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();

			}
		};

		mouse=new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
					for(int c=0;c<=(i/2);c++){
						graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
						graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
					}
				repaint();
				x1 = x2;
				y1 = y2;
			}

		};
		addMouseMotionListener(mouse);
		addMouseListener(mouseA);

	}
	public void paintComponent(Graphics g){
		if(image == null){
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
	}
	
	public void eraser(){
		graphics2D.setPaint(Color.white);
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();

			}
		};

		mouse=new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
					for(int c=0;c<=12;c++){
						graphics2D.setPaint(Color.white);
						graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
						graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
						graphics2D.setPaint(Color.black);
					}
				repaint();
				x1 = x2;
				y1 = y2;
			}

		};
		addMouseMotionListener(mouse);
		addMouseListener(mouseA);
		
		i=0;
	}
	
	public void sizeLine(int l){
		switch(l){
			case 1:
				i=0;
				break;
			case 2:
				i=2;
				break;
			case 3:
				i=4;
				break;
			case 4:
				i=6;
				break;
		}
	}
	
	public void oval(){
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
		public void mousePressed(MouseEvent e){
			x1 = e.getX();
			y1 = e.getY();
		}
		public void mouseDragged(MouseEvent e){
			x2 = e.getX();
			y2 = e.getY();
		}
		public void mouseReleased(MouseEvent e){
			x2 = e.getX();
			y2 = e.getY();
			if(graphics2D != null)
			w=Math.abs(x1-x2);
			h=Math.abs(y1-y2);
			/*int r=(w+h)/2;
			int a=(((w/2)^2)+((h/2)^2))^(1/2);
			int l=((w/2)*(h/2))/a;
			l=2*l;
			l=l/3;*/
			xx1=Math.min(x1,x2);
			yy1=Math.min(y1,y2);
			/*if(x2>x1){
				if(y2>y1){
					xx1=(Math.min(x1,x2))-l;
					yy1=(Math.min(y1,y2))-l;
				}else{
					xx1=(Math.min(x1,x2))-l;
					yy1=(Math.min(y1,y2))+l;
				}
			}else{
				if(y2>y1){
					xx1=(Math.min(x1,x2))+l;
					yy1=(Math.min(y1,y2))-l;
				}else{
					xx1=(Math.min(x1,x2))+l;
					yy1=(Math.min(y1,y2))+l;
				}
			}*/
			for(int c=0;c<=(i/2);c++){
				graphics2D.drawOval(xx1+c, yy1+c,w,h);
				graphics2D.drawOval(xx1-c, yy1-c,w,h);
			}
			
			repaint();
			x1 = x2;
			y1 = y2;
		}
		};
		addMouseListener(mouseA);
		
	}
	
	public void rec(){
		repaint();
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
		public void mousePressed(MouseEvent e){
			x1 = e.getX();
			y1 = e.getY();
		}
		public void mouseDragged(MouseEvent e){
			x2 = e.getX();
			y2 = e.getY();
		}
		public void mouseReleased(MouseEvent e){
			x2 = e.getX();
			y2 = e.getY();
			if(graphics2D != null)
			w=Math.abs(x1-x2);
			h=Math.abs(y1-y2);
			xx1=Math.min(x1,x2);
			yy1=Math.min(y1,y2);
			for(int c=0;c<=(i/2);c++){
			graphics2D.drawRect(xx1+c, yy1+c, w, h);
			graphics2D.drawRect(xx1-c, yy1-c, w, h);
			}
			repaint();
			x1 = x2;
			y1 = y2;
		}
		};
		addMouseListener(mouseA);
		
	}
		public void pen(){
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
		};

		mouse=new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
					for(int c=0;c<=(i/2);c++){
						graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
						graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
					}
				repaint();
				x1 = x2;
				y1 = y2;
			}

		};
		addMouseMotionListener(mouse);
		addMouseListener(mouseA);
		
	}
		
		public void triangle(){
			removeMouseListener(mouseA);
			removeMouseMotionListener(mouse);
			mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
			}
			public void mouseReleased(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
				w=Math.abs(x1-x2);
				h=Math.abs(y1-y2);
				int a=((w^2)+(h^2))^(1/2);
				for(int c=0;c<=(i/2);c++){
					if(x2<x1){
						graphics2D.drawPolygon(new int[]{x1+c,x2+c,x2+a+c},new int[] {y1+c,y2+c,y2+c},3);
						graphics2D.drawPolygon(new int[]{x1-c,x2-c,x2+a-c},new int[] {y1-c,y2-c,y2-c},3);
					}else{
						graphics2D.drawPolygon(new int[]{x1+c,x2+c,x2-a+c},new int[] {y1+c,y2+c,y2+c},3);
						graphics2D.drawPolygon(new int[]{x1-c,x2-c,x2-a-c},new int[] {y1-c,y2-c,y2-c},3);
					}
				}
				repaint();
				x1 = x2;
				y1 = y2;
			}
			};
			addMouseListener(mouseA);
			
		}
		public void line(){
			removeMouseListener(mouseA);
			removeMouseMotionListener(mouse);
			mouseA=new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					x1 = e.getX();
					y1 = e.getY();
				}
				public void mouseReleased(MouseEvent e){
					x2 = e.getX();
					y2 = e.getY();
					if(graphics2D != null)
						for(int c=0;c<=(i/2);c++){
							graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
							graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
						}
					repaint();
					x1 = x2;
					y1 = y2;
				}

			};
			addMouseListener(mouseA);
			
		}
		public void ffont(String font){
			
		fonts=font;
		}
		
		public void size(int size){
			
			this.size=size;
			}
		
	public void text(String text){
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();

			}
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
			}
			public void mouseReleased(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				Font f=new Font(fonts, Font.PLAIN,size);
				graphics2D.setFont(f);
				graphics2D.drawString(text, x1,y1);
				repaint();
			}
		};
		
		x1=x2;
		y1=y2;
		addMouseListener(mouseA);
	}
	
	public void save(){
		JFileChooser chooser = new JFileChooser();
		int num = chooser.showSaveDialog(null);
		if(num==JFileChooser.APPROVE_OPTION){
		    String test = chooser.getSelectedFile() +".png";
		    File f=new File(test);
	        BufferedImage dest = new BufferedImage(1468, 1409,BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2 = dest.createGraphics();
	        g2.drawImage(image, 0, 0, null);
	        g2.dispose();
	        try {
	            ImageIO.write(dest, "jpg",f);
	        } catch(IOException e) {
	            System.out.println("Write error for " + f.getPath() +
	                               ": " + e.getMessage());
	        }
		 }
	}
	


	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
	
	
	public void red(){
		graphics2D.setPaint(Color.red);
		repaint();
	}
	
	public void gray(){
		graphics2D.setPaint(Color.gray);
		repaint();
	}
	
	public void yellow(){
		graphics2D.setPaint(Color.yellow);
		repaint();
	}
	public void orange(){
		graphics2D.setPaint(Color.orange);
		repaint();
	}
	public void black(){
		graphics2D.setPaint(Color.black);
		repaint();
	}
	
	public void white(){
		graphics2D.setPaint(Color.white);
		repaint();
	}
	
	
	public void green(){
		graphics2D.setPaint(Color.green);
		repaint();
	}
	
	public void pink(){
		graphics2D.setPaint(Color.pink);
		repaint();
	}
	
	public void cyan(){
		graphics2D.setPaint(Color.cyan);
		repaint();
	}
	public void magenta(){
		graphics2D.setPaint(Color.magenta);
		repaint();
	}
	
	public void blue(){
		graphics2D.setPaint(Color.blue);
		repaint();
	}
	
	

}

