package Model;
public class Persona {
    //ATRIBUTOS
    public String nombreCompleto;
    public String cedula;
    public int edad;
    public String lugarNacimiento;
    public String genero;
    
    //CONSTRUCTOR
    public Persona(String nombreCompleto, String cedula, int edad, String lugarNacimiento, String genero) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.edad = edad;
        this.lugarNacimiento = lugarNacimiento;
        this.genero = genero;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NOMBRE COMPLETO: ").append(nombreCompleto).append("\n");
        sb.append("CEDULA: ").append(cedula).append("\n");
        sb.append("EDAD: ").append(edad).append("\n");
        sb.append("LUGAR DE NACIMIENTO: ").append(lugarNacimiento).append("\n");
        sb.append("GENERO: ").append(genero).append("\n");
        return sb.toString();
    }
    
}
