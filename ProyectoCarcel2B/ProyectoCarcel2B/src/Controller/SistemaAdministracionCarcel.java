package Controller;

import Model.*;
import java.util.ArrayList;
import java.sql.Connection;

public class SistemaAdministracionCarcel {
    //ATRIBUTOS
    protected ArrayList<Pabellon> listaPabellones;

    //CONSTRUCTOR

    public SistemaAdministracionCarcel() {
        this.listaPabellones = new ArrayList<>();
        clasificarxPabellonDB();
    }
    //METER A LOS PPL EN SUS RESPECTIVOS PPL
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
