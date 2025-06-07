package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "PRO_NOME", nullable = false)
    private String proNome;

    @NotNull(message = "Preço de Custo é obrigatório")
    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2, nullable = false)
    private Double proPrecoCusto;

    @NotNull(message = "Preço de Venda é obrigatório")
    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2, nullable = false)
    private Double proPrecoVenda;

    @NotNull(message = "Quantidade em estoque é obrigatório")
    @Column(name = "PRO_QTD_ESTOQUE", nullable = false)
    private Integer quantidadeEstoque;

    @NotBlank(message = "Categoria é obrigatória")
    @Column(name = "PRO_CATEGORIA", nullable = false)
    private String categoria;

    @NotBlank(message = "Código de barra é obrigatório")
    @Column(name = "PRO_COD_BARRA", nullable = false)
    private String codigoBarras;

    @NotBlank(message = "Marca é obrigatória")
    @Column(name = "PRO_MARCA", nullable = false)
    private String marca;

    @NotBlank(message = "Unidade de Medida é obrigatória")
    @Column(name = "PRO_UNIDADE_MED", nullable = false)
    private String unidadeMedida;

    @NotNull(message = "Status é obrigatório")
    @Column(name = "PRO_ATIVO", nullable = false)
    private Boolean ativo;

    @NotNull(message = "Data de Cadastro é obrigatória")
    @Column(name = "PRO_DATA_CAD", nullable = false)
    private LocalDateTime dataCadastro;



    public Produto() {
    }

    public Produto(Long proId, String proNome, Double proPrecoCusto, Double proPrecoVenda, Integer quantidadeEstoque,
                   String categoria, String codigoBarras, String marca, String unidadeMedida, Boolean ativo, LocalDateTime dataCadastro
                   ) {
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}