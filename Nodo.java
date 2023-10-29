public class Nodo<AnyType> {
    AnyType data;
    int stock;
    Nodo<AnyType> next;

  public Nodo(AnyType data, int stock) { // Agregamos el valor stock 
    this.data = data;
    this.stock=stock;
    this.next = null;

  }
}
