package controllers;


import java.awt.event.ActionEvent;
import models.ModelPrincipal;
import views.ViewPrincipal;
import views.ViewClientes;
//import views.ViewDirecciones;




/**
 *
 * @author lupita
 */

public final class ControllerMain{
    ModelPrincipal model_principal;
    ViewPrincipal view_principal; 
    ViewClientes view_clientes;
    //ViewDirecciones view_direcciones;
    
   // ViewPrincipal view_principal;
    
    

    public ControllerMain(ModelPrincipal modelprincipal, Object views[]){
        this.model_principal = modelprincipal;
        this.view_clientes = (ViewClientes) views[1];
        this.view_principal = (ViewPrincipal) views[0];
       // this.view_direcciones = (ViewDirecciones) views[2];
        
          initView();
        this. view_principal.jmi_clientes.addActionListener(e ->jmi_clientesActionPerformed());
        this. view_principal.jmi_peliculas.addActionListener(e ->jmi_peliculas_click());
        this. view_principal.jmi_salir.addActionListener(e ->jmi_salir_click());
       //initView();
        
       

    }
    public void initView(){
        this.view_principal.setLocationRelativeTo(null);
        this.view_principal.setVisible(true);
    }//fin del init view
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==view_principal.jmi_clientes)
           jmi_clientesActionPerformed();
    }
    
    
    public void jmi_clientesActionPerformed() {
        this.view_principal.setContentPane(view_clientes);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
  
    public void jmi_peliculas_click() {
        //this.view_principal.setContentPane(view_peliculas);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
    
    public void jmi_salir_click() {
         System.exit(0);
    }   
    }



