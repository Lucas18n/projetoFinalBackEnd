package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOR_ID")
    private Long forId;

    @NotBlank
    @Column(name = "FOR_NOME_FANTASIA", nullable = false)
    private String forNomeFantasia;

    @NotBlank
    @Column(name = "FOR_CNPJ", nullable = false, length = 14)
    private String forCnpj;

    @NotBlank
    @Size(max = 100)
    @Column(name = "FOR_RAZAO_SOCIAL")
    private String forRazaoSocial;

    @NotBlank
    @Size(max = 100)
    @Column(name = "FOR_RESPONSAVEL")
    private String forResponsavel;


    @Size(max = 100)
    @Column(name = "FOR_TIPO_EMPRESA")
    private String ForTipoEmpresa;

    @Column(name = "FOR_ATIVO", nullable = false)
    private Boolean forAtivo;

    // Relação com Endereço
    @OneToMany(mappedBy = "endFornecedor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

    // Relação com Contato
    @OneToMany(mappedBy = "conFornecedor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Contato> contatos;

    // Construtores
    public Fornecedor() {}


    public Fornecedor(Long forId, String forNomeFantasia, String forCnpj, String forRazaoSocial, String forResponsavel, String forTipoEmpresa, Boolean forAtivo) {
        this.forId = forId;
        this.forNomeFantasia = forNomeFantasia;
        this.forCnpj = forCnpj;
        this.forRazaoSocial = forRazaoSocial;
        this.forResponsavel = forResponsavel;
        ForTipoEmpresa = forTipoEmpresa;
        this.forAtivo = forAtivo;
    }
// Getters e Setters


    public Boolean getForAtivo() {
        return forAtivo;
    }

    public void setForAtivo(Boolean forAtivo) {
        this.forAtivo = forAtivo;
    }

    public String getForTipoEmpresa() {
        return ForTipoEmpresa;
    }

    public void setForTipoEmpresa(String forTipoEmpresa) {
        ForTipoEmpresa = forTipoEmpresa;
    }

    public String getForResponsavel() {
        return forResponsavel;
    }

    public void setForResponsavel(String forResponsavel) {
        this.forResponsavel = forResponsavel;
    }

    public Long getForId() {
        return forId;
    }

    public void setForId(Long forId) {
        this.forId = forId;
    }

    public String getForNomeFantasia() {
        return forNomeFantasia;
    }

    public void setForNomeFantasia(String forNomeFantasia) {
        this.forNomeFantasia = forNomeFantasia;
    }

    public String getForCnpj() {
        return forCnpj;
    }

    public void setForCnpj(String forCnpj) {
        this.forCnpj = forCnpj;
    }

    public String getForRazaoSocial() {
        return forRazaoSocial;
    }

    public void setForRazaoSocial(String forRazaoSocial) {
        this.forRazaoSocial = forRazaoSocial;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
