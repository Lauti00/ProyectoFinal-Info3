public class BinaryNode<AnyType> {
    int bal; // para almacenar el valor del equilibro del nodo
    AnyType element;
    BinaryNode<AnyType> left;
    BinaryNode<AnyType> right;
    int stock;
    
    
    public BinaryNode (AnyType element , int stock){ // Constructor utilizado por el usuario
        this.element = element;
        this.stock = stock;
        left = right = null;
    }


    public BinaryNode(AnyType theElement, int stock, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
       element = theElement;
       left = lt;
       right = rt;
       this.stock = stock; // Constructor 2 utilizado por el programa
    }
    
    public int getStock(){ // Devuelve stock
        return stock;
    }

    public AnyType getElement(){ // Devuelve el elemento
        return element;
    }
    

    public BinaryNode<AnyType> getLeft(){ // Devuelve el nodo izquierdo
        return left;
    }
    

    public BinaryNode<AnyType> getRight(){ // Devuelve el nodo derecho
        return right;
    }


    public void setElement(AnyType x){ // Setea el elemento
        element = x;
    }


    public void setLeft(BinaryNode<AnyType> t){ // Setea el nodo izquierdo
        left = t;
    }


    public void setRight(BinaryNode<AnyType> r){ // Setea el nodo derecho
        right = r;
    }



    public static <AnyType> int size(BinaryNode<AnyType> t){ // Devuelve el tamaño 
        if( t==null )
            return 0;
        else
            return 1 + size(t.left) + size(t.right);
    }


    public static <AnyType> int height (BinaryNode<AnyType> t){ // Devuelve altura
        if( t == null)
            return -1;
        else
            return 1 + Math.max(height(t.left),height(t.right));
    }


    public BinaryNode<AnyType> duplicate(){ // Si llega a haber un duplicado
        BinaryNode<AnyType> root = new BinaryNode<AnyType> ( element, stock ,null, null);
        
        if(left != null) // If there's a left subtree
            root.left = left.duplicate(); // Duplicate, attach
        if(right != null) // If there's a right subtree
            root.right = right.duplicate(); // Duplicate; aatach
        return root; // Return resulting tree
    }
    public QueueList<String> setInventory(QueueList<String>queue){
        
        if( left != null){ // left
            left.setInventory(queue);  
        }

        queue.enqueue((String) element, stock); // Node
        if( right != null){
            right.setInventory(queue); // Right
        }
        return queue; 
    }   
    // Esta funcion realiza la insercion de los elementos en orden y los inserta en la cola

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
