package main.java.prototipos.main;


import main.java.classes.Abrir;
import main.java.classes.Produto;

import java.util.LinkedHashSet;

public class Reference {

    public static void main(String[] args) {
        //LinkedHashSet<String> stringLinkedList = new LinkedHashSet<>();
        Abrir.setNomearquivo("produtos_original.txt");
        LinkedHashSet<Produto> stringLinkedList = Abrir.getListaProdutos();
        stringLinkedList.forEach(System.out::println); //Methhod reference
    }
}
