package main.java.classes;

/**
 * Classe de Produtos
 * @author Izabel Santos *
 */
public class Produto implements Comparable<Produto> {

    private int codigo;
    private String referencia;
    private String descricao;
    private String imagem;
    private String fornecedor;
    private String marca;
    private String observacao;
    private double preco_venda;

    public Produto(int codigo, String referencia, String descricao, String imagem, String fornecedor, String marca, String observacao, double preco_venda) {
        this.codigo = codigo;
        this.referencia = referencia;
        this.descricao = descricao;
        this.imagem = imagem;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.observacao = observacao;
        this.preco_venda = preco_venda;
    }

    public Produto(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    @Override
    public String toString() {
        return  "codigo=" + codigo +
                ", referencia='" + referencia + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imagem='" + imagem + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", marca='" + marca + '\'' +
                ", observacao='" + observacao + '\'' +
                ", preco_venda=" + preco_venda;

    }

    @Override
    public int compareTo(Produto produto) {
        try {
            if ((this.getCodigo() == produto.getCodigo()) &&
                    (this.getDescricao().equals(produto.getDescricao())) &&
                    (this.getReferencia().equals(produto.getReferencia())) &&
                    (this.getObservacao().equals(produto.getObservacao())) &&
                    (this.getMarca().equals(produto.getMarca())) &&
                    (this.getImagem().equals(produto.getImagem())) &&
                    (this.getPreco_venda() == produto.getPreco_venda())) {
                return 1;
            }

        } catch (Exception e) {
            return 0;
        }
        return -1;
    }
}
