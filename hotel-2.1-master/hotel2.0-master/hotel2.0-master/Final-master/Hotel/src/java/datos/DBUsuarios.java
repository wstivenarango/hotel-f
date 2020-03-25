/*
 * DBContactos.java
 * 
 * Created on 7/04/2008, 10:26:02 PM
 */
package datos;

import java.sql.*;
import logica.Reserva;
import logica.Usuario;

public class DBUsuarios {

    DBConexion cn;

    public DBUsuarios() {
        cn = new DBConexion();
    }

    public ResultSet getUsuarioById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_nombre, "
                + " con_Id, "
                + " con_numhab, "
                + " con_tipo,"
                + " con_imc, "
                + " con_objetivo "
                + " FROM usuarios "
                + " WHERE con_id = ? ");
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }

    /**
     * trae todos los registros de la tabla contactos
     */
    public ResultSet getUsuario() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_nombre, "
                + " con_Id, "
                + " con_dias, "
                + " con_numhab, "
                + " con_tipo, "
                + " FROM usuarios "
                + " ORDER BY con_nombre, con_edad ");

        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarUsuario(Reserva c, Usuario f) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into usuarios (con_nombre, "
                    + " con_Id, "
                    + " con_dias, "
                    + " con_numhab,"
                    + " con_tipo,) "
                    + " values(?,?,?,?,?)");
            pstm.setString(1, f.getNombre());
            pstm.setString(2,(f.getId()));
            pstm.setString(3, Integer.toString(c.getDias()));
            pstm.setString(4, Integer.toString(c.getNum_habitacion()));
            pstm.setString(6, c.getTipo());


            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void actualizarUsuario(Reserva c, Usuario f) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update usuarios set con_nombre = ?, "
                    + " con_Id = ?, "
                    + " con_dias = ?, "
                    + " con_num_hab = ?, "
                    + " con_tipo = ?, "
 
                    + " where con_id = ?");
            pstm.setString(1, f.getNombre());
            pstm.setString(2,(f.getId()));
            pstm.setString(3, Integer.toString(c.getDias()));
            pstm.setString(4, Integer.toString(c.getNum_habitacion()));
            pstm.setString(6, c.getTipo());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void borrarUsuario(Reserva c, Usuario f) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from usuarios "
                    + " where con_id = ?");

            pstm.setString
        (1, f.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}
