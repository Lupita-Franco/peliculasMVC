
package controllers;

import models.ModelRentas;
import views.ViewRentas;

public class ControllerRentas {
  ModelRentas model_rentas;
    ViewRentas view_rentas;

public ControllerRentas (ModelRentas model_rentas, ViewRentas view_rentas){
    this.model_rentas =model_rentas;
    this.view_rentas =view_rentas;
    this.view_rentas.jbtn_primero.addActionListener(e-> jbtn_primero_click());
    this.view_rentas.jbtn_anterior.addActionListener(e->jbtn_anterior_click());
    this.view_rentas.jbtn_siguiente.addActionListener(e->jbtn_siguiente_click());
    this.view_rentas.jbtn_ultimo.addActionListener(e->jbtn_ultimo_click());  
    this.view_rentas.jbtn_agregar.addActionListener(e->jbtn_agregar_click());   
     initView();
}

public void getValores(){
    view_rentas.jtf_id_rentas.setText(""+model_rentas.getId_rentas());
    view_rentas.jtf_id_clientes.setText(""+model_rentas.getId_clientes());
    view_rentas.jtf_id_peliculas.setText(""+model_rentas.getId_peliculas());
    view_rentas.jtf_formato.setText(model_rentas.getFormato());
    view_rentas.jtf_costo_dia.setText(model_rentas.getCosto_dia());
    view_rentas.jtf_dias.setText(model_rentas.getDias());
    view_rentas.jtf_renta_total.setText(model_rentas.getRenta_total());
}

public void setValores(){
    model_rentas.setId_rentas(Integer.parseInt(view_rentas.jtf_id_rentas.getText()));
    model_rentas.setId_clientes(Integer.parseInt(view_rentas.jtf_id_clientes.getText()));
    model_rentas.setId_peliculas(Integer.parseInt(view_rentas.jtf_id_peliculas.getText()));
    model_rentas.setFormato(view_rentas.jtf_formato.getText());
    model_rentas.setCosto_dia(view_rentas.jtf_costo_dia.getText());
    model_rentas.setDias(view_rentas.jtf_dias.getText());
    model_rentas.setRenta_total(view_rentas.jtf_renta_total.getText());
}
public void jbtn_actualizar_click(){
    setValores();
 model_rentas.Actualizar(model_rentas.getId_rentas(), model_rentas.getId_clientes(),model_rentas.getId_peliculas(),model_rentas.getFormato(), model_rentas.getCosto_dia(),model_rentas.getDias(),model_rentas.getRenta_total());    
}

public void jbtn_agregar_click(){
    setValores();
    model_rentas.insertar();
    getValores();
}

public void jbtn_primero_click(){
    setValores();
    model_rentas.movePrimero();
    getValores();
}

public void jbtn_ultimo_click(){
 setValores();
    model_rentas.moveUltimo();
    getValores();
}

public void jbtn_anterior_click(){
    setValores();
    model_rentas.moveAnterior();
    getValores();
}

public void jbtn_siguiente_click(){
    setValores();
    model_rentas.moveSiguiente();
    getValores();
}

public void initView(){

   model_rentas.Conectar();
   view_rentas.setVisible(true);
   model_rentas.movePrimero();
   getValores();
   
}

}

