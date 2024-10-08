package main.java.classes;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/***************************************************************
 * Aplicação de cadastro de Produtos construido no NetBeans
 * @author Izabel Santos
 ***************************************************************/
public class Principal extends Extensao {

    // Inicio declaração de variáveis

    private final String[] marcas = comboValues();
    private JComboBox<String> cb_marca;
    private JPanel js_image_pane;
    private JLabel lbl_image_pane;
    private JTextArea txt_area;
    private JTextField txt_codigo;
    private JTextField txt_descricao;
    private JTextField txt_fornecedor;
    private JTextField txt_preco;
    private JTextField txt_referencia;
    private String txt_marca;
    private String txt_imagem;

    // Declaração de Variáveis
    /**********************************************
     * Cria o form Principal
     **********************************************/
    public Principal() {
        initComponents();
    }


    private void initComponents() {

        // Declaração de Variáveis
        JPanel aba_cadastro = new JPanel();
        JPanel aba_lista = new JPanel();
        DefaultTableModel tableModel;

        JLabel lbl_codigo = new JLabel();
        JLabel lbl_referencia = new JLabel();
        JLabel lbl_fornecedor = new JLabel();
        JLabel lbl_descricao = new JLabel();
        JLabel lbl_marca = new JLabel();
        JLabel lbl_preco = new JLabel();
        JLabel lbl_observacoes = new JLabel();
        JLabel txt_prod_info = new JLabel();

        JTable jTable1 = new JTable();
        JTabbedPane ap_registro = new JTabbedPane();
        JScrollPane txt_sp_observacoes = new JScrollPane();
        JScrollPane scrollpane_tabela = new JScrollPane();

        JSeparator jSeparator1 = new JSeparator();
        JSeparator separador_lp = new JSeparator();
        JLabel lbl_titulo = new JLabel();
        JMenu mp_sair = new JMenu();
        JMenu mp_arquivo = new JMenu();
        JMenuItem btn_mp_abrir = new JMenuItem();
        JMenuItem btn_mp_sair = new JMenuItem();
        JMenuBar menu_principal = new JMenuBar();
        JButton btn_lp_editar = new JButton("Editar");
        JButton btn_lp_sair = new JButton("Sair");
        JButton btn_cadastrar = new JButton("Cadastrar");
        JButton btn_reset = new JButton("Reset");
        JButton btn_cad_sair = new JButton("Sair");
        JButton btn_image = new JButton("Escolher imagem");

        txt_referencia = new JTextField();
        txt_codigo = new JTextField();
        txt_descricao = new JTextField();
        txt_fornecedor = new JTextField();
        js_image_pane = new JPanel();
        lbl_image_pane = new JLabel();
        cb_marca = new JComboBox<>();
        txt_area = new JTextArea();
        txt_preco = new JTextField();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Produtos");

        lbl_codigo.setText("Código");
        lbl_referencia.setText("Referência");
        lbl_descricao.setText("Descrição");
        lbl_fornecedor.setText("Fornecedor");

        js_image_pane.setBackground(new Color(0, 153, 102));
        js_image_pane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        js_image_pane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        js_image_pane.setDoubleBuffered(true);
        js_image_pane.setOpaque(false);
        js_image_pane.setPreferredSize(new Dimension(200, 300));


        lbl_image_pane.setBackground(new Color(51, 51, 51));
        js_image_pane.add(lbl_image_pane);

        //Combobox para variavel  txtmarca;
        cb_marca.setModel(new DefaultComboBoxModel<>( marcas ));
        cb_marca.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED ){
                txt_marca = marcas[ cb_marca.getSelectedIndex()];
            }
        });

        //***********************  Ações de kexboard ************************
        btn_mp_abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        btn_mp_sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));


        //Classe Abrir
        new Abrir();  //Abrindo o arquivo com os registros em tempo de execução
        LinkedHashSet<Produto> temp = Abrir.getListaProdutos(); //Obtendo a lista de produtos para a tabela
        String[] columns = new String [] { "Codigo", "Referencia", "Descricao","Fornecedor", "Imagem",  "Marca", "Observação", "Preço" };
        tableModel = new DefaultTableModel( converterDados(temp), columns);
        jTable1.setModel(tableModel);
        scrollpane_tabela.setViewportView(jTable1);
         jTable1.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new MouseAdapter() { //Evento onclick da tabela
            public void mouseClicked( MouseEvent evt) {
                txt_prod_info.setText("");
                int index = jTable1.getSelectedRow();
                TableModel model = jTable1.getModel();
                StringBuilder linha = new StringBuilder();
                linha.append("<html>");
                for(int i = 0; i < 7; i++){
                    linha.append(model.getValueAt(index, i).toString());
                    linha.append("<br/>");
                }
                linha.append("</html>");
                txt_prod_info.setText(linha.toString());
            }
        });


        mp_sair.addActionListener(e -> System.exit(3));


        lbl_marca.setText("Marca");
        btn_image.addActionListener(this::btn_imageActionPerformed);
        txt_area.setColumns(20);
        txt_area.setRows(5);
        txt_sp_observacoes.setViewportView(txt_area);
        lbl_preco.setText("Preço de venda");
        lbl_observacoes.setText("Observações");

        btn_cadastrar.addActionListener(evt -> btn_cadastrarActionPerformed());
        btn_reset.addActionListener(evt -> btn_resetActionPerformed());
        btn_cad_sair.addActionListener(evt -> btn_cad_sairActionPerformed());


       /*  Layout  */
        GroupLayout aba_cadastroLayout = new GroupLayout(aba_cadastro);
        aba_cadastro.setLayout(aba_cadastroLayout);
        aba_cadastroLayout.setHorizontalGroup(
                aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(aba_cadastroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addGroup( aba_cadastroLayout.createSequentialGroup()
                                                .addGroup(aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup( aba_cadastroLayout.createSequentialGroup()
                                                                .addGroup(aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl_codigo)
                                                                        .addComponent(txt_codigo, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl_referencia)
                                                                        .addComponent(txt_referencia)))
                                                        .addComponent(txt_descricao)
                                                        .addGroup( aba_cadastroLayout.createSequentialGroup()
                                                                .addGroup(aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl_fornecedor)
                                                                        .addComponent(lbl_descricao))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(txt_sp_observacoes)
                                                        .addGroup( aba_cadastroLayout.createSequentialGroup()
                                                                .addGroup(aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txt_preco, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbl_preco)
                                                                        .addComponent(lbl_observacoes))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(aba_cadastroLayout.createSequentialGroup()
                                                                                .addComponent(lbl_marca)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addComponent(cb_marca, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addComponent(txt_fornecedor))
                                                .addGap(10, 10, 10)
                                                .addGroup(aba_cadastroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(aba_cadastroLayout.createSequentialGroup()
                                                                .addComponent(btn_image)
                                                                .addGap(45, 45, 45))
                                                        .addComponent(js_image_pane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                        .addGroup( aba_cadastroLayout.createSequentialGroup()
                                                .addGap(0, 133, Short.MAX_VALUE)
                                                .addComponent(btn_cad_sair, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_reset, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_cadastrar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        aba_cadastroLayout.setVerticalGroup(
                aba_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aba_cadastroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(aba_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(aba_cadastroLayout.createSequentialGroup()
                                                .addComponent(js_image_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_image))
                                        .addGroup(aba_cadastroLayout.createSequentialGroup()
                                                .addGroup(aba_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbl_codigo)
                                                        .addComponent(lbl_referencia))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(aba_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txt_referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_descricao)
                                                .addGap(3, 3, 3)
                                                .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_fornecedor)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(aba_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbl_preco)
                                                        .addComponent(lbl_marca))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(aba_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                                .addComponent(lbl_observacoes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_sp_observacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(aba_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_cad_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()) //Sem nada, fica com o minimo de espaço, 30 e  Short.MAX_VALUE ,adiciona 30 de altura na base
        );

        ap_registro.addTab("Cadastro", aba_cadastro);


        btn_lp_editar.setText("Editar");
        btn_lp_editar.setMaximumSize(new Dimension(51, 23));
        btn_lp_editar.setMinimumSize(new Dimension(51, 23));
        btn_lp_editar.addActionListener(evt -> btn_lp_editarActionPerformed());



        btn_lp_sair.setText("Sair");
        btn_lp_sair.addActionListener(evt -> btn_lp_sairActionPerformed());

        GroupLayout aba_listaLayout = new GroupLayout(aba_lista);
        aba_lista.setLayout(aba_listaLayout);
        aba_lista.setLayout(aba_listaLayout);


        aba_listaLayout.setHorizontalGroup(
                aba_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aba_listaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(aba_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(separador_lp)
                                        .addComponent(scrollpane_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                                        .addGroup(aba_listaLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btn_lp_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_lp_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_prod_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        aba_listaLayout.setVerticalGroup(
                aba_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aba_listaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollpane_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_prod_info, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separador_lp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(aba_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_lp_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_lp_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );


        ap_registro.addTab("Lista de Produtos", aba_lista);

        getContentPane().add(ap_registro,BorderLayout.CENTER);

        lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 18)); // NOI18N
        lbl_titulo.setText("Registro de Produtos");
        lbl_titulo.setBorder( new EmptyBorder(30,10,30,0));
        getContentPane().add(lbl_titulo, BorderLayout.PAGE_START);
        mp_arquivo.setText("Arquivo");
        btn_mp_abrir.setText("Abrir");
        mp_arquivo.add(btn_mp_abrir);
        btn_mp_sair.setText("Sair");
        mp_arquivo.add(btn_mp_sair);
        menu_principal.add(mp_arquivo);
        mp_sair.setText("Sair");
        menu_principal.add(mp_sair);
        setJMenuBar(menu_principal);

        pack();
    }

    private void btn_lp_editarActionPerformed() {
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Funcionalidade ainda não criada!");
    }

    private void btn_lp_sairActionPerformed() {
        // TODO add your handling code here:
        System.exit(1);
    }

    private void btn_cad_sairActionPerformed() {
        // TODO add your handling code here:
        System.exit(2);
    }

    private void btn_resetActionPerformed() {
        // TODO add your handling code here:
        txt_codigo.setText("");
        txt_referencia.setText("");
        txt_descricao.setText("");
        txt_fornecedor.setText("");
        txt_area.setText("");
        txt_preco.setText("");
        //tableModel.fireTableDataChanged();
    }

    private void btn_cadastrarActionPerformed() {
        // TODO add your handling code here:

        Cadastrar novoproduto = new Cadastrar(
                txt_codigo.getText(),
                txt_referencia.getText(),
                txt_descricao.getText(),
                txt_imagem,
                txt_fornecedor.getText(),
                txt_marca,
                txt_area.getText(),
                txt_preco.getText()
        );
        novoproduto.novoProduto();
    }

    private void btn_imageActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

        txt_imagem = obterImagem();
        Image uu = Toolkit.getDefaultToolkit().createImage(txt_imagem).getScaledInstance(200,300,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon( uu );
        lbl_image_pane = new JLabel(imageIcon);
        js_image_pane.add(lbl_image_pane);
        js_image_pane.revalidate();
        js_image_pane.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }


}
