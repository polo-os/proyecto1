package modelo_logica;

import Conexion_bd.CRUD;
import Conexion_bd.ConexionBD;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SesionEntrenamiento implements CRUD <SesionEntrenamiento>{

    // Atributos
    private int idSesion;
    private int duracionMin;
    private String fecha;
    private String notas;
    private Usuario usuario;
    private ConexionBD conexionBD;

    // Constructores
    public SesionEntrenamiento() {}

    public SesionEntrenamiento(String fecha, int duracionMin, String notas) {
        this.fecha = fecha;
        this.duracionMin = duracionMin;
        this.notas = notas;
    }

    // Getters y Setters
    public int getIdSesion() { return idSesion; }
    public void setIdSesion(int idSesion) { this.idSesion = idSesion; }

    public int getDuracionMin() { return duracionMin; }
    public void setDuracionMin(int duracionMin) { this.duracionMin = duracionMin; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    // CRUD

    // CREATE
    @Override
    public boolean insertarBD() {
        boolean conf;
        this.conexionBD = new ConexionBD();

        String sql = "INSERT INTO Sesion_Entrenamiento(id_usuario, fecha, duracion_min, notas) "
                + "VALUES (" + this.usuario.getId_usuario() + ", '"
                + this.fecha + "', "
                + this.duracionMin + ", '"
                + this.notas + "');";

        if (this.conexionBD.setAutoCommitBD(false)) {
            if (this.conexionBD.insertarBD(sql)) {
                this.conexionBD.commitBD();
                this.conexionBD.cerrarConexion();
                conf = true;
            } else {
                this.conexionBD.rollbackBD();
                this.conexionBD.cerrarConexion();
                conf = false;
            }
        } else {
            this.conexionBD.cerrarConexion();
            conf = false;
        }
        return conf;
    }

    // READ  — todas las sesiones de un usuario
    @Override
    public List<SesionEntrenamiento> consultarBD() {
        List<SesionEntrenamiento> lista = new ArrayList<>();
        this.conexionBD = new ConexionBD();

        String sql = "SELECT * FROM Sesion_Entrenamiento "
                + "WHERE id_usuario = " + this.getUsuario().getId_usuario()
                + " ORDER BY fecha DESC;";

        try {
            ResultSet rs = this.conexionBD.consultarBD(sql);

            while (rs.next()) {
                SesionEntrenamiento sesion = new SesionEntrenamiento();
                sesion.setIdSesion(rs.getInt("id_sesion"));
                sesion.setFecha(rs.getString("fecha"));
                sesion.setDuracionMin(rs.getInt("duracion_min"));
                sesion.setNotas(rs.getString("notas"));
                lista.add(sesion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al consultar sesiones\nTipo de error: " + e.getMessage());
        } finally {
            this.conexionBD.cerrarConexion();
        }
        return lista;
    }

    // UPDATE
    @Override
    public boolean actualizarBD() {
        boolean conf;
        this.conexionBD = new ConexionBD();

        String sql = "UPDATE Sesion_Entrenamiento SET "
                + "fecha = '" + this.fecha + "', "
                + "duracion_min = " + this.duracionMin + ", "
                + "notas = '" + this.notas + "' "
                + "WHERE id_sesion = " + this.idSesion + ";";

        if (this.conexionBD.setAutoCommitBD(false)) {
            if (this.conexionBD.actualizarBD(sql)) {
                this.conexionBD.commitBD();
                this.conexionBD.cerrarConexion();
                conf = true;
            } else {
                this.conexionBD.rollbackBD();
                this.conexionBD.cerrarConexion();
                conf = false;
            }
        } else {
            this.conexionBD.cerrarConexion();
            conf = false;
        }
        return conf;
    }

    // DELETE
    @Override
    public boolean borrarBD() {
        boolean conf;
        this.conexionBD = new ConexionBD();

        String sql = "DELETE FROM Sesion_Entrenamiento "
                + "WHERE id_sesion = " + this.idSesion + ";";

        if (this.conexionBD.setAutoCommitBD(false)) {
            if (this.conexionBD.borrarBD(sql)) {
                this.conexionBD.commitBD();
                this.conexionBD.cerrarConexion();
                conf = true;
            } else {
                this.conexionBD.rollbackBD();
                this.conexionBD.cerrarConexion();
                conf = false;
            }
        } else {
            this.conexionBD.cerrarConexion();
            conf = false;
        }
        return conf;
    }
}
