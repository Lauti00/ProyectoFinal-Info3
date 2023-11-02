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

    public Producto(String nombre , int cantidad , int id, float precio){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.id=id;
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

    public void changeStock(int x){
        this.cantidad = cantidad + x;
    }
    public String toString(){
        return nombre + "\t" + cantidad;
    }
}
