package View;

import Controller.SistemaAdministracionCarcel;
import java.awt.BorderLayout;

public class EstadisticaSeguridad extends javax.swing.JPanel {

    public EstadisticaSeguridad() {
        initComponents();
        mostrarEstadisticas();
    }

    public void mostrarEstadisticas() {
        SistemaAdministracionCarcel sistema = new SistemaAdministracionCarcel();
        double promedioEdades = sistema.calcularPromedioEdadesSeguridad();
        double promAnios = sistema.calcularPromAniosTrabajadosAdministracion();
        double promHoras = sistema.calcularPromHorasTrabajadosAdministracion();
        String conteoTipoArma = sistema.conteoTipoArma();
        String conteoEntrenamiento = sistema.conteoNivelEntrenamiento();
        String conteoLimitante = sistema.conteoLimitante();
        String conteoEquipamiento = sistema.conteoEquipamiento();
        String lugarNacimiento = sistema.conteoLugaresNacimientoSeguridad();
        StringBuilder sb = new StringBuilder();
        sb.append("Promedio de edades: ").append(promedioEdades).append("\n");
        sb.append("Promedio de Anios Trabajados: ").append(promAnios).append("\n");
        sb.append("Promedio de Horas Trabajadas: ").append(promHoras).append("\n");
        sb.append("\n" + conteoEntrenamiento);
        sb.append("\n" + conteoEquipamiento);
        sb.append("\n" + conteoLimitante);
        sb.append("\n" + conteoTipoArma);
        sb.append("\n" + lugarNacimiento);

        jTextArea1.setText(sb.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        inicio.setBackground(new java.awt.Color(102, 153, 255));
        inicio.setBorder(new javax.swing.border.MatteBorder(null));
        inicio.setForeground(new java.awt.Color(255, 255, 255));

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
        inicio.setLayout(inicioLayout);
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 388, Short.MAX_VALUE))
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel inicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
