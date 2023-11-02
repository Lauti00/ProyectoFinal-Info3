import java.util.Scanner;


public class Proyecto {
    public static void main(String[] args) {
        int option;
        int cont = 0;
        Scanner console = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        do {
            System.out.println("MENU");
            System.out.println("1.Agregar producto\n2.Eliminar Producto\n3.Buscar Producto\n4.Mostrar inventario\n0.Salir");
            option = console.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Programa finalizado.");
                    System.exit(0);
                case 1:
                    add(tree);
                    break;
                case 2:{
                    remove(tree);
                    break;
                    }
                case 3:
                    search(tree);
                    break;
               case 4:
                    print(tree);
                    break;
                default:
                    System.out.println("Opcion incorrecta, ingrese otra opcion");
            }
            System.out.println("Desea continuar con el programa ? \n0-Finalizar programa\n1-Continuar con el programa ");
            cont = console.nextInt();
        } while (cont == 1);
        console.close();
    }

    public static void add(BinarySearchTree tree){
        
        String name = " ";
        int stock = 0;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        do{
            try{
                System.out.println("Ingrese el nombre del producto");
                name = input.next();
                name = name.toLowerCase();
            }catch(Exception e){
                throw new IllegalArgumentException("El nombre debe ser String");
            }
            System.out.println("Ingrese la cantidad de stock del producto");
            try{
                stock = input.nextInt();
            }catch(Exception e){
                throw new IllegalArgumentException("El stock tiene que ser entero");
            }
            Producto producto= new Producto(name,stock);
            if(tree.find(producto) == null)
                flag = true;
            else{
                System.out.println("Nombre de producto ya ingresado");
        }

        }while(flag==false);

        /*System.out.println("Ingrese la cantidad de stock del producto");
        try{
            stock = input.nextInt();
        }catch(Exception e){
            input.close();
            throw new IllegalArgumentException("El stock tiene que ser entero");
        }
        Producto producto= new Producto(name,stock);
        if(tree.find(producto) == null)
            flag = true;
        else{
            System.out.println("Nombre de producto ya ingresado");
            System.exit(0);
        }*/
        Producto producto1= new Producto(name,stock);
        tree.insert(producto1);
        System.out.println("Producto cargado correctamente");
        //input.close();
    }
    
    public static void remove(BinarySearchTree tree){
        String name =" ";
        Scanner console = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto a borrar");
        try{
            name = console.next();
        }catch (Exception e){
            throw new IllegalArgumentException("El nombre debe ser un String");
        }
        Producto producto = new Producto(name);
        if(tree.find(producto) == null){
           System.out.println("No se encontro el producto");
            //throw new IllegalArgumentException();
        }else{
            tree.remove(producto);
            System.out.println("Producto removido correctamente");
        }
                    
    }
    
    public static void search(BinarySearchTree tree){
        String name = " ";
        Scanner console = new Scanner(System.in);

        System.out.println("Ingrese el nombre del producto: ");
        try{
            name = console.next();
        }catch(Exception e){
            throw new IllegalArgumentException("El nombre debe ser un String");
        }
        Producto producto = new Producto(name);
        if(tree.find(producto) == null)
            System.out.println("El producto ingresado anteriormente no existe");
        else
            System.out.println("Producto: " + tree.findName(producto));
                                    
    }

    public static void print(BinarySearchTree tree){
        int cantidad = 0;
        QueueList queue = new QueueList();
        queue=tree.setInventory(queue);
        cantidad=queue.getContador();
        System.out.println("ID\tNombre\tStock");
        for(int i=0; i<cantidad; i++)
            System.out.println(i + "\t" + queue.dequeue());
        
    } 
    
}
