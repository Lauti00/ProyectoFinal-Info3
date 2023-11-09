public class Producto{
    private String nombre;
    private int cantidad;
    private int id;

    public Producto(String nombre, int cantidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
    }

    public Producto(String nombre){
        this.nombre=nombre;
    }

    public void setNombre(String nom){
        nombre=nom;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCantidad(int c){
        cantidad=c;
    }

    public int getCantidad(){
        return cantidad;
    }
  
    public void setId(int i){
        id=i;
    }

    public int getId(){
        return id;
    }

    public void changeStock(int x){ //Cambia el stock, funcion usada en BinarySearchTree
        if(x<0 && cantidad + x <= 0){
            System.out.println("No hay stock suficiente para descontar");
        }
        this.cantidad = cantidad + x;
    }

    public String toString(){
        return nombre + "\t" + cantidad;
    }
}
