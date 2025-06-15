public class Postre extends Producto {
    private String tipo;

    public Postre (String id, String nombre, double precio, String descripcion, String tipo){
        super (id,nombre,precio,descripcion);
        this.tipo= tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    @Override
    public double calcularCosto(){
        return getPrecio();
    }
    @Override
    public void mostrarDetalles(){
        System.out.print(" |Postre: "+this.getNombre());
        System.out.print(" |ID: "+this.getId());
        System.out.print(" |Descripcion: "+this.getDescripcion());
        System.out.print(" |Tipo de postre: "+this.tipo);
        System.out.print(" |Precio: $"+calcularCosto());
        System.out.println(" ");
    }
}
