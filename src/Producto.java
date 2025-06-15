public abstract class  Producto implements Verificable {
    private String id;
    private String nombre;
    private double precio;
    private String descripcion;

    public Producto(String id, String nombre, double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public abstract double calcularCosto();

    public abstract void mostrarDetalles();
    @Override
    public String obtenerIdVerificacion(){
        return "Producto" + this.getId();
    }
    @Override
    public String obtenerResumenVerificacion(){
        return "Producto: "+this.nombre+ " Precio: $"+this.precio;
    }

}
