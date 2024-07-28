package View;

import Controller.SistemaAdministracionCarcel;
import Model.PPL;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaPPL_P1 extends javax.swing.JPanel {
    DefaultTableModel modelo;
    
    public ListaPPL_P1() {
        initComponents();
        modelo = (DefaultTableModel) this.listaCompleta.getModel();
        mostrarTabla();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCompleta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        listaCompleta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#PPL", "Nombre", "Cedula", "Edad", "LugarNacimiento", "Genero", "Alias", "Clasificacion", "Celda", "Pabellon", "FechaIngreso", "FechaSalida", "Pena", "AniosRestantes", "Delito", "VisitasSemanales"
            }
        ));
        jScrollPane1.setViewportView(listaCompleta);
        if (listaCompleta.getColumnModel().getColumnCount() > 0) {
            listaCompleta.getColumnModel().getColumn(0).setPreferredWidth(60);
            listaCompleta.getColumnModel().getColumn(1).setPreferredWidth(310);
            listaCompleta.getColumnModel().getColumn(2).setPreferredWidth(155);
            listaCompleta.getColumnModel().getColumn(3).setPreferredWidth(60);
            listaCompleta.getColumnModel().getColumn(9).setPreferredWidth(135);
            listaCompleta.getColumnModel().getColumn(14).setPreferredWidth(120);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PABELLON 1: \"INQUISICION\" - TIPO: ALTA PELIGOSIDAD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(205, 205, 205))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(441, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void mostrarTabla(){
        while(modelo.getRowCount() > 0)
        this.modelo.removeRow(0);
        ArrayList<PPL> listaPPL = new ArrayList<PPL>();
        ArrayList<PPL> listaPPLaux = new ArrayList<PPL>();
        SistemaAdministracionCarcel sistema = new SistemaAdministracionCarcel();
        listaPPL = sistema.getListaPabellones().get(0).listaPPL;
        listaPPLaux =sistema.cambiarNumeracionPPL(listaPPL);
        for (PPL ppl : listaPPLaux) 
            this.modelo.addRow(new Object[]{ppl.numPPL, ppl.nombreCompleto, 
                ppl.cedula, ppl.edad, ppl.lugarNacimiento, ppl.genero, ppl.alias, 
                ppl.clasificacion, ppl.celda, ppl.pabellon, ppl.fechaIngreso, 
                ppl.fechaSalida, ppl.penaAsignada, ppl.aniosRestantes, 
                ppl.delitoCometido, ppl.visitasSemanales});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaCompleta;
    // End of variables declaration//GEN-END:variables
}
