
package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelRentas {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_rentas;
    private int id_clientes;
    private int id_peliculas;
    private String formato;
    private String costo_dia;
    private String dias;
    private String renta_total;

    public int getId_rentas() {
        return id_rentas;
    }

    public void setId_rentas(int id_rentas) {
        this.id_rentas = id_rentas;
    }

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public int getId_peliculas() {
        return id_peliculas;
    }

    public void setId_peliculas(int id_peliculas) {
        this.id_peliculas = id_peliculas;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getCosto_dia() {
        return costo_dia;
    }

    public void setCosto_dia(String costo_dia) {
        this.costo_dia = costo_dia;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getRenta_total() {
        return renta_total;
    }

    public void setRenta_total(String costo_total) {
        this.renta_total = costo_total;
    }
    
      
      
public void Conectar(){
    
    try{
        conexion=DriverManager.getConnection("jdbc:mysql://localhost/cine","root","utec");
        st = conexion.createStatement();
        SeleccionarTodos();
}catch (SQLException ex){
    
   
        JOptionPane.showMessageDialog(null, "error 1" + ex.getMessage());
    
    }
            
    
 //conectar
}
public void llenarValores(){
try{
setId_rentas(rs.getInt("id_rentas"));
setId_clientes(rs.getInt("id_clientes"));
setId_peliculas(rs.getInt("id_peliculas"));
setFormato(rs.getString("formato"));
setCosto_dia(rs.getString("costo_dias"));
setDias(rs.getString("dias"));
setRenta_total(rs.getString("renta_total"));

}catch (SQLException ex){
JOptionPane.showMessageDialog(null,"error 2" + ex.getMessage());

}
}
    
 public void movePrimero(){
    try{
        rs.first();
        llenarValores();
    }
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "error 3" + ex.getMessage())     ;
    }
}
public void moveUltimo(){
    try{
        rs.last();
        llenarValores();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "error 4");
    }
}
public void moveSiguiente(){
    try{
        if(rs.isLast()== false)
         rs.next();
         llenarValores();
         
    }catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "error 5");
    }
}
public void moveAnterior(){
    try{
        if(rs.isFirst()== false)
        rs.previous();
        llenarValores();
        
    }catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "error 6");
    }
}
public void SeleccionarTodos(){
    try{
        sql="SELECT * FROM rentas ;";
        ps =conexion.prepareStatement(sql);
        rs =ps.executeQuery();
        movePrimero();
     }
    catch (SQLException ex){
    JOptionPane.showMessageDialog(null, "error 7" + ex.getMessage());
    }
}


public void insertar(){
    try{
        sql= "INSERT INTO rentas (id_clientes,id_peliculas,formato,costo_dia,dias,renta_total )values (?,?,?,?,?,?)";
        ps=conexion.prepareStatement(sql);
        ps.setInt (1,id_clientes);
        ps.setInt(2,id_peliculas);
        ps.setString(3,formato);
        ps.setString(4,costo_dia);
        ps.setString(5,dias);
        ps.setString(6,renta_total);
        ps.executeUpdate();
        movePrimero();
         SeleccionarTodos();
    } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "error 8");
    }
}

public void borrar(int id_rentas){
    try{
       sql="DELETE FROM rentas where id_rentas=?;";
       ps =conexion.prepareStatement(sql);
       ps.setInt(1,id_rentas);
       ps.executeUpdate();
       movePrimero();
       SeleccionarTodos();
       
       
    }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "error 9" + ex.getMessage());
        
    }
}
public void Actualizar(int id_rentas,int id_clientes,int id_peliculas, String formato, String costo_dia, String dias,String costo_rentas){
    try{
        System.out.println( "pato");
        sql="UPDATE rentas SET id_clientes =?, id_peliculas=?,d=?,formato=? , id_costo_dias=?,dias=?,costo_total=?WHERE id_rentas=?;";
        ps=conexion.prepareStatement(sql);
        ps.setInt(7,id_rentas);
        ps.setInt(1,id_clientes);
        ps.setInt(2,id_peliculas);
        ps.setString(3, formato);
        ps.setString(4, costo_dia);
        ps.setString(5, dias);
        ps.setString(6, renta_total);
        ps.executeUpdate();
        movePrimero();
        SeleccionarTodos();
    }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "error 8" + ex.getMessage());
    }
   

}
    
    
    
    
}
