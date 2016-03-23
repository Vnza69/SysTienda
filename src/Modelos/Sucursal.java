package Modelos;

/*Autores
*Pintor Vega Cynthia Michelle 
*González Huerta José Uriel 
*Hernández García Richar F. 
*González García José Erik
*/

import java.io.Serializable;
public class Sucursal implements Serializable
{
    private int suc_codigo;
    private int id_supervisor;
    private String correo;
    private String telefono;
    private String direccion;

    public Sucursal (int suc_codigo, int id_supervisor, String correo, String telefono, String direccion)
    {
	this.suc_codigo = suc_codigo;
	this.id_supervisor = id_supervisor;
	this.correo = correo;
	this.telefono = telefono;
        this.direccion = direccion;
    }


    public void SetSuc_codigo (int suc_codigo)
    {
	this.suc_codigo = suc_codigo;

    }


    public int getSuc_codigo ()
    {
	return suc_codigo;
    }


    public void setId_supervisor (int id_supervisor)
    {
	this.id_supervisor = id_supervisor;
    }


    public int getId_supervisor ()
    {
	return id_supervisor;
    }


    public void setCorreo (String correo)

    {
	this.correo = correo;

    }


    public String getCorreo ()
    {
	return correo;
    }


    public void setTelefono (String telefono)

    {
	this.telefono = telefono;

    }


    public String getTelefono ()
    {
	return telefono;
    }

    public void setDireccion (String direccion)

    {
	this.direccion = direccion;

    }

    public String getDireccion ()
    {
	return direccion;
    }



} // clase Sucursal
