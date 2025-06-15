import java.util.Scanner;

public interface GestionSistema {
    public abstract void agregarProducto(Producto producto);
    public abstract void eliminarProducto(String idProducto);
    public abstract void mostrarProductoPorId(String idProducto);
    public abstract void listarTodosLosProductos();
    Producto buscarProductoPorId(String idProducto); // NUEVO Y PÚBLICO
    // Gestión de Personal
    public abstract void agregarPersonal(Persona persona);
    public abstract void eliminarPersonal(String idPersonal);
    public abstract void mostrarPersonalPorId(String idPersonal);
    public abstract void listarTodoElPersonal();
    // Gestión de Pedidos
    public abstract void crearPedido(Pedidos pedido);
    public abstract void mostrarPedido(String numeroPedido);
    public abstract void cancelarPedido(String numeroPedido);
    public abstract void  gestionarCreacionDeNuevoPedido();
    public abstract void editarPedido(String numeroPedido);
    // Informes
    public abstract int getTotalProductos(); // NUEVO
    public abstract int getTotalPersonal();  // NUEVO
    public abstract int getTotalPedidos();
}
