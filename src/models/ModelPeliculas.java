
package models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelPeliculas {
      private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_peliculas;
    private String nombre;
    private String formato;
    private String duracion;
    private String descripcion;

   
    public int getId_peliculas() {
        return id_peliculas;
    }

    public void setId_peliculas(int id_peliculas) {
        this.id_peliculas = id_peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
setId_peliculas(rs.getInt("id_peliculas"));
setNombre(rs.getString("nombre"));
setFormato(rs.getString("BLUE RAY, DVD"));
setDuracion(rs.getString("duracion"));
setDescripcion(rs.getString("descripcion"));

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
        sql="SELECT * FROM peliculas ;";
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
        sql= "INSERT INTO peliculas (nombre,formato,duracion,descripcion )values (?,?,?,?)";
        ps=conexion.prepareStatement(sql);
        ps.setString (1,nombre);
        ps.setString(2,formato);
        ps.setString(3,duracion);
         ps.setString(4,descripcion);
        ps.executeUpdate();
        movePrimero();
         SeleccionarTodos();
    } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "error 8");
    }
}
public void borrar(int id_peliculas){
    try{
       sql="DELETE FROM peliculas where id_peliculas=?;";
       ps =conexion.prepareStatement(sql);
       ps.setInt(1,id_peliculas);
       ps.executeUpdate();
       movePrimero();
       SeleccionarTodos();
       
       
    }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "error 9" + ex.getMessage());
        
    }
}
public void Actualizar(int id_peliculas, String nombre, String SelectItem, String duracion,String descripcion){
    try{
        System.out.println( "pato");
        sql="UPDATE peliculas SET nombre =?, formato=?,duracion=?,descripcion=? WHERE id_peliculas=?;";
        ps=conexion.prepareStatement(sql);
        ps.setInt(5,id_peliculas);
        ps.setString(1,nombre);
        ps.setString(2, formato);
        ps.setString(3, duracion);
        ps.setString(4, descripcion);
        ps.executeUpdate();
        movePrimero();
        SeleccionarTodos();
    }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "error 10" + ex.getMessage());
    }
}
}
   





        
    
    





    
    

