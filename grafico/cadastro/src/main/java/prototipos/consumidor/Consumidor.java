/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototipos.consumidor;

import java.util.function.Consumer;

/**
 *
 * @author Izabel Santos
 */
public class Consumidor{
    
    public static void main(String[] args){
        Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
        imprimirUmaFrase.accept("Explosion!");
    }
    
}
