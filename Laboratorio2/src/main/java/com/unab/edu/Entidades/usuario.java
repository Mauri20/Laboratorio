/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import lombok.Data;

/**
 *
 * @author Stanly
 */
@Data
public class usuario {
    private int idUsuario;
    private String Usuario;
    private String PassWord;
    private int tipoUsuario;
    
}
