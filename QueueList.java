public class QueueList{
    private int contador;
    private Nodo front;
    private Nodo back;

    public QueueList() {
        front = back = null;
    }

    public int getContador(){
        return contador;
    }

    public void enqueue(Producto element) { // Ingresa element y stock
        if (isEmpty())
            back = front = new Nodo(element);
        else
            back = back.next = new Nodo(element);
        contador++;
    }
    

    public String dequeue() {
        if (isEmpty()) {
            try {
                throw new Exception("QueueList getFront");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        Producto returnValue = front.data;
        
        front = front.next;
        return returnValue+ "\t"; // Retorna los valores como String

    }

    public Producto getFront() {
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
