package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "END_ID")
    private Long endId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "END_CLI_ID")
    private Cliente endCliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "END_FOR_ID")
    private Fornecedor endFornecedor;

    @Column(name = "END_RUA")
    private String endRua;

    @Column(name = "END_NUMERO")
    private String endNumero;

    @Column(name = "END_CIDADE")
    private String endCidade;

    @Column(name = "END_CEP", length = 9)
    private String endCep;

    @Column(name = "END_ESTADO", length = 50)
    private String endEstado;

    @Column(name = "END_PAIS", length = 60)
    private String endPais;

    public Endereco() {
    }


    public Endereco(Long endId, Cliente endCliente, String endRua, String endNumero, String endCidade, String endCep, String endEstado, String endPais) {
        this.endId = endId;
        this.endCliente = endCliente;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endCidade = endCidade;
        this.endCep = endCep;
        this.endEstado = endEstado;
        this.endPais = endPais;
    }

    public Endereco(Long endId, Fornecedor endFornecedor, String endRua, String endNumero, String endCidade, String endCep, String endEstado, String endPais) {
        this.endId = endId;
        this.endFornecedor = endFornecedor;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endCidade = endCidade;
        this.endCep = endCep;
        this.endEstado = endEstado;
        this.endPais = endPais;
    }

    public Fornecedor getEndFornecedor() {
        return endFornecedor;
    }

    public void setEndFornecedor(Fornecedor endFornecedor) {
        this.endFornecedor = endFornecedor;
    }

    public Long getEndId() {
        return endId;
    }

    public void setEndId(Long endId) {
        this.endId = endId;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    public Cliente getEndCliente() {
        return endCliente;
    }

    public void setEndCliente(Cliente endCliente) {
        this.endCliente = endCliente;
    }

    public String getEndPais() {
        return endPais;
    }

    public void setEndPais(String endPais) {
        this.endPais = endPais;
    }
}