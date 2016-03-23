package Controlador;

/*Autores
*Pintor Vega Cynthia Michelle 
*González Huerta José Uriel 
*Hernández García Richar F. 
*González García José Erik
*/
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Modelos.*;

public class Hitbox {

    private Connection conexion = null;
    private PreparedStatement ordenSQL = null;
    
    private Connection conecta () throws SQLException
    {
        try
	{
	    Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
	    String accessFileName = "./Database";
	    String connURL = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + accessFileName + ".accdb;";
	    Connection con = DriverManager.getConnection (connURL, "", "");
	    return con;
	}
	catch (Exception e)
	{
	    e.printStackTrace ();
            return null;
	}
    }
    public void cierraConexion () throws SQLException
    {
	try
	{
	    conexion.close ();
	}
	catch (Exception e)
	{
	    e.printStackTrace ();
	}
    }



    public boolean userPass (String user, String pass)
    {
        boolean acc = false;
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Acceso WHERE user = '" +
		user + "' AND pass ='" + pass + "'";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
            if (respuesta.next ())
            {
                acc = true;
            }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
        return acc;
    }


    

    public void registraCliente (String nom_cliente, String direc_cliente, String tel_cliente, String imbox_cliente)
    {
	try
	{
            String sql;
            conexion = conecta ();
	    sql = "INSERT INTO Clientes " +
		"( nom_cliente, direc_cliente, tel_cliente, imbox_cliente ) " +
		"VALUES ('" + nom_cliente + "','" + direc_cliente + "','" + tel_cliente + "','" + imbox_cliente + "')";
            ordenSQL = this.conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}	
    }
    public void corrigeCliente (int id, String nom_cliente, String direc_cliente, String tel_cliente, String imbox_cliente)
    {
	Cliente cliente = null;
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "UPDATE Clientes SET nom_cliente='" + nom_cliente + "',direc_cliente='" +
                    direc_cliente + "',tel_cliente='" + tel_cliente + "',imbox_cliente='" +
                    imbox_cliente + "' WHERE num_cliente=" + id;
            //System.out.print(sql);
	    ordenSQL = conexion.prepareStatement (sql);
	     int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
    }
    public ArrayList listaClientes ()
    {
	ArrayList clientes = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Clientes ORDER BY nom_cliente";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		clientes.add (new Cliente (
			    respuesta.getInt ("num_cliente"),
			    respuesta.getString ("nom_cliente"),
			    respuesta.getString ("direc_cliente"),
                            respuesta.getString ("tel_cliente"),
			    respuesta.getString ("imbox_cliente")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return clientes;
    }
    public ArrayList listaClienteBuscados (String nombre)
    {
	ArrayList clientes = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Clientes WHERE nom_cliente LIKE '%" + nombre + "%' ORDER BY nom_cliente";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		clientes.add (new Cliente (
			    respuesta.getInt ("num_cliente"),
			    respuesta.getString ("nom_cliente"),
			    respuesta.getString ("direc_cliente"),
                            respuesta.getString ("tel_cliente"),
			    respuesta.getString ("imbox_cliente")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return clientes;
    }
    public Cliente borraCliente (int id)
    {
	Cliente cliente = null;
	try
	{
	    conexion = conecta ();
	    String sql = "DELETE FROM clientes WHERE num_cliente = " +
		id;
	    ordenSQL = conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return cliente;
    }
    
    
    public void registraEmpleado (int suc_codigo, String nom_empleado, int edad, String genero, String direccion, String tel_empleado, String referencias_comerciales)
    {
	try
	{
            String sql;
            conexion = conecta ();
	    sql = "INSERT INTO Empleados " +
		"( suc_codigo, nom_empleado, edad, genero, direccion, tel_empleado, referencias_comerciales ) " +
		"VALUES (" + suc_codigo + ",'" + nom_empleado + "'," + edad + ",'" + genero + "','"+ direccion +"','"+ tel_empleado +"','"+ referencias_comerciales +"')";
            ordenSQL = this.conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}	
    }
    public void corrigeEmpleado (int id, int suc_codigo, String nom_empleado, int edad, String genero, String direccion, String tel_empleado, String referencias_comerciales)
    {
	try
	{
            String sql;
            conexion = conecta ();
	    sql = "UPDATE Empleados SET suc_codigo="+ suc_codigo +", nom_empleado='" + nom_empleado + "', "
                    + "edad="+ edad +", genero='"+ genero +"', direccion='"+ direccion +"', tel_empleado='"
                    + tel_empleado + "', referencias_comerciales='" + referencias_comerciales +"' WHERE id_empleado=" + id;
            ordenSQL = this.conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}	
    }
    public ArrayList listaEmpleados ()
    {
	ArrayList empleados = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Empleados ORDER BY nom_empleado";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		empleados.add (new Empleado (
                            respuesta.getInt ("id_empleado"),
			    respuesta.getInt ("suc_codigo"),
			    respuesta.getString ("nom_empleado"),
			    respuesta.getInt ("edad"),
                            respuesta.getString ("genero"),
			    respuesta.getString ("direccion"),
                            respuesta.getString ("tel_empleado"),
			    respuesta.getString ("referencias_comerciales")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return empleados;
    }
    public ArrayList listaEmpleadoBuscados (String nombre)
    {
	ArrayList empleados = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Empleados WHERE nom_empleado LIKE '%" + nombre + "%' ORDER BY nom_empleado";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		empleados.add (new Empleado (
			    respuesta.getInt ("id_empleado"),
			    respuesta.getInt ("suc_codigo"),
			    respuesta.getString ("nom_empleado"),
			    respuesta.getInt ("edad"),
                            respuesta.getString ("genero"),
			    respuesta.getString ("direccion"),
                            respuesta.getString ("tel_empleado"),
			    respuesta.getString ("referencias_comerciales")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return empleados;
    }
    public Empleado borraEmpleado (int id)
    {
	Empleado empleado = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Empleados WHERE nom_empleado=" +
		id;
	    ordenSQL = conexion.prepareStatement (sql);
	    ResultSet respuesta = ordenSQL.executeQuery ();
	    if (respuesta.next ())
	    {
		empleado = new Empleado (
                            respuesta.getInt ("id_empleado"),
			    respuesta.getInt ("suc_codigo"),
			    respuesta.getString ("nom_empleado"),
			    respuesta.getInt ("edad"),
                            respuesta.getString ("genero"),
			    respuesta.getString ("direccion"),
                            respuesta.getString ("tel_empleado"),
			    respuesta.getString ("referencias_comerciales")
			);
		sql = "DELETE FROM Empleados " +
		    " WHERE id_empleado=" + respuesta.getInt ("id_empleado");
		ordenSQL = conexion.prepareStatement (sql);
		int registrosAfectados = ordenSQL.executeUpdate ();
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return empleado;
    }
    
    
    public void registraMercancia (String nom_mercancia, String descripcion, int precio, int cantidad_ext, int suc_codigo)
    {
	try
	{
            String sql;
            conexion = conecta ();
	    sql = "INSERT INTO Mercancia " +
		"(nom_mercancia, descripcion, precio, cantidad_ext, su_codigo) " +
		"VALUES ('" + nom_mercancia + "','" + descripcion + "'," + precio + ","+ cantidad_ext +","+ suc_codigo +")";
            ordenSQL = this.conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}	
    }
    public void corrigeMercancia (int id, String nom_mercancia, String descripcion, int precio, int cantidad_ext, int suc_codigo)
    {
	try
	{
            String sql;
            conexion = conecta ();
	    sql = "UPDATE Mercancia SET nom_mercancia='"+ nom_mercancia + "', descripcion='" + descripcion 
                    + "', precio=" + precio + ", cantidad_ext=" + cantidad_ext + ", su_codigo=" + suc_codigo + " WHERE mercancia_id=" + id;
		ordenSQL = this.conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}	
    }
    public ArrayList listaMercancia ()
    {
	ArrayList mercancias = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Mercancia ORDER BY nom_mercancia";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		mercancias.add (new Mercancia (
                            respuesta.getInt ("mercancia_id"),
			    respuesta.getString ("nom_mercancia"),
			    respuesta.getString ("descripcion"),
                            respuesta.getInt ("precio"),
			    respuesta.getInt ("cantidad_ext"),
                            respuesta.getInt ("su_codigo")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return mercancias;
    }
    public ArrayList listaMercanciaBuscados (String nombre)
    {
	ArrayList mercancias = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Mercancia WHERE nom_mercancia LIKE '%" + nombre + "%' ORDER BY nom_mercancia";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		mercancias.add (new Mercancia (
			    respuesta.getInt ("mercancia_id"),
			    respuesta.getString ("nom_mercancia"),
			    respuesta.getString ("descripcion"),
                            respuesta.getInt ("precio"),
			    respuesta.getInt ("cantidad_ext"),
                            respuesta.getInt ("su_codigo")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return mercancias;
    }
    public Mercancia borraMercancia (int id)
    {
	Mercancia mercancia = null;
	try
	{
	    conexion = conecta ();
/*	    String sql = "SELECT * FROM Mercancia WHERE mercancia_id=" +
		id;
	    ordenSQL = conexion.prepareStatement (sql);
	    ResultSet respuesta = ordenSQL.executeQuery ();
	    if (respuesta.next ())
	    {
		mercancia = new Mercancia (
                            respuesta.getInt ("mercancia_id"),
			    respuesta.getString ("nom_mercancia"),
			    respuesta.getString ("descripcion"),
                            respuesta.getInt ("precio"),
			    respuesta.getInt ("cantidad_ext"),
                            respuesta.getInt ("su_codigo")
			);*/
		String sql = "DELETE FROM Mercancia " +
		    " WHERE mercancia_id=" + id;
		ordenSQL = conexion.prepareStatement (sql);
	       int registrosAfectados = ordenSQL.executeUpdate ();
	    //}
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return mercancia;
    }
    
    
    
    public void registraPago (int folio, String forma_pago, int pago, int mercancia_id, String fecha_pago, int num_cliente)
    {
	try
	{
            String sql;
            conexion = conecta ();
	    sql = "INSERT INTO Pagos " +
		"( folio, forma_pago, pago, mercancia_id, fecha_pago, num_cliente) " +
		"VALUES (" + folio + ",'" + forma_pago + "'," + pago + "," + mercancia_id + ",'"+ fecha_pago +"',"+ num_cliente +")";
            ordenSQL = this.conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}	
    }
    public ArrayList listaPagos ()
    {
	ArrayList pagos = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Pagos ORDER BY folio";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		pagos.add (new Pagos (
                            respuesta.getInt ("folio"),
			    respuesta.getString ("forma_pago"),
                            respuesta.getInt ("pago"),
			    respuesta.getInt ("mercancia_id"),
                            respuesta.getString ("fecha_pago"),
                            respuesta.getInt ("num_cliente")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return pagos;
    }
    public ArrayList listaPagosBuscados (String fecha_pago)
    {
	ArrayList pagos = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Pagos WHERE fecha_pago LIKE '%" + fecha_pago + "%' ORDER BY folio";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		pagos.add (new Pagos (
			    respuesta.getInt ("folio"),
			    respuesta.getString ("forma_pago"),
                            respuesta.getInt ("pago"),
			    respuesta.getInt ("mercancia_id"),
                            respuesta.getString ("fecha_pago"),
                            respuesta.getInt ("num_cliente")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return pagos;
    }
    public Pagos borraPagos (int folio)
    {
	Pagos pagos = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Pagos WHERE folio=" + folio;
	    ordenSQL = conexion.prepareStatement (sql);
	    ResultSet respuesta = ordenSQL.executeQuery ();
	    if (respuesta.next ())
	    {
		pagos = new Pagos (
                            respuesta.getInt ("folio"),
			    respuesta.getString ("forma_pago"),
                            respuesta.getInt ("pago"),
			    respuesta.getInt ("mercancia_id"),
                            respuesta.getString ("fecha_pago"),
                            respuesta.getInt ("num_cliente")
			);
		sql = "DELETE FROM Pagos " +
		    " WHERE folio=" + respuesta.getInt ("folio");
		ordenSQL = conexion.prepareStatement (sql);
		int registrosAfectados = ordenSQL.executeUpdate ();
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return pagos;
    }
    
    
    
    public void registraSucursal (int id_supervisor, String correo, String telefono, String direccio)
    {
	try
	{
            String sql;
            conexion = conecta ();
	    sql = "INSERT INTO Mercancia " +
		"( id_supervisor, correo, telefono, direccio) " +
		"VALUES (" + id_supervisor + ",'" + correo + "','" + telefono + "','" + direccio + "')";
            ordenSQL = this.conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}	
    }
    public void corrigeSucursal (int id, int id_supervisor, String correo, String telefono, String direccio)
    {
	try
	{
            String sql;
            conexion = conecta ();
	    sql = "UPDATE Mercancia SET id_supervisor="+id_supervisor+", correo='"+
                    correo+"', telefono='"+telefono+"', direccio='"+direccio+"' WHERE suc_codigo="+id;
            ordenSQL = this.conexion.prepareStatement (sql);
            int registrosAfectados = ordenSQL.executeUpdate ();
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}	
    }
    public ArrayList listaSucursal ()
    {
	ArrayList sucursal = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Sucursal ORDER BY suc_codigo";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		sucursal.add (new Sucursal (
                            respuesta.getInt ("suc_codigo"),
			    respuesta.getInt ("id_supervisor"),
			    respuesta.getString ("correo"),
                            respuesta.getString ("telefono"),
			    respuesta.getString ("direccion")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return sucursal;
    }
    public ArrayList listaSucursalBuscados (int suc_codigo)
    {
	ArrayList sucursal = new ArrayList ();
	ResultSet respuesta = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Sucursal WHERE suc_codigo LIKE '%" + suc_codigo + "%' ORDER BY suc_codigo";
	    ordenSQL = conexion.prepareStatement (sql);
	    respuesta = ordenSQL.executeQuery ();
	    while (respuesta.next ())
	    {
		sucursal.add (new Sucursal (
			    respuesta.getInt ("suc_codigo"),
			    respuesta.getInt ("id_supervisor"),
			    respuesta.getString ("correo"),
                            respuesta.getString ("telefono"),
			    respuesta.getString ("direccio")
			    ));
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return sucursal;
    }
    public Sucursal borraSucursal (int suc_codigo)
    {
	Sucursal sucursal = null;
	try
	{
	    conexion = conecta ();
	    String sql = "SELECT * FROM Sucursal WHERE suc_codigo=" + suc_codigo;
	    ordenSQL = conexion.prepareStatement (sql);
	    ResultSet respuesta = ordenSQL.executeQuery ();
	    if (respuesta.next ())
	    {
		sucursal = new Sucursal (
                            respuesta.getInt ("suc_codigo"),
			    respuesta.getInt ("id_supervisor"),
			    respuesta.getString ("correo"),
                            respuesta.getString ("telefono"),
			    respuesta.getString ("direccion")
			);
		sql = "DELETE FROM Sucursal WHERE suc_codigo=" + respuesta.getInt ("suc_codigo");
		ordenSQL = conexion.prepareStatement (sql);
		int registrosAfectados = ordenSQL.executeUpdate ();
	    }
	    cierraConexion ();
	}
	catch (SQLException sqlException)
	{
	    sqlException.printStackTrace ();
	}
	return sucursal;
    }
}