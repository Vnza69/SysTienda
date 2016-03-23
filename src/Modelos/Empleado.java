package Modelos;

/*Autores
*Pintor Vega Cynthia Michelle 
*González Huerta José Uriel 
*Hernández García Richar F. 
*González García José Erik
*/

import java.io.Serializable;
public class Empleado implements Serializable
{
    private int id_empleado;
    private int suc_codigo;
    private String nom_empleado;
    private int edad;
    private String genero;
    private String direccion;
    private String tel_empleado;
    private String referencias_comerciales;

    public Empleado (int id_empleado, int suc_codigo, String nom_empleado, int edad, String genero, String direccion, String tel_empleado, String referencias_comerciales)
    {
        this.id_empleado = id_empleado;
	this.suc_codigo = suc_codigo;
	this.nom_empleado = nom_empleado;
	this.edad = edad;
	this.genero = genero;
	this.direccion = direccion;
	this.tel_empleado = tel_empleado;
	this.referencias_comerciales = referencias_comerciales;
    }
    
    
    public void setId_empleado (int id_empleado)
    {
	this.id_empleado = id_empleado;

    }


    public int getId_empleado ()
    {
	return id_empleado;
    }

    public void setSuc_codigo (int suc_codigo)
    {
	this.suc_codigo = suc_codigo;

    }


    public int getSuc_codigo ()
    {
	return suc_codigo;
    }


    public void setNom_empleado (String nom_empleado)
    {
	this.nom_empleado = nom_empleado;
    }


    public String getNom_empleado ()
    {
	return nom_empleado;
    }


    public void setEdad (int edad)

    {
	this.edad = edad;

    }


    public int getEdad ()
    {
	return edad;
    }


    public void setGenero (String genero)

    {
	this.genero = genero;

    }


    public String getGenero ()
    {
	return genero;
    }


    public void setDireccion (String direccion)

    {
	this.direccion = direccion;

    }


    public String getDireccion ()
    {
	return direccion;
    }


    public void setTel_empleado (String tel_empleado)

    {
	this.tel_empleado = tel_empleado;

    }


    public String getTel_empleado ()
    {
	return tel_empleado;
    }


    public void setReferencias_comerciales (String referencias_comerciales)

    {
	this.referencias_comerciales = referencias_comerciales;

    }


    public String getReferencias_comerciales ()
    {
	return referencias_comerciales;
    }



    // Place your code here
    // main method
} // Empleado class
