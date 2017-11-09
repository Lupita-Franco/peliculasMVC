
package models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelClientes {
   private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_clientes;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

   
    public int getId_clientes() {
        return id_clientes;
    }

   
    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
     
public void Conectar(){
    
    try{
        conexion=DriverManager.getConnection("jdbc:mysql://localhost/peliculas","root","utec");
        st = conexion.createStatement();
        SeleccionarTodos();
}catch (SQLException ex){
    
   
        JOptionPane.showMessageDialog(null, "error 1" + ex.getMessage());
    
    }
            
    
 //conectar
}
public void llenarValores(){
try{
setId_clientes(rs.getInt("id_clientes"));
setNombre(rs.getString("nombre"));
setTelefono(rs.getString("telefono"));
setEmail(rs.getString("email"));
setDireccion(rs.getString("direccion"));

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
        sql="SELECT * FROM personas;";
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
        sql= "INSERT INTO clientes (nombre,telefono,email,direccion )values (?,?,?,?)";
        ps=conexion.prepareStatement(sql);
        ps.setString (1,nombre);
        ps.setString(2,telefono);
        ps.setString(3,email);
         ps.setString(4,direccion);
        ps.executeUpdate();
        movePrimero();
         SeleccionarTodos();
    } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "error 8");
    }
}
public void borrar(int id_clientes){
    try{
       sql="DELETE FROM clientes where id_clientes=?;";
       ps =conexion.prepareStatement(sql);
       ps.setInt(1,id_clientes);
       ps.executeUpdate();
       movePrimero();
       SeleccionarTodos();
       
       
    }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "error 9" + ex.getMessage());
        
    }
}
public void Actualizar(int id_clientes, String nombre, String telefono, String email,String direccion){
    try{
        System.out.println( "pato");
        sql="UPDATE clientes SET nombre =?, telefono=?,email=?,direccion=? WHERE id_clientes=?;";
        ps=conexion.prepareStatement(sql);
        ps.setInt(4,id_clientes);
        ps.setString(1,nombre);
        ps.setString(2, telefono);
        ps.setString(3, email);
        ps.setString(3, direccion);
        ps.executeUpdate();
        movePrimero();
        SeleccionarTodos();
    }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "error 10" + ex.getMessage());
    }
   
}
}



            

