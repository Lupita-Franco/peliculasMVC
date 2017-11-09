package controllers;
import models.ModelPeliculas;
import views.ViewPeliculas;

public class ControllerPeliculas {
  ModelPeliculas model_peliculas;
    ViewPeliculas view_peliculas;
 
public ControllerPeliculas (ModelPeliculas model_peliculas, ViewPeliculas view_peliculas){
    this.model_peliculas =this.model_peliculas;
    this.view_peliculas =view_peliculas;
    this.view_peliculas.jbtn_primero.addActionListener(e-> jbtn_primero_click());
    this.view_peliculas.jbtn_anterior.addActionListener(e->jbtn_anterior_click());
    this.view_peliculas.jbtn_siguiente.addActionListener(e->jbtn_siguiente_click());
    this.view_peliculas.jbtn_ultimo.addActionListener(e->jbtn_ultimo_click());
    this.view_peliculas.jbtn_nuevo.addActionListener(e->jbtn_nuevo_click());
    this.view_peliculas.jbtn_agregar.addActionListener(e->jbtn_agregar_click());
    this.view_peliculas.jbtn_borrar.addActionListener(e->jbtn_borrar_click());
    this.view_peliculas.jbtn_actualizar.addActionListener(e->jbtn_actualizar_click());
    initView();
    
}


public void getValores(){
    view_peliculas.jtf_id_peliculas.setText(""+model_peliculas.getId_peliculas());
    view_peliculas.jtf_nombre.setText(model_peliculas.getNombre());
    view_peliculas.jtf_formato.setText(model_peliculas.getFormato());
    view_peliculas.jtf_duracion.setText(model_peliculas.getDuracion());
    view_peliculas.jtf_descripcion.setText(model_peliculas.getDescripcion());
}

public void setValores(){
    model_peliculas.setId_peliculas(Integer.parseInt(view_peliculas.jtf_id_peliculas.getText()));
    model_peliculas.setNombre(view_peliculas.jtf_nombre.getText());
    model_peliculas.setFormato( view_peliculas.jtf_formato.getText());
    model_peliculas.setDuracion(view_peliculas.jtf_duracion.getText());
    model_peliculas.setDescripcion(view_peliculas.jtf_descripcion.getText());
}

public void jbtn_nuevo_click(){  
    view_peliculas.jtf_id_peliculas.setText("");
    view_peliculas.jtf_nombre.setText("");
    view_peliculas.jtf_formato.setText("");
    view_peliculas.jtf_duracion.setText("");
    view_peliculas.jtf_descripcion.setText("");
}
public void jbtn_agregar_click(){
    setValores();
    model_peliculas.insertar();
    getValores();
}

public void jbtn_actualizar_click(){
    setValores();
 model_peliculas.Actualizar(model_peliculas.getId_peliculas(), model_peliculas.getNombre() ,model_peliculas.getFormato(),model_peliculas.getDuracion(), model_peliculas.getDescripcion());    
}

public void jbtn_borrar_click(){
    setValores();
    model_peliculas.borrar(model_peliculas.getId_peliculas());
    getValores();
}

public void jbtn_primero_click(){
    setValores();
    model_peliculas.movePrimero();
    getValores();
}

public void jbtn_ultimo_click(){
 setValores();
    model_peliculas.moveUltimo();
    getValores();
}

public void jbtn_anterior_click(){
    setValores();
    model_peliculas.moveAnterior();
    getValores();
}

public void jbtn_siguiente_click(){
    setValores();
    model_peliculas.moveSiguiente();
    getValores();
}
public void initView(){

   model_peliculas.Conectar();
   view_peliculas.setVisible(true);
   model_peliculas.movePrimero();
   getValores();
   
}
}

