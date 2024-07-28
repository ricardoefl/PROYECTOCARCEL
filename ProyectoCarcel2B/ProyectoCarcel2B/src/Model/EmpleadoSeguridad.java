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
        return "EmpleadoSeguridad{" + "numSeguridad=" + numSeguridad + ", pabellon=" + pabellon + ", tipoLicenciaArma=" + tipoLicenciaArma + ", nivelEntrenamiento=" + nivelEntrenamiento + ", limitanteFisico=" + limitanteFisico + ", equipoProteccion=" + equipoProteccion + '}';
    }

    
    
}