package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class FormaPagamento  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FPG_ID")
    private Long fpgId;

    @Column(name = "FPG_DESCRICAO")
    private String fpgDescricao;

    @Column(name = "FPG_ATIVO")
    private Boolean ativo; // Ex: true

    @Column(name = "FPG_PERMISSAO_PARCELA")
    private Boolean permiteParcelamento; // Ex: true

    @Column(name = "FPG_MAXIMO_PARCELA")
    private Integer numeroMaximoParcelas; // Ex: 12

    @Column(name = "FPG_TAXA_ADD")
    private BigDecimal taxaAdicional; // Ex: new BigDecimal("1.99") // 1,99% de taxa

    public FormaPagamento() {
    }

    public FormaPagamento(Long fpgId, String fpgDescricao, Boolean ativo, Boolean permiteParcelamento, Integer numeroMaximoParcelas, BigDecimal taxaAdicional) {
        this.fpgId = fpgId;
        this.fpgDescricao = fpgDescricao;
        this.ativo = ativo;
        this.permiteParcelamento = permiteParcelamento;
        this.numeroMaximoParcelas = numeroMaximoParcelas;
        this.taxaAdicional = taxaAdicional;
    }

    public Long getFpgId() {
        return fpgId;
    }

    public void setFpgId(Long fpgId) {
        this.fpgId = fpgId;
    }

    public String getFpgDescricao() {
        return fpgDescricao;
    }

    public void setFpgDescricao(String fpgDescricao) {
        this.fpgDescricao = fpgDescricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getPermiteParcelamento() {
        return permiteParcelamento;
    }

    public void setPermiteParcelamento(Boolean permiteParcelamento) {
        this.permiteParcelamento = permiteParcelamento;
    }

    public Integer getNumeroMaximoParcelas() {
        return numeroMaximoParcelas;
    }

    public void setNumeroMaximoParcelas(Integer numeroMaximoParcelas) {
        this.numeroMaximoParcelas = numeroMaximoParcelas;
    }

    public BigDecimal getTaxaAdicional() {
        return taxaAdicional;
    }

    public void setTaxaAdicional(BigDecimal taxaAdicional) {
        this.taxaAdicional = taxaAdicional;
    }
}