
package main;
import models.*;
import views.*;
import controllers.*;



public class Main {

    public static void main(String[] mgfc) {
        
        ModelClientes model_clientes = new ModelClientes();
        ViewClientes view_clientes = new ViewClientes();
        ControllerClientes controller_clientes= new ControllerClientes(model_clientes, view_clientes);
        
        ModelPeliculas model_peliculas = new ModelPeliculas();
        ViewPeliculas view_peliculas = new ViewPeliculas();
     //  ControllerPeliculas controller_peliculas= new ControllerPeliculas(model_peliculas, view_peliculas);
        
        
        ModelRentas model_rentas = new ModelRentas();
        ViewRentas view_rentas = new ViewRentas();
      //ControllerRentas controller_rentas= new ControllerRentas(model_rentas, view_rentas);
        
        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        Object views[] =new Object [4];
      
        views[1] = view_clientes;
        views[2] = view_peliculas;
        views[3] = view_rentas;
        views[0] = view_principal;
        // controllers[0]= controller_personas;

        ControllerMain controller_main = new ControllerMain(model_principal,views);
    }
    
} 
