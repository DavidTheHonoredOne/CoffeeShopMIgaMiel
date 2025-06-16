import java.util.Scanner;
public class Cafeteria implements GestionSistema{
    private Producto[] menuProductos;
    private int contProducts;
    private Persona[] personal;
    private int contPersonal;
    private Pedidos[] pedidos;
    private int contPedidos;

    public Cafeteria() {
        this.menuProductos = new Producto[100];
        this.contProducts = 0;
        this.personal = new Persona[10];
        this.contPersonal = 0;
        this.pedidos = new Pedidos[100];
        this.contPedidos = 0;
    }
    // Scanner
    private Scanner kb = new Scanner(System.in);
//Agregar Productos
    @Override
    public void agregarProducto(Producto producto) {
      if (this.contProducts >= 100) {
            System.out.println("No hay espacio para agregar más productos.");
            return;
        }
        for (int i = 0; i < contProducts; i++) {
            if (this.menuProductos[i].getId().equals(producto.getId())) {
                System.out.println("Ya existe un producto con ese ID.");
                return;
            }
        }
        this.menuProductos[this.contProducts] = producto;
        this.contProducts++;
        System.out.println("Producto agregado exitosamente.");
    }
    @Override
    public void eliminarProducto(String idProducto) {
        if (this.contProducts == 0) {
            System.out.println("No hay productos para eliminar.");
            return;
        }
        int i;
        for (i = 0; i < this.contProducts; i++) {
            if (this.menuProductos[i].getId().equals(idProducto)) {
                for (int j = i; j < this.contProducts - 1; j++) {
                    this.menuProductos[j] = this.menuProductos[j + 1];
                }
                this.menuProductos[this.contProducts - 1] = null;
                this.contProducts--;
                System.out.println("Producto eliminado exitosamente.");
                return;
            }
        }
        if (i == this.contProducts) {
            System.out.println("No se encontró un producto con ese ID.");
            return;
        }
        // Se recorre nuevamente el vector para eliminarlos de los pedidos
        for (int k = 0; k < this.contPedidos; k++) {
            this.pedidos[k].eliminarProductoPorId(idProducto);
        }
    }
    @Override
    public Producto buscarProductoPorId(String idProducto) {
        if (this.contProducts == 0) {
            System.out.println("No hay productos disponibles.");
            return null;
        }
        for (int i = 0; i < this.contProducts; i++) {
            if (this.menuProductos[i].getId().trim().equalsIgnoreCase(idProducto.trim())) {
                return this.menuProductos[i];
            }
        }
        return null;
    }
    @Override
    public void mostrarProductoPorId(String idProducto) {
        if (this.contProducts == 0) {
            System.out.println("No hay productos para mostrar.");
            return;
        }
        for (int i = 0; i < this.contProducts; i++) {
            if (this.menuProductos[i].getId().trim().equalsIgnoreCase(idProducto.trim())) {
                this.menuProductos[i].mostrarDetalles();
                return;
            }
        }
        System.out.println("No se encontró un producto con ese ID.");
    }
    @Override
    public void listarTodosLosProductos() {
    if (this.contProducts == 0) {
            System.out.println("No hay productos disponibles.");
            return;
        }
        System.out.println("Lista de productos:");
        for (int i = 0; i < this.contProducts; i++) {
            this.menuProductos[i].mostrarDetalles();
        }
    }
    //Personal
    @Override
    public void agregarPersonal(Persona persona) {
        if (this.contPersonal >= 10) {
            System.out.println("No hay espacio para agregar más personal.");
            return;
        }
        for (int i = 0; i < contPersonal; i++) {
            if (this.personal[i].getId().equals(persona.getId())) {
                System.out.println("Ya existe un personal con ese ID.");
                return;
            }
        }
        this.personal[this.contPersonal] = persona;
        this.contPersonal++;
        System.out.println("Personal agregado exitosamente.");
    }
    @Override
    public void eliminarPersonal(String idPersonal) {
        if (this.contPersonal == 0) {
            System.out.println("No hay personal para eliminar.");
            return;
        }
        for (int i = 0; i < this.contPersonal; i++) {
            if (this.personal[i].getId().equals(idPersonal)) {
                for (int j = i; j < this.contPersonal - 1; j++) {
                    this.personal[j] = this.personal[j + 1];
                }
                this.personal[this.contPersonal - 1] = null;
                this.contPersonal--;
                System.out.println("Personal eliminado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró un personal con ese ID.");
    }
    @Override
    public void mostrarPersonalPorId(String idPersonal) {
        if (this.contPersonal == 0) {
            System.out.println("No hay personal para mostrar.");
            return;
        }
        for (int i = 0; i < this.contPersonal; i++) {
            if (this.personal[i].getId().equals(idPersonal)) {
                this.personal[i].mostrarInfoPersonal();
                return;
            }
        }
        System.out.println("No se encontró un personal con ese ID.");
    }
    @Override
    public void listarTodoElPersonal() {
        if (this.contPersonal == 0) {
            System.out.println("No hay personal disponible.");
            return;
        }
        System.out.println("Lista de personal:");
        for (int i = 0; i < this.contPersonal; i++) {
            this.personal[i].mostrarInfoPersonal();
        }
    }
    //Pedidos
    @Override
    public void crearPedido(Pedidos pedido) {
        if (this.contPedidos >= 100) {
            System.out.println("No hay espacio para agregar más pedidos.");
            return;
        }
        for (int i = 0; i < contPedidos; i++) {
            if (this.pedidos[i].getNumeroPedido().equals(pedido.getNumeroPedido())) {
                System.out.println("Ya existe un pedido con ese número.");
                return;
            }
        }
        this.pedidos[this.contPedidos] = pedido;
        this.contPedidos++;
        System.out.println("Pedido creado exitosamente.");
    }
    public void cancelarPedido(String numeroPedido){
        if (this.contPedidos == 0) {
            System.out.println("No hay pedidos para cancelar.");
            return;
        }
        for (int i = 0; i < this.contPedidos; i++) {
            if (this.pedidos[i].getNumeroPedido().equals(numeroPedido)) {
                for (int j = i; j < this.contPedidos - 1; j++) {
                    this.pedidos[j] = this.pedidos[j + 1];
                }
                this.pedidos[this.contPedidos - 1] = null;
                this.contPedidos--;
                System.out.println("Pedido cancelado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró un pedido con ese número.");
    }
    @Override
    public void mostrarPedido(String numeroPedido) {
        if (this.contPedidos == 0) {
            System.out.println("No hay pedidos para mostrar.");
            return;
        }
        for (int i = 0; i < this.contPedidos; i++) {
            if (this.pedidos[i].getNumeroPedido().equals(numeroPedido)) {
                this.pedidos[i].mostrarDetallesPedido();
                return;
            }
        }
        System.out.println("No se encontró un pedido con ese número.");
    }
    @Override
    public void gestionarCreacionDeNuevoPedido() {
        System.out.println("--- Creación de Nuevo Pedido ---");
        System.out.print("Nombre del cliente: ");
        String nombreCliente = kb.nextLine();
        System.out.print("Telefono del cliente: ");
        String telefonoCliente = kb.nextLine();
        Cliente cl = new Cliente(nombreCliente, telefonoCliente);
        String numPedido = "P-" + System.currentTimeMillis();
        Pedidos pedido = new Pedidos(numPedido,cl);
        String idProductoIngresado;
        do {
            System.out.println("Agregue productos al pedido por ID, de lo contrario ingrese 0:");
            this.listarTodosLosProductos();
            System.out.print("ID de producto: ");
            idProductoIngresado = kb.nextLine();
            if (!idProductoIngresado.equals("0")) {
                Producto productoEncontrado = this.buscarProductoPorId(idProductoIngresado);
                if (productoEncontrado != null) {
                    pedido.agregarProducto(productoEncontrado);
                    System.out.println("| Producto: " + productoEncontrado.getNombre() + ", agregado.");
                } else {
                    System.out.println("ID de producto no encontrado. Intente de nuevo.");
                }
            }
        } while (!idProductoIngresado.equals("0"));
        System.out.println("Numero de Pedido Asignado es: " + numPedido);
        this.crearPedido(pedido);
    }
    public void editarPedido(String numeroPedido) {
        Pedidos pedidoEditar = null;
        for (int i = 0; i < this.contPedidos; i++) {
            if (this.pedidos[i].getNumeroPedido().equals(numeroPedido)) {
                pedidoEditar = this.pedidos[i];
                break;
            }
        }
        if (pedidoEditar == null) {
            System.out.println("No se encontró un pedido con ese número.");
            return;
        }
        int opcionEditar;
        do {
            System.out.println("--- Edición de Pedido ---");
            System.out.println("1. Agregar producto al pedido");
            System.out.println("2. Eliminar producto del pedido");
            System.out.println("3. Mostrar detalles del pedido");
            System.out.println("0. Salir de edición");
            System.out.print("Seleccione una opción: ");
            opcionEditar = kb.nextInt();
            kb.nextLine();
            switch (opcionEditar) {
                case 1:
                    this.listarTodosLosProductos();
                    System.out.print("Ingrese el ID del producto a agregar: ");
                    String idProdAgregar = kb.nextLine();
                    Producto prodAgregar = this.buscarProductoPorId(idProdAgregar);
                    if (prodAgregar != null) {
                        pedidoEditar.agregarProducto(prodAgregar);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 2:
                    pedidoEditar.mostrarDetallesPedido();
                    System.out.print("Ingrese el ID del producto a eliminar del pedido: ");
                    String idProdEliminar = kb.nextLine();
                    pedidoEditar.eliminarProductoPorId(idProdEliminar);
                    break;
                case 3:
                    pedidoEditar.mostrarDetallesPedido();
                    break;
                case 0:
                    System.out.println("Saliendo de la edición del pedido.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionEditar != 0);
    }
    @Override
    public int getTotalProductos() {
        return this.contProducts;
    }
    @Override
    public int getTotalPersonal() {
        return this.contPersonal;
    }
    @Override
    public int getTotalPedidos() {
        return this.contPedidos;
    }
}




