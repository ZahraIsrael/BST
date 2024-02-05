public class BinaryNode{
    private BinaryNode left, right;
    private Comparable value;
    
    public BinaryNode(String c){
        value = c;
    }
    
    public BinaryNode left(){
        return left;
    }
    
    public BinaryNode right(){
        return right;
    }
    
    public void setLeft(BinaryNode l){
        left = l;
    }
    
    public void setRight(BinaryNode r){
        right = r;
    }
    
    public Comparable getValue(){
        return value;
    }
    
    public String toString(){
        return "Value:" + value + ", Left:" + (left==null?null: left.value) + ", Right:" + (right==null?null:right.value); 
    }

}