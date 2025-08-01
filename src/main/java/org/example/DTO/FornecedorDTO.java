package org.example.DTO;

public class FornecedorDTO {

    private Long forId;
    private String forNomeFantasia;
    private String forCnpj;
    private String forRazaoSocial;
    private String forResponsavel;
    private String ForTipoEmpresa;
    private Boolean forAtivo;



    // Endereco
    private String endRua;
    private String endNumero;
    private String endCidade;
    private String endCep;
    private String endEstado;
    private String endPais;

    // Contato
    private String conCelular;
    private String conTelefoneComercial;
    private String conEmail;

    public FornecedorDTO() {
    }

    public Long getForId() {
        return forId;
    }

    public void setForId(Long forId) {
        this.forId = forId;
    }

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

    public String getEndPais() {
        return endPais;
    }

    public void setEndPais(String endPais) {
        this.endPais = endPais;
    }

    public String getConCelular() {
        return conCelular;
    }

    public void setConCelular(String conCelular) {
        this.conCelular = conCelular;
    }

    public String getConTelefoneComercial() {
        return conTelefoneComercial;
    }

    public void setConTelefoneComercial(String conTelefoneComercial) {
        this.conTelefoneComercial = conTelefoneComercial;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }
}
