
package main;
import models.*;
import views.*;
import controllers.*;



public class Main {

    public static void main(String[] mgfc) {
        
        ModelClientes model_clientes = new ModelClientes();
        ViewClientes view_clientes = new ViewClientes();
        ControllerClientes controller_clientespersonas= new ControllerClientes(model_clientes, view_clientes);
        
        //ModelDirecciones model_direcciones = new ModelDirecciones();
        //ViewDirecciones view_direcciones = new ViewDirecciones();
//        ControllerDirecciones controller_direcciones= new ControllerDirecciones(model_direcciones, view_direcciones);
        
        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        Object views[] =new Object [3];
      
        views[1] = view_clientes;
       // views[2] = view_peliculas;
        views[0] = view_principal;
        // controllers[0]= controller_personas;

        ControllerMain controller_main = new ControllerMain(model_principal,views);
    }
    
} 
