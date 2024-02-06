import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.awt.event.MouseEvent;
import java.util.Queue;

public class BinaryTreePanel extends JPanel {
	
	public BinaryTreePanel() {
		System.out.println("hello world");
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		BinaryTree tree = BinaryTreeFrame.tree;
		//System.out.println("x");
		
		int space = 100;
		
		int x = 600;
		int y = 20;
		
		drawTree(g, tree.getRoot(), x, y, space);
		
	}
	
	public void drawTree(Graphics g, BinaryNode n, int x, int y, int space) {
		//System.out.println(1);
		if(n!=null) {
			g.drawString(n.getValue()+"", x, y);
		
		
		int left= x-space;
		int right= x+space;
		int newY = y+90;
		g.setColor(Color.BLUE);
		
		if(n.left()!= null) {
			g.drawLine(x, y, left,  newY);
			drawTree(g, n.left(), left, newY, space/2);
		}
		if(n.right()!= null) {
			g.drawLine(x, y, right, newY);
			drawTree(g, n.right(), right, newY, space/2);
		}
	}
		
	}
	
	
	
}
