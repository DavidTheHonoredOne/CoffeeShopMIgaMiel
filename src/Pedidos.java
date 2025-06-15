public class Pedidos implements Verificable {
    private Cliente cliente;
    private String numeroPedido;
    private Producto[] menuProductos;
    private int contP;
    private double totalPagar;

    public Pedidos(String numeroPedido, Cliente cliente) {
        this.menuProductos = new Producto[10];
        this.contP = 0;
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.totalPagar = 0;
    }
    // Setters
    public void setContP(int contP) {
        this.contP = contP;
    }
    public void setMenuProductos(Producto[] menuProductos) {
        this.menuProductos = menuProductos;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    //Getters
    public int getContP() {
        return contP;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public double getTotalPagar() {
        return totalPagar;
    }
    public String getNumeroPedido() {
        return numeroPedido;
    }
    public Producto[] getMenuProductos() {
        return menuProductos;
    }
//Methods
    public void agregarProducto(Producto producto) {
        if(this.contP >= 10) {
            System.out.println("No hay espacio para más productos");
            return;
        }
        for(int i = 0; i < this.contP; i++) {
            if(this.menuProductos[i].getId().equals(producto.getId())) {
                System.out.println("El producto ya existe");
                return;
            }
        }
        this.menuProductos[this.contP] = producto;
        this.contP++;
        System.out.println("Producto agregado ");
    }

    public void eliminarProductoPorId(String idProducto) {
        if (this.contP == 0) {
            System.out.println("No hay productos en el pedido para eliminar.");
            return;
        }
        for (int i = 0; i < this.contP; i++) {
            if (this.menuProductos[i].getId().equals(idProducto)) {
                for (int j = i; j < this.contP - 1; j++) {
                    this.menuProductos[j] = this.menuProductos[j + 1];
                }
                this.menuProductos[this.contP - 1] = null;
                this.contP--;
                System.out.println("Producto eliminado del pedido exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró un producto con ese ID en el pedido.");
    }

    public void mostrarDetallesPedido(){
        if(this.contP == 0) {
            System.out.println("No hay productos en el pedido");
            return;
        }
        System.out.println("Detalles del pedido:");
        System.out.println("Cliente: " + this.cliente.getNombre());
        System.out.println("Número de pedido: " + this.numeroPedido);
        System.out.println("Productos:");
        double total = 0;
        for(int i = 0; i < this.contP; i++) {
            System.out.println("- " + this.menuProductos[i].getNombre() + ": $" + this.menuProductos[i].getPrecio());
            total += this.menuProductos[i].getPrecio();
        }
        System.out.println("Total a pagar: $" + total);
        this.totalPagar = total;
    }

    @Override
    public String obtenerIdVerificacion() {
        return this.getNumeroPedido();
    }
    @Override
    public String obtenerResumenVerificacion() {
        return "Pedido a nombre de: " + this.cliente.getNombre() +
               ", con número de pedido: " + this.numeroPedido +
               ", total a pagar: " + this.totalPagar;
    }

}
