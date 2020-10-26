/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import lombok.Data;

/**
 *
 * @author Elmer Cardoza
 */
@Data
public class Usuario {
    private int idUsuario;
    private String Usuario;
    private String Pass;
    private int tipoUsuario;
}
