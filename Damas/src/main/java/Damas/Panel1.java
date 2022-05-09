package Damas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Datos.General;
import Datos.Partidas;
public class Panel1 extends javax.swing.JPanel {
    
    Tablero objeto = new Tablero();
    Partidas objetopartida = General.modelotransferencia;
    public static int white,black;
    private String turno1,turno2, turnoact;
    int turnojugador=1;
    int n=0;
    public Panel1() {
        
        initComponents();
        t = new Timer(1000,accion);
        
        
    }
    public Timer t;
    private ActionListener accion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            actualizar();
            n++;
        }
    };
    public void actualizar(){
        blancas.setText(String.valueOf(objeto.objm.getbl()));
        negras.setText(String.valueOf(objeto.objm.getne()));
        turno.setText(verturno());
    }

    public void inicio(){
        t.start();
        turno1=objetopartida.getNombreJug1damas();
        turno2=objetopartida.getNombreJug2damas();
    }

    private String verturno()
    {
        if(objeto.objm.getTurno()==1){
            turnoact=turno1;
        }
        else if (objeto.objm.getTurno()==2){
            turnoact = turno2;
        }
        return turnoact;
    }
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        turno = new javax.swing.JLabel();
        blancas = new javax.swing.JLabel();
        negras = new javax.swing.JLabel();

        jLabel1.setText("TURNO");

        jLabel2.setText("FICHAS BLANCAS");

        jLabel3.setText("FICHAS NEGRAS");

        turno.setText(" ");

        blancas.setText(" ");

        negras.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(blancas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(negras, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(turno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(blancas)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(negras)
                .addGap(18, 18, 18)
                
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }


    
    public javax.swing.JLabel blancas;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel negras;
    public javax.swing.JLabel turno;
    
}
