


public class BinaryNode<AnyType> {
    int bal; // para almacenar el valor del equilibro del nodo
    AnyType element;
    BinaryNode<AnyType> left;
    BinaryNode<AnyType> right;
    int stock;
    
    
    public BinaryNode (AnyType element , int stock){
        this.element = element;
        this.stock = stock;
        left = right = null;
    }


    public BinaryNode(AnyType theElement, int stock, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
       element = theElement;
       left = lt;
       right = rt;
       this.stock = stock; 
    }
    
    public int getStock(){
        return stock;
    }

    public AnyType getElement(){
        return element;
    }
    

    public BinaryNode<AnyType> getLeft(){
        return left;
    }
    

    public BinaryNode<AnyType> getRight(){
        return right;
    }


    public void setElement(AnyType x){
        element = x;
    }


    public void setLeft(BinaryNode<AnyType> t){
        left = t;
    }


    public void setRight(BinaryNode<AnyType> r){
        right = r;
    }



    public static <AnyType> int size(BinaryNode<AnyType> t){
        if( t==null )
            return 0;
        else
            return 1 + size(t.left) + size(t.right);
    }


    public static <AnyType> int height (BinaryNode<AnyType> t){
        if( t == null)
            return -1;
        else
            return 1 + Math.max(height(t.left),height(t.right));
    }


    public BinaryNode<AnyType> duplicate(){
        BinaryNode<AnyType> root = new BinaryNode<AnyType> ( element, stock ,null, null);
        
        if(left != null) // If there's a left subtree
            root.left = left.duplicate(); // Duplicate, attach
        if(right != null) // If there's a right subtree
            root.right = right.duplicate(); // Duplicate; aatach
        return root; // Return resulting tree
    }


    public void printPreOrder(){
        System.out.println(element); // Node
        if(left != null ){
            left.printPreOrder();  // left
        }
        if( right != null ){
            right.printPreOrder();  // Right
       }
    }

    //Print tree rooted at current node using postorder traversal
    public void printPostOrder(){
        if(left != null) // left
            left.printPostOrder();
        if( right != null) // Right
            right.printPostOrder();
        System.out.println(element); // Node
    }
    
    public void printInOrder(){
        if( left != null){ // left
            left.printInOrder();  
        }
        System.out.println(element + "\t" + stock); // Node
        if( right != null){
            right.printInOrder(); // Right
        } 
    }    
}
