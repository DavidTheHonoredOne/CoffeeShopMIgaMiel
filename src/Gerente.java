public class Gerente extends Persona{
    private String turno;
    public Gerente(String id, String nombre, String telefono, String turno) {
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

    @Override
    public void mostrarInfoPersonal() {
        System.out.println("---Gerente---");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Turno: " + getTurno());
    }
}
