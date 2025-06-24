package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long cliId;

    @OneToMany(mappedBy = "endCliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "conCliente", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    @Column(name = "CLI_NOME")
    private String cliNome;

    @Column(name = "CLI_CPF", length = 11)
    private String cliCpf;

    @Column(name = "CLI_DATA_NAS", nullable = false)
    private LocalDateTime dataNascimento;

    @Column(name = "CLI_FORMA_PAG", nullable = false)
    private String cliformaPagamento;

    @Column(name = "CLI_ATIVO", nullable = false)
    private Boolean cliAtivo;



    public Cliente() {
    }

    public Cliente(Long cliId, String cliNome, String cliCpf, LocalDateTime dataNascimento, String cliformaPagamento, Boolean cliAtivo) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.dataNascimento = dataNascimento;
        this.cliformaPagamento = cliformaPagamento;
        this.cliAtivo = cliAtivo;
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

    public String getCliformaPagamento() {
        return cliformaPagamento;
    }

    public void setCliformaPagamento(String cliformaPagamento) {
        this.cliformaPagamento = cliformaPagamento;
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
