package org.example.DTO;

import java.time.LocalDateTime;

public class ClienteDTO {

    private Long cliId;
    private String cliNome;
    private String cliCpf;
    private String cliProfissao;
    private String cliEstCivil;
    private Boolean cliAtivo;
    private LocalDateTime dataNascimento;

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

    public ClienteDTO() {
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliProfissao() {
        return cliProfissao;
    }

    public void setCliProfissao(String cliProfissao) {
        this.cliProfissao = cliProfissao;
    }

    public String getCliEstCivil() {
        return cliEstCivil;
    }

    public void setCliEstCivil(String cliEstCivil) {
        this.cliEstCivil = cliEstCivil;
    }

    public Boolean getCliAtivo() {
        return cliAtivo;
    }

    public void setCliAtivo(Boolean cliAtivo) {
        this.cliAtivo = cliAtivo;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
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
