package Modelos;

/*Autores
*Pintor Vega Cynthia Michelle
*González Huerta José Uriel
*Hernández García Richar F.
*González García José Erik
*/

import java.io.Serializable;
public class Mercancia implements Serializable
{
    private int mercancia_id;
    private String nom_mercancia;
    private String descripcion;
    private int precio;
    private int cantidad_ext;
    private int suc_codigo; 

    public Mercancia (int mercancia_id,String nom_mercancia,String descripcion,int precio,int cantidad_ext,int suc_codigo)
    {
	this.mercancia_id = mercancia_id;
	this.nom_mercancia = nom_mercancia;
	this.descripcion = descripcion;
	this.precio = precio;
	this.cantidad_ext = cantidad_ext;
	this.suc_codigo = suc_codigo;
	
    }


    public void setMercancia_id (int mercancia_id)
    {
	this.mercancia_id = mercancia_id;

    }


    public int getMercancia_id ()
    {
	return mercancia_id;
    }


    public void setNom_mercancia (String nom_mercancia)
    {
	this.nom_mercancia = nom_mercancia;

    }


    public String getNom_mercancia ()
    {
	return nom_mercancia;
    }


    public void setDescripcion (String descripcion)
    {
	this.descripcion = descripcion;

    }


    public String getDescripcion ()
    {
	return descripcion;
    }


    public void setPrecio (int precio)
    {
	this.precio = precio;

    }


    public int getPrecio ()
    {
	return precio;
    }


    public void setCantidad_ext (int cantidad_ext)
    {
	this.cantidad_ext = cantidad_ext;

    }


    public int getCantidad_ext ()
    {
	return cantidad_ext;
    }


    public void setSuc_codigo (int suc_codigo)
    {
	this.suc_codigo = suc_codigo;

    }


    public int getSuc_codigo ()
    {
	return suc_codigo;
    }

}











