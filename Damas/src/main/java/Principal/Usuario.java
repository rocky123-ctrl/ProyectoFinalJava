
package Principal;
//import java.io.Serializable;

import javax.swing.JOptionPane;

import Datos.General;
import Datos.Guardarycargar;
import Datos.Partidas;

//import Datos.Guardarycargar;

public class Usuario extends javax.swing.JFrame{

    
    //Guardarycargar guar = new Guardarycargar();
    General gen = new General();
    Partidas modelo = General.modelotransferencia;
    Guardarycargar guar = new Guardarycargar();
    String nombres2[];
    int opcion;
    
    public static Usuario general = null;

    static {
        //iniciarDatos();
    }



    public Usuario() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        nombres2 = modelo.getNombre();
        if(nombres2 != null){
            for(String nombre : nombres2){
                ListaUsuarios.addItem(nombre);
            }
        }
        
        
       
    }

    public void inciar(){
        this.modelo= gen.cargar();
        if(this.modelo.getNombre().length>0){
            for(int i=0; i<this.modelo.getNombre().length;i++){
                ListaUsuarios.addItem(this.modelo.getNombre()[i]);
            }
        }
    }

    public void setOpcion(int opcion){
        this.opcion = opcion;
    }

    
    public String[] pasardatos(){
        int cont = ListaUsuarios.getItemCount();
        String nombres[] = new String[cont];
        for(int i = 0;i<cont;i++){
            nombres[i]= ListaUsuarios.getItemAt(i);
        }
        return nombres;
    }

    public String[][] DatosTabladamini(){
        int cont = ListaUsuarios.getItemCount();
        String nombres[][] = new String[cont][7];
        for(int i = 0;i<cont;i++){
            nombres[i][0]= ListaUsuarios.getItemAt(i);
            nombres[i][1]= String.valueOf(0);
            nombres[i][2]= String.valueOf(0);
            nombres[i][3]= String.valueOf(0);
            nombres[i][4]= String.valueOf(0);
            nombres[i][5]= String.valueOf(0);
            nombres[i][6]= String.valueOf(0);
        }
        return nombres;
    }

    public String[][] DatosTablahanini(){
        int cont = ListaUsuarios.getItemCount();
        String nombres2[][] = new String[cont][9];
        for(int i = 0;i<cont;i++){
            nombres2[i][0]= ListaUsuarios.getItemAt(i);
            nombres2[i][1]= String.valueOf(0);
            nombres2[i][2]= String.valueOf(0);
            nombres2[i][3]= String.valueOf(0);
            nombres2[i][4]= String.valueOf(0);
            nombres2[i][5]= String.valueOf(0);
            nombres2[i][6]= String.valueOf(0);
            nombres2[i][7]=String.valueOf(0);
            nombres2[i][8]=String.valueOf(0);
        }
        return nombres2;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextoNombre = new javax.swing.JTextField();
        Btn_Crear = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ListaUsuarios = new javax.swing.JComboBox<>();
        Btn_Borrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        TextoNombre.setFont(new java.awt.Font("Dubai Medium", 2, 14)); // NOI18N
        TextoNombre.setToolTipText("Ingrese nombre de usuario");

        Btn_Crear.setText("CREAR");
        Btn_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CrearActionPerformed(evt);
            }
        });

        jButton3.setText("JUGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Btn_Borrar.setText("BORRAR");
        Btn_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(TextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_Crear)
                            .addComponent(Btn_Borrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_Borrar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(ListaUsuarios))
                .addGap(30, 30, 30)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Menuprincipal menu = new Menuprincipal();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void Btn_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CrearActionPerformed
        int cont2 = ListaUsuarios.getItemCount();
        String texto = TextoNombre.getText();
        texto=texto.replaceAll(" ", "");
        /*this.modelo= gen.cargar();
        if(this.modelo.getNombre().length>0){
            for(int i=0; i<this.modelo.getNombre().length;i++){
            ListaUsuarios.addItem(this.modelo.getNombre()[i]);

          }
        }
        */
        if(texto.length()!=0){                                                           
            if(verificarnombre(TextoNombre.getText())!=true)
            {ListaUsuarios.addItem(TextoNombre.getText());modelo.setNombre(pasardatos());
                modelo.setDatosTabladam(DatosTabladamini());
                 modelo.setDatosTablahan(DatosTablahanini());                  
                 gen.guardar();
                 
                 TextoNombre.setText("");}
            
            else{JOptionPane.showMessageDialog(null, "Este usuario ya existe","Error",JOptionPane.ERROR_MESSAGE);}                     
           // guardar();           
        }else{JOptionPane.showMessageDialog(null, "No puedes guardar un nombre vacio","Error",JOptionPane.ERROR_MESSAGE);}
       
        
    }

    public boolean verificarnombre(String texto){
        boolean ver = false;
        int cont3 = ListaUsuarios.getItemCount();
        for(int i = 0;i<cont3;i++){
            if(texto == ListaUsuarios.getItemAt(i)){
                ver = true;
            }
        }
        return ver;
    }

    /*public void guardar(){
        nombres2 = pasardatos();
        Guardarycargar.serializarObjeto("usario.txt", this);
    }*/

    private void Btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BorrarActionPerformed
        // TODO add your handling code here:
        ListaUsuarios.removeItem(ListaUsuarios.getSelectedItem());
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       // guardar();
    }

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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Borrar;
    private javax.swing.JButton Btn_Crear;
    private javax.swing.JComboBox<String> ListaUsuarios;
    private javax.swing.JTextField TextoNombre;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
