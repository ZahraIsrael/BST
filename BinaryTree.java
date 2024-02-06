import java.util.LinkedList;
import java.util.Queue;
@SuppressWarnings("unchecked")
public class BinaryTree{
    private BinaryNode root;
    
    public BinaryTree(){
        root = null;
    }

	public BinaryNode getRoot() {
    	return root;
    }
    
    public void add(BinaryNode a){
        if(root==null){
            root=a;
            return;
        }
        add(root, a);
    }
    
    private void add(BinaryNode parent, BinaryNode a){
        if(parent==null)return;
        if(a.getValue().compareTo(parent.getValue()) < 0){
            if(parent.left() == null){
                parent.setLeft(a);
            }else{
                add(parent.left(), a);
            }
            
        }else if(a.getValue().compareTo(parent.getValue()) > 0){
            if(parent.right()==null){
                parent.setRight(a);
            }else{
                add(parent.right(), a);
            }
        }
    }
    
    public String inOrder(){
        return inOrder(root).trim();
    }
    
    private String inOrder(BinaryNode parent){
        String temp="";
        if(parent!=null){
            temp+= inOrder(parent.left());
            temp+=parent.getValue()+" ";
            temp+= inOrder(parent.right());
        }
        return temp;
    }
    
    public String toString() {
    	return inOrder();
    }
    
    public String levelOrder() {
    	String temp = "";
    	Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		BinaryNode k = queue.poll();
    		temp+= k.getValue()+ " ";
    		if(k.left()!=null) {
    			queue.offer(k.left());
    		}
    		if(k.right()!= null) {
    			queue.offer(k.right());
    		}
    	}
    	return temp.trim();
    }
    
    public String preOrder(){
        return preOrder(root).trim();
    }
    
    private String preOrder(BinaryNode parent){
        String temp="";
        if(parent!=null){
            temp+= parent.getValue() +" ";
            temp+= preOrder(parent.left());
            temp+= preOrder(parent.right());
        }
        return temp;
    }
    
    public String postOrder(){
       return postOrder(root).trim();
    }
    
    private String postOrder(BinaryNode parent){
        String temp="";
        if(parent!= null){
            temp+= postOrder(parent.right());
            temp+= postOrder(parent.left());
            temp+= parent.getValue()+" ";
        }
        return temp;
    }
    
    public String reverse(){
        return reverse(root).trim();
    }
    
    private String reverse(BinaryNode parent){
        String temp= "";
        if(parent!= null){
            temp+= postOrder(parent.right());
            temp+= parent.getValue()+" ";
            temp+= postOrder(parent.left());
        }
        return temp;
    }
    
    public BinaryNode remove(Comparable target) {
    	if(root==null)return null;
    	BinaryNode temp = root;
    	BinaryNode successor;
    	if(root.getValue().equals(target)) {
    		if(root.left()==null&& root.right()==null) {
    			root=null;
    			return temp;
    		}else if(root.left()==null) {
    			root=(root.right());
    			temp.setRight(null);
    			return temp;
    		}else if(root.right()==null) {
    			root=root.left();
    			temp.setLeft(null);
    			return temp;
    		}else {
    			successor = inOrderSuccessor(root);
    			swap(root, successor);
    			if(root.right()==successor) {
    				root.setRight(successor.right());
    				successor.setRight(null);
    				return successor;
    			}
    			return remove(root.right(), target);
    		}
    	}
    	return remove(temp, target);
    }
    
    private BinaryNode remove(BinaryNode startNode, Comparable target) {
    	BinaryNode remove, successor;
    	BinaryNode parent = search(startNode, target);
    	if(parent==null)return null;
    	Boolean isLeft= parent.left()!=null&& parent.left().getValue().equals(target);
    	remove= parent.left()!=null ? parent.left(): parent.right();
    	if(remove.left()==null && remove.right()==null) {
    		if(isLeft) {
    			parent.setLeft(null);
    		}else {
    			parent.setRight(null);
    		}
    		return remove;
    	}else if(remove.left()==null) {
    		if(isLeft) {
    			parent.setLeft(remove.right());
    		}else {
    			parent.setRight(remove.right());
    		}
    		remove.setRight(null);
    		return remove;
    	}else if(remove.right()==null) {
    		if(isLeft) {
    			parent.setLeft(remove.left());
    		}else {
    			parent.setRight(remove.left());
    		}
    		remove.setLeft(null);
    		return remove;
    	}else {
    		successor= inOrderSuccessor(remove);
    		swap(successor, remove);
    		if(successor.right()==successor) {
    			remove.setRight(successor.right());
    			successor.setRight(null);
    			return successor;
    		}
    	}
    	return remove(remove.right(), target);
    }
    
    private BinaryNode inOrderSuccessor(BinaryNode x) {
    	BinaryNode temp = x.right();
    	while(temp.left()!=null) {
    		temp.setLeft(temp.left());
    	}
    	return temp;
    }
    
    private void swap(BinaryNode x, BinaryNode y) {
    	BinaryNode temp = x;
    	x=y;
    	y=temp;
    }
    
    public BinaryNode search(BinaryNode parent, Comparable target) {
    	if(parent==null)return null;
    	if(parent.left()!=null && parent.left()==(target)|| parent.right()!=null && parent.right()==(target)) {
    		return parent;
    	}else if(target.compareTo(parent.getValue())<0) {
    		return search(parent.left(), target);
    	}else {
    		return search(parent.right(), target);
    	}
    }
}
