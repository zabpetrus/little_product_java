package main.java.prototipos;

import main.java.classes.Abrir;
import main.java.classes.Extensao;
import main.java.classes.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedHashSet;

public class Teste extends Extensao {

    public Teste() {

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setSize(new Dimension(600, 400));
        Abrir arquivo = new Abrir();


        String[] columns = new String[]{"Codigo", "Referencia", "Descricao", "Fornecedor", "Imagem", "Marca", "Observação", "Preço"};
        LinkedHashSet<Produto> data = arquivo.getListaProdutos();
        DefaultTableModel tableModel = new DefaultTableModel(converterDados(data), columns);
        JTable table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        JFrame mio = new JFrame();
        mio.setLayout(new FlowLayout());
        mio.add(scrollPane);
        mio.setSize(new Dimension(600, 400));
        mio.setTitle("Teste JTable");
        mio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mio.setVisible(true);
    }

    public static void main(String[] args) {
        new Teste();
    }
}