package Conexion_bd;

import java.sql.ResultSet;
import java.util.List;

public interface  CRUD <T> {
    boolean insertarBD();
    List<T> consultarBD();
    boolean actualizarBD();
    boolean borrarBD();




}
