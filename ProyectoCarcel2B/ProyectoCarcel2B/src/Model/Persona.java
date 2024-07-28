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
    
}
