
import javax.management.InstanceNotFoundException;

public class BinarySearchTree 
{
    protected BinaryNode root;

    public BinarySearchTree(){ // Constructor
        root = null;
    }

    public void insert (Producto x){
        root = insert(x,root);
    }

    public void remove (Producto x){
        root = remove(x,root);
    }

    public void removeMin(){
        root = removeMin(root);
    }
    public Producto findMin(){
        return elementAt(findMin(root));
    }
    public int findStock(Producto x, int stock){
        return elementAtInt(find(x,root),stock);
    }
    public Producto find (Producto x){
        return elementAt(find(x,root));
    }
    public String findName (Producto x){
        return elementAtName(find(x,root));
    }

    public String changeStock (Producto x , int stock){
        return elementAtStock(find(x, root),stock);
    }

    public void makeEmpty(){ // Vacia el arbol binario de busqueda
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null; // Si esta vacia retorna true sino false
    }

    private String elementAtName(BinaryNode t){
        return t == null ? null : t.element.toString(); // Devuelve el elemento (Producto o String en nuestro caso)
    }

    private String elementAtStock(BinaryNode t, int stock){
        if(t==null)
            return null;
        else{
            t.element.changeStock(stock);
            return t.element.toString();
        }
    }
    
    private int elementAtInt(BinaryNode t, int stock){
        if(t==null)
            return 0;
        else{
            return t.element.getCantidad();
        }
    }

    private Producto elementAt(BinaryNode t){
        return t == null ? null : t.element; // Devuelve el elemento (Producto o String en nuestro caso)
    }

    private BinaryNode find(Producto x, BinaryNode t)
    {
        while( t != null)
        {
            if(x.getNombre().compareTo(t.element.getNombre()) < 0)
                t = t.left;
            else if(x.getNombre().compareTo(t.element.getNombre()) > 0)
                t = t.right;
            else
                return t; // Match
        }
        return null; // Not found
    }

    public QueueList setInventory(QueueList queue){
        if( root != null) root.setInventory(queue); // Llama a la funcion de la clase BinaryNode mientas root sea != null
        return queue; // Retorna la cola ya ordenada
    }


    protected BinaryNode findMin( BinaryNode t )
    {
        if ( t != null)
            while( t.left != null)
                t = t.left; // Recorre el sub-arbol izquierdo hasta encontrar el minimo (llegar a null)
        
        return t;
    }


    protected BinaryNode insert (Producto x, BinaryNode t)
    {
        if ( t == null)
            t = new BinaryNode(x);
        else if( x.getNombre().compareTo(t.element.getNombre()) < 0)
            t.left = insert(x, t.left ); // Compara con todos los nodos del arbol para poder saber donde insertar el nuevo elemento
        else if( x.getNombre().compareTo(t.element.getNombre()) > 0)
            t.right = insert ( x, t.right );
        else if(x.getNombre().compareTo(t.element.getNombre()) == 0) // Modificacion para que imprima valores repetidos
            t.left = insert(x,t.left);       //  Se puede insertar tanto en el sub-arbol izquierdo como en el derecho
        return t;
    }

    protected BinaryNode removeMin( BinaryNode t)
    {
        if ( t == null){ // No puede ser null por lo que arroja error
            try {
                throw new InstanceNotFoundException();
            } catch (InstanceNotFoundException e) {
                e.printStackTrace();
            }
        } else if ( t.left != null) // Si el izquierdo es distinto de null entonces recorre todo el arbol izquierdo hasta que sea igual a null
            {
                t.left = removeMin( t.left );
                return t;
            }
            else
                return t.right; // Sino se ingreso nada en el arbol izquierdo se devuelve el elemento del arbol derecho (el primero)
        return null; // Sino encuentra nada arroja un null
    }

    protected BinaryNode remove ( Producto x, BinaryNode t)
    {
        if( t == null){ // t=null -> error (no puede ser null no existe el nodo)
            try {
                throw new Exception( x.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if( x.getNombre().compareTo( t.element.getNombre() ) < 0 ) // Recorre primero el sub-arbol izquierdo para encontrar al nodo
            t.left = remove( x, t.left); // Se llama asi misma la funcion hasta que termine el sub-arbol izquierdo
        else if( x.getNombre().compareTo( t.element.getNombre() ) > 0) // Recorre el sub-arbol derecho en busca de el nodo a remover
            t.right = remove(x, t.right); // ".."
        else if ( t.left != null && t.right != null ) // Two children (En caso que tenga dos hijos)
        {
            t.element = findMin(t.right).element;
            t.right = removeMin( t.right );
        }
        else
            t=( t.left != null) ? t.left : t.right; // Asigna t al izquierdo o derecho segun corresponda
        return t;
    }

    public int height(){ // Devuelve la altura del arbol binario de busqueda
        return BinaryNode.height(root);
    }

    public Producto getRoot(){ // Devuelve la raiz del arbol binario de busqueda
        return root.element;
    }

    public int size(){ // Devuelve el tamaño del arbol binario de busqueda
        return BinaryNode.size( root );
    }

    
  
    
 }