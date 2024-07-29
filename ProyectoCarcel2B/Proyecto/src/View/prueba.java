package View;

import Controller.SistemaAdministracionCarcel;
import Model.PPL;

public class prueba {
    public static void main(String[] args) {
        /*PPL ppl = new PPL(2001, "Ricardo Fabian Espinosa Largo", "0000000000", 20, 
                "Chone", "Masculino", "Pie Grande", "Maxima Peligrosidad", 
                "T9", "Increible", "28/07/2024", "28/072030", 6, 
                6, "Muy guapo", 4);
        SistemaAdministracionCarcel sistema = new SistemaAdministracionCarcel();
        sistema.insertarPPL(ppl);*/
        SistemaAdministracionCarcel sistema = new SistemaAdministracionCarcel();
        System.out.println(sistema.eliminarEmp("1285913089"));
    }
}