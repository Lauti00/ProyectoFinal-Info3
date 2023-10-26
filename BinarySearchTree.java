
import javax.management.InstanceNotFoundException;

public class BinarySearchTree<AnyType extends Comparable <? super AnyType>> 
{
    protected BinaryNode<AnyType> root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert (AnyType x , int stock){
        root = insert(x,root,stock);
    }
    public void remove (AnyType x){
        root = remove(x,root);
    }
    public void removeMin(){
        root = removeMin(root);
    }
    public AnyType findMin(){
        return elementAt(findMin(root));
    }
    public AnyType find (AnyType x){
        return elementAt(find(x,root));
    }
    public int findStock (AnyType x){
        return elementAtInt(find(x,root));
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }

    private int elementAtInt(BinaryNode<AnyType> t){
        return t == null ? 0 : t.stock;
    }

    private AnyType elementAt(BinaryNode<AnyType> t){
        return t == null ? null : t.element;
    }

    private BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> t)
    {
        while( t != null)
        {
            if(x.compareTo(t.element) < 0)
                t = t.left;
            else if(x.compareTo(t.element) > 0)
                t = t.right;
            else
                return t; // Match
        }
        return null; // Not found
    }

    public BinaryNode<AnyType> findStock(AnyType x, BinaryNode<AnyType> t)
    {
        while( t != null)
        {
            if(x.compareTo(t.element) < 0)
                t = t.left;
            else if(x.compareTo(t.element) > 0)
                t = t.right;
            else{
                return t; // Match
            }
        }
        return null; // Not found
    }
    
    public QueueList<String> setInventory(QueueList<String> queue){
        if( root != null) root.setInventory(queue);
        return queue;
    }


    protected BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if ( t != null)
            while( t.left != null)
                t = t.left;
        
        return t;
    }


    protected BinaryNode<AnyType> insert (AnyType x, BinaryNode<AnyType> t , int stock)
    {
        if ( t == null)
            t = new BinaryNode<AnyType>(x, stock);
        else if( x.compareTo(t.element) < 0)
            t.left = insert(x, t.left , stock);
        else if( x.compareTo(t.element) > 0)
            t.right = insert ( x, t.right , stock);
        else if(x.compareTo(t.element) == 0) // Modificacion para que imprima valores repetidos
            t.left = insert(x,t.left, stock);       //  Se puede insertar tanto en el sub-arbol izquierdo como en el derecho
        return t;
    }

    protected BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t)
    {
        if ( t == null){
            try {
                throw new InstanceNotFoundException();
            } catch (InstanceNotFoundException e) {
                e.printStackTrace();
            }
        } else if ( t.left != null)
            {
                t.left = removeMin( t.left );
                return t;
            }
            else
                return t.right;
        return null;
    }

    protected BinaryNode<AnyType> remove ( AnyType x, BinaryNode<AnyType> t)
    {
        if( t == null){
            try {
                throw new Exception( x.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if( x.compareTo( t.element ) < 0 )
            t.left = remove( x, t.left);
        else if( x.compareTo( t.element ) > 0)
            t.right = remove(x, t.right);
        else if ( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = removeMin( t.right );
        }
        else
            t=( t.left != null) ? t.left : t.right;
        return t;
    }

    public int height(){
        return BinaryNode.height(root);
    }

    public AnyType getRoot(){
        return root.element;
    }

    public int size(){
        return BinaryNode.size( root );
    }

    public void MakeEmpty(){
        root = null;
    }

    
  
    
 }