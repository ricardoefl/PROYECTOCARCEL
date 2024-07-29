package Controller;

import Model.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class SistemaAdministracionCarcel {
    //ATRIBUTOS
    protected ArrayList<Pabellon> listaPabellones;
    protected ArrayList<PPL> listaPPL; // ATRIBUTO AUX
    protected ArrayList<EmpleadoSeguridad> listaSeguridad; // ATRIBUTO AUX
    protected ArrayList<EmpleadoAdministracion> listaAdministracion;

    //CONSTRUCTOR
    public SistemaAdministracionCarcel() {
        this.listaPabellones = new ArrayList<>();
        this.listaPPL = getLstPPL();
        this.listaSeguridad = getLstSeguridad();
        this.listaAdministracion = getLstAdministracion();
        clasificarxPabellonDB();
    }
    //ELIMINAR
    public boolean eliminarEmp(String cedula){
        if(((new ConeccionDB()).eliminarEmpleadoSeguridad(cedula))||
                ((new ConeccionDB()).eliminarEmpleadoAdministracion(cedula))){
        return true;
    }
        return false;
    }
    public boolean eliminarPPL(String cedula){
        return (new ConeccionDB()).eliminarPPL(cedula);
    }
    //INSERTAR
    public void insertarPPL(PPL ppl){
        (new ConeccionDB()).insertarPPL(ppl);
    }
    //BUSCAR:
    public PPL buscarPPL(String cedula){
        return (new ConeccionDB()).consultarPPL(cedula);
    }
    public Empleado buscarEmpleado(String cedula){
        if((new ConeccionDB()).consultarEmpleadoAdministracion(cedula) != null){
            return (new ConeccionDB()).consultarEmpleadoAdministracion(cedula);
        }
        if((new ConeccionDB()).consultarEmpleadoSeguridad(cedula) != null){
            return (new ConeccionDB()).consultarEmpleadoSeguridad(cedula);
        }
        return null;
    }
    
    //METER A LOS PPL EN SUS RESPECTIVOS PABELLONES
    public void clasificarxPabellonDB() {
        String nombrePabellon;
        //LISTAS DE PPL
        ArrayList<PPL> redencionPPL = new ArrayList<>();
        ArrayList<PPL> fraternidadPPL = new ArrayList<>();
        ArrayList<PPL> sombraPPL = new ArrayList<>();
        ArrayList<PPL> inquisicionPPL = new ArrayList<>();
        
        //LISTAS DE EMPLEADOS DE SEGURIDAD
        ArrayList<EmpleadoSeguridad> redencionSeguridad = new ArrayList<>();
        ArrayList<EmpleadoSeguridad> fraternidadSeguridad = new ArrayList<>();
        ArrayList<EmpleadoSeguridad> sombraSeguridad = new ArrayList<>();
        ArrayList<EmpleadoSeguridad> inquisicionSeguridad = new ArrayList<>();
        
        for (PPL ppl : getLstPPL()) {
            nombrePabellon = ppl.pabellon;
            switch (nombrePabellon) {
                case "Inquisicion":
                    inquisicionPPL.add(ppl);
                    break;
                case "Sombra":
                    sombraPPL.add(ppl);
                    break;
                case "Fraternidad":
                    fraternidadPPL.add(ppl);
                    break;
                case "Redencion":
                    redencionPPL.add(ppl);
                    break;
            }
        }
        for (EmpleadoSeguridad emp : getLstSeguridad()) {
            nombrePabellon = emp.pabellon;
            switch (nombrePabellon) {
                case "Inquisicion":
                    inquisicionSeguridad.add(emp);
                    break;
                case "Sombra":
                    sombraSeguridad.add(emp);
                    break;
                case "Fraternidad":
                    fraternidadSeguridad.add(emp);
                    break;
                case "Redencion":
                    redencionSeguridad.add(emp);
                    break;
            }
        }
        Pabellon PabellonRedencion = new Pabellon("Redencion", 
                "Baja Peligrosidad", redencionSeguridad, 
                redencionPPL);
        Pabellon PabellonFraternidad = new Pabellon("Fraternidad", 
                "Baja Peligrosidad", fraternidadSeguridad,
                fraternidadPPL);
        Pabellon PabellonSombra = new Pabellon("Sombra", 
                "Media Peligrosidad", sombraSeguridad,
                sombraPPL);
        Pabellon PabellonInquisicion = new Pabellon("Redencion", 
                "Maxima Peligrosidad", inquisicionSeguridad, 
                inquisicionPPL);
        
        this.listaPabellones.add(PabellonInquisicion); // 0 
        this.listaPabellones.add(PabellonSombra); // 1
        this.listaPabellones.add(PabellonFraternidad); // 2
        this.listaPabellones.add(PabellonRedencion); // 3
    }
    //CAMBIAR NUMEROS DE PPL CUANDO SE MUESTRAN POR PABELLONES
    public ArrayList<PPL> cambiarNumeracionPPL(ArrayList<PPL> listaPPL){
        for (int i = 0; i < listaPPL.size(); i++) {
            listaPPL.get(i).numPPL = (i+1);
        }
        return listaPPL;
    }
    //CAMBIAR NUMEROS DE EMPLEADOS DE SEGURIDAD CUANDO SE MUESTRAN POR PABELLONES
    public ArrayList<EmpleadoSeguridad> cambiarNumeracionSeg(
            ArrayList<EmpleadoSeguridad> listaSeguridad){
        for (int i = 0; i < listaSeguridad.size(); i++) {
            listaSeguridad.get(i).numSeguridad = (i+1);
        }
        return listaSeguridad;
    }
        // CALCULO DE SALARIOS DE LOS EMPLEADOS ADMINISTRATIVOS
    public Map<Integer, Double> calcularSalario() {
        Map<Integer, Double> salarios = new HashMap<>();
        for (EmpleadoAdministracion empleado : listaAdministracion) {
            double salario = empleado.valorXHora * empleado.horasTrabajadas;
            salarios.put(empleado.numAdministracion, salario);
        }

        return salarios;
    }

    // CALCULO PROMEDIO DE LAS EDADES DE LOS PRESOS
    public double calcularPromedioEdadesPPL() {
        int sumaEdades = 0;
        for (PPL ppl : this.listaPPL) {
            sumaEdades += ppl.edad;
        }
        return (double) sumaEdades / this.listaPPL.size();
    }

    // CALCULO PROMEDIO DE LAS EDADES DE LOS EMPLEADOS DE SEGURIDAD
    public double calcularPromedioEdadesSeguridad() {
        int sumaEdades = 0;
        for (EmpleadoSeguridad empleadoSeguridad : this.listaSeguridad) {
            sumaEdades += empleadoSeguridad.edad;
        }
        return (double) sumaEdades / this.listaSeguridad.size();
    }
    // CALCULO PROMEDIO DE LAS EDADES DE LOS EMPLEADOS ADMINISTRATIVOS
    public double calcularPromedioEdadesAdministracion() {
        int sumaEdades = 0;
        for (EmpleadoAdministracion empleado : this.listaAdministracion) {
            sumaEdades += empleado.edad;
        }
        return (double) sumaEdades / this.listaAdministracion.size();
    }
    // CALCULO PROMEDIO DE LAS PENAS DE LOS PRESOS
    public double calcularPromPenas() {
        int sumaPenas = 0;
        for (PPL ppl : this.listaPPL) {
            sumaPenas += ppl.penaAsignada;
        }
        return (double) sumaPenas / this.listaPPL.size();
    }
    // CALCULO PROMEDIO DE LOS ANIOS TRABAJADOS DE LOS EMPLEADOS ADMINISTRATIVOS
    public double calcularPromAniosTrabajadosAdministracion() {
        int sumaAniosTrabajados = 0;
        for (EmpleadoAdministracion empleado : this.listaAdministracion) {
            sumaAniosTrabajados += empleado.aniosTrabajados;
        }
        return (double) sumaAniosTrabajados / this.listaAdministracion.size();
    }
    // CALCULO PROMEDIO DE LOS ANIOS TRABAJADOS DE LOS EMPLEADOS DE SEGURIDAD
    public double calcularPromAniosTrabajadosSeguridad() {
        int sumaAniosTrabajados = 0;
        for (EmpleadoSeguridad empleado : this.listaSeguridad) {
            sumaAniosTrabajados += empleado.aniosTrabajados;
        }
        return (double) sumaAniosTrabajados / this.listaSeguridad.size();
    }
    // CALCULO PROMEDIO DE LAS HORAS TRABAJADAS DE LOS EMPLEADOS DE SEGURIDAD
    public double calcularPromHorasTrabajadosSeguridad() {
        int sumaHorasTrabajados = 0;
        for (EmpleadoSeguridad empleado : this.listaSeguridad) {
            sumaHorasTrabajados += empleado.horasTrabajadas;
        }
        return (double) sumaHorasTrabajados / this.listaSeguridad.size();
    }
    // CALCULO PROMEDIO DE LAS HORAS TRABAJADAS DE LOS EMPLEADOS DE ADMINISTRATIVOS
    public double calcularPromHorasTrabajadosAdministracion() {
        int sumaHorasTrabajados = 0;
        for (EmpleadoAdministracion empleado : this.listaAdministracion) {
            sumaHorasTrabajados += empleado.horasTrabajadas;
        }
        return (double) sumaHorasTrabajados / this.listaAdministracion.size();
    }
    // CONTEO DE LOS DELITOS QUE EXISTEN EN LA CARCEL
    public String conteoDelitos() {
        ArrayList<String> delitos = new ArrayList<>();
        StringBuilder s = new StringBuilder("Conteo de Delitos: \n");
        for (PPL ppl : listaPPL) {
            delitos.add(ppl.delitoCometido);

        }
        HashMap<String, Integer> conteoDelitos = new HashMap<>();
        for (String delito : delitos) {
            conteoDelitos.put(delito, conteoDelitos.getOrDefault(delito, 0) + 1);
        }
        for (String delito : conteoDelitos.keySet()) {
            s.append(delito).append(": ").append(conteoDelitos.get(delito)).append("\n");
        }
        return s.toString();
    }
    // CONTEO DE LOS LUGARES DE NACIMIENTO DE LOS PRESOS
    public String conteoLugaresNacimientoPPL() {
        ArrayList<String> lugaresNacimiento = new ArrayList<>();
        StringBuilder s = new StringBuilder("Lugares de nacimiento: \n");
        for (PPL ppl : listaPPL) {
            lugaresNacimiento.add(ppl.lugarNacimiento);
        }
        HashMap<String, Integer> conteoLugares = new HashMap<>();
        for (String lugar : lugaresNacimiento) {
            conteoLugares.put(lugar, conteoLugares.getOrDefault(lugar, 0) + 1);
        }
        for (String lugar : conteoLugares.keySet()) {
            s.append(lugar).append(": ").append(conteoLugares.get(lugar)).append("\n");
        }
        return s.toString();
    }
        // CONTEO DE LOS LUGARES DE NACIMIENTO DE LOS EMPLEADOS DE SEGURIDAD
        public String conteoLugaresNacimientoSeguridad() {
        ArrayList<String> lugaresNacimiento = new ArrayList<>();
        StringBuilder s = new StringBuilder("Lugares de nacimiento: \n");
        for (EmpleadoSeguridad seguridad : listaSeguridad) {
            lugaresNacimiento.add(seguridad.lugarNacimiento);
        }
        HashMap<String, Integer> conteoLugares = new HashMap<>();
        for (String lugar : lugaresNacimiento) {
            conteoLugares.put(lugar, conteoLugares.getOrDefault(lugar, 0) + 1);
        }
        for (String lugar : conteoLugares.keySet()) {
            s.append(lugar).append(": ").append(conteoLugares.get(lugar)).append("\n");
        }
        return s.toString();
    }
            // CONTEO DE LOS LUGARES DE NACIMIENTO DE LOS EMPLEADOS ADMINISTRATIVOS
            public String conteoLugaresNacimientoAdministracion() {
        ArrayList<String> lugaresNacimiento = new ArrayList<>();
        StringBuilder s = new StringBuilder("Lugares de nacimiento: \n");
        for (EmpleadoAdministracion administracion : listaAdministracion) {
            lugaresNacimiento.add(administracion.lugarNacimiento);
        }
        HashMap<String, Integer> conteoLugares = new HashMap<>();
        for (String lugar : lugaresNacimiento) {
            conteoLugares.put(lugar, conteoLugares.getOrDefault(lugar, 0) + 1);
        }
        for (String lugar : conteoLugares.keySet()) {
            s.append(lugar).append(": ").append(conteoLugares.get(lugar)).append("\n");
        }
        return s.toString();
    }
            // CONTEO DEL NIVEL ACADEMICO DE LOS EMPLEADOS ADMINISTRATIVOS
    public String conteoNivelAcademico() {
        ArrayList<String> nivelesAcademicos = new ArrayList<>();
        StringBuilder s = new StringBuilder("Niveles Academicos: \n");
        for (EmpleadoAdministracion empleado : listaAdministracion) {
            nivelesAcademicos.add(empleado.nivelAcademico);
        }
        HashMap<String, Integer> conteoNivelAcademico = new HashMap<>();
        for (String nivel : nivelesAcademicos) {
            conteoNivelAcademico.put(nivel, conteoNivelAcademico.getOrDefault(nivel, 0) + 1);
        }
        for (String nivel : conteoNivelAcademico.keySet()) {
            s.append(nivel).append(": ").append(conteoNivelAcademico.get(nivel)).append("\n");
        }
        return s.toString();
    }
    // CONTEO DE LOS IDIOMAS HABLADOS DE LOS EMPLEADOS ADMINISTRATIVOS
    public String conteoIdiomas() {
        ArrayList<String> idiomas = new ArrayList<>();
        StringBuilder s = new StringBuilder("Idiomas: \n");
        for (EmpleadoAdministracion empleado : listaAdministracion) {
            idiomas.add(empleado.idiomasHablados);
        }
        HashMap<String, Integer> conteoIdiomas = new HashMap<>();
        for (String idioma : idiomas) {
            conteoIdiomas.put(idioma, conteoIdiomas.getOrDefault(idioma, 0) + 1);
        }
        for (String idioma : conteoIdiomas.keySet()) {
            s.append(idioma).append(": ").append(conteoIdiomas.get(idioma)).append("\n");
        }
        return s.toString();
    }
    // CONTEO DE LAS HABILIDADAS BLANDAS DE LOS EMPLEADOS ADMINISTRATIVOS
    public String conteoHabilidadesBlandas() {
        ArrayList<String> habilidades = new ArrayList<>();
        StringBuilder s = new StringBuilder("Habilidades Blandas: \n");
        for (EmpleadoAdministracion empleado : listaAdministracion) {
            habilidades.add(empleado.idiomasHablados);
        }
        HashMap<String, Integer> conteoHabilidades = new HashMap<>();
        for (String habilidad : habilidades) {
            conteoHabilidades.put(habilidad, conteoHabilidades.getOrDefault(habilidad, 0) + 1);
        }
        for (String habilidad : conteoHabilidades.keySet()) {
            s.append(habilidad).append(": ").append(conteoHabilidades.get(habilidad)).append("\n");
        }
        return s.toString();
    }
    // CONETO DE LAS CERTIFICACIONES DE LOS EMPLEADOS ADMINISTRATIVOS
    public String conteoCertificacionesAdicionales() {
        ArrayList<String> certificaciones = new ArrayList<>();
        StringBuilder s = new StringBuilder("Certificaciones Adicionales: \n");
        for (EmpleadoAdministracion empleado : listaAdministracion) {
            certificaciones.add(empleado.certificadosAdicionales);
        }
        HashMap<String, Integer> conteoHabilidades = new HashMap<>();
        for (String certificados : certificaciones) {
            conteoHabilidades.put(certificados, conteoHabilidades.getOrDefault(certificados, 0) + 1);
        }
        for (String certificados : conteoHabilidades.keySet()) {
            s.append(certificados).append(": ").append(conteoHabilidades.get(certificados)).append("\n");
        }
        return s.toString();
    }
    // CONTEO DEL TIPO DE ARMA QUE USAN LOS EMPLEADOS DE SEGURIDAD
    public String conteoTipoArma() {
        ArrayList<String> tipoArma = new ArrayList<>();
        StringBuilder s = new StringBuilder("Tipos de Licencia de Arma: \n");
        for (EmpleadoSeguridad empleado : listaSeguridad) {
            tipoArma.add(empleado.tipoLicenciaArma);
        }
        HashMap<String, Integer> conteoTipoArma = new HashMap<>();
        for (String arma : tipoArma) {
            conteoTipoArma.put(arma, conteoTipoArma.getOrDefault(arma, 0) + 1);
        }
        for (String arma : conteoTipoArma.keySet()) {
            s.append(arma).append(": ").append(conteoTipoArma.get(arma)).append("\n");
        }
        return s.toString();
    }
    // CONTEO DEL NIVEL DE ENTREAMIENTO DE LOS EMPLEADOS DE SEGURIDAD
    public String conteoNivelEntrenamiento() {
        ArrayList<String> nivelEntrenamiento = new ArrayList<>();
        StringBuilder s = new StringBuilder("Niveles de Entrenamiento: \n");
        for (EmpleadoSeguridad empleado : listaSeguridad) {
            nivelEntrenamiento.add(empleado.nivelEntrenamiento);
        }
        HashMap<String, Integer> conteoNivelEntrenamiento = new HashMap<>();
        for (String nivel : nivelEntrenamiento) {
            conteoNivelEntrenamiento.put(nivel, conteoNivelEntrenamiento.getOrDefault(nivel, 0) + 1);
        }
        for (String nivel : conteoNivelEntrenamiento.keySet()) {
            s.append(nivel).append(": ").append(conteoNivelEntrenamiento.get(nivel)).append("\n");
        }
        return s.toString();
    }
    // CONTEO DE LAS LIMITANTES QUE TIENEN LOS EMPLEADOS DE SEGURIDAD
    public String conteoLimitante() {
        ArrayList<String> limitante = new ArrayList<>();
        StringBuilder s = new StringBuilder("Limitante: \n");
        for (EmpleadoSeguridad empleado : listaSeguridad) {
            limitante.add(empleado.limitanteFisico);
        }
        HashMap<String, Integer> conteoLimitante = new HashMap<>();
        for (String nivel : limitante) {
            conteoLimitante.put(nivel, conteoLimitante.getOrDefault(nivel, 0) + 1);
        }
        for (String nivel : conteoLimitante.keySet()) {
            s.append(nivel).append(": ").append(conteoLimitante.get(nivel)).append("\n");
        }
        return s.toString();
    }
    // CONTEO DEL EQUIPAMIENTO QUE TIENEN LOS EMPLEADOS DE SEGURIDAD
    public String conteoEquipamiento() {
        ArrayList<String> equipamiento = new ArrayList<>();
        StringBuilder s = new StringBuilder("Equipamiento: \n");
        for (EmpleadoSeguridad empleado : listaSeguridad) {
            equipamiento.add(empleado.equipoProteccion);
        }
        HashMap<String, Integer> conteoEquipamiento = new HashMap<>();
        for (String nivel : equipamiento) {
            conteoEquipamiento.put(nivel, conteoEquipamiento.getOrDefault(nivel, 0) + 1);
        }
        for (String nivel : conteoEquipamiento.keySet()) {
            s.append(nivel).append(": ").append(conteoEquipamiento.get(nivel)).append("\n");
        }
        return s.toString();
    }
    public ArrayList<Pabellon> getListaPabellones() {
        return listaPabellones;
    }
    
    public ArrayList<PPL> getLstPPL() {
        return (new ConeccionDB()).getListaPPL();
    }
    public ArrayList<EmpleadoSeguridad> getLstSeguridad() {
        return (new ConeccionDB()).getListaEmpleadosSeguridad();
    }
    public ArrayList<EmpleadoAdministracion> getLstAdministracion() {
        return (new ConeccionDB()).getListaEmpleadosAdministracion();
    }
}