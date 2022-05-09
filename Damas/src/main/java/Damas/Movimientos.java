package Damas;

import javax.swing.JOptionPane;

import Cronometro.Cronometro;
import Datos.General;
import Datos.Partidas;
import Principal.Menuprincipal;

public class Movimientos {
    int[][] delete = new int [4][4];
    int [][]  tablero = new int[8][8];
    int [][] pbl = new int [12][6];
    Juego frame;
    public static int turno=1;
    public static int contne, contbl;
    int casin = 0,casib =1, fbl=3, fne=2, rbl=5,rne=4,cmb=0,cmn=0;
    boolean eat;
    String tiempo;
    Partidas modelo = General.modelotransferencia;
    General gen = new General();
    
    public boolean getEat() {
        return eat;
    }
    public void setTurno(int turnoent){
        turno=turnoent;
    }
    public int getTurno()
    {
        return turno;
    }
    public void resEat(){
        eat=false;
    }
    public int getCasin()
    {
        return casin;
    }
    public int getCasib()
    {
        return casib;
    }
    public int getfne()
    {
        return fne;
    }
    public int getne()
    {
        return contne;
    }
    public int getbl()
    {
        return contbl;
    }   
    public int getfbl()
    {
        return fbl;
    }
    public int getrbl()
    {
        return rbl;
    }
    public int getrne()
    {
        return rne;
    }
    public int [][] getTab()
    {
        contbl=12;
        contne=12;
        Setfichas();
        return tablero;
    }
    public int [][] obtab()
    {        
        return tablero;
    }
    public void Setfichas(){
        for(int j = 0; j<8;j++){
            if (j % 2 == 0) {
                    tablero[0][j] = fne;    //negras
                    tablero[1][j] = casin;
                    tablero[2][j] = fne;//negras
                    tablero[3][j] = casin;
                    tablero[4][j] = casib;
                    tablero[5][j] = casin;
                    tablero[6][j] = fbl;
                    tablero[7][j] = casin;
            } 
            else {
                    tablero[0][j] = casin;    
                    tablero[1][j] = fne;
                    tablero[2][j] = casin;
                    tablero[3][j] = casib;
                    tablero[4][j] = casin;
                    tablero[5][j] = fbl;
                    tablero[6][j] = casin;
                    tablero[7][j] = fbl;
            }
        }
        
    }
    public void revisarDama(){
        
        for(int i = 0;i<8;i++)
        {
           if (tablero[0][i]==fbl) 
           {
               tablero[0][i]=rbl;
           }
           if (tablero[7][i]==fne)
           {
               tablero[7][i]=rne;
           }
        }
    }
    boolean changef;
    public boolean movebl(int x1,int x2,int y1,int y2,int op){
        boolean hayerror=true;
        eat=false;
        changef = false;
        int x3=0,y3=0;        
            if (y1>y2){//va hacia delante
                if(x2<x1){//va hacia la izquierda  x1 mayor  y1 mayor
                    int l = x1-x2, a = y1 - y2;
                    if (l==1 && a==1){//se movio normal
                        hayerror=false;
                        
                    }
                    else if (l==2 && a==2){//comio
                        if ((tablero[y1-1][x1-1]==fne)||(tablero[y1-1][x1-1]==rne)){
                            hayerror=false;
                            x3=x1-1;
                            y3=y1-1;
                            eat=true;
                            
                        }
                    }  
                }    
            else if (x2>x1){//va hacia la derecha x2 mayor  y1 mayor
                    int l = x2-x1, a = y1 - y2;
                        if (l==1 && a==1){//se movio normal
                            hayerror=false;
                            
                        }
                        else if (l==2 && a==2){//comio
                            if ((tablero[y1-1][x1+1]==fne)||(tablero[y1-1][x1+1]==rne)){
                                hayerror=false;
                                eat=true;
                                x3=x1+1;
                                y3=y1-1;
                                
                            }
                        }
                }  
            }
        
       if(op==1){
            if(!hayerror){
                changef=true;
       
                if(eat)
                    deletef(x3,y3);
            }
        }
        else if (op ==2){//si come mueve
            if(!hayerror && eat){                
                deletef(x3,y3);
                changef=true;
            
            }
        }       
        if (changef)
            change(x1, x2, y1, y2);
        else if(op!=2)
            JOptionPane.showMessageDialog(null, "Movimiento invalido");
        return changef;
    }
    public boolean movedabl(int x1,int x2,int y1,int y2,int op){
            boolean hayerror=false;
            changef=false;
            int a=y2-y1, l=x2-x1;
            if (a<0)
            a*=(-1);
            if (l<0)
            l*=(-1);
            adddelete(0,0,2);
            hayerror =false;
            if(a==l)//se movio recto sin doblar
            {
                if(y2>y1){//hacia abajo
                    if(x2>x1){//hacia la derecha
                        int p=0;                        
                        while (p<a)// busca obstaculos
                        {
                            p++;
                            if(tablero[y1+p][x1+p]==fne || tablero[y1+p][x1+p]==rne){// va a comer
                                l=p+1;
                                adddelete(x1+p,y1+p,1);//agregar para borrar
                                if(tablero[y1+l][x1+l]!=casib && p!=a){//puede seguir o puede caer
                                    hayerror=true;    
                                }                          
                            }
                            else if(tablero[y1+p][x1+p]==fbl || tablero[y1+p][x1+p]==rbl){
                                hayerror=true;
                            }
                        }                                          
                    }
                    else{//hacia la izquierda
                        int p=0;
                        while (p<a)// busca obstaculos
                        {
                            p++;
                            if(tablero[y1+p][x1-p]==fne || tablero[y1+p][x1-p]==rne){// va a comer
                                l=p+1;
                                adddelete(x1-p,y1+p,1);//agregar para borrar
                                if(tablero[y1+l][x1-l]!=casib && p!=a){//puede seguir o puede caer
                                    hayerror=true;    
                                }                          
                            }
                            else if(tablero[y1+p][x1-p]==fbl || tablero[y1+p][x1-p]==rbl){
                                hayerror=true;
                            }
                        }
                    }                        
                }
                else{//hacia arriba
                    if(x2>x1){//hacia la derecha
                        int p=0;
                        
                        while (p<a)// busca obstaculos
                        {
                            p++;
                            if(tablero[y1-p][x1+p]==fne || tablero[y1-p][x1+p]==rne){// va a comer
                                l=p+1;
                                adddelete(x1+p,y1-p,1);//agregar para borrar
                                if(tablero[y1-l][x1+l]!=casib && p!=a){//puede seguir o puede caer
                                    hayerror=true;    
                                }                          
                            }
                            else if(tablero[y1-p][x1+p]==fbl || tablero[y1-p][x1+p]==rbl){
                                hayerror=true;
                            }
                        }                                          
                    }
                    else{//hacia la izquierda
                        int p=0;
                        while (p<a)// busca obstaculos
                        {
                            p++;
                            if(tablero[y1-p][x1-p]==fne || tablero[y1-p][x1-p]==rne){// va a comer
                                l=p+1;
                                adddelete(x1-p,y1-p,1);//agregar para borrar
                                if(tablero[y1-l][x1-l]!=casib && p!=a){//puede seguir o puede caer
                                    hayerror=true;    
                                }                          
                            }
                            else if(tablero[y1-p][x1-p]==fbl || tablero[y1-p][x1-p]==rbl){
                                hayerror=true;
                            }
                        }
                    }
                }
            }            
        if(op==1){
            if(hayerror){
                adddelete(0,0,0);
            }
            else{
                changef=true;
                for(int i=0;i<4;i++){
                    if(delete[i][0]!=0){
                        deletef(delete[i][0],delete[i][1]);
                        eat=true;
                    }
                }
                
            }
        }
        else if (op ==2){//si come mueve
            for(int i=0;i<4;i++){
                if(delete[i][0]!=0){
                    eat=true;
                }
            }
            if(!hayerror && eat){
                for(int i=0;i<4;i++){
                    if(delete[i][0]!=0){
                        deletef(delete[i][0],delete[i][1]);                        
                    }
                }
                changef=true;
                
            } 
            else{
                adddelete(0,0,0);
            }
        }       

        if (changef)
            change(x1, x2, y1, y2);
        else if(op!=2)
            JOptionPane.showMessageDialog(null, "Movimiento invalido");
        
        return changef;
        }
    public void adddelete(int x,int y, int op){
            boolean add=false;
            if(op==1){//agregar
                for(int i=0;i<4;i++)
                {
                    if(delete[i][0]==0 && add==false){
                        delete[i][0]=x;
                        delete[i][1]=y;        
                        add=true;
                    }
                }
            }
            else{
                for(int i=0;i<4;i++)
                {
                        delete[i][0]=0;
                        delete[i][1]=0;
                }
            }
    }
    //Juego juego =new Juego();
    public void deletef(int x,int y){
    
    if(tablero[y][x]==fne||tablero[y][x]== rne)
    contne--;
    else
    contbl--;
    tablero[y][x]=1;
    //juego.panel.blancas.setText("Hola");
    }
    public void change(int x1,int x2,int y1,int y2){
        if (tablero[y1][x1]==fne || tablero[y1][x1]==rne)
        {
            cmn++;
        }
        else
        {
            cmb++;
        }
        tablero[y2][x2]=tablero[y1][x1];
        revisarDama();
        tablero[y1][x1]=1;

    }
    public int getestado(){
        int estado=0;
        if(contbl==0){
            estado=2;
        }
        else if(contne==0){
            estado=1;
        }
        return estado;
    }
    public int getcmb(){
        return cmb;
    }
    public int getcmn(){
        return cmn;
    }
    public String gettime(){
        tiempo = Cronometro.getTime();
        return tiempo;
    }
    /*

    JOptionPane.showMessageDialog(null, "Ganan blancas");
            tiempo = Cronometro.getTime();
            fin.setmodificartabladatosdamas(1, cmb, cmn, tiempo);
            //Juego juego =new Juego();
     JOptionPane.showMessageDialog(null, "Ganan negras");
            tiempo = Cronometro.getTime();
            fin.setmodificartabladatosdamas(2, cmn, cmb, tiempo);
       

    0 = mov, 1 si
    1 = 1 come, 0 = no come
    2 = tipo pieeza, 1 peon, 2 dama
    3 = x
    4 = y
    5 = derecha2 izquierda1
    */
    public void moveia(){
        for (int fx=0;fx<8;fx++){
            for (int cy=0;cy<8;cy++){
                if (tablero[cy][fx]==fne){
                    addpos(1,fx,cy);
                }
                else if (tablero[cy][fx]==rne){
                    addpos(2,fx,cy);
                }
            }
        }
        actdates();
        orderteam();
    }
    public void orderteam()
    {
        int[][] matriz2 = new int[1][6];
        for(int f=0;f<12;f++)
        {
            for(int f2=0;f2<12;f++)
            {
                if(pbl[f][0]<pbl[f2][0])
                {
                    matriz2[0][0]=pbl[f2][0];
                    matriz2[0][1]=pbl[f2][1];
                    matriz2[0][2]=pbl[f2][2];
                    matriz2[0][3]=pbl[f2][3];
                    matriz2[0][4]=pbl[f2][4];
                    matriz2[0][5]=pbl[f2][5];
                    matriz2[0][6]=pbl[f2][6];
                    pbl[f2][1]=pbl[f][1];
                    pbl[f2][2]=pbl[f][2];
                    pbl[f2][3]=pbl[f][3];
                    pbl[f2][4]=pbl[f][4];
                    pbl[f2][5]=pbl[f][5];
                    pbl[f2][6]=pbl[f][6];
                    pbl[f][1]=matriz2[0][1];
                    pbl[f][2]=matriz2[0][2];
                    pbl[f][3]=matriz2[0][3];
                    pbl[f][4]=matriz2[0][4];
                    pbl[f][5]=matriz2[0][5];
                    pbl[f][6]=matriz2[0][6];
                }
            }
        }
        for(int f=0;f<12;f++)
        {
            for(int f2=0;f2<12;f++)
            {
                if(pbl[f][1]<pbl[f2][1] && pbl[f][0] !=0) // ordenar los que se pueden mover, de forma en que los que coman mas queden de ultimo
                {
                    matriz2[0][0]=pbl[f2][0];
                    matriz2[0][1]=pbl[f2][1];
                    matriz2[0][2]=pbl[f2][2];
                    matriz2[0][3]=pbl[f2][3];
                    matriz2[0][4]=pbl[f2][4];
                    matriz2[0][5]=pbl[f2][5];
                    matriz2[0][6]=pbl[f2][6];
                    pbl[f2][1]=pbl[f][1];
                    pbl[f2][2]=pbl[f][2];
                    pbl[f2][3]=pbl[f][3];
                    pbl[f2][4]=pbl[f][4];
                    pbl[f2][5]=pbl[f][5];
                    pbl[f2][6]=pbl[f][6];
                    pbl[f][1]=matriz2[0][1];
                    pbl[f][2]=matriz2[0][2];
                    pbl[f][3]=matriz2[0][3];
                    pbl[f][4]=matriz2[0][4];
                    pbl[f][5]=matriz2[0][5];
                    pbl[f][6]=matriz2[0][6];
                }
            }
        }

        for(int f=0;f<12;f++)
        {
            for(int f2=0;f2<12;f++)
            {
                if(pbl[f][1]<pbl[f2][1] && pbl[f][0] !=0) // ordenar los que se pueden mover, de forma en que los que coman mas queden de ultimo
                {
                    matriz2[0][0]=pbl[f2][0];
                    matriz2[0][1]=pbl[f2][1];
                    matriz2[0][2]=pbl[f2][2];
                    matriz2[0][3]=pbl[f2][3];
                    matriz2[0][4]=pbl[f2][4];
                    matriz2[0][5]=pbl[f2][5];
                    matriz2[0][6]=pbl[f2][6];
                    pbl[f2][1]=pbl[f][1];
                    pbl[f2][2]=pbl[f][2];
                    pbl[f2][3]=pbl[f][3];
                    pbl[f2][4]=pbl[f][4];
                    pbl[f2][5]=pbl[f][5];
                    pbl[f2][6]=pbl[f][6];
                    pbl[f][1]=matriz2[0][1];
                    pbl[f][2]=matriz2[0][2];
                    pbl[f][3]=matriz2[0][3];
                    pbl[f][4]=matriz2[0][4];
                    pbl[f][5]=matriz2[0][5];
                    pbl[f][6]=matriz2[0][6];
                }
            }
        }
    }
    public void addpos(int tipo, int x, int y){
        boolean add =false;
        for(int pos =0;pos<12;pos++)
        {
            if(pbl[pos][2]==0 && !add){
                pbl[pos][0]=0;
                pbl[pos][2]=tipo;
                pbl[pos][3]=x;
                pbl[pos][4]=y;

                add=true;
            }
        }        
    }
    public void actdates(){
        for(int pos =0;pos<12;pos++)
        {
            int x=pbl[pos][3];
            int y=pbl[pos][4];
            if(tablero[y][x]==fne){
                if (x>0 && y<7){//izquierda
                    if (tablero[y+1][x-1] == casib){// se mueve sin comer
                        pbl[pos][0]=1;
                        pbl[pos][1]=0;
                    }
                    else if (x>=2 && y <=5){
                        if(tablero [y+1][x-1] == fbl || tablero [y+1][x-1] == rbl){//podria comer
                            if(tablero [y+2][x-2] == casib){
                                pbl[pos][0]=1;
                                pbl[pos][1]=1;
                                watcheat(x,y,pos);
                            }
                        }
                    }
                }
                if(x<7 && y<7)//derecha
                {
                    if (tablero[y+1][x+1] == casib ){// se mueve sin comer
                        pbl[pos][0]=1;
                        pbl[pos][1]=0;
                    }
                    else if (x>=2 && y <=5){
                        if(tablero [y+1][x+1] == fbl || tablero [y+1][x+1] == rbl){//podria comer
                            if(tablero [y+2][x+2] == casib){
                                pbl[pos][0]=1;
                                pbl[pos][1]=1; 
                                watcheat(x,y,pos);
                            }
                        }
                    }
                }
            }

            else{//
                
            }//fin si es reina 
        }//fin ciclo
    }
    public void watcheat(int x, int y, int pos){//metodo para contar cuantas puede comer
        int eat=0,eat2=0 ;
        if(y<=5&&x>=2)
        {
            if(tablero[y+1][x-1]==fbl || tablero[y+1][x-1]==rbl ){
                if(tablero[y+2][x-2]==casib){
                    eat++;
                    y+=2;
                    x-=2;
                    if(y<=5&&x>=2)
                    {
                        if(tablero[y+1][x-1]==fbl || tablero[y+1][x-1]==rbl ){
                            if(tablero[y+2][x-2]==casib){
                                eat++;
                            }
                        }
                    }
                    if(y<=5 && x<=5)
                    {            
                        if(tablero[y+1][x+1]==fbl || tablero[y+1][x+1]==rbl ){
                            if(tablero[y+2][x+2]==casib){
                                eat++;
                            }
                        }
                    }
                }
            }
        }
        if(y<=5 && x<=5)
        {            
            if(tablero[y+1][x+1]==fbl || tablero[y+1][x+1]==rbl ){
                if(tablero[y+2][x+2]==casib){
                    eat2++;
                    y+=2;
                    x+=2;
                    if(y<=5&&x>=2)
                    {
                        if(tablero[y+1][x-1]==fbl || tablero[y+1][x-1]==rbl ){
                            if(tablero[y+2][x-2]==casib){
                                eat2++;
                            }
                        }
                    }
                    if(y<=5 && x<=5)
                    {            
                        if(tablero[y+1][x+1]==fbl || tablero[y+1][x+1]==rbl ){
                            if(tablero[y+2][x+2]==casib){
                                eat2++;
                            }
                        }
                    }
                }
            }
        }

        if(eat<eat2){
            pbl[pos][5]=2;//derecha
            pbl[pos][1]=eat2;
        }
        else{
            pbl[pos][1]=eat;//izquierda
            pbl[pos][5]=1;
        }
    }

    /*
    crear metodo para ver cuantas puede comer 
    crear metodo para ordenar las piezas
    crear metodo para generar numero aleatorio entre los que tengan la mismas opciones de movimientos
    */
    public boolean movene(int x1,int x2,int y1,int y2,int op){
        boolean hayerror=true;
        eat=false;
        changef = false;
        int x3=0,y3=0;
            if (y2>y1){//va hacia abajo
                if(x2<x1){//va hacia la izquierda  x1 mayor  y1 mayor
                    int l = x1-x2, a = y2-y1;
                    if (l==1 && a==1){//se movio normal
                        hayerror=false;
                        
                    }
                    else if (l==2 && a==2){//comio
                        if ((tablero[y1+1][x1-1]==fbl)||(tablero[y1+1][x1-1]==rbl)){
                            hayerror=false;
                            x3=x1-1;
                            y3=y1+1;
                            eat=true;
                            
                        }
                    }  
                }    
                else if (x2>x1){//va hacia la derecha x2 mayor  y1 mayor
                    int l = x2-x1, a = y2-y1;
                        if (l==1 && a==1){//se movio normal
                            hayerror=false;
                            
                        }
                        else if (l==2 && a==2){//comio
                            if ((tablero[y1+1][x1+1]==fbl)||(tablero[y1+1][x1+1]==rbl)){
                                hayerror=false;
                                eat=true;
                                x3=x1+1;
                                y3=y1+1;
                                
                            }
                        }
                }  
            }
        
       if(op==1){
            if(!hayerror){
                changef=true;
                if(eat)
                    deletef(x3,y3);
                
            }
        }
        else if (op ==2){//si come mueve
            if(!hayerror && eat){
                deletef(x3,y3);
                changef=true;
                
            }
        }       
        if (changef)
            change(x1, x2, y1, y2);
        else if(op!=2)
            JOptionPane.showMessageDialog(null, "Movimiento invalido");
        return changef;
    
    }
    public boolean movedane(int x1,int x2,int y1,int y2,int op){
            boolean hayerror=false;
            
            changef=false;
            int a=y2-y1, l=x2-x1;
            if (a<0)
            a*=(-1);
            if (l<0)
            l*=(-1);
            adddelete(0,0,2);
            hayerror =false;
            if(a==l)//se movio recto sin doblar
            {
                if(y2>y1){//hacia abajo
                    if(x2>x1){//hacia la derecha
                        int p=0;                        
                        while (p<a)// busca obstaculos
                        {
                            p++;
                            if(tablero[y1+p][x1+p]==fbl || tablero[y1+p][x1+p]==rbl){// va a comer
                                l=p+1;
                                adddelete(x1+p,y1+p,1);//agregar para borrar
                                if(tablero[y1+l][x1+l]!=casib && p!=a){//puede seguir o puede caer
                                    hayerror=true;    
                                }                          
                            }
                            else if(tablero[y1+p][x1+p]==fne || tablero[y1+p][x1+p]==rne){
                                hayerror=true;
                            }
                        }                                          
                    }
                    else{//hacia la izquierda
                        int p=0;
                        while (p<a)// busca obstaculos
                        {
                            p++;
                            if(tablero[y1+p][x1-p]==fbl || tablero[y1+p][x1-p]==rbl){// va a comer
                                l=p+1;
                                adddelete(x1-p,y1+p,1);//agregar para borrar
                                if(tablero[y1+l][x1-l]!=casib && p!=a){//puede seguir o puede caer
                                    hayerror=true;    
                                }                          
                            }
                            else if(tablero[y1+p][x1-p]==fne || tablero[y1+p][x1-p]==rne){
                                hayerror=true;
                            }
                        }
                    }                        
                }
                else{//hacia arriba
                    if(x2>x1){//hacia la derecha
                        int p=0;                        
                        while (p<a)// busca obstaculos
                        {
                            p++;
                            if(tablero[y1-p][x1+p]==fbl || tablero[y1-p][x1+p]==rbl){// va a comer
                                l=p+1;
                                adddelete(x1+p,y1-p,1);//agregar para borrar
                                if(tablero[y1-l][x1+l]!=casib && p!=a){//puede seguir o puede caer
                                    hayerror=true;    
                                }                          
                            }
                            else if(tablero[y1-p][x1+p]==fne || tablero[y1-p][x1+p]==rne){
                                hayerror=true;
                            }
                        }                                          
                    }
                    else{//hacia la izquierda
                        int p=0;
                        while (p<a)// busca obstaculos
                        {
                            p++;
                            if(tablero[y1-p][x1-p]==fbl || tablero[y1-p][x1-p]==rbl){// va a comer
                                l=p+1;
                                adddelete(x1-p,y1-p,1);//agregar para borrar
                                if(tablero[y1-l][x1-l]!=casib && p!=a){//puede seguir o puede caer
                                    hayerror=true;    
                                }                          
                            }
                            else if(tablero[y1-p][x1-p]==fne || tablero[y1-p][x1-p]==rne){
                                hayerror=true;
                            }
                        }
                    }
                }
            }            
        if(op==1){
            if(hayerror){
                adddelete(0,0,0);
            }
            else{
                changef=true;
                for(int i=0;i<4;i++){
                    if(delete[i][0]!=0){
                        deletef(delete[i][0],delete[i][1]);
                        eat=true;
                    }
                    
                }
            }
        }
        else if (op ==2){//si come mueve
            for(int i=0;i<4;i++){
                if(delete[i][0]!=0){
                    eat=true;
                }
            }
            if(!hayerror && eat){
                for(int i=0;i<4;i++){
                    if(delete[i][0]!=0){
                        deletef(delete[i][0],delete[i][1]);                        
                    }
                }
                
                changef=true;
            } 
            else{
                adddelete(0,0,0);
            }
        }       
        if (changef)
            change(x1, x2, y1, y2);
        else if(op!=2)
            JOptionPane.showMessageDialog(null, "Movimiento invalido");
        
        return changef;
        }       
        
}
