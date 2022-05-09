package Datos;

import java.io.Serializable;

public class General  {

        Guardarycargar guar = new Guardarycargar();

        public static Partidas modelotransferencia = new Partidas();

        public void guardar(){                
                guar.serializarObjeto("datos.txt", modelotransferencia);
        }

        public Partidas cargar(){
                modelotransferencia = guar.cargarObjeto("datos.txt");
               return this.modelotransferencia;
        }
}
