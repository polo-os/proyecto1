package modelo_logica;

import Conexion_bd.ConexionBD;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroLevantamiento {
    private  int idRegistro,pesoLevantado,repeticiones;
    private ConexionBD conexionBD;

    public RegistroLevantamiento() {
    }

    public RegistroLevantamiento(int pesoLevantado, int repeticiones) {
        this.pesoLevantado = pesoLevantado;
        this.repeticiones = repeticiones;
    }

    public RegistroLevantamiento(int idRegistro, int pesoLevantado, int repeticiones) {
        this.idRegistro = idRegistro;
        this.pesoLevantado = pesoLevantado;
        this.repeticiones = repeticiones;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getPesoLevantado() {
        return pesoLevantado;
    }

    public void setPesoLevantado(int pesoLevantado) {
        this.pesoLevantado = pesoLevantado;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

// INSERTAR
    public boolean insertarRegistroBD(){
        //conexion a la bd
        this.conexionBD=new ConexionBD();
        boolean conf;
        //Sentencia sql
        String sql="INSERT INTO Registro_Levantamiento(Peso,Repeticiones)"
                + "VALUES ("+this.getPesoLevantado()+","+this.getRepeticiones()+");";

        if (this.conexionBD.setAutoCommitBD(false)){
            if (this.conexionBD.insertarBD(sql)){
                this.conexionBD.commitBD();
                this.conexionBD.cerrarConexion();
                conf=true;
            }else{
                this.conexionBD.rollbackBD();
                this.conexionBD.cerrarConexion();
                conf=false;
            }
        }else{
            this.conexionBD.cerrarConexion();
            conf=false;
        }
        return conf;
    }

//SELECT
public List<RegistroLevantamiento>consultarRegistroBD(){
    List<RegistroLevantamiento> listaReg=new ArrayList<>();

    this.conexionBD=new ConexionBD();
    //sentencia sql
    String sql="SELECT * FROM Registro_Levantamieto";
    try {
        ResultSet rs=this.conexionBD.consultaBD(sql);
        RegistroLevantamiento registro;
        while (rs.next()){
            registro=new RegistroLevantamiento();
            registro.setIdRegistro(rs.getInt("id_registro"));
            registro.setPesoLevantado(rs.getInt("peso"));
            registro.setRepeticiones(rs.getInt("repeticiones"));
            listaReg.add(registro);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error al consultar en la clase RegistroLevantamiento");
    }
    return listaReg;
}

public boolean actualizarRegistroBD(){
        boolean conf;
        //sentencia sql
        String sql="UPDATE Registro_Levantamiento set peso="
                +this.getPesoLevantado()+",repeticiones="+this.getRepeticiones()+
                "WHERE id_registro="+this.getIdRegistro()+";";
    if (this.conexionBD.setAutoCommitBD(false)){
        if (this.conexionBD.actualizarBD(sql)){
            this.conexionBD.commitBD();
            this.conexionBD.cerrarConexion();
            conf=true;
        }else {
            this.conexionBD.rollbackBD();
            this.conexionBD.cerrarConexion();
            conf=false;
        }
    }else {
        this.conexionBD.cerrarConexion();
        conf=false;
    }
    return conf;
}

public boolean eliminarRegistroBD(){
    boolean conf;
    //conexion
    this.conexionBD=new ConexionBD();
    //sentencia sql
    String sql="DELETE FROM Registro_Levantamiento WHERE id_registro="+this.getIdRegistro()+";";

    if (this.conexionBD.setAutoCommitBD(false)){
        if (this.conexionBD.borrarBD(sql)){
            this.conexionBD.commitBD();
            this.conexionBD.cerrarConexion();
            conf=true;
        }else {
            this.conexionBD.rollbackBD();
            this.conexionBD.cerrarConexion();
            conf=false;
        }
    }else {
        this.conexionBD.cerrarConexion();
        conf=false;
    }
    return conf;
}

}
