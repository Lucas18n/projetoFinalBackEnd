package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class FormaPagamento  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FPG_ID", nullable = false)
    private Long fpgId;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 1, message = "Descrição não pode estar vazia")
    @Column(name = "FPG_DESCRICAO", nullable = false)
    private String fpgDescricao;

    @NotNull(message = "Campo 'ativo' é obrigatório")
    @Column(name = "FPG_ATIVO", nullable = false)
    private Boolean ativo;

    @NotNull(message = "Campo 'permiteParcelamento' é obrigatório")
    @Column(name = "FPG_PERMISSAO_PARCELA", nullable = false)
    private Boolean permiteParcelamento;

    @NotNull(message = "Número máximo de parcelas é obrigatório")
    @Min(value = 1, message = "Deve ser no mínimo 1 parcela")
    @Column(name = "FPG_MAXIMO_PARCELA", nullable = false)
    private Integer numeroMaximoParcelas;

    @NotNull(message = "Taxa adicional é obrigatória")
    @Column(name = "FPG_TAXA_ADD", nullable = false)
    private BigDecimal taxaAdicional;



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