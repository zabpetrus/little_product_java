package main.java.prototipos.consumidor;

import java.util.function.Consumer;

/**
 *
 * @author Izabel Santos
 */
public class Consumidor {

    public static void main(String[] args){
        Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
        imprimirUmaFrase.accept("Explosion!");
    }

}
