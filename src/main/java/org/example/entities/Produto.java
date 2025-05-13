package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @Column(name = "PRO_NOME")
    private String proNome;

    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2)
    private Double proPrecoCusto;

    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2)
    private Double proPrecoVenda;

    @Column(name = "PRO_QTD_ESTOQUE")
    private Integer quantidadeEstoque; // Ex: 120

    @Column(name = "PRO_CATEGORIA")
    private String categoria; // Ex: "Bebidas"

    @Column(name = "PRO_COD_BARRA")
    private String codigoBarras; // Ex: "7894900011517"

    @Column(name = "PRO_MARCA")
    private String marca; // Ex: "Coca-Cola"

    @Column(name = "PRO_UNIDADE_MED")
    private String unidadeMedida; // Ex: "Litro"

    @Column(name = "PRO_ATIVO")
    private String ativo; // Ex: true

    @Column(name = "PRO_DATA_CAD")
    private LocalDateTime dataCadastro; // Ex: LocalDateTime.now()

    @Column(name = "PRO_DATA_ATU")
    private LocalDateTime dataAtualizacao; // Ex: LocalDateTime.now()

    public Produto() {
    }

    public Produto(Long proId, String proNome, Double proPrecoCusto, Double proPrecoVenda, Integer quantidadeEstoque,
                   String categoria, String codigoBarras, String marca, String unidadeMedida, String ativo, LocalDateTime dataCadastro,
                   LocalDateTime dataAtualizacao) {
        this.proId = proId;
        this.proNome = proNome;
        this.proPrecoCusto = proPrecoCusto;
        this.proPrecoVenda = proPrecoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.codigoBarras = codigoBarras;
        this.marca = marca;
        this.unidadeMedida = unidadeMedida;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public Double getProPrecoCusto() {
        return proPrecoCusto;
    }

    public void setProPrecoCusto(Double proPrecoCusto) {
        this.proPrecoCusto = proPrecoCusto;
    }

    public Double getProPrecoVenda() {
        return proPrecoVenda;
    }

    public void setProPrecoVenda(Double proPrecoVenda) {
        this.proPrecoVenda = proPrecoVenda;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}