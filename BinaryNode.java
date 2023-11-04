public class BinaryNode {
    int bal; // para almacenar el valor del equilibro del nodo
    Producto element;
    BinaryNode left;
    BinaryNode right;
    
    
    public BinaryNode (Producto element){ // Constructor utilizado por el usuario
        this.element = element;    
        left = right = null;
    }


    public BinaryNode(Producto theElement, BinaryNode lt, BinaryNode rt){
       element = theElement;
       left = lt;
       right = rt;
       
    }
    
    public Producto getElement(){ // Devuelve el elemento
        return element;
    }

    public BinaryNode getLeft(){ // Devuelve el nodo izquierdo
        return left;
    }

    public BinaryNode getRight(){ // Devuelve el nodo derecho
        return right;
    }

    public void setElement(Producto x){ // Setea el elemento
        element = x;
    }

    public void setLeft(BinaryNode t){ // Setea el nodo izquierdo
        left = t;
    }

    public void setRight(BinaryNode r){ // Setea el nodo derecho
        right = r;
    }

    public static  int size(BinaryNode t){ // Devuelve el tamaño 
        if( t==null )
            return 0;
        else
            return 1 + size(t.left) + size(t.right);
    }

    public static  int height (BinaryNode t){ // Devuelve altura
        if( t == null)
            return -1;
        else
            return 1 + Math.max(height(t.left),height(t.right));
    }

    public BinaryNode duplicate(){ // Si llega a haber un duplicado
        BinaryNode root = new BinaryNode ( element ,null, null);
        
        if(left != null) // If there's a left subtree
            root.left = left.duplicate(); // Duplicate, attach
        if(right != null) // If there's a right subtree
            root.right = right.duplicate(); // Duplicate; aatach
        return root; // Return resulting tree
    }

    public QueueList setInventory(QueueList queue){
        
        if( left != null){ // left
            left.setInventory(queue);  
        }

        queue.enqueue(element); // Node
        if( right != null){
            right.setInventory(queue); // Right
        }
        return queue; 
    }   
    // Esta funcion realiza la insercion de los elementos en orden y los inserta en la cola

}
