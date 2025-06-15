public class Empleado extends Persona{
   private String turno;
   public Empleado(String id, String nombre, String telefono, String turno) {
       super(id, nombre, telefono);
       this.turno = turno;
   }
   //Setters
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public String getTurno() {
        return turno;
    }
    //Methods Override
    @Override
    public void obtenerRol() {
        System.out.println("Soy un empleado.");
    }
    @Override
    public void mostrarInfoPersonal() {
        System.out.println("---Empleado---");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Turno: " + getTurno());
    }
}
