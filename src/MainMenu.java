import java.util.Scanner;
public class MainMenu {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int opcion;
        Cafeteria cafeteria = new Cafeteria();
        do {
            System.out.println("--Cafeteria Miga & Miel--");
            System.out.println("1. Gestion de Productos");
            System.out.println("2. Gestion de Personal");
            System.out.println("3. Gestion de Pedidos");
            System.out.println("4. Informes");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion de preferencia: ");
            opcion = kb.nextInt();
            kb.nextLine(); // Limpiar salto de línea
            switch (opcion){
                case 1:
                    int opcionProduct;
                    do {
                        System.out.println("--Gestion de Productos--");
                        System.out.println("1. Agregar bebidas o postres");
                        System.out.println("2. Listar todos los productos");
                        System.out.println("3. Buscar por ID");
                        System.out.println("4. Eliminar Productos");
                        System.out.println("0. Regresar al menu principal");
                        System.out.print("Ingrese su opcion de preferencia: ");
                        opcionProduct = kb.nextInt();
                        kb.nextLine(); // Limpiar salto de línea
                        switch (opcionProduct){
                            case 1:
                                System.out.println("Ingrese el producto a agregar: ");
                                System.out.println("1. Bebida");
                                System.out.println("2. Postre");
                                System.out.println("0. Regresar al menu principal");
                                System.out.print("Ingrese su opcion de preferencia: ");
                                int opcionProducto = kb.nextInt();
                                kb.nextLine(); // Limpiar salto de línea
                                switch(opcionProducto){
                                    case 1:
                                        System.out.println("Ingrese los datos de la bebida:");
                                        System.out.print("Nombre: ");
                                        String nombreBebida = kb.nextLine();
                                        System.out.print("Precio: ");
                                        double precioBebida;
                                        do {
                                            precioBebida = kb.nextDouble();
                                            if (precioBebida < 0) {
                                                System.out.println("Por favor, ingrese un precio positivo.");
                                                System.out.print("Precio: ");
                                            }
                                        } while (precioBebida < 0);
                                        kb.nextLine(); // Limpiar salto de línea
                                        System.out.print("ID: ");
                                        String idBebida = kb.nextLine();
                                        System.out.print("Descripcion: ");
                                        String descripcionBebida = kb.nextLine();
                                        System.out.print("Tamaño: ");
                                        String tamanioBebida = kb.nextLine();
                                        System.out.print("Temperatura: ");
                                        String temperaturaBebida = kb.nextLine();
                                        Bebida bebida = new Bebida(idBebida, nombreBebida, precioBebida
                                                , descripcionBebida, tamanioBebida, temperaturaBebida);
                                        cafeteria.agregarProducto(bebida);
                                        break;
                                    case 2:
                                        System.out.println("Ingrese los datos del postre:");
                                        System.out.print("Nombre: ");
                                        String nombrePostre = kb.nextLine();
                                        System.out.print("Precio: ");
                                        double precioPostre = kb.nextDouble();
                                        kb.nextLine(); // Limpiar salto de línea
                                        System.out.print("ID: ");
                                        String idPostre = kb.nextLine();
                                        System.out.print("Descripcion: ");
                                        String descripcionPostre = kb.nextLine();
                                        System.out.print("Tipo de postre: ");
                                        String tipoPostre = kb.nextLine();
                                        Postre postre = new Postre(idPostre, nombrePostre, precioPostre
                                                , descripcionPostre, tipoPostre);
                                        cafeteria.agregarProducto(postre);
                                        break;
                                    case 0:
                                        System.out.println("Devolviendose al menu principal.");
                                        break;
                                    default:
                                        System.out.println("Opcion no valida, ingrese nuevamente.");
                                }
                                break;
                            case 2:
                                System.out.println("Listando todos los productos: ");
                                cafeteria.listarTodosLosProductos();
                                break;
                            case 3:
                                System.out.println("Ingrese el ID del producto a buscar: ");
                                String idProducto = kb.nextLine();
                                Producto producto = cafeteria.buscarProductoPorId(idProducto);
                             if (producto != null) {
                                    producto.mostrarDetalles();
                                } else {
                                    System.out.println("No se encontró un producto con ese ID.");
                                }
                                break;
                            case 4:
                                System.out.println("Ingrese el ID del producto a eliminar: ");
                                String idProductoEliminar = kb.nextLine();
                                cafeteria.eliminarProducto(idProductoEliminar);
                                break;
                            case 0:
                                System.out.println("Devolviendose al menu principal.");
                                break;
                            default:
                                System.out.println("Opcion no valida, ingrese nuevamente.");
                                break;
                        }
                    } while (opcionProduct != 0);
                    break;
                case 2:
                    int opcionPersonal;
                    do {
                        System.out.println("--Gestion de Personal--");
                        System.out.println("1. Registrar empleado/gerente");
                        System.out.println("2. Listar personal");
                        System.out.println("3. Despedir personal");
                        System.out.println("4. Buscar personal por ID");
                        System.out.println("0. Regresar al menu principal");
                        System.out.print("Ingrese su opcion de preferencia: ");
                        opcionPersonal = kb.nextInt();
                        kb.nextLine(); // Limpiar salto de línea
                        switch (opcionPersonal){
                            case 1:
                                int opcionRegistro;
                                System.out.println("Ingrese quien quiere registrar: ");
                                System.out.println("1. Empleado");
                                System.out.println("2. Gerente");
                                System.out.println("0. Regresar al menu principal");
                                System.out.print("Ingrese su opcion de preferencia: ");
                                opcionRegistro = kb.nextInt();
                                kb.nextLine(); // Limpiar salto de línea
                                switch (opcionRegistro){
                                    case 1:
                                        System.out.println("Ingrese los datos del empleado:");
                                        System.out.print("Nombre: ");
                                        String nombreEmpleado = kb.nextLine();
                                        System.out.print("Telefono:");
                                        String telefonoEmpleado = kb.nextLine();
                                        System.out.print("ID: ");
                                        String idEmpleado = kb.nextLine();
                                        System.out.print("Turno: ");
                                        String turnoEmpleado = kb.nextLine();
                                        Empleado worker = new Empleado(idEmpleado, nombreEmpleado
                                                , telefonoEmpleado, turnoEmpleado);
                                        cafeteria.agregarPersonal(worker);
                                        System.out.println("Registrando empleado...");
                                        break;
                                    case 2:
                                        System.out.println("Ingrese los datos del gerente:");
                                        System.out.print("Nombre: ");
                                        String nombreGerente = kb.nextLine();
                                        System.out.print("Telefono:");
                                        String telefonoGerente = kb.nextLine();
                                        System.out.print("ID: ");
                                        String idGerente = kb.nextLine();
                                        System.out.print("Turno: ");
                                        String turnoGerente = kb.nextLine();
                                        Gerente manager = new Gerente(idGerente, nombreGerente
                                                , telefonoGerente, turnoGerente);
                                        cafeteria.agregarPersonal(manager);
                                        System.out.print("Registrando gerente...");
                                        break;
                                    case 0:
                                        System.out.println("Devolviendose al menu principal.");
                                        break;
                                    default:
                                        System.out.println("Opcion no valida, ingrese nuevamente.");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Listando todo el personal: ");
                                cafeteria.listarTodoElPersonal();
                                break;
                            case 3:
                                System.out.print("Ingrese el ID del personal a despedir: ");
                                String idPersonal = kb.nextLine();
                                cafeteria.eliminarPersonal(idPersonal);
                                break;
                            case 4:
                                System.out.print("Ingrese el ID del personal a buscar: ");
                                idPersonal = kb.nextLine();
                                cafeteria.mostrarPersonalPorId(idPersonal);
                                break;
                            case 0:
                                System.out.println("Devolviendose al menu principal.");
                                break;
                            default:
                                System.out.println("Opcion no valida, ingrese nuevamente.");
                                break;
                        }
                        break;
                    } while (opcionPersonal != 0);
                    break;
                case 3:
                    int opcionPedidos;
                    do {
                        System.out.println("--Gestion de Pedidos--");
                        System.out.println("1. Crear nuevo pedido");
                        System.out.println("2. Buscar pedido por numero");
                        System.out.println("3. Cancelar pedido");
                        System.out.println("4. Editar pedido");
                        System.out.println("0. Regresar al menu principal");
                        System.out.print("Ingrese su opcion de preferencia: ");
                        opcionPedidos = kb.nextInt();
                        kb.nextLine(); // Limpiar salto de línea
                        switch (opcionPedidos){
                            case 1:
                                cafeteria.gestionarCreacionDeNuevoPedido();
                                break;
                            case 2:
                                System.out.print("Ingrese el numero de pedido a buscar: ");
                                String numeroPedido = kb.nextLine();
                                cafeteria.mostrarPedido(numeroPedido);
                                break;
                            case 3:
                                System.out.print("Ingrese el numero de pedido a cancelar: ");
                                numeroPedido = kb.nextLine();
                                cafeteria.cancelarPedido(numeroPedido);
                                break;
                            case 4:
                                System.out.print("Ingrese el numero de pedido a editar: ");
                                String numeroPedidoEditar = kb.nextLine();
                                cafeteria.editarPedido(numeroPedidoEditar);
                                break;
                            case 0:
                                System.out.println("Devolviendose al menu principal.");
                                break;
                            default:
                                System.out.println("Opcion no valida, ingrese nuevamente.");
                                break;
                        }
                    } while (opcionPedidos != 0);
                    break;
                case 4:
                    int opcionInformes;
                    do{
                        System.out.println("--Informes--");
                        System.out.println("1. Total de productos registrados");
                        System.out.println("2. Total de personal registrado");
                        System.out.println("3. Total de pedidos realizados");
                        System.out.println("0. Regresar al menu principal");
                        System.out.print("Ingrese su opcion de preferencia: ");
                        opcionInformes = kb.nextInt();
                        kb.nextLine(); // Limpiar salto de línea
                        switch (opcionInformes){
                            case 1:
                                System.out.println("Total de productos resgistrados " +cafeteria.getTotalProductos());
                                break;
                            case 2:
                                System.out.println("Total de personal registrado: " + cafeteria.getTotalPersonal());
                                break;
                            case 3:
                                System.out.println("Total de pedidos realizados: " + cafeteria.getTotalPedidos());
                                break;
                            case 0:
                                System.out.println("Devolviendose al menu principal.");
                                break;
                            default:
                                System.out.println("Opcion no valida, ingrese nuevamente.");
                                break;
                        }
                        break;
                    } while (opcionInformes != 0);
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida, ingrese denuevo.");
                    break;
            }
        } while (opcion != 0);
    }
}