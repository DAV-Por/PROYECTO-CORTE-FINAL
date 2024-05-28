import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionPedidos gestionPedidos = new GestionPedidos();
        Pedido pedido = new Pedido();
        Inventario inventario = new Inventario();
        Informe informe = new Informe(gestionPedidos, inventario);
        // Llamar al array de usuarios
        Usuario[] usuarios = {new Usuario("Juan", "Admin123", Usuario.Rol.ADMINISTRADOR),
                new Usuario("Felipe", "Contador123", Usuario.Rol.CONTADOR),
                new Usuario("Cesar", "Mercadero123", Usuario.Rol.MERCADERO)};

        int opcion; int IdPedido; int opcionGetionPedidos;
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario que ingrese su nombre de usuario y contraseña
        System.out.println("Ingrese su nombre de usuario");
        System.out.print("---> ");
        String nombreUsuarioIngresado = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        System.out.print("---> ");
        String passwordIngresado = sc.nextLine();

        // Verificar si el usuario existe y la contraseña es correcta
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.Login(nombreUsuarioIngresado, passwordIngresado)) {
                usuario = u;

            }
        }

        // Si el usuario existe y la contraseña es correcta, mostrar un mensaje de bienvenida y realizar diferentes acciones dependiendo del rol del usuario
        if (usuario != null) {
            System.out.println("Inicio de sesión exitoso! Bienvenido " + usuario.getNombreUsuario() + ".");
            System.out.println("Su rol es: " + usuario.getRol());

            switch (usuario.getRol()) {
                case ADMINISTRADOR:
                    System.out.println("*** MENU ADMINISTRADOR ***\n*** BIENVENIDO ***");
                    System.out.println("1. Ver el inventario");
                    System.out.println("2. Generar informe de inventario");
                    System.out.println("3. Generar informe de ventas");
                    System.out.println("4. Gestionar pedidos");
                    System.out.print("---> ");
                    opcion = sc.nextInt();
                    switch (opcion){
                        case 1:
                            Inventario.mostrarInventario();
                            System.out.println("\n");
                            break;
                        case 2:
                            Informe.generarInformeInventario();
                            break;
                        case 3:
                            Informe.generarInformeVentas();
                            break;
                        case 4:
                            System.out.println("*** GESTION DE PEDIDOS ***");
                            System.out.println("1. Mostrar informacion de pedido");
                            System.out.println("2. Agregar pedido");
                            System.out.println("3. Enviar pedido");
                            System.out.println("4. Entregar pedido");
                            System.out.println("5. Devolver pedido\n");
                            System.out.print("---> ");
                            opcionGetionPedidos = sc.nextInt();
                            switch (opcionGetionPedidos){
                                case 1:
                                    pedido.mostrarInformacionPedido();
                                    break;
                                case 2:
                                    System.out.println("\nPara agregar un pedido por favor introduce los siguientes datos");
                                    System.out.println("ID del producto: ");
                                    //IdProductoPedidoAgregado
                                    int idPPA = sc.nextInt();
                                    sc.nextLine();
                                    //nombreProductoPedidoAgregado
                                    System.out.println("Nombre del prodocuto: ");
                                    String nPPA = sc.nextLine();
                                    //precioProductoPedidoAgregado
                                    int prPPA;
                                    //descripcionProductoPedidoAgregado
                                    String dPPA;
                                    if (idPPA == 1011 || nPPA.equals("Salsa de tomate") || nPPA.equals("salsa de tomate")) {
                                        idPPA = 1011;
                                        prPPA = 2200;
                                        dPPA = "Pasta elaborada principalmente a partir de pulpa de tomates";
                                        nPPA = "Salsa de Tomate";
                                    } else if (idPPA == 1012 || nPPA.equals("Harina de trigo") || nPPA.equals("harina de trigo")) {
                                        idPPA = 1012;
                                        prPPA = 1800;
                                        dPPA = "polvo fino de origen vegetal que se obtiene de la molienda del trigo";
                                        nPPA = "Harina de trigo";
                                    } else if (idPPA == 1013 || nPPA.equals("Barra de margarina") || nPPA.equals("barra de margarina")) {
                                        idPPA = 1013;
                                        prPPA = 3000;
                                        dPPA = "Mezcla de aceitres compuestos mayoritariamente por grasas insaturadas";
                                        nPPA = "Barra de Margarina";
                                    } else if (idPPA == 1014 || nPPA.equals("Bonbonbum") || nPPA.equals("bonbonbum")) {
                                        idPPA = 1014;
                                        prPPA = 500;
                                        dPPA = "caramelo relleno de chicle";
                                        nPPA = "Bonbonbum";
                                    } else {
                                        System.out.println("Producto no encontrado, se agregara como producto nuevo, \nPor favor agregale un precio y una descripcion");
                                        System.out.println("Precio: ");
                                        prPPA = sc.nextInt();
                                        System.out.println("Descripcion: (opcional)");
                                        dPPA = sc.next();
                                    }
                                    System.out.println("Cuanta cantidad quiere añadir al pedido?");
                                    System.out.println("Cantidad: ");
                                    //cantidadProductoPedidoAgregado
                                    int cPPA = sc.nextInt();
                                    sc.nextLine();
                                    prPPA = cPPA * prPPA;
                                    Producto productoAgregado = new Producto(nPPA, idPPA, prPPA, cPPA, dPPA);
                                    Pedido pedidoAgregado = new Pedido(idPPA);
                                    pedidoAgregado.agregarProducto(productoAgregado);
                                    gestionPedidos.agregarPedido(pedidoAgregado);
                                    System.out.println("Su producto se a agregado correctamente\n¿Desea ver su pedido?\n\nY(Si)     N(No)\n--->");
                                    String decicion = sc.nextLine();
                                    if (decicion.equals("Y")||decicion.equals("y")){
                                        System.out.println("Pedidos:");
                                        for (Pedido pedidoAgregados : gestionPedidos.getPedidos().values()) {
                                            pedidoAgregados.mostrarInformacionPedido();
                                            System.out.println();
                                        }
                                    } else if (decicion.equals("N")|| decicion.equals("n")) {
                                        System.out.println("Muchas gracias...");
                                    }
                                    break;
                                case 3:
                                    System.out.print("\nIngresa el ID del pedido\n--->");
                                    IdPedido = sc.nextInt();
                                    gestionPedidos.enviarPedido(IdPedido);
                                    break;
                                case 4:
                                    System.out.print("\nIngresa el ID del pedido\n---> ");
                                    IdPedido = sc.nextInt();
                                    gestionPedidos.entregarPedido(IdPedido);
                                    break;
                                case 5:
                                    System.out.print("\nIngresa el ID del pedido\n---> ");
                                    IdPedido = sc.nextInt();
                                    gestionPedidos.devolverPedido(IdPedido);
                                    break;
                            }
                            break;
                    }
                    break;
                case CONTADOR://solucionado
                    System.out.println("*** MENU CONTADOR ***\n*** BIENVENIDO ***");
                    System.out.println("1. Ver el inventario");
                    System.out.println("2. Generar informe de inventario");
                    System.out.println("3. Generar informe de ventas\n");
                    System.out.print("--> ");
                    opcion = sc.nextInt();
                    switch (opcion){
                        case 1:
                            Inventario.mostrarInventario();
                            break;
                        case 2:
                            Informe.generarInformeInventario();
                            break;
                        case 3:
                            Informe.generarInformeVentas();
                            break;
                    }
                    break;
                case MERCADERO://SOLUCIONADO
                    System.out.println("**** MENU MERCADERO *****\n**** BIENVENIDO ****");
                    System.out.println("1. Ver inventario de productos");
                    System.out.println("2. Gestionar pedidos\n");
                    System.out.print("---> ");
                    opcion = sc.nextInt();
                    switch (opcion){
                        case 1:
                            Inventario.mostrarInventario();
                            break;
                        case 2:
                            System.out.println("*** GESTION DE PEDIDOS ***");
                            System.out.println("1. Mostrar informacion de pedido");
                            System.out.println("2. Agregar pedido");
                            System.out.println("3. Enviar pedido");
                            System.out.println("4. Entregar pedido");
                            System.out.println("5. Devolver pedido\n");
                            System.out.print("---> ");
                            opcionGetionPedidos = sc.nextInt();
                            switch (opcionGetionPedidos){
                                case 1:
                                        pedido.mostrarInformacionPedido();
                                    break;
                                case 2:
                                    System.out.println("\nPara agregar un pedido por favor introduce los siguientes datos");
                                    System.out.println("ID del producto: ");
                                    int idPPA = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Nombre del prodocuto: ");
                                    String nPPA = sc.nextLine();
                                    int prPPA;
                                    String dPPA;
                                    if (idPPA == 1011 || nPPA.equals("Salsa de tomate") || nPPA.equals("salsa de tomate")) {
                                        idPPA = 1011;
                                        prPPA = 2200;
                                        dPPA = "Pasta elaborada principalmente a partir de pulpa de tomates";
                                        nPPA = "Salsa de Tomate";
                                    } else if (idPPA == 1012 || nPPA.equals("Harina de trigo") || nPPA.equals("harina de trigo")) {
                                        idPPA = 1012;
                                        prPPA = 1800;
                                        dPPA = "polvo fino de origen vegetal que se obtiene de la molienda del trigo";
                                        nPPA = "Harina de trigo";
                                    } else if (idPPA == 1013 || nPPA.equals("Barra de margarina") || nPPA.equals("barra de margarina")) {
                                        idPPA = 1013;
                                        prPPA = 3000;
                                        dPPA = "Mezcla de aceitres compuestos mayoritariamente por grasas insaturadas";
                                        nPPA = "Barra de Margarina";
                                    } else if (idPPA == 1014 || nPPA.equals("Bonbonbum") || nPPA.equals("bonbonbum")) {
                                        idPPA = 1014;
                                        prPPA = 500;
                                        dPPA = "caramelo relleno de chicle";
                                        nPPA = "Bonbonbum";
                                    } else {
                                        System.out.println("Producto no encontrado, se agregara como producto nuevo, \nPor favor agregale un precio y una descripcion");
                                        System.out.println("Precio: ");
                                        prPPA = sc.nextInt();
                                        System.out.println("Descripcion: (opcional)");
                                        dPPA = sc.next();
                                    }
                                    System.out.println("Cuanta cantidad quiere añadir al pedido?");
                                    System.out.println("Cantidad: ");
                                    int cPPA = sc.nextInt();
                                    sc.nextLine();
                                    prPPA = cPPA * prPPA;
                                    Producto productoAgregado = new Producto(nPPA, idPPA, prPPA, cPPA, dPPA);
                                    Pedido pedidoAgregado = new Pedido(idPPA);
                                    pedidoAgregado.agregarProducto(productoAgregado);
                                    gestionPedidos.agregarPedido(pedidoAgregado);
                                    System.out.println("Su producto se a agregado correctamente\n¿Desea ver su pedido?\n\nY(Si)     N(No)\n--->");
                                    String decicion = sc.nextLine();
                                    if (decicion.equals("Y")||decicion.equals("y")){
                                        System.out.println("Pedidos:");
                                        for (Pedido pedidoAgregados : gestionPedidos.getPedidos().values()) {
                                            pedidoAgregados.mostrarInformacionPedido();
                                            System.out.println();
                                        }
                                    } else if (decicion.equals("N")|| decicion.equals("n")) {
                                        System.out.println("Muchas gracias...");
                                    }
                                    break;
                                case 3:
                                    System.out.print("\nIngresa el ID del pedido\n--->");
                                    IdPedido = sc.nextInt();
                                    gestionPedidos.enviarPedido(IdPedido);
                                    break;
                                case 4:
                                    System.out.print("\nIngresa el ID del pedido\n---> ");
                                    IdPedido = sc.nextInt();
                                    gestionPedidos.entregarPedido(IdPedido);
                                    break;
                                case 5:
                                    System.out.print("\nIngresa el ID del pedido\n---> ");
                                    IdPedido = sc.nextInt();
                                    gestionPedidos.devolverPedido(IdPedido);
                                    break;
                                }
                            }
                        break;
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos, vuelvelo a intentar mas tarde");
        }
    }
}