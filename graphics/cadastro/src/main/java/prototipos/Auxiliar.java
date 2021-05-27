package main.java.prototipos;

import main.java.classes.Abrir;
import main.java.classes.Cadastrar;
import main.java.classes.Extensao;
import main.java.classes.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.LinkedHashSet;


public class Auxiliar extends Extensao {

    private final JTextField txt_codigo;
    private final JTextField txt_referencia;
    private final JTextField txt_descricao;
    private final JTextField txt_fornecedor;
    private final JTextField txt_preco;
    private final JComboBox<String> cb_marca;
    private final JPanel panel_foto;
    private final JTextArea txt_observacao;
    private String txt_marca;

    public Auxiliar(){

        setLayout(new FlowLayout());

        // Variables declaration - do not modify
        txt_observacao = new JTextArea();
        JPanel aba_cadastrar = new JPanel();

        JPanel aba_listar = new JPanel();
        JTable tbl_produtos = new JTable();
        JLabel lbl_codigo = new JLabel("Código");
        JLabel lbl_referencia = new JLabel("Referência");
        JLabel lbl_descricao = new JLabel("Descrição");
        JLabel lbl_marca = new JLabel("Marca");
        JLabel lbl_preco = new JLabel("Preço");
        JLabel lbl_foto = new JLabel("Foto do Produto");
        JLabel lbl_nomearquivo = new JLabel("");
        JLabel lbl_fornecedor = new JLabel("Fornecedor");
        JLabel lbl_observacao = new JLabel("Observação");
        JButton btn_sair = new JButton("Sair");
        JButton btn_cancelar = new JButton("Cancelar");
        JSeparator jSeparator1 = new JSeparator();
        JSeparator jSeparator2 = new JSeparator();
        JScrollPane js_observacao = new JScrollPane();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable tbl_Principal = new JTable();

        JMenuItem sublink_ac_abrir = new JMenuItem();
        JMenuItem sublink_ac_sair = new JMenuItem();
        JButton btn_reset = new JButton("Reset");
        JButton btn_foto = new JButton("Foto");
        JButton btn_cadastrar = new JButton("Cadastrar");
        JScrollPane jsp_observacao = new JScrollPane();
        String[] marcas = comboValues();

        //********************************************************
        JMenuBar menu_header = new JMenuBar();
        JMenu link_acoes = new JMenu();
        JMenu link_sair = new JMenu();
        sublink_ac_sair.setText("Sair");
        sublink_ac_abrir.setText("Abrir Lista");
        link_acoes.add(sublink_ac_abrir);
        link_acoes.add(sublink_ac_sair);
        menu_header.add(link_acoes);
        menu_header.add(link_sair);
        link_sair.setText("Sair");
        link_acoes.setText("Ações");
        menu_header.add(link_acoes);
        menu_header.add(link_sair);
        setJMenuBar(menu_header);

        sublink_ac_sair.addActionListener(e -> System.exit(1));

        //*************************************************************

        txt_codigo = new JTextField("Codigo", 10);
        txt_referencia = new JTextField("Referencia", 20);
        txt_descricao = new JTextField("Descricao", 30);
        txt_fornecedor = new JTextField("Fornecedor", 30);
        txt_preco = new JTextField("Preco", 20);
        cb_marca = new JComboBox<>();

        //****************************************************

        JPanel box_codigo = new JPanel();
        box_codigo.setLayout(new BoxLayout(box_codigo, BoxLayout.Y_AXIS));
        box_codigo.add(lbl_codigo);
        box_codigo.add(txt_codigo);

        //**************************************************

        JPanel box_referencia = new JPanel();
        box_referencia.setLayout(new BoxLayout(box_referencia, BoxLayout.Y_AXIS));
        box_referencia.add(lbl_referencia);
        box_referencia.add(txt_referencia);
        aba_cadastrar.add(box_referencia);

        //**************************************************



        //***************************************************

        JPanel box_descricao = new JPanel();
        box_descricao.setLayout(new BoxLayout(box_descricao, BoxLayout.Y_AXIS));
        box_descricao.add(lbl_descricao);
        box_descricao.add(txt_descricao);
        aba_cadastrar.add(box_descricao);

        //*****************************************************

        JPanel box_fornecedor = new JPanel();
        box_fornecedor.setLayout(new BoxLayout(box_fornecedor, BoxLayout.Y_AXIS));
        box_fornecedor.add(lbl_fornecedor);
        box_fornecedor.add(txt_fornecedor);
        aba_cadastrar.add(box_fornecedor);

        //******************************************************

        JPanel box_marca = new JPanel();
        box_marca.setLayout(new BoxLayout(box_marca, BoxLayout.Y_AXIS));
        box_marca.add(lbl_marca);
        cb_marca.setModel(new DefaultComboBoxModel<>( marcas ));
        box_marca.add(cb_marca);
        cb_marca.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED ){
                txt_marca = marcas[ cb_marca.getSelectedIndex()];
            }
        });
        aba_cadastrar.add(box_marca);

        //****************************************************

        JPanel box_observacao = new JPanel();
        box_observacao.setLayout(new BoxLayout(box_observacao, BoxLayout.Y_AXIS));
        box_observacao.add(lbl_observacao);
        txt_observacao.setFont(new Font("SansSerif", 0, 13));
        txt_observacao.setColumns(20);
        txt_observacao.setRows(5);
        js_observacao.setViewportView(txt_observacao);
        box_observacao.add(js_observacao);
        aba_cadastrar.add(box_observacao);

        //*********************************************************


        JPanel box_foto = new JPanel();
        box_foto.setLayout(new BoxLayout(box_foto, BoxLayout.PAGE_AXIS));
        box_foto.add(lbl_foto);
        panel_foto = new JPanel();
        panel_foto.setBackground(Color.BLUE);
        panel_foto.setPreferredSize(new Dimension(200,250));
        box_foto.add(panel_foto);
        box_foto.add(btn_foto);
        aba_cadastrar.add(box_foto);

        //******************************************************

        JPanel box_preco = new JPanel();
        box_preco.add(lbl_preco);
        box_preco.add(txt_preco);
        aba_cadastrar.add(box_preco);

        //*****************************************************

        JPanel buttons = new JPanel();
        buttons.add(btn_reset);
        buttons.add(btn_reset);
        buttons.add(btn_cancelar);
        buttons.add(btn_cadastrar);
        aba_cadastrar.add(buttons);

        //********************************************************


        JTabbedPane painel_abas = new JTabbedPane();

        //***************************************************

        painel_abas.addTab("Cadastrar", aba_cadastrar);
        painel_abas.setBounds(20, 5, 587, 435);
        painel_abas.addTab("Lista de Produtos", aba_listar);
        getContentPane().add(painel_abas);

        //*****************************************************

        LinkedHashSet<Produto> temp = new Abrir().getListaProdutos();
        String[] columns = new String [] { "Codigo", "Referencia", "Descricao", "Imagem", "Fornecedor", "Marca", "Observação", "Preço" };
        tbl_produtos.setModel(new DefaultTableModel( this.converterDados(temp), columns ) {
            final Class[] types = new Class [] {
                    Integer.class,
                    String.class,
                    String.class,
                    String.class,
                    String.class,
                    String.class,
                    String.class,
                    Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        //*******************************************************************************************




        btn_reset.addActionListener(e -> {
            txt_codigo.setText("");
            txt_referencia.setText("");
            txt_descricao.setText("");
            txt_fornecedor.setText("");
            txt_observacao.setText("");
            txt_preco.setText("");
        });


        btn_foto.addActionListener(e -> {
            String imagem = obterImagem();
            Image uu = Toolkit.getDefaultToolkit().createImage(imagem).getScaledInstance(200,300,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon( uu );
            JLabel merlin = new JLabel(imageIcon);
            panel_foto.add(merlin);
            panel_foto.revalidate();
            panel_foto.repaint();
        });

        btn_cadastrar.addActionListener(e -> {

            Cadastrar novoproduto = new Cadastrar(
                    txt_codigo.getText(),
                    txt_referencia.getText(),
                    txt_descricao.getText(),
                    "produto.png",
                    txt_fornecedor.getText(),
                    txt_marca,
                    txt_observacao.getText(),
                    txt_preco.getText()
            );
            novoproduto.novoProduto();
        });



    }

    public static void main(String[] args) {
        Auxiliar joker = new Auxiliar();
        joker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        joker.setSize(500, 450);
        joker.setVisible(true);
    }
}
