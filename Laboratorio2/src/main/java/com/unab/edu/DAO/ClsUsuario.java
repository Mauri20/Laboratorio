/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.usuario;
import com.unab.edu.conexionmysql.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class ClsUsuario {

    Conexion cn = new Conexion();
    Connection con = cn.RetornoConexion();

    public ArrayList<usuario> TraerUsuarios() {
        var listado = new ArrayList<usuario>();
        try {
            CallableStatement statement = con.prepareCall("SELECT * FROM usuario where tipoUsuario=2;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                usuario usu = new usuario();
                usu.setIdUsuario(res.getInt("idUsuario"));
                usu.setUsuario(res.getString("Usuario"));
                usu.setPassWord(res.getString("PassWord"));
                usu.setTipoUsuario(res.getInt("tipoUsuario"));
                //Agregando a la lista
                listado.add(usu);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los Usuarios " + e);
        }

        return listado;
    }

    public usuario Login(usuario user) {
        usuario usu = new usuario();
        try {
            CallableStatement statement = con.prepareCall("call sp_s_Login(?,?,?);");
            statement.setString("pUsuario", user.getUsuario());
            statement.setString("pPass", user.getPassWord());
            statement.setInt("pTipo", user.getTipoUsuario());
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                usu.setIdUsuario(res.getInt("idUsuario"));
                usu.setUsuario(res.getString("Usuario"));
                usu.setPassWord(res.getString("PassWord"));
                usu.setTipoUsuario(res.getInt("tipoUsuario"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario" + e);
        }
        return usu;
    }

}
