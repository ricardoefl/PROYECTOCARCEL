package Model;

public class EmpleadoAdministracion extends Empleado{
    //ATRIBUTOS
    public int numAdministracion;
    public String nivelAcademico;
    public String idiomasHablados;
    public String habilidadesBlandas;
    public String certificadosAdicionales;

    public EmpleadoAdministracion(int numAdministracion, String nivelAcademico, String idiomasHablados, String habilidadesBlandas, String certificadosAdicionales, String cargo, int horasTrabajadas, double valorXHora, String telefonoContacto, String fechaContratacion, int aniosTrabajados, String nombreCompleto, String cedula, int edad, String lugarNacimiento, String genero) {
        super(cargo, horasTrabajadas, valorXHora, telefonoContacto, fechaContratacion, aniosTrabajados, nombreCompleto, cedula, edad, lugarNacimiento, genero);
        this.numAdministracion = numAdministracion;
        this.nivelAcademico = nivelAcademico;
        this.idiomasHablados = idiomasHablados;
        this.habilidadesBlandas = habilidadesBlandas;
        this.certificadosAdicionales = certificadosAdicionales;
    }

    @Override
    public String toString() {
        return "EmpleadoAdministracion{" + "numAdministracion=" + numAdministracion + ", nivelAcademico=" + nivelAcademico + ", idiomasHablados=" + idiomasHablados + ", habilidadesBlandas=" + habilidadesBlandas + ", certificadosAdicionales=" + certificadosAdicionales + '}';
    }
    
}
