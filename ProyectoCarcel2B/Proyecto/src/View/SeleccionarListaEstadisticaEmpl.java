package View;
import View.EstadisticaAdministracion;
import View.EstadisticaSeguridad;
import java.awt.BorderLayout;
public class SeleccionarListaEstadisticaEmpl extends javax.swing.JPanel {
    public SeleccionarListaEstadisticaEmpl() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicio = new javax.swing.JPanel();
        tipoLista = new javax.swing.JComboBox<>();
        mostrar = new javax.swing.JButton();

        inicio.setBackground(new java.awt.Color(102, 153, 255));
        inicio.setBorder(new javax.swing.border.MatteBorder(null));
        inicio.setForeground(new java.awt.Color(255, 255, 255));

        tipoLista.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tipoLista.setForeground(new java.awt.Color(0, 0, 0));
        tipoLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEGURIDAD", "ADMINISTRACION" }));
        tipoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoListaActionPerformed(evt);
            }
        });

        mostrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mostrar.setForeground(new java.awt.Color(0, 0, 0));
        mostrar.setText("MOSTRAR");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
        inicio.setLayout(inicioLayout);
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicioLayout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(tipoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mostrar)
                .addGap(327, 327, 327))
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostrar))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        int tipo = tipoLista.getSelectedIndex();
        switch(tipo){
            case 0:
                EstadisticaSeguridad tabla1 = new EstadisticaSeguridad();
                tabla1.setSize(940, 450);
                tabla1.setLocation(0, 0);
                inicio.removeAll();
                inicio.add(tabla1, BorderLayout.CENTER);
                inicio.revalidate();
                inicio.repaint();
                break;
            case 1:
                EstadisticaAdministracion tabla2 = new EstadisticaAdministracion();
                tabla2.setSize(940, 450);
                tabla2.setLocation(0, 0);
                inicio.removeAll();
                inicio.add(tabla2, BorderLayout.CENTER);
                inicio.revalidate();
                inicio.repaint();
                break;
        }      
    }//GEN-LAST:event_mostrarActionPerformed

    private void tipoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoListaActionPerformed

    }//GEN-LAST:event_tipoListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel inicio;
    private javax.swing.JButton mostrar;
    private javax.swing.JComboBox<String> tipoLista;
    // End of variables declaration//GEN-END:variables
}
