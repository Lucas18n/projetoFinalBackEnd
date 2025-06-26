package org.example.services;

import org.example.DTO.ClienteDTO;
import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.repositories.ClienteRepository;
import org.example.repositories.EnderecoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente obj) {
       try {
           obj.setCliId(null);
           obj = repository.save(obj);
           enderecoRepository.saveAll(obj.getEnderecos());
           return obj;
       } catch (DataIntegrityViolationException e) {
           throw new ValueBigForAtributeException(e.getMessage());
       }
    }

    public Cliente update(Long id, ClienteDTO objDto) {
        try {
            Cliente entity = findById(id);
            //Atualiza os dados do cliente
            entity.setCliNome(objDto.getCliNome());
            entity.setCliCpf(objDto.getCliCpf());
            entity.setCliAtivo(objDto.getCliAtivo());
            entity.setDataNascimento(objDto.getDataNascimento());


            //Atualiza o endereço do cliente
            Endereco endereco = entity.getEnderecos().get(0);

            //Assumindo que há apenas um endereço por cliente
            endereco.setEndRua(objDto.getEndRua());
            endereco.setEndPais(objDto.getEndPais());
            endereco.setEndCep(objDto.getEndCep());
            endereco.setEndNumero(objDto.getEndNumero());
            endereco.setEndEstado(objDto.getEndEstado());
            endereco.setEndCidade(objDto.getEndCidade());

            //Atualiza o contato
            Contato contato = entity.getContatos().get(0);

            contato.setConCelular(objDto.getConCelular());
            contato.setConEmail(objDto.getConEmail());
            contato.setConTelefoneComercial(objDto.getConTelefoneComercial());

            //Salva as alterações
            repository.save(entity);

            return entity;
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteCliente(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        Cliente cliente = new Cliente(null, objDto.getCliNome(), objDto.getCliCpf(), objDto.getDataNascimento(), objDto.getCliAtivo(), objDto.getCliProfissao(), objDto.getCliEstCivil());

        Endereco endereco = new Endereco(null, cliente, objDto.getEndRua(), objDto.getEndNumero(),
                objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado(),
                objDto.getEndPais());


        Contato contato = new Contato(null, cliente, objDto.getConCelular(), objDto.getConTelefoneComercial(),
                objDto.getConEmail());

        cliente.getEnderecos().add(endereco);
        cliente.getContatos().add(contato);

        return cliente;
    }

    public ClienteDTO toNewDTO(Cliente obj) {
        ClienteDTO dto = new ClienteDTO();

// Mapeie os atributos comuns entre Cliente e ClienteNewDTO
        dto.setCliId(obj.getCliId());
        dto.setCliNome(obj.getCliNome());
        dto.setCliCpf(obj.getCliCpf());
        dto.setCliAtivo(obj.getCliAtivo());
        dto.setDataNascimento(obj.getDataNascimento());
        dto.setCliEstCivil(obj.getCliEstCivil());
        dto.setCliProfissao(obj.getCliProfissao());



// Atributos específicos de Endereco
        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());
        dto.setEndPais(endereco.getEndPais());

// Atributos específicos de Contato
        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());

        return dto;
    }

}
