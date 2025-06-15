public class Cliente {
    private String nombre;
    private String telefono;


    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }

}
