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

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> getAll() {
        return repository.findAll();
    }

    public Fornecedor findById(Long id) {
        Fornecedor fornecedor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        // Força carregamento das coleções LAZY
        fornecedor.getEnderecos().size();
        fornecedor.getContatos().size();

        return fornecedor;
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
        try {
            Fornecedor entity = findById(id);

            // Atualiza dados básicos
            entity.setForNomeFantasia(objDto.getForNomeFantasia());
            entity.setForCnpj(objDto.getForCnpj());
            entity.setForRazaoSocial(objDto.getForRazaoSocial());
            entity.setForResponsavel(objDto.getForResponsavel());
            entity.setForTipoEmpresa(objDto.getForTipoEmpresa());
            entity.setForAtivo(objDto.getForAtivo());

            // Atualiza Endereço (assumindo apenas um)
            Endereco endereco = entity.getEnderecos().iterator().next();
            endereco.setEndRua(objDto.getEndRua());
            endereco.setEndNumero(objDto.getEndNumero());
            endereco.setEndCidade(objDto.getEndCidade());
            endereco.setEndCep(objDto.getEndCep());
            endereco.setEndEstado(objDto.getEndEstado());
            endereco.setEndPais(objDto.getEndPais());

            // Atualiza Contato (assumindo apenas um)
            Contato contato = entity.getContatos().iterator().next();
            contato.setConCelular(objDto.getConCelular());
            contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
            contato.setConEmail(objDto.getConEmail());

            return repository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteFornecedor(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Fornecedor fromDTO(FornecedorDTO objDto) {
        Fornecedor fornecedor = new Fornecedor(
                null,
                objDto.getForNomeFantasia(),
                objDto.getForCnpj(),
                objDto.getForRazaoSocial(),
                objDto.getForResponsavel(),
                objDto.getForTipoEmpresa(),
                objDto.getForAtivo()
        );

        Endereco endereco = new Endereco(null, fornecedor, objDto.getEndRua(), objDto.getEndNumero(),
                objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndPais(), objDto.getEndEstado());

        Contato contato = new Contato(null, fornecedor, objDto.getConCelular(),
                objDto.getConTelefoneComercial(), objDto.getConEmail());

        fornecedor.setEnderecos(new ArrayList<>());
        fornecedor.setContatos(new ArrayList<>());

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
        dto.setForResponsavel(obj.getForResponsavel());
        dto.setForTipoEmpresa(obj.getForTipoEmpresa());
        dto.setForAtivo(obj.getForAtivo());

        if (!obj.getEnderecos().isEmpty()) {
            Endereco end = obj.getEnderecos().iterator().next();
            dto.setEndRua(end.getEndRua());
            dto.setEndNumero(end.getEndNumero());
            dto.setEndCidade(end.getEndCidade());
            dto.setEndCep(end.getEndCep());
            dto.setEndEstado(end.getEndEstado());
            dto.setEndPais(end.getEndPais());
        }

        if (!obj.getContatos().isEmpty()) {
            Contato con = obj.getContatos().iterator().next();
            dto.setConCelular(con.getConCelular());
            dto.setConTelefoneComercial(con.getConTelefoneComercial());
            dto.setConEmail(con.getConEmail());
        }

        return dto;
    }
}
