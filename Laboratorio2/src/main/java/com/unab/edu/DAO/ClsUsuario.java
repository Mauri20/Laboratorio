/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexion.conexion;
import com.unab.edu.entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Elmer Cardoza
 */
public class ClsUsuario {

    conexion claseconnect = new conexion();
    Connection connect = claseconnect.retornarConexion();

    public ArrayList<Usuario> LoguinUsuario(String usu, String pass, int tipous) {
        ArrayList<Usuario> ListaUsuarios = new ArrayList<>();
        try {
            
            CallableStatement st = connect.prepareCall("call SP_S_LOGUIUSUARIO(?,?,?);");
            JOptionPane.showMessageDialog(null, "PUTO!");
            st.setString("pusuario", usu);
            st.setString("ppass", pass);
            st.setInt("tipo", tipous);
            JOptionPane.showMessageDialog(null, "PUTO2!");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario es = new Usuario();
                es.setUsuario(rs.getString("Usuario"));
                es.setPass(rs.getString("Contra"));
                es.setTipoUsuario(rs.getInt("tipoUsuario"));
                ListaUsuarios.add(es);
            }
            connect.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontraron usuarios"+e);
        }
        return ListaUsuarios;
    }

}
