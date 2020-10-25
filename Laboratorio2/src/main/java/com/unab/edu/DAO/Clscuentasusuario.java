/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.cuentasusuario;
import com.unab.edu.conexionmysql.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Stanly
 */
public class Clscuentasusuario {
   Conexion cn = new Conexion();
   Connection con = cn.RetornoConexion();
   
   public ArrayList<cuentasusuario> Transacciones() {
        var listado = new ArrayList<cuentasusuario>();
        try {
            CallableStatement statement = con.prepareCall("SELECT * FROM appbanco.cuentasusuario;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                cuentasusuario transaccion = new cuentasusuario();
                transaccion.setIdcuentasusuario(res.getInt("idcuentasusuario"));
                transaccion.setSaldo(res.getDouble("saldo"));
                transaccion.setIdUsuario(res.getInt("idUsuario"));
                transaccion.setTransaccion(res.getInt("transaccion"));
                transaccion.setFecha(res.getDate("fecha"));
                //Agregando a la lista
                listado.add(transaccion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron las Transacciones " + e);
        }

        return listado;
    }
}
