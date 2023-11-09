import java.util.Scanner;


public class Proyecto {
    public static void main(String[] args) {
        int option = 0;
        int cont = 0;
        boolean flag = true, flag1 = true;
        Scanner console = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        do {
            System.out.println("---------------------------------------------------");
            System.out.println("MENU");
            System.out.println("1.Agregar producto\n2.Eliminar Producto\n3.Buscar Producto\n4.Mostrar inventario\n0.Salir");
            System.out.println("---------------------------------------------------");
            do {
                try {
                    option = console.nextInt();
                    flag1 = false;
                } catch (Exception e) {
                    System.out.println("ERROR: La opcion no es valida. Intente nuevamente");
                    console.next();
                    continue;
                }
            } while (flag1 == true);
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
            do {
                try {
                    System.out.println("---------------------------------------------------");
                    System.out.println("Desea continuar con el programa ?  \n0-Finalizar programa\n1-Continuar con el programa ");
                    System.out.println("---------------------------------------------------");
                    cont = console.nextInt();
                    flag = false;
                } catch (Exception e) {
                    System.out.println("ERROR: La opcion ingresada no es valida. Intente de nuevo");
                    console.nextLine();
                    continue;
                }
            } while (flag == true);
        } while (cont == 1);
    }

    public static void add(BinarySearchTree tree) {
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
                input.nextLine(); // Limpiar el búfer de entrada
                continue; // Volver al principio del bucle para ingresar un valor válido
            }

            System.out.println("Ingrese la cantidad de stock del producto");

            try {
                stock = input.nextInt();
            } catch (Exception e) {
                System.out.println("El stock debe ser un número entero. Intente nuevamente.");
                input.nextLine(); // Limpiar el búfer de entrada
                continue; // Volver al principio del bucle para ingresar un valor válido
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
                    try {
                        System.out.println("Ingrese la cantidad que desea sumarle al stock");
                        stock = input.nextInt();
                        System.out.println("Producto actualizado correctamente");
                        System.out.println("---------------------------------------------------");
                        System.out.println("Nombre\tStock");
                        System.out.println(tree.changeStock(producto, stock));
                        System.out.println("---------------------------------------------------");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("ERROR: La cantidad tiene que ser un numero entero");
                        input.next();
                        continue;
                    }
                } else {
                    break;
                }
            }
        } while (!flag);
    }

    public static void remove(BinarySearchTree tree) {
        String name = " ";
        Scanner console = new Scanner(System.in);
        char option = ' ';
        int stock = 0;
        boolean flag = false;
        do {
            try {
                System.out.println("Desea remover el producto o descontar stock ?\n(Presione 'y' para remover producto / Presione 'n' para descontar stock)");
                option = console.next().charAt(0);
                System.out.println("Ingrese el nombre del producto:");
                name = console.next();
            } catch (Exception e) {
                System.out.println("El nombre debe ser un String válido. Intente nuevamente.");
                console.nextLine(); // Limpiar el búfer de entrada
                continue; // Volver al principio del bucle para ingresar un valor válido
            }
            Producto producto = new Producto(name);
            if (option == 'y' || option == 'Y') {
                if (tree.find(producto) == null) {
                    System.out.println("No se encontró el producto. Intente nuevamente.");
                } else {
                    tree.remove(producto);
                    System.out.println("Producto removido correctamente");
                    flag = true;
                     
                }
            } else if (option == 'n' || option == 'N') {
                if (tree.find(producto) == null)
                    System.out.println("No se encontró el producto. Intente nuevamente.");
                else {
                    try {
                        System.out.println("Ingrese la cantidad de stock a descontar");
                        stock = console.nextInt();
                        if (stock > tree.findStock(producto, stock))
                            System.out.println("La cantidad ingresada es mayor a la cantidad de stock del producto");
                        else {
                            stock = -stock;
                            System.out.println("Producto actualizado correctamente");
                            System.out.println("---------------------------------------------------");
                            System.out.println("Nombre\tStock");
                            System.out.println(tree.changeStock(producto, stock));
                            System.out.println("---------------------------------------------------");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR: La cantidad tiene que ser un numero entero");
                        console.nextLine();
                        continue;
                    }
                    flag = true;
                }
            } else
                System.out.println("La opcion ingresada no es valida");
        } while (flag == false); // Repetir hasta que se encuentre y elimine el producto
    }

    public static void search(BinarySearchTree tree) {
        String name = " ";
        Scanner console = new Scanner(System.in);
        char option = ' ';
        boolean flag = true;
        do {

            System.out.println("Ingrese el nombre del producto: ");
            try {
                name = console.next().toLowerCase();
            } catch (Exception e) {
                System.out.println("El nombre debe ser un String válido. Intente nuevamente.");
                console.nextLine();
                break;
            }

            Producto producto = new Producto(name);

            if (tree.find(producto) == null)
                System.out.println("El producto ingresado anteriormente no existe");
            else {
                System.out.println("---------------------------------------------------");
                System.out.println("Nombre\tStock");
                System.out.println(tree.findName(producto));
                System.out.println("---------------------------------------------------");
                break;
            }
            System.out.println(
                    "No ha ingresado un nombre que pertenezca al inventario. Desea continuar ?\n(Presione 'y' si desea continuar / Presione cualquier otra letra para salir de esta opcion)");
            option = console.next().charAt(0);
        } while (option == 'y' || option == 'Y');
    }

    public static void print(BinarySearchTree tree) {
        int cantidad = 0;
        QueueList queue = new QueueList();
        queue = tree.setInventory(queue);
        cantidad = queue.getContador();
        if (cantidad == 0) {
            System.out.println("No ha ingresado ningun elemento");
        } else {
            System.out.println("---------------------------------------------------");
            System.out.println("ID\tNombre\tStock");
            for (int i = 0; i < cantidad; i++)
                System.out.println(i + "\t" + queue.dequeue());
            System.out.println("---------------------------------------------------");
        }
    }

}
