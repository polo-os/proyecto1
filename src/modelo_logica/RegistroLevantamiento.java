package modelo_logica;

import Conexion_bd.ConexionBD;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroLevantamiento {
    private  int idRegistro,pesoLevantado,repeticiones;
    //conexion bd
    private ConexionBD conexionBD;
    private Ejercicio ejercicio;
    private Usuario usuario;

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

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public ConexionBD getConexionBD() {
        return conexionBD;
    }

    public void setConexionBD(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        String sql="INSERT INTO Registro_Levantamiento(id_usuario,id_ejercicio,Peso,Repeticiones)"
                + "VALUES ("+this.usuario.getId_usuario()+","+this.ejercicio.getIdEjercicio()+","+this.getPesoLevantado()+","+this.getRepeticiones()+");";

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
    public List<RegistroLevantamiento>consultarRegistroBD(int idusuario){
        List<RegistroLevantamiento> listaReg=new ArrayList<>();

        this.conexionBD=new ConexionBD();
        //sentencia sql
        String sql = "SELECT id_registro,id_ejercicio,nombre_ejercicio,grupo_muscular,peso,repeticiones " +
                "FROM Registro_Levantamiento " +
                "INNER JOIN Ejercicio USING(id_ejercicio) " +
                "WHERE id_usuario = "+idusuario+";";
        try {

            ResultSet rs=this.conexionBD.consultaBD(sql);
            RegistroLevantamiento registro;
            Ejercicio ejer;
            while (rs.next()){
                ejer=new Ejercicio();
                ejer.setIdEjercicio(rs.getInt("id_ejercicio"));
                ejer.setNombreEjercicio(rs.getString("nombre_ejercicio"));
                ejer.setGrupoMuscular(rs.getString("grupo_muscular"));
                registro=new RegistroLevantamiento();
                registro.setIdRegistro(rs.getInt("id_registro"));
                registro.setEjercicio(ejer);
                registro.setPesoLevantado(rs.getInt("peso"));
                registro.setRepeticiones(rs.getInt("repeticiones"));

                listaReg.add(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al consultar en la clase RegistroLevantamiento\n" +
                    "tipo de error: "+e.getMessage());
        }
        finally {
            this.conexionBD.cerrarConexion();
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

    public boolean busRegistro(){
        boolean ent;

        this.conexionBD = new ConexionBD();

        String sql = "SELECT * FROM Registro_Levantamiento "+
                "WHERE id_usuario = "+this.usuario.getId_usuario()+
                " AND id_ejercicio = "+this.ejercicio.getIdEjercicio()+";";

        try{
            ResultSet rs = this.conexionBD.consultaBD(sql);

            if(rs.next()){
                ent = true;
            }
            else {
                ent = false;
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,
                    "Error al buscar registro\n" +
                            "Tipo de error: " + e.getMessage());
            ent = false;
        }
        finally {
            this.conexionBD.cerrarConexion();
        }
        return  ent;
    }

    public List<RegistroLevantamiento> filtrarEjercicio(String nombre_ejercicio){

        List<RegistroLevantamiento> listreg =  new ArrayList<>();

        this.conexionBD = new ConexionBD();

        String sql =
                "SELECT " +
                        "Registro_Levantamiento.id_usuario, " +
                        "nombre, " +
                        "nombre_ejercicio, " +
                        "repeticiones, " +
                        "Registro_Levantamiento.peso " +
                        "FROM Registro_Levantamiento " +
                        "INNER JOIN Usuario USING(id_usuario) " +
                        "INNER JOIN Ejercicio USING(id_ejercicio) " +
                        "WHERE nombre_ejercicio = '" + nombre_ejercicio + "' " +
                        "ORDER BY Registro_Levantamiento.peso DESC;";

        try{

            ResultSet rs = this.conexionBD.consultaBD(sql);
            RegistroLevantamiento registro;
            Ejercicio ejer;
            Usuario user;

            while (rs.next()){

                ejer = new Ejercicio();
                ejer.setNombreEjercicio(rs.getString("nombre_ejercicio"));

                registro = new RegistroLevantamiento();
                registro.setEjercicio(ejer);
                registro.setRepeticiones(rs.getInt("repeticiones"));
                registro.setPesoLevantado(rs.getInt("peso"));

                user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                registro.setUsuario(user);

                listreg.add(registro);
            }

        }
        catch (Exception e){

            JOptionPane.showMessageDialog(null,
                    "Error al filtrar ejercicios\n" +
                            "Tipo de error: " + e.getMessage());

        }
        finally {
            this.conexionBD.cerrarConexion();
        }
        return listreg;
    }
}