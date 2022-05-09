package Datos;

import java.io.Serializable;

public class Partidas implements Serializable{
    private String [] Nombre;
    private String NombreJug1damas, NombreJug2damas;
    private String DatosTabladam [][];
    private String DatosTablahan [][];
    private String victoria [] = {"0","0","0"};
    private String jg[]={"0","0"}, jd[]={"0","0"};
    private int [][] tablero;
    

    public String getNombreJug1damas() {
        return NombreJug1damas;
    }
    public void setNombreJug1damas(String nombreJug1damas) {
        NombreJug1damas = nombreJug1damas;
    }
    public String getNombreJug2damas() {
        return NombreJug2damas;
    }
    public void setNombreJug2damas(String nombreJug2damas) {
        NombreJug2damas = nombreJug2damas;
    }
    public String[] getNombre() {
        return Nombre;
    }
    public void setNombre(String[] nombre) {
        Nombre = nombre;
    }
    public void setDatosTabladam(String[][] DatosTabladam) {
        this.DatosTabladam = DatosTabladam;
    }
    public String[][] getDatosTabladam() {
        return DatosTabladam;
    }
    public void setDatosTablahan(String[][] DatosTablahan) {
        this.DatosTablahan = DatosTablahan;
    }
    public String[][] getDatosTablahan() {
        return DatosTablahan;
    }
    public int[][] getTablero() {
        return tablero;
    }
    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    public String getVictoria()
    {
        String texto="";

        if(victoria[0]!="0")
        {
            texto = victoria[0] + "      " + victoria[1] + "    " + victoria[2];
        }
        return texto;
    }
    public String getjg() {
        String texto="";

        if(jg[0]!="0")
        {
            texto = "   Jugador: " + jg[0] + " Vict:  " + jg[1];
        }
        return texto;
    }
    public String getjd() {
        String texto="";

        if(jd[0]!="0")
        {
            texto = "   Jugador: " + jd[0] + " Der: " + jd[1];
        }
        return texto;
    }

    public void setmodificartabladatosdamas(int ganador,int movganador, int movperdedor,String tiempo){
        String Jganador="",Jperdedor="";
        if(ganador==1){
            Jganador = NombreJug1damas;
            Jperdedor = NombreJug2damas;
        }
        else if (ganador ==2 && NombreJug2damas!="computer")
        {
            Jganador = NombreJug2damas;
            Jperdedor = NombreJug1damas;
        }
        for(int i=0; i<DatosTabladam.length;i++){
            if(DatosTabladam[i][0]==Jganador){
                int victorias = Integer.parseInt(DatosTabladam[i][2])+1;//suma 1
                int partidas = Integer.parseInt(DatosTabladam[i][1])+1;//suma 1
                int movimientos = Integer.parseInt(DatosTabladam[i][4])+movganador;
                int Promediomov = movimientos/partidas;
                this.DatosTabladam[i][1]=String.valueOf(partidas);
                this.DatosTabladam[i][2]=String.valueOf(victorias);
                this.DatosTabladam[i][4]=String.valueOf(movimientos);
                this.DatosTabladam[i][5]=String.valueOf(Promediomov);

                int mov = Integer.parseInt(victoria[1]);
                
                if(mov!=0 && (movganador < mov))
                {
                    victoria[0]=DatosTabladam[i][0];
                    victoria[1]=String.valueOf(movganador);
                    victoria[2]=tiempo;
                }
                else if (mov==0){
                    victoria[0]=DatosTabladam[i][0];
                    victoria[1]=String.valueOf(movganador);
                    victoria[2]=tiempo;
                }
            }
        }
        for(int i=0; i<DatosTabladam.length;i++){
            if(DatosTabladam[i][0]==Jperdedor){
                int derrotas = Integer.parseInt(DatosTabladam[i][3])+1;//suma 1
                int partidas = Integer.parseInt(DatosTabladam[i][1])+1;//suma 1
                int movimientos = Integer.parseInt(DatosTabladam[i][4])+movperdedor;
                int Promediomov = movimientos/partidas;
                this.DatosTabladam[i][1]=String.valueOf(partidas);
                this.DatosTabladam[i][3]=String.valueOf(derrotas);
                this.DatosTabladam[i][4]=String.valueOf(movimientos);
                this.DatosTabladam[i][5]=String.valueOf(Promediomov);
            }
        }
    }

    public void modificarabandono(String Nombre,int opcion, int movimientos,String tiempo){
        
        for(int i=0; i<DatosTablahan.length;i++){
            if(DatosTablahan[i][0]==Nombre){
                if(opcion==3)
                {
                    int cont = Integer.parseInt(DatosTablahan[i][3]) + 1;                    
                    this.DatosTablahan[i][3]=String.valueOf(cont);
                }
                else {
                                         
                    
                    int contagg = Integer.parseInt(DatosTablahan[i][opcion])+1;// 1 gana                     
                    int time= Integer.parseInt(tiempo)+Integer.parseInt(DatosTablahan[i][6]);
                    int partidas = Integer.parseInt(DatosTablahan[i][8]) +1;
                    int movt = Integer.parseInt(DatosTablahan[i][7]) +movimientos;
                    

                    System.out.println(time + " " + partidas);
                    int promediot = time / partidas;
                    int h, m,s;
                    DatosTablahan[i][7]=String.valueOf(movt);
                    movt = movt / partidas;
                    DatosTablahan[i][4]=String.valueOf(movt);

                    h= promediot /3600;
                    promediot -= h * 3600;
                    m= (promediot % 3600) / 60;
                    promediot -=m*60;
                    s= promediot;
                    System.out.println(s);
                    tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s;
                    DatosTablahan[i][opcion]=String.valueOf(contagg);
                    DatosTablahan[i][5]=tiempo;
                    DatosTablahan[i][6]=String.valueOf(time);
                    DatosTablahan[i][8]=String.valueOf(partidas);
                    if(Integer.parseInt(DatosTablahan[i][1])>Integer.parseInt(jg[1]))//jugador ganador
                    {
                        jg[1]=DatosTablahan[i][1];
                        jg[0]=DatosTablahan[i][0];
                    }
                    else if (Integer.parseInt(DatosTablahan[i][2])>Integer.parseInt(jd[1]))
                    {
                        jd[1]=DatosTablahan[i][1];
                        jd[0]=DatosTablahan[i][0];
                    }


// CONVERTIR LOS SEGUNDOS AL TIEMPO EN HORAS, MINUTOS Y SEGUNDOS
/*if (Integer.parseInt(tiempo) > Integer.parseInt(vl[2]))
                        { 
                            int time =Integer.parseInt(tiempo);
                            int h, m,s;
                            h= time /3600;
                            time -= h * 3600;
                            m= (time % 3600) / 60;
                            time -=m*60;
                            s= time;
                            String tiempo2 = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s;
                            vl[1]=tiempo2;
                            vl[2]=tiempo;
                            vl[0]=Nombre;
                        }
                        else if (vc[0]!="0" && (Integer.parseInt(tiempo) < Integer.parseInt(vl[2]) ) )
                        {
                            int time =Integer.parseInt(tiempo);
                            int h, m,s;
                            h= time /3600;
                            time -= h * 3600;
                            m= (time % 3600) / 60;
                            time -=m*60;
                            s= time;
                            String tiempo2 = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s;
                            vl[1]=tiempo2;
                            vl[2]=tiempo;
                            vl[0]=Nombre;
                        }
                    }
*/
                }
                
            }
        }
    }
    

    

















/*   //escoger si cargar o no
si es nueva
    Partidas partida1=new Partidas();
si no
    
    Partidas partida2 = Guardarycargar.deserializarObjeto("usuario.dat", Usuario.class);
        if(tmpUsuarios == null){
            System.out.println("Creando los datos iniciales");
            Usuario.general = new Usuario();
        }else{
            System.out.println("Cargando Datos del Archivo");
            Usuario.general = tmpUsuarios;

        }
    partida1.setTablero("partida2.getTablero")
    partida1.setUsuarios("partida".getusuarios")    

    reportes/******************************* 
        String tabla1 = partida1.getTabla
        

    */
}
