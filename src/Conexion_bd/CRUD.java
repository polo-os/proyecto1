package Conexion_bd;

import java.sql.ResultSet;

public interface CRUD {
    boolean insertarBD(String sentenciaSQL);
    ResultSet consultarBD(String sentenciaSQL);
    boolean actualizarBD(String sentenciaSQL);
    boolean borrarBD(String sentenciaSQL);
}
