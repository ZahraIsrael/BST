import java.util.Scanner;
import javax.swing.*;
public class GraphicBinaryTreeRunner {
	public static BinaryTree tree;
	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		tree = new BinaryTree();
		String input = "32 45 67 12 23 98 76 56";
		String[] list = input.split(" ");
		for(String k:list)
		{
			BinaryNode temp = new BinaryNode(k);
			tree.add(temp);
		}
		BinaryTreeFrame frame = new BinaryTreeFrame("name");
		System.out.println(tree.levelOrder());
}
}
