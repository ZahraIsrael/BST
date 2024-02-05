import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.awt.event.MouseEvent;
import java.util.Queue;

public class BinaryTreePanel extends JPanel implements MouseListener {
	private BinaryTree tree;
	private Queue<BinaryNode> lo;
	
	public BinaryTreePanel() {
		tree= GraphicBinaryTreeRunner.tree;
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		//1200x480
		int x = 600;
		int y = 20;
		g.setColor(Color.BLUE);
		int space = 100;
		drawTree(g, tree.getRoot(), x, y, space);
	}
	
	public void drawTree(Graphics g, BinaryNode n, int x, int y, int space) {
		if(n!=null) {
			g.drawString(n.getValue()+"", x, y);
		}
		
		int left= x-space;
		int right= x+space;
		int newY = y+90;
		
		if(n.left()!= null) {
			g.drawLine(x, y, left,  newY);
			drawTree(g, n.left(), left, newY, space/2);
		}
		if(n.right()!= null) {
			g.drawLine(x, y, right, newY);
			drawTree(g, n.right(), right, newY, space/2);
		}
		
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
	}
	
}
