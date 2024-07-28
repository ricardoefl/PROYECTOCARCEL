package Model;
public class Empleado extends Persona{
    //ATRIBUTOS
    public String cargo;
    public double salario;
    public int horasTrabajadas;
    public double valorXHora;
    public String telefonoContacto;
    public String fechaContratacion;
    public int aniosTrabajados;
    //CONSTRUCTOR
    public Empleado(String cargo, int horasTrabajadas, double valorXHora, String telefonoContacto, String fechaContratacion, int aniosTrabajados, String nombreCompleto, String cedula, int edad, String lugarNacimiento, String genero) {
        super(nombreCompleto, cedula, edad, lugarNacimiento, genero);
        this.cargo = cargo;
        this.horasTrabajadas = horasTrabajadas;
        this.valorXHora = valorXHora;
        this.telefonoContacto = telefonoContacto;
        this.fechaContratacion = fechaContratacion;
        this.aniosTrabajados = aniosTrabajados;
    }
    
    
}
