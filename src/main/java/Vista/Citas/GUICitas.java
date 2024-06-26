/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Citas;

import Controlador.Citas.ControladorCitas;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class GUICitas extends javax.swing.JFrame {
    ControladorCitas controladorCitas;

    /**
     * Creates new form AgendarCita
     */
    public GUICitas() {
        initComponents();
        controladorCitas = new ControladorCitas(agendar, eliminar, consultar, this);
        agendar.addActionListener(controladorCitas);
        eliminar.addActionListener(controladorCitas);
        consultar.addActionListener(controladorCitas);
        
    }
    
    public void setContenido(JPanel contenido){
        content.removeAll();
        content.add(contenido, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    
    public JPanel getContenido(){
        return Fondo;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Fondo = new javax.swing.JPanel();
        consultar = new javax.swing.JButton();
        agendar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        content = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultar.setBackground(new java.awt.Color(255, 255, 255));
        consultar.setForeground(new java.awt.Color(18, 91, 173));
        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        Fondo.add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 200, 40));

        agendar.setBackground(new java.awt.Color(255, 255, 255));
        agendar.setForeground(new java.awt.Color(18, 91, 173));
        agendar.setText("Agendar");
        agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarActionPerformed(evt);
            }
        });
        Fondo.add(agendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        eliminar.setBackground(new java.awt.Color(255, 255, 255));
        eliminar.setForeground(new java.awt.Color(18, 91, 173));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        Fondo.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 200, 40));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        Fondo.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 890, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarActionPerformed
       
    }//GEN-LAST:event_agendarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

    }//GEN-LAST:event_eliminarActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed

    }//GEN-LAST:event_consultarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton agendar;
    private javax.swing.JButton consultar;
    private javax.swing.JPanel content;
    private javax.swing.JButton eliminar;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
