package Model;
public class PPL extends Persona{
    //ATRIBUTOS
    public int numPPL;
    public String alias;
    public String clasificacion;
    public String celda;
    public String pabellon;
    public String fechaIngreso;
    public String fechaSalida;
    public int penaAsignada;
    public int aniosRestantes;
    public String delitoCometido;
    public int visitasSemanales;
    
    //CONSTRUCTOR
    public PPL(int numPPL,String nombreCompleto, String cedula, int edad, 
            String lugarNacimiento, String genero, String alias, 
            String clasificacion, String celda, String pabellon, 
            String fechaIngreso, String fechaSalida, int penaAsignada, 
            int aniosRestantes, String delitoCometido, int visitasSemanales) {
        super(nombreCompleto, cedula, edad, lugarNacimiento, genero);
        this.numPPL = numPPL;
        this.alias = alias;
        this.clasificacion = clasificacion;
        this.celda = celda;
        this.pabellon = pabellon;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.penaAsignada = penaAsignada;
        this.aniosRestantes = aniosRestantes;
        this.delitoCometido = delitoCometido;
        this.visitasSemanales = visitasSemanales;
    }
    
    //TOSTRING PARA PRUEBAS
    @Override
    public String toString() {
        return "PPL{" + "numPPL=" + numPPL + ", alias=" + alias + ", clasificacion=" + clasificacion + ", celda=" + celda + ", pabellon=" + pabellon + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", penaAsignada=" + penaAsignada + ", aniosRestantes=" + aniosRestantes + ", delitoCometido=" + delitoCometido + ", visitasSemanales=" + visitasSemanales + '}';
    }
    
    
}
