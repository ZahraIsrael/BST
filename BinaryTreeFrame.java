import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BinaryTreeFrame extends JFrame  {
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 480;
	public static BinaryTree tree = new BinaryTree();
	
	public BinaryTreeFrame(String framename) {
		

		super(framename);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		BinaryTreePanel p = new BinaryTreePanel();
        add(p);
		
        p.setLayout(null);
       
        
        JTextField text = new JTextField();
        p.add(text);

        JButton delete = new JButton("delete");
        
       

        JButton add = new JButton("add");
        p.add(delete);
        p.add(add);

        setVisible(true);
       
        add.setBounds(20, 10, 50, 20);
        delete.setBounds(20, 35, 50, 20);
        text.setBounds(80, 22, 50, 20);
		add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
				
                String x = text.getText();
                if(e.getSource()==add){
					if(x.length()>0)
                    tree.add(new BinaryNode(Integer.parseInt(x)));

                    text.setText("");
					p.revalidate();
                    p.repaint();
					System.out.println(tree.levelOrder());



                }
                
            }
        });
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String x = text.getText();
				

                if(e.getSource()==delete){
					if(x.length()>0)
                    tree.remove(Integer.parseInt(x));
                    text.setText("");
                    p.repaint();
                }
                
            }
        });
	}

	// @Override
	// public void actionPerformed(ActionEvent e) {
	// 	// TODO Auto-generated method stub
	// 	//throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	// }
	
}
