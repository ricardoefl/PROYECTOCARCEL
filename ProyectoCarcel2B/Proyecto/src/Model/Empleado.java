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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("CARGO: ").append(cargo).append("\n");
        sb.append("SALARIO:").append(salario).append("\n");
        sb.append("HORAS TRABAJADAS (SEMANALES): ").append(horasTrabajadas).append("\n");
        sb.append("VALOR POR HORA: ").append(valorXHora).append("\n");
        sb.append("TELEFONO DE CONTACTO: ").append(telefonoContacto).append("\n");
        sb.append("FECHA DE CONTRATACION:").append(fechaContratacion).append("\n");
        sb.append("ANIOS TRABAJADOS: ").append(aniosTrabajados).append("\n");
        return sb.toString();
    }
    
}