package Datos;

import java.io.FileInputStream;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Guardarycargar {
    
    public static boolean serializarObjeto(String direccionArchivo, Object Objeto){
        boolean sw = false;
        try(FileOutputStream fos = new FileOutputStream(direccionArchivo);
                ObjectOutputStream salida = new ObjectOutputStream(fos);){
                    salida.writeObject(Objeto);
                    salida.close();
                    sw = true;
                } catch(Exception e){
                    e.printStackTrace();
                }

        return sw;
    }
    public Partidas  cargarObjeto(String direccionArchivo){
        Partidas datosGuardados=new Partidas();
        try(FileInputStream fos = new FileInputStream(direccionArchivo);
        ObjectInputStream entrada = new ObjectInputStream(fos);){
                    datosGuardados=(Partidas)entrada.readObject();
                    entrada.close();          
                } catch(Exception e){
                    e.printStackTrace();
                }

        return datosGuardados;
    }

    /*@SuppressWarnings("unchecked")
    public static <E> E deserializarObjeto(String direccionArchivo, Class<E> claseObjetivo) {
        E objeto = null;
        try (FileInputStream fis = new FileInputStream(direccionArchivo);
                ObjectInputStream entrada = new ObjectInputStream(fis);) {
                    objeto = (E)entrada.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return objeto;
    }*/



}
