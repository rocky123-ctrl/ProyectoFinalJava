package Damas;
import Cronometro.Cronometro;
import Datos.General;
import Datos.Partidas;
import Principal.Menuprincipal;


import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Juego extends JFrame {
	Tablero juego =new Tablero();
    Cronometro crono = new Cronometro();
    Panel1 panel = new Panel1();
    Partidas modelo = General.modelotransferencia;
    General gen = new General();
	public Juego() {
                
        super("Juego");
        JButton salir = new JButton("SALIR");
        salir.setName("BtnSalir");
        General gen = new General();
        this.add(salir);
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setSize(1000,800);
        this.setLocationRelativeTo(null); 
        this.setLayout(null);
        this.getContentPane().add(this.juego);
        this.getContentPane().add(this.crono);
        this.getContentPane().add(this.panel);
        
        salir.setBounds(50,500,150,50);
        
        this.juego.setBounds(220,50 ,720, 720);
        this.crono.setBounds(200,0,400,50);
        this.panel.setBounds(0,200,220,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        salir.addActionListener(oyente);
       
        }
        
        public void init(){
            crono.inicio();
            panel.inicio();
            
        }

        public void salir(){
            panel.t.stop();
            Cronometro.t.stop();
            Menuprincipal menu = new Menuprincipal();
            menu.setVisible(true);
            this.dispose();
        }
   
        
                
    ActionListener oyente = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            salir();
        }
    
    };
    
    
    
	public void inicio(int op) {
        setVisible(true);
        juego.setop(op);//tablero
        init();

        // recoge la matriz que esta en juego juego.objm.getTab();
        // recuperar juego 
	}
    
    	
}
