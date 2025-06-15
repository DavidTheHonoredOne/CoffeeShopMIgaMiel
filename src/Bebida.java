public class Bebida extends  Producto{
    private String tamanio;
    private String temperatura;

    public Bebida (String id, String nombre, double precio, String descripcion, String tamanio, String temperatura){
        super (id, nombre, precio, descripcion);
        this.tamanio= tamanio;
        this.temperatura= temperatura;
    }
    @Override
    public double calcularCosto(){
        return getPrecio();
    }
    @Override

    public void mostrarDetalles(){
        System.out.println("Bebida:  " +this.getNombre());
        System.out.println("ID:  " +this.getId());
        System.out.println("Descripción: " + this.getDescripcion());
        System.out.println("Tamaño:  " +this.tamanio);
        System.out.println("Temperatura deseada:  " +this.temperatura);
        System.out.println("Precio: $" +calcularCosto());
    }
}
