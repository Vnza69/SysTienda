package Modelos;

/*Autores
*Pintor Vega Cynthia Michelle 
*González Huerta José Uriel 
*Hernández García Richar F. 
*González García José Erik
*/

import java.io.Serializable;
public class Cliente implements Serializable
{
    private int num_cliente;
    private String nom_cliente;
    private String direc_cliente;
    private String tel_cliente;
    private String imbox_cliente;

    public Cliente (int num_cliente, String nom_cliente, String direc_cliente, String tel_cliente, String imbox_cliente)
    {
        this.num_cliente = num_cliente;
        this.nom_cliente = nom_cliente;
        this.direc_cliente = direc_cliente;
        this.tel_cliente = tel_cliente;
        this.imbox_cliente = imbox_cliente;

    }


    public void setNum_cliente (int num_cliente)
    {
        this.num_cliente = num_cliente;
    }


    public int getNum_cliente ()
    {
        return num_cliente;
    }



    public void setNom_cliente (String nom_cliente)
    {
        this.nom_cliente = nom_cliente;
    }


    public String getNom_cliente ()
    {
        return nom_cliente;
    }


    public void setDirec_cliente (String direc_cliente)

    {
        this.direc_cliente = direc_cliente;

    }


    public String getDirec_cliente ()
    {
        return direc_cliente;
    }


    public void setTel_cliente (String tel_cliente)

    {
        this.tel_cliente = tel_cliente;

    }


    public String getTel_cliente ()
    {
        return tel_cliente;
    }


    public void setImbox_cliente (String imbox_cliente)

    {
        this.imbox_cliente = imbox_cliente;

    }


    public String getImbox_cliente ()
    {
        return imbox_cliente;
    }

}
