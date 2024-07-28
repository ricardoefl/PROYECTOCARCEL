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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NUMERO: ").append(numPPL).append("\n");
        sb.append(super.toString());
        sb.append("ALIAS: ").append(alias).append("\n");
        sb.append("CLASIFICACION: ").append(clasificacion).append("\n");
        sb.append("CELDA: ").append(celda).append("\n");
        sb.append("PABELLON: ").append(pabellon).append("\n");
        sb.append("FECHA DE INGRESO: ").append(fechaIngreso).append("\n");
        sb.append("FECHA DE SALIDA: ").append(fechaSalida).append("\n");
        sb.append("PENA ASIGNADA: ").append(penaAsignada).append("\n");
        sb.append("ANIOS RESTANTES: ").append(aniosRestantes).append("\n");
        sb.append("DELITO COMETIDO: ").append(delitoCometido).append("\n");
        sb.append("VISITAS SEMANALES (HORAS): ").append(visitasSemanales);
        return sb.toString();
    }
       
}