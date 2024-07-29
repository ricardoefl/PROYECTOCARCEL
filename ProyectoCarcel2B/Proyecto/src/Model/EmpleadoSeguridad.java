package Model;
public class EmpleadoSeguridad extends Empleado{
    //ATRIBUTOS
    public int numSeguridad;
    public String pabellon;
    public String tipoLicenciaArma;
    public String nivelEntrenamiento;
    public String limitanteFisico;
    public String equipoProteccion;
    
    //CONSTRUCTOR
    public EmpleadoSeguridad(int numSeguridad, String pabellon, String tipoLicenciaArma, 
            String nivelEntrenamiento, String limitanteFisico, 
            String equipoProteccion, String cargo,
            int horasTrabajadas, double valorXHora, String telefonoContacto, 
            String fechaContratacion, int aniosTrabajados, String nombreCompleto, 
            String cedula, int edad, String lugarNacimiento, String genero) {
        super(cargo, horasTrabajadas, valorXHora, telefonoContacto, 
                fechaContratacion, aniosTrabajados, nombreCompleto, cedula, edad, 
                lugarNacimiento, genero);
        this.numSeguridad = numSeguridad;
        this.pabellon = pabellon;
        this.tipoLicenciaArma = tipoLicenciaArma;
        this.nivelEntrenamiento = nivelEntrenamiento;
        this.limitanteFisico = limitanteFisico;
        this.equipoProteccion = equipoProteccion;
    }   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NUMERO: ").append(numSeguridad).append("\n");
        sb.append(super.toString());
        sb.append("PABELLON:").append(pabellon).append("\n");
        sb.append("TIPO DE LICENCIA DE ARMA: ").append(tipoLicenciaArma).append("\n");
        sb.append("NIVEL DE ENTRENAMIENTO: ").append(nivelEntrenamiento).append("\n");
        sb.append("LIMITANTE FISICO: ").append(limitanteFisico).append("\n");
        sb.append("EQUIPO DE PROTECCION: ").append(equipoProteccion);
        return sb.toString();
    }
    
}