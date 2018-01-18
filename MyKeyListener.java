package Graphics3d;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    Sprites sp;
    
  public MyKeyListener(Sprites sp){
	   this.sp = sp;
   }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_D) {
			//System.out.println("D");
			sp.axis = 'y';
			sp.degrees = 10;
			sp.counter++;
//			for (int row = 0; row < sp.x.length; row++) {
//				for (int col = 0; col < sp.x[row].length; col++) {
//					sp.WCStoMCS(sp.x, sp.y, sp.z, sp.X, sp.Y, row, col);
//					sp.MCStoWCS(sp.X, sp.Y, row, col);
//				}
//			}
		}
		if (k == KeyEvent.VK_A) {
			sp.axis = 'y';
			sp.degrees = -10;
			sp.counter++;
//			for (int row = 0; row < sp.x.length; row++) {
//				for (int col = 0; col < sp.x[row].length; col++) {
//					sp.WCStoMCS(sp.x, sp.y, sp.z, sp.X, sp.Y, row, col);
//					sp.MCStoWCS(sp.X, sp.Y, row, col);
//				}
//			}
		}
		if (k == KeyEvent.VK_W) {
			sp.axis = 'x';
			sp.degrees = 10;
			sp.counter++;
//			for (int row = 0; row < sp.x.length; row++) {
//				for (int col = 0; col < sp.x[row].length; col++) {
//					sp.WCStoMCS(sp.x, sp.y, sp.z, sp.X, sp.Y, row, col);
//					sp.MCStoWCS(sp.X, sp.Y, row, col);
//				}
//			}
		}
		if (k == KeyEvent.VK_S) {
			sp.axis = 'x';
			sp.degrees = -10;
			sp.counter++;
//			for (int row = 0; row < sp.x.length; row++) {
//				for (int col = 0; col < sp.x[row].length; col++) {
//					sp.WCStoMCS(sp.x, sp.y, sp.z, sp.X, sp.Y, row, col);
//					sp.MCStoWCS(sp.X, sp.Y, row, col);
//				}
//			}
		}
		if (k == KeyEvent.VK_E) {
			sp.axis = 'z';
			sp.degrees = 10;
			sp.counter++;
//			for (int row = 0; row < sp.x.length; row++) {
//				for (int col = 0; col < sp.x[row].length; col++) {
//					sp.WCStoMCS(sp.x, sp.y, sp.z, sp.X, sp.Y, row, col);
//					sp.MCStoWCS(sp.X, sp.Y, row, col);
//				}
//			}
		}
		if (k == KeyEvent.VK_Z) {
			sp.axis = 'z';
			sp.degrees = -10;
			sp.counter++;
		
		}
		Graphic.f.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
