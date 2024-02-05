import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BinaryTreeFrame extends JFrame implements ActionListener {
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 480;
	private JButton add, delete;
	private JTextField text;
	private BinaryTree tree;
	
	public BinaryTreeFrame(String framename) {
		
		super(framename);
		tree= GraphicBinaryTreeRunner.tree;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		BinaryTreePanel p = new BinaryTreePanel();
		add(p);
		p.setLayout(null);
		
		add = new JButton("ADD");
        p.add(add);
        delete = new JButton("DELETE");
        p.add(delete);
		text = new JTextField("");
		p.add(text);
		
		setVisible(true);
		add.setBounds(10, 10, 100, 25);
        delete.setBounds(125, 10, 100, 25);
        text.setBounds(10, 50, 100, 25);
		
		add.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e){ 
		            	String x = text.getText();
		            	BinaryNode a = new BinaryNode(x);
		                tree.add(a);
		                System.out.println("a");
		            } 
		            
		        }); 
		
		delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ 
            	String x = text.getText();
            	BinaryNode a = new BinaryNode(x);
                tree.remove(a.getValue());
                System.out.println("d");
            } 
            
        }); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
