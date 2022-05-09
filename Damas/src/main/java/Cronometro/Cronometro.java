package Cronometro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cronometro extends javax.swing.JPanel {
    static String tiempo;
    public Cronometro() {
        initComponents();
        t = new Timer(1000,accion);
    }
    public void inicio(){
        t.start();
    }
    
    public static Timer t;
    private int h , m , s;
    private ActionListener accion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            s++;
            if(s==60){
                m++;
                s=0;
            }
            if(m==60){
                m=0;
                h++;
            }
            actualizar();
        }
    };
    public void actualizar(){
        tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s;
        Tiempo.setText(tiempo);
    }
    
    public static String getTime(){
        t.stop();
        return tiempo;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cronolabel = new javax.swing.JLabel();
        Tiempo = new javax.swing.JLabel();

        //setBackground(new java.awt.Color(255, 255, 255));

        Cronolabel.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        Cronolabel.setText("Cronometro:");

        Tiempo.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        Tiempo.setText("00:00:00");
        Tiempo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cronolabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(Tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cronolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tiempo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cronolabel;
    private javax.swing.JLabel Tiempo;
    // End of variables declaration//GEN-END:variables
}
