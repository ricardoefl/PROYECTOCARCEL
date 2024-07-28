package View;
import java.awt.BorderLayout;
public class SeleccionarListaPPL extends javax.swing.JPanel {
    public SeleccionarListaPPL() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicial = new javax.swing.JPanel();
        tipoLista = new javax.swing.JComboBox<>();
        mostrar = new javax.swing.JButton();

        inicial.setBackground(new java.awt.Color(102, 153, 255));
        inicial.setBorder(new javax.swing.border.MatteBorder(null));
        inicial.setForeground(new java.awt.Color(255, 255, 255));

        tipoLista.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tipoLista.setForeground(new java.awt.Color(0, 0, 0));
        tipoLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LISTA COMPLETA", "PABELLON 1", "PABELLON 2", "PABELLON 3", "PABELLON 4" }));
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

        javax.swing.GroupLayout inicialLayout = new javax.swing.GroupLayout(inicial);
        inicial.setLayout(inicialLayout);
        inicialLayout.setHorizontalGroup(
            inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicialLayout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(tipoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mostrar)
                .addGap(342, 342, 342))
        );
        inicialLayout.setVerticalGroup(
            inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicialLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostrar))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        int tipo = tipoLista.getSelectedIndex();
        switch(tipo){
            case 0:
                ListaPPL_Completa tablaCompleta = new ListaPPL_Completa();
                tablaCompleta.setSize(940, 450);
                tablaCompleta.setLocation(0, 0);
                inicial.removeAll();
                inicial.add(tablaCompleta, BorderLayout.CENTER);
                inicial.revalidate();
                inicial.repaint();
                break;
            case 1:
                ListaPPL_P1 tablaP1 = new ListaPPL_P1();
                tablaP1.setSize(940, 450);
                tablaP1.setLocation(0, 0);
                inicial.removeAll();
                inicial.add(tablaP1, BorderLayout.CENTER);
                inicial.revalidate();
                inicial.repaint();
                break;
            case 2:
                ListaPPL_P2 tablaP2 = new ListaPPL_P2();
                tablaP2.setSize(940, 450);
                tablaP2.setLocation(0, 0);
                inicial.removeAll();
                inicial.add(tablaP2, BorderLayout.CENTER);
                inicial.revalidate();
                inicial.repaint();
                break;
            case 3:
                ListaPPL_P3 tablaP3 = new ListaPPL_P3();
                tablaP3.setSize(940, 450);
                tablaP3.setLocation(0, 0);
                inicial.removeAll();
                inicial.add(tablaP3, BorderLayout.CENTER);
                inicial.revalidate();
                inicial.repaint();
                break;
            case 4:
                ListaPPL_P4 tablaP4 = new ListaPPL_P4();
                tablaP4.setSize(940, 450);
                tablaP4.setLocation(0, 0);
                inicial.removeAll();
                inicial.add(tablaP4, BorderLayout.CENTER);
                inicial.revalidate();
                inicial.repaint();
                break;
        }      
    }//GEN-LAST:event_mostrarActionPerformed

    private void tipoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel inicial;
    private javax.swing.JButton mostrar;
    private javax.swing.JComboBox<String> tipoLista;
    // End of variables declaration//GEN-END:variables
}
