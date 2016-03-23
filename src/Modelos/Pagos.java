package Modelos;

/*Autores
*Pintor Vega Cynthia Michelle
*González Huerta José Uriel
*Hernández García Richar F.
*González García José Erik
*/

import java.io.Serializable;
public class Pagos implements Serializable
{
    private String forma_pago;
    private int folio;
    private String fecha_pago;
    private int pago;
    private int mercancia_id;
    private int num_cliente; 

    public Pagos (int folio, String forma_pago, int pago, int mercancia_id, String fecha_pago, int num_cliente)
    {
	this.forma_pago = forma_pago;
	this.folio = folio;
	this.fecha_pago = fecha_pago;
	this.pago = pago;
	this.mercancia_id = mercancia_id;
	this.num_cliente = num_cliente;
	
    }


    public void setForma_pago (String forma_pago)
    {
	this.forma_pago = forma_pago;

    }


    public String getForma_pago ()
    {
	return forma_pago;
    }


    public void setFolio (int folio)
    {
	this.folio = folio;

    }


    public int getFolio ()
    {
	return folio;
    }


    public void setFecha_pago (String fecha_pago)
    {
	this.fecha_pago = fecha_pago;

    }


    public String getFecha_pago ()
    {
	return fecha_pago;
    }


    public void setPago (int pago)
    {
	this.pago = pago;

    }


    public int getPago ()
    {
	return pago;
    }


    public void setMercancia_id (int mercancia_id)
    {
	this.mercancia_id = mercancia_id;

    }


    public int getMercancia_id ()
    {
	return mercancia_id;
    }


    public void setNum_cliente (int num_cliente)
    {
	this.num_cliente = num_cliente;

    }


    public int getNum_cliente ()
    {
	return num_cliente;
    }
    
}

