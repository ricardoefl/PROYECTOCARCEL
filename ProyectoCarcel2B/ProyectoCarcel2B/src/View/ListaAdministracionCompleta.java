package View;

import Controller.SistemaAdministracionCarcel;
import Model.EmpleadoAdministracion;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaAdministracionCompleta extends javax.swing.JPanel {
    DefaultTableModel modelo;
    
    public ListaAdministracionCompleta() {
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
                "#Empleado", "Nombre", "Cedula", "Edad", "LugarNacimiento", "Genero", "Cargo", "Salario", "HorasTrabajadas", "Valorxhora", "Telefono", "FechaContratacion", "AniosTrabajados", "NivelAcademico", "HabilidadesBlandas", "IdiomasHablados", "CertificacionesAdicionales"
            }
        ));
        jScrollPane1.setViewportView(listaCompleta);
        if (listaCompleta.getColumnModel().getColumnCount() > 0) {
            listaCompleta.getColumnModel().getColumn(0).setPreferredWidth(60);
            listaCompleta.getColumnModel().getColumn(1).setPreferredWidth(310);
            listaCompleta.getColumnModel().getColumn(2).setPreferredWidth(155);
            listaCompleta.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("LISTA COMPLETA DE EMPLEADOS DE ADMINISTRACION  -  PENITENCIARIA DE LOJA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(101, 101, 101))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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
        ArrayList<EmpleadoAdministracion> listaAdministracion = new ArrayList<EmpleadoAdministracion>();
        SistemaAdministracionCarcel sistema = new SistemaAdministracionCarcel();
        listaAdministracion = sistema.getLstAdministracion();
        for (EmpleadoAdministracion emp: listaAdministracion) 
            this.modelo.addRow(new Object[]{emp.numAdministracion, emp.nombreCompleto, 
                emp.cedula, emp.edad, emp.lugarNacimiento, emp.genero, emp.cargo, 
                emp.salario, emp.horasTrabajadas, emp.valorXHora, emp.telefonoContacto, 
                emp.fechaContratacion, emp.aniosTrabajados, emp.nivelAcademico, 
                emp.habilidadesBlandas, emp.idiomasHablados, emp.certificadosAdicionales});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaCompleta;
    // End of variables declaration//GEN-END:variables
}
