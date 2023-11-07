import java.util.Scanner;


public class Proyecto {
    public static void main(String[] args) {
        int option = 0;
        int cont = 0;
        Scanner console = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        do {
            System.out.println("---------------------------------------------------");
            System.out.println("MENU");
            System.out.println("1.Agregar producto\n2.Eliminar Producto\n3.Buscar Producto\n4.Mostrar inventario\n0.Salir");
            System.out.println("---------------------------------------------------");
            option = console.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Programa finalizado.");
                    System.exit(0);
                case 1:
                    add(tree);
                    break;
                case 2:
                    remove(tree);
                    break;
                    
                case 3:
                    search(tree);
                    break;
               case 4:
                    print(tree);
                    break;
                default:
                    System.out.println("Opcion incorrecta, ingrese otra opcion");
            }
            System.out.println("---------------------------------------------------");
            System.out.println("Desea continuar con el programa ?  \n0-Finalizar programa\n1-Continuar con el programa ");
            System.out.println("---------------------------------------------------");
            cont = console.nextInt();
        } while (cont == 1);
        console.close();
    }

    public static void add(BinarySearchTree tree){
        char option = ' ';
        String name = " ";
        int stock = 0;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        
        do {
            try {
                System.out.println("Ingrese el nombre del producto");
                name = input.next();
                name = name.toLowerCase();
            } catch (Exception e) {
                System.out.println("El nombre debe ser un String válido. Intente nuevamente.");
                input.nextLine();  // Limpiar el búfer de entrada
                continue;  // Volver al principio del bucle para ingresar un valor válido
            }
    
            System.out.println("Ingrese la cantidad de stock del producto");
            
            try {
                stock = input.nextInt();
            } catch (Exception e) {
                System.out.println("El stock debe ser un número entero. Intente nuevamente.");
                input.nextLine();  // Limpiar el búfer de entrada
                continue;  // Volver al principio del bucle para ingresar un valor válido
            }
            
            Producto producto = new Producto(name, stock);
    
            if (tree.find(producto) == null) {
                Producto producto1 = new Producto(name, stock);
                tree.insert(producto1);
                System.out.println("Producto cargado correctamente");
                flag = true;
            } else {
                System.out.println("Ya se ha ingresado un producto con ese nombre...\nDesea agregarle más stock al producto ? \n(Presione 'y' para aceptar o 'n' para rechazar)");
                option = input.next().charAt(0);
                if (option == 'y') {
                    System.out.println("Ingrese la cantidad que desea sumarle al stock");
                    stock = input.nextInt();
                    System.out.println("Producto actualizado correctamente");
                    System.out.println("---------------------------------------------------");
                    System.out.println("Nombre\tStock");
                    System.out.println(tree.changeStock(producto, stock));
                    System.out.println("---------------------------------------------------");
                    flag = true;
                } else {
                    break;
                }
            }
        } while (!flag);
    }
    
    public static void remove(BinarySearchTree tree) {
        String name = " ";
        Scanner console = new Scanner(System.in);
        
        do {
            try {
                System.out.println("Ingrese el nombre del producto a borrar");
                name = console.next();
            } catch (Exception e) {
                System.out.println("El nombre debe ser un String válido. Intente nuevamente.");
                console.nextLine();  // Limpiar el búfer de entrada
                continue;  // Volver al principio del bucle para ingresar un valor válido
            }
    
            Producto producto = new Producto(name);
            if (tree.find(producto) == null) {
                System.out.println("No se encontró el producto. Intente nuevamente.");
            } else {
                tree.remove(producto);
                System.out.println("Producto removido correctamente");
                break;  // Salir del bucle si se encontró y eliminó el producto
            }
        } while (true);  // Repetir hasta que se encuentre y elimine el producto
    }
    
    public static void search(BinarySearchTree tree){
       do{
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
        else{
            System.out.println("Nombre\tStock");
            System.out.println(tree.findName(producto));
            break;
        }
    }while(true);                            
    }

    public static void print(BinarySearchTree tree){
        int cantidad = 0;
        QueueList queue = new QueueList();
        queue=tree.setInventory(queue);
        cantidad=queue.getContador();
        System.out.println("---------------------------------------------------");
        System.out.println("ID\tNombre\tStock");
        for(int i=0; i<cantidad; i++)
            System.out.println(i + "\t" + queue.dequeue());
        System.out.println("---------------------------------------------------");
    } 
    
}
