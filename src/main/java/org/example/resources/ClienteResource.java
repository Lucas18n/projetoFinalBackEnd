package org.example.resources;

import org.example.DTO.ClienteDTO;
import org.example.entities.Cliente;
import org.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<Cliente> list = clienteService.getAll();
        List<ClienteDTO> listDto = list.stream()
                .map(clienteService::toNewDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        Cliente obj = clienteService.findById(id);
        ClienteDTO objDto = clienteService.toNewDTO(obj);
        return ResponseEntity.ok(objDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDTO objDto) {
        Cliente obj = clienteService.fromDTO(objDto);
        obj = clienteService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getCliId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Long id) {
        Cliente updated = clienteService.update(id, objDto);
        ClienteDTO updatedDto = clienteService.toNewDTO(updated);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
