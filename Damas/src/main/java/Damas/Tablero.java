package Damas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Datos.General;
import Datos.Partidas;
import Principal.Menuprincipal;

//@SuppressWarnings("serial")
public class Tablero extends JPanel implements ActionListener {
    ImageIcon fn = new ImageIcon("./Recursos/Fnegra.jpeg");
    ImageIcon fb = new ImageIcon("./Recursos/Froja.jpeg");
    ImageIcon rn = new ImageIcon("./Recursos/Rnegra.jepg");
    ImageIcon rb = new ImageIcon("./Recursos/Rroja.jpeg");
    ImageIcon cn = new ImageIcon("./Recursos/cnegra.jpeg");
    ImageIcon cb = new ImageIcon("./Recursos/cblanca.jpeg"); 
    int x2,y2,x1,y1,select=0, turno=1,turno2=0;
    boolean fmove= true,sec=false;
    private JButton botones[][];
    Movimientos objm = new Movimientos();
    int [][] tab = new int [8][8];
    int Width=90, heigth=85,opcion;
    Partidas fin = General.modelotransferencia;
    General gen = new General();
    public Tablero(){

        addbutton();
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Mostrando Panel de Juego")));
        alinear();
        Setab(); //inserta las fichas;
    }
    
    public void setop(int op){
        opcion= op;
    }
    public void addbutton()
    {
        botones = new JButton[8][8];
        
        for (int i = 0; i < botones.length; i++) {
                for (int j = 0; j < botones[0].length; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].setBorderPainted(false);
                botones[i][j].setContentAreaFilled(false);
                botones[i][j].setOpaque(false);
                botones[i][j].addActionListener(this);
                }
        }
    }

    public void alinear() 
    {
	    //JPanel panel = new JPanel();
        //panel.
        setLayout(new GridLayout(8, 8));
        for (int i = 0; i < botones.length; i++) {
                for (int j = 0; j < botones[0].length; j++) {
                        add(botones[i][j]);
                }
        }
        //add(panel);
    }       
    public void Setab(){
        tab = objm.getTab();                
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones.length; j++) {
                if (tab[i][j] == objm.getfne()) {
                        botones[i][j].setIcon(new ImageIcon(fn.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else if (tab[i][j] == objm.getfbl()) {
                        botones[i][j].setIcon(new ImageIcon(fb.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else if (tab[i][j] == objm.getrne()) {
                        botones[i][j].setIcon(new ImageIcon(rn.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else if (tab[i][j] == objm.getCasin()) {
                        botones[i][j].setIcon(new ImageIcon(cn.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else if (tab[i][j] == objm.getrbl()) {
                        botones[i][j].setIcon(new ImageIcon(rb.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else {
                    botones[i][j].setIcon(new ImageIcon(cb.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                }
            }
        }
    }
    public void pintab(){
        tab=objm.obtab();
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones.length; j++) {
                if (tab[i][j] == objm.getfne()) {
                        botones[i][j].setIcon(new ImageIcon(fn.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else if (tab[i][j] == objm.getfbl()) {
                        botones[i][j].setIcon(new ImageIcon(fb.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else if (tab[i][j] == objm.getrne()) {
                        botones[i][j].setIcon(new ImageIcon(rn.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else if (tab[i][j] == objm.getCasin()) {
                        botones[i][j].setIcon(new ImageIcon(cn.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else if (tab[i][j] == objm.getrbl()) {
                        botones[i][j].setIcon(new ImageIcon(rb.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                } else {
                    botones[i][j].setIcon(new ImageIcon(cb.getImage().getScaledInstance(Width, heigth, Image.SCALE_DEFAULT)));
                }
            }
        }
    }

    
    public void actionPerformed(ActionEvent e){
        
        tab=objm.obtab();        
        fmove=false;
        objm.resEat();
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                    if(e.getSource() == botones[i][j]) {
                        
                        if(select==1)
                        {   
                            x2=j;
                            y2=i;
                            if (opcion==2){
                                if ((tab[y1][x1]==objm.getfbl() )&& tab[y2][x2] == objm.getCasib()||sec){
                                    if(sec==false){            
                                        if(objm.movebl(x1, x2, y1, y2,1)==true)
                                        {
                                            turno=2;
                                            pintab();
                                        }                                                
                                        select=0;
                                    }
                                    else{
                                            if(tab[y2][x2]!=objm.getCasib())
                                            {   
                                                x1=x2;
                                                y1=y2;       
                                                select=1;
                                            }
                                            else{//si come mueve
                                                if(objm.movebl(x1, x2, y1, y2,2)==true)
                                                {
                                                    pintab();
                                                }
                                                select=0;
                                            }
                                        turno=2;                                                
                                        }
                                    
                                    sec =false;
                                    if (objm.getEat()==true && tab[y2][x2]!=objm.getrbl())
                                        {
                                            turno=1;
                                            select=1;
                                            x1=x2;
                                            y1=y2;
                                            sec=true;
                                            //JOptionPane.showMessageDialog(null, "comi entonces el turno sigue siendo mio y tengo sel " +y1 + x1 + y2+x2);                                                
                                        }
                                    }
                                    else if((tab[y1][x1]==objm.getrbl()&& tab[y2][x2] == objm.getCasib())||sec){//reinaaa blanca
                                        if(sec==false){

                                            if(objm.movedabl(x1, x2, y1, y2,1)==true)
                                            {
                                                turno=2;
                                                pintab();
                                            }                                                
                                            select=0;
                                        }
                                        else{
                                            if(tab[y2][x2]!=objm.getCasib())
                                            {   
                                                x1=x2;
                                                y1=y2;                                                    
                                                select=1;
                                            }
                                            else{//si come mueve
                                                if(objm.movedabl(x1, x2, y1, y2,2)==true)
                                                {
                                                    pintab();
                                                }
                                                select=0;
                                            }
                                            turno=2;
                                        }                                                                                 
                                        sec =false;
                                        if (objm.getEat()==true)
                                        {
                                            turno=1;
                                            select=1;
                                            x1=x2;
                                            y1=y2;
                                            sec=true;
                                            //JOptionPane.showMessageDialog(null, "comi entonces el turno sigue siendo mio y tengo sel " +y1 + x1 + y2+x2);
                                        }
                                    }
                                    else if ((tab[y1][x1]==objm.getfbl()|| tab[y1][x1]==objm.getrbl()) && tab[y2][x2]==objm.getCasin()){
                                        JOptionPane.showMessageDialog(null, "NO PUEDE MOVER A CASILLAS NEGRAS");
                                        select=0;
                                    }
                                    else{
                                        select=0;
                                    }

                                if (turno==2){
                                    //objm.moveia();
                                    turno=1;
                                } 
                            }   
                            else{//modo 1vs1
                                if(turno==1)//turno blancas
                                {
                                    if ( tab[y1][x1]==objm.getfbl() && (tab[y2][x2] == objm.getCasib()||sec)){
                                        if(sec==false){
                                                
                                                if(objm.movebl(x1, x2, y1, y2,1)==true)
                                                {
                                                    turno=2;
                                                    pintab();
                                                }                                                
                                                select=0;
                                            }
                                        else{
                                                if(tab[y2][x2]!=objm.getCasib())
                                                {   
                                                    x1=x2;
                                                    y1=y2;       
                                                    select=1;
                                                }
                                                else{//si come mueve
                                                    if(objm.movebl(x1, x2, y1, y2,2)==true)
                                                    {
                                                        pintab();
                                                    }
                                                    
                                                    select=0;
                                                }
                                                turno=2;
                                            }                                
                                            sec =false;                                            
                                            if (objm.getEat()==true && tab[y2][x2]!=objm.getrbl())
                                            {
                                                turno=1;
                                                select=1;
                                                x1=x2;
                                                y1=y2;
                                                sec=true;
                                                //JOptionPane.showMessageDialog(null, "comi entonces el turno sigue siendo mio y tengo sel " +y1 + x1 + y2+x2);                                                
                                            }
                                        }
                                    else if(tab[y1][x1]==objm.getrbl() && (tab[y2][x2] == objm.getCasib()||sec)){//reinaaa blanca
                                            if(sec==false){
                                                
                                                if(objm.movedabl(x1, x2, y1, y2,1)==true)
                                                {
                                                    turno=2;
                                                    pintab();
                                                }                                                
                                                select=0;
                                            }
                                            else{
                                                if(tab[y2][x2]!=objm.getCasib())
                                                {   
                                                    x1=x2;
                                                    y1=y2;                                                    
                                                    select=1;
                                                }
                                                else{//si come mueve
                                                    if(objm.movedabl(x1, x2, y1, y2,2)==true)
                                                    {
                                                        pintab();
                                                    }
                                                    select=0;
                                                }                                            
                                                turno=2;                                            
                                            }
                                            sec =false;
                                            if (objm.getEat()==true)
                                            {
                                                turno=1;
                                                select=1;
                                                x1=x2;
                                                y1=y2;
                                                sec=true;
                                                
                                            }
                                    }
                                    else if ((tab[y1][x1]==objm.getfbl()|| tab[y1][x1]==objm.getrbl()) && tab[y2][x2]==objm.getCasin()){
                                        JOptionPane.showMessageDialog(null, "NO PUEDE MOVER A CASILLAS NEGRAS");
                                        select=0;
                                    }
                                    else{
                                        select=0;
                                    }
                                }
                                else{//turno negras
                                    if ( tab[y1][x1]==objm.getfne() && (tab[y2][x2] == objm.getCasib() || sec )){
                                        if(sec==false){
                                                
                                                if(objm.movene(x1, x2, y1, y2,1)==true)
                                                {
                                                    turno=1;
                                                    pintab();
                                                }                                                
                                                select=0;
                                            }
                                        else{//segunda ronda
                                                if(tab[y2][x2]!=objm.getCasib())
                                                {   
                                                    x1=x2;
                                                    y1=y2;       
                                                    select=1;
                                                }
                                                else{//si come mueve
                                                    if(objm.movene(x1, x2, y1, y2,2)==true)
                                                    {
                                                        pintab();
                                                    }
                                                    
                                                    select=0;
                                                }
                                                turno=1;
                                            }                                
                                            sec =false;                                            
                                            if (objm.getEat()==true && tab[y2][x2]!=objm.getrne())
                                            {
                                                turno=2;
                                                select=1;
                                                x1=x2;
                                                y1=y2;
                                                sec=true;
                                                //JOptionPane.showMessageDialog(null, "comi entonces el turno sigue siendo mio y tengo sel " +y1 + x1 + y2+x2);                                                
                                            }
                                        }
                                        else if(tab[y1][x1]==objm.getrne()&& (tab[y2][x2] == objm.getCasib()||sec)){//reinaaa negra
                                            if(sec==false){
                                                if(objm.movedane(x1, x2, y1, y2,1)==true)
                                                {
                                                    turno=1;
                                                    pintab();
                                                }                                                
                                                select=0;
                                            }
                                            else{
                                                if(tab[y2][x2]!=objm.getCasib())
                                                {   
                                                    x1=x2;
                                                    y1=y2;                                                    
                                                    select=1;
                                                    

                                                }
                                                else{//si come mueve
                                                    if(objm.movedane(x1, x2, y1, y2,2)==true)
                                                    {
                                                        pintab();
                                                    }
                                                    
                                                    select=0;
                                                }                                            
                                                turno=1;                                            
                                            }
                                            sec =false;
                                            if (objm.getEat()==true)
                                            {
                                                turno=2;
                                                select=1;
                                                x1=x2;
                                                y1=y2;
                                                sec=true;
                                                
                                            }
                                    }
                                    else if ((tab[y1][x1]==objm.getfne()|| tab[y1][x1]==objm.getrne()) && tab[y2][x2]==objm.getCasin()){
                                        JOptionPane.showMessageDialog(null, "NO PUEDE MOVER A CASILLAS NEGRAS");
                                        select=0;
                                    }
                                    else{
                                        select=0;
                                    }
                                }
                            }                            
                        }
                        else{
                            x1=j;
                            y1=i;
                            if(tab[y1][x1]==0 || tab[y1][x1]==1){
                                select=0;
                            }
                            else{
                                select=1;
                            }                          
                        }
                         actualizar();                           
                    }
                }
            }
    }
    public void actualizar(){
        objm.setTurno(turno);
        if(objm.getestado()!=0){
            String tiempo = objm.gettime();
            if(objm.getestado()==1){
                int movewin = objm.getcmb();
                int movelose = objm.getcmn();
                JOptionPane.showMessageDialog(null, "Ganan blancas");
                fin.setmodificartabladatosdamas(1, movewin, movelose, tiempo);
            }
            else if(objm.getestado()==2){
                
                int movelose = objm.getcmb();
                int movewin = objm.getcmn();
                JOptionPane.showMessageDialog(null, "Ganan negras");
                fin.setmodificartabladatosdamas(1, movewin, movelose, tiempo);
            }
            Juego frame = (Juego)SwingUtilities.getWindowAncestor(this);
            frame.dispose();
            Menuprincipal menu =new Menuprincipal();
            menu.setVisible(true);
        }
    }
}
   

