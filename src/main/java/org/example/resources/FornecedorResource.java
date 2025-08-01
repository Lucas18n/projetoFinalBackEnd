package org.example.resources;

import org.example.DTO.ClienteDTO;
import org.example.DTO.FornecedorDTO;
import org.example.entities.Cliente;
import org.example.entities.Fornecedor;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> getAll() {
        List<Fornecedor> list = fornecedorService.getAll();
        List<FornecedorDTO> listDto = list.stream().map(obj -> fornecedorService.toNewDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.findById(id);
        FornecedorDTO dto = fornecedorService.toNewDTO(fornecedor);
        return ResponseEntity.ok().body(dto);
    }



    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody FornecedorDTO objDto) {
        Fornecedor obj = fornecedorService.fromDTO(objDto);
        obj = fornecedorService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getForId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody FornecedorDTO objDto, @PathVariable Long id) {
        fornecedorService.update(id, objDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        fornecedorService.deleteFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
