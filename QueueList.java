public class QueueList<AnyType>{
    private int contador;
    private Nodo<AnyType> front;
    private Nodo<AnyType> back;

    public QueueList() {
        front = back = null;
    }

    public int getContador(){
        return contador;
    }

    public void enqueue(AnyType element, int stock) {
        if (isEmpty())
            back = front = new Nodo<AnyType>(element,stock);
        else
            back = back.next = new Nodo<AnyType>(element, stock);
        contador++;
    }
    

    public String dequeue() {
        if (isEmpty()) {
            //throw new UnderflowException("QueueList dequeue");
            try {
                throw new Exception("QueueList getFront");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        AnyType returnValue = front.data;
        int stock= front.stock;
        front = front.next;
        return returnValue+ "\t" + stock;

    }

    public AnyType getFront() {
        if (isEmpty())
            System.out.println("ERROR");
            try {
                throw new Exception("QueueList getFront");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return front.data;
    }

    public void makeEmpty() {
        front = null;
        back = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    
}
