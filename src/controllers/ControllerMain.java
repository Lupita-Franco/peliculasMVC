package controllers;


import java.awt.event.ActionEvent;
import models.ModelPrincipal;
import views.ViewPrincipal;
import views.ViewClientes;
import views.ViewPeliculas;
import views.ViewRentas;




/**
 *
 * @author lupita
 */

public final class ControllerMain{
    ModelPrincipal model_principal;
    ViewPrincipal view_principal; 
    ViewClientes view_clientes;
    ViewPeliculas view_peliculas;
    ViewRentas view_rentas;
    
   // ViewPrincipal view_principal;
    
    

    public ControllerMain(ModelPrincipal modelprincipal, Object views[]){
        this.model_principal = modelprincipal;
        this.view_clientes = (ViewClientes) views[1];
        this.view_peliculas = (ViewPeliculas) views[2];
        this.view_rentas = (ViewRentas) views[3];
        this.view_principal = (ViewPrincipal) views[0];
         initView();
        this.view_principal.jmi_clientes.addActionListener(e ->jmi_clientesActionPerformed());
        this.view_principal.jmi_peliculas.addActionListener(e ->jmi_peliculas_click());
        this.view_principal.jmi_rentas.addActionListener(e ->jmi_rentas_click());
        this.view_principal.jmi_salir.addActionListener(e ->jmi_salir_click());
       //initView();
        
       

    }
    public void initView(){
        this.view_principal.setLocationRelativeTo(null);
        this.view_principal.setVisible(true);
    }//fin del init view
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==view_principal.jmi_clientes)
               if(e.getSource()==view_principal.jmi_peliculas)
                  if(e.getSource()==view_principal.jmi_rentas)
           jmi_clientesActionPerformed();
           jmi_peliculasActionPerformed();
           jmi_rentasActionPerformed();
    }
    
    
    
    public void jmi_clientesActionPerformed() {
        this.view_principal.setContentPane(view_clientes);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
     
    public void jmi_peliculasActionPerformed() {
        this.view_principal.setContentPane(view_peliculas);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
    public void jmi_peliculas_click() {
        this.view_principal.setContentPane(view_peliculas);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
     public void jmi_rentasActionPerformed() {
        this.view_principal.setContentPane(view_rentas);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
   
      public void jmi_rentas_click() {
        this.view_principal.setContentPane(view_rentas);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
   
    public void jmi_salir_click() {
         System.exit(0);
    }   
    }



