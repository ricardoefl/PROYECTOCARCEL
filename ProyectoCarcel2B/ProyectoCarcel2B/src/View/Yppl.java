package View;
import Controller.SistemaAdministracionCarcel;
import Model.PPL;
public class Yppl extends javax.swing.JPanel {
    private String mensaje;
    public Yppl(String cedula) {
        initComponents();
        mostrarResultado(cedula);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicial = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuadrito = new javax.swing.JTextArea();

        inicial.setBackground(new java.awt.Color(102, 153, 255));
        inicial.setBorder(new javax.swing.border.MatteBorder(null));
        inicial.setForeground(new java.awt.Color(255, 255, 255));

        cuadrito.setBackground(new java.awt.Color(255, 255, 255));
        cuadrito.setColumns(20);
        cuadrito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cuadrito.setForeground(new java.awt.Color(0, 0, 0));
        cuadrito.setLineWrap(true);
        cuadrito.setRows(5);
        cuadrito.setText("\n");
        cuadrito.setBorder(null);
        jScrollPane1.setViewportView(cuadrito);

        javax.swing.GroupLayout inicialLayout = new javax.swing.GroupLayout(inicial);
        inicial.setLayout(inicialLayout);
        inicialLayout.setHorizontalGroup(
            inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicialLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 468, Short.MAX_VALUE))
        );
        inicialLayout.setVerticalGroup(
            inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
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

    public void mostrarResultado(String cedula){
        SistemaAdministracionCarcel sistema = new SistemaAdministracionCarcel();
        if(sistema.eliminarPPL(cedula)){
            this.mensaje = "PPL BORRADO DE LA BASE DE DATOS";
        }else{
            this.mensaje = "PPL NO ENCONTRADO";
        }
        this.cuadrito.setText(this.mensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea cuadrito;
    private javax.swing.JPanel inicial;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
