package Principal;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Damas.Juego;
import Damas.MenuDamas;
import Datos.General;
import Datos.Partidas;
import TorreHanoi.VentanaPrincipal;

public class Menuprincipal extends javax.swing.JFrame {

    Usuario usu = new Usuario();
    General gen = new General();
    Partidas modelo = General.modelotransferencia;
    VentanaPrincipal torre = new VentanaPrincipal();
    MenuDamas dam = new MenuDamas();
    Reportes report = new Reportes();
    Juego juego = new Juego();
    //crear una clase partidas.java

    //Reportes report = new Reportes();

    public Menuprincipal() {
        initComponents();
        //partida1 = newPartida()
        this.setLocationRelativeTo(null);
        JButton cargar = new JButton("Cargar Partida");
        cargar.setBounds(550, 20, 150, 50);
        this.add(cargar);
        cargar.addActionListener(escuchador);
    }

    ActionListener escuchador = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            cargar();

        }
    
    };
    
    public void cargar(){
            this.modelo = gen.cargar();
            if(modelo.getNombre()!=null){
                usu.inciar();
            }else{JOptionPane.showMessageDialog(null, "No hay partidas cargadas","Error",JOptionPane.ERROR_MESSAGE);}
            
    }
    

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnDamasChinas = new javax.swing.JButton();
        btnTorreHanoi = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        Btn_Salir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 2, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JUEGOS PRO");

        btnDamasChinas.setFont(new java.awt.Font("Gabriola", 2, 18)); // NOI18N
        btnDamasChinas.setText("DAMAS");
        btnDamasChinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDamasChinasActionPerformed(evt);
            }
        });

        btnTorreHanoi.setFont(new java.awt.Font("Gabriola", 2, 20)); // NOI18N
        btnTorreHanoi.setText("TORRES DE HANOI");
        btnTorreHanoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTorreHanoiActionPerformed(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Gabriola", 2, 20)); // NOI18N
        btnReportes.setText("REPORTES");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        Btn_Salir.setFont(new java.awt.Font("Gabriola", 2, 20)); // NOI18N
        Btn_Salir.setText("SALIR");
        Btn_Salir.setBounds(500, 600, 150, 50);
        Btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SalirActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Gabriola", 2, 20)); // NOI18N
        jButton3.setText("CREAR JUGADOR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTorreHanoi, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDamasChinas, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(Btn_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDamasChinas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTorreHanoi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(Btn_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTorreHanoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTorreHanoiActionPerformed
        if(modelo.getNombre()!= null)
        {
            torre.setVisible(true);
            this.dispose();
        }else{JOptionPane.showMessageDialog(null, "Primero crea un usuario","Error",JOptionPane.ERROR_MESSAGE);}
    }

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        if(modelo.getNombre()!= null)
        {
            report.setVisible(true);
            this.dispose();
        }else{JOptionPane.showMessageDialog(null, "Primero crea un usuario","Error",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnDamasChinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDamasChinasActionPerformed
        if(modelo.getNombre()!= null)
        {
            if(modelo.getNombre().length>=2){
            dam.setModeloDamas(this.modelo);
            dam.setVisible(true);
            this.dispose();
            }else{JOptionPane.showMessageDialog(null, "Para Jugar este juego al menos crea 2 usuarios","Error",JOptionPane.ERROR_MESSAGE);}
        }else{JOptionPane.showMessageDialog(null, "Primero crea un usuario","Error",JOptionPane.ERROR_MESSAGE);}
      
    }//GEN-LAST:event_btnDamasChinasActionPerformed

    private void Btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Btn_SalirActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        usu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menuprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menuprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menuprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menuprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menuprincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Salir;
    private javax.swing.JButton btnDamasChinas;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnTorreHanoi;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
