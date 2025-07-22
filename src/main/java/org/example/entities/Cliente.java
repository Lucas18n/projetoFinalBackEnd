package org.example.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long cliId;

    @OneToMany(mappedBy = "endCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)  // opcional manter, mas o fetch LAZY já ajuda
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(mappedBy = "conCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<Contato> contatos = new HashSet<>();

    @Column(name = "CLI_NOME")
    private String cliNome;

    @Column(name = "CLI_CPF", length = 11)
    private String cliCpf;

    @Column(name = "CLI_DATA_NAS", nullable = false)
    private LocalDateTime dataNascimento;

    @Column(name = "CLI_ATIVO", nullable = false)
    private Boolean cliAtivo;

    @Column(name = "CLI_PROFISSAO", nullable = false)
    private String cliProfissao;

    @Column(name = "CLI_EST_CIVIL", nullable = false)
    private String cliEstCivil;

    public Cliente() {
    }

    public Cliente(Long cliId, String cliNome, String cliCpf, LocalDateTime dataNascimento, Boolean cliAtivo, String cliProfissao, String cliEstCivil) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.dataNascimento = dataNascimento;
        this.cliAtivo = cliAtivo;
        this.cliProfissao = cliProfissao;
        this.cliEstCivil = cliEstCivil;
    }

    // getters e setters

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

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getCliAtivo() {
        return cliAtivo;
    }

    public void setCliAtivo(Boolean cliAtivo) {
        this.cliAtivo = cliAtivo;
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

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Set<Contato> contatos) {
        this.contatos = contatos;
    }
}
