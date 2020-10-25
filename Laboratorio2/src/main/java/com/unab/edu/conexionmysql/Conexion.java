/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Stanly
 */
public class Conexion {
    
    private Connection conexionbd;
    
    public Conexion(){
        try {
            conexionbd = DriverManager.getConnection("jdbc:mysql://localhost/appbanco","root","root");
            System.out.println("conectado a la base de datos");
        } catch (Exception e) {
            System.out.println("Error verifique la conexion de la base de datos"+e);
        }
    
    
    }
    
    public Connection RetornoConexion(){
        return conexionbd;
    
    }
    
}
