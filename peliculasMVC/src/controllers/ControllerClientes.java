
package controllers;
import models.ModelClientes;
import views.ViewClientes;

public class ControllerClientes {
  ModelClientes model_clientes;
    ViewClientes view_clientes;
 
public ControllerClientes (ModelClientes model_clientes, ViewClientes view_clientes){
    this.model_clientes =model_clientes;
    this.view_clientes =view_clientes;
    this.view_clientes.jbtn_primero.addActionListener(e-> jbtn_primero_click());
    this.view_clientes.jbtn_anterior.addActionListener(e->jbtn_anterior_click());
    this.view_clientes.jbtn_siguiente.addActionListener(e->jbtn_siguiente_click());
    this.view_clientes.jbtn_ultimo.addActionListener(e->jbtn_ultimo_click());
    this.view_clientes.jbtn_nuevo.addActionListener(e->jbtn_nuevo_click());
    this.view_clientes.jbtn_agregar.addActionListener(e->jbtn_agregar_click());
    this.view_clientes.jbtn_borrar.addActionListener(e->jbtn_borrar_click());
    this.view_clientes.jbtn_actualizar.addActionListener(e->jbtn_actualizar_click());
    initView();
    
}


public void getValores(){
    view_clientes.jtf_id_clientes.setText(""+model_clientes.getId_clientes());
    view_clientes.jtf_nombre.setText(model_clientes.getNombre());
    view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
    view_clientes.jtf_email.setText(model_clientes.getEmail());
    view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
}

public void setValores(){
    model_clientes.setId_clientes(Integer.parseInt(view_clientes.jtf_id_clientes.getText()));
    model_clientes.setNombre(view_clientes.jtf_nombre.getText());
    model_clientes.setTelefono(view_clientes.jtf_telefono.getText());
    model_clientes.setEmail(view_clientes.jtf_email.getText());
    model_clientes.setDireccion(view_clientes.jtf_direccion.getText());
}

public void jbtn_nuevo_click(){  
    view_clientes.jtf_id_clientes.setText("");
    view_clientes.jtf_nombre.setText("");
    view_clientes.jtf_telefono.setText("");
    view_clientes.jtf_email.setText("");
    view_clientes.jtf_email.setText("");
}
public void jbtn_agregar_click(){
    setValores();
    model_clientes.insertar();
    getValores();
}
public void jbtn_actualizar_click(){
    setValores();
 model_clientes.Actualizar(model_clientes.getId_clientes(), model_clientes.getNombre() ,model_clientes.getTelefono(),model_clientes.getEmail(), model_clientes.getDireccion());    
}
public void jbtn_borrar_click(){
    setValores();
    model_clientes.borrar(model_clientes.getId_clientes());
    getValores();
}


public void jbtn_primero_click(){
    setValores();
    model_clientes.movePrimero();
    getValores();
}

public void jbtn_ultimo_click(){
 setValores();
    model_clientes.moveUltimo();
    getValores();
}

public void jbtn_anterior_click(){
    setValores();
    model_clientes.moveAnterior();
    getValores();
}

public void jbtn_siguiente_click(){
    setValores();
    model_clientes.moveSiguiente();
    getValores();
}
public void initView(){

   model_clientes.Conectar();
   view_clientes.setVisible(true);
   model_clientes.movePrimero();
   getValores();
   
}
}

