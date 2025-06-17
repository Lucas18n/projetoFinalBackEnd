package org.example.services;

import org.example.DTO.FornecedorDTO;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.Fornecedor;
import org.example.repositories.FornecedorRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> getAll() {
        return repository.findAll();
    }

    public Fornecedor findById(Long id) {
        Optional<Fornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Fornecedor insert(Fornecedor obj) {
        try {
            obj.setForId(null);
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Fornecedor update(Long id, FornecedorDTO objDto) {
        Fornecedor entity = findById(id);

        // Atualiza campos simples
        entity.setForNomeFantasia(objDto.getForNomeFantasia());
        entity.setForCnpj(objDto.getForCnpj());

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



        return repository.save(entity);
    }



    public void deleteFornecedor(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Fornecedor fromDTO(FornecedorDTO objDto) {
        System.out.println("Criando fornecedor com nome fantasia: " + objDto.getForNomeFantasia());

        Fornecedor fornecedor = new Fornecedor(
                null,
                objDto.getForNomeFantasia(),
                objDto.getForCnpj(),
                objDto.getForRazaoSocial()
        );

        // Inicializa as listas para evitar NullPointerException
        fornecedor.setEnderecos(new ArrayList<>());
        fornecedor.setContatos(new ArrayList<>());

        Endereco endereco = new Endereco(null, fornecedor, objDto.getEndRua(), objDto.getEndNumero(),
                objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndPais(),
                objDto.getEndEstado());

        Contato contato = new Contato(null, fornecedor, objDto.getConCelular(), objDto.getConTelefoneComercial(),
                objDto.getConEmail());

        fornecedor.getEnderecos().add(endereco);
        fornecedor.getContatos().add(contato);

        return fornecedor;
    }





    public FornecedorDTO toNewDTO(Fornecedor obj) {
        FornecedorDTO dto = new FornecedorDTO();
        dto.setForId(obj.getForId());
        dto.setForNomeFantasia(obj.getForNomeFantasia());
        dto.setForCnpj(obj.getForCnpj());
        dto.setForRazaoSocial(obj.getForRazaoSocial());

        // Supondo que só exista um endereço por fornecedor
        if (obj.getEnderecos() != null && !obj.getEnderecos().isEmpty()) {
            Endereco end = obj.getEnderecos().get(0);
            dto.setEndRua(end.getEndRua());
            dto.setEndNumero(end.getEndNumero());
            dto.setEndCidade(end.getEndCidade());
            dto.setEndCep(end.getEndCep());
            dto.setEndEstado(end.getEndEstado());
            dto.setEndPais(end.getEndPais());
        }

        // Supondo que só exista um contato por fornecedor
        if (obj.getContatos() != null && !obj.getContatos().isEmpty()) {
            Contato con = obj.getContatos().get(0);
            dto.setConCelular(con.getConCelular());
            dto.setConTelefoneComercial(con.getConTelefoneComercial());
            dto.setConEmail(con.getConEmail());
        }

        return dto;
    }

}
