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
        ArrayList<PPL> redencion = new ArrayList<>();
        ArrayList<PPL> fraternidad = new ArrayList<>();
        ArrayList<PPL> sombra = new ArrayList<>();
        ArrayList<PPL> inquisicion = new ArrayList<>();
        
        for (PPL ppl : getLstPPL()) {
            nombrePabellon = ppl.pabellon;
            switch (nombrePabellon) {
                case "Inquisicion":
                    inquisicion.add(ppl);
                    break;
                case "Sombra":
                    sombra.add(ppl);
                    break;
                case "Fraternidad":
                    fraternidad.add(ppl);
                    break;
                case "Redencion":
                    redencion.add(ppl);
                    break;
            }
        }
        Pabellon PabellonRedencion = new Pabellon("Redencion", 
                "Baja Peligrosidad", redencion);
        Pabellon PabellonFraternidad = new Pabellon("Fraternidad", 
                "Baja Peligrosidad", fraternidad);
        Pabellon PabellonSombra = new Pabellon("Sombra", 
                "Media Peligrosidad", sombra);
        Pabellon PabellonInquisicion = new Pabellon("Redencion", 
                "Maxima Peligrosidad", inquisicion);
        
        this.listaPabellones.add(PabellonInquisicion); // 0
        this.listaPabellones.add(PabellonSombra); // 1
        this.listaPabellones.add(PabellonFraternidad); // 2
        this.listaPabellones.add(PabellonRedencion); // 3
    }
    //CAMBIAR NUMEROS DE PPL CUANDO SE MUESTRAN POR PABELLONES
    public ArrayList<PPL> cambiarNumeracion(ArrayList<PPL> listaPPL){
        for (int i = 0; i < listaPPL.size(); i++) {
            listaPPL.get(i).numPPL = (i+1);
        }
        return listaPPL;
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
