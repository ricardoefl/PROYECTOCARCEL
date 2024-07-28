package Model;
import java.util.ArrayList;
public class Pabellon {
    //ATRIBUTOS
    public String nombre;
    public String clasificacion;
    public ArrayList<Persona> listaEmpleadoSeguridad;
    public ArrayList<PPL> listaPPL;
    
    //CONSTRUCTOR
    public Pabellon(String nombre, String clasificacion, ArrayList<PPL> listaPPL) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.listaPPL = listaPPL;
    }
    
}
