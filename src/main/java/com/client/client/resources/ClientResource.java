package com.client.client.resources;

import com.client.client.dto.ClientDTO;
import com.client.client.services.ClientService;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.stream.Stream;
import com.client.client.services.ClientService;
@RestController
@CrossOrigin
@RequestMapping("/clients")
public class ClientResource {
    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientDTO> creatClient(@RequestBody @Valid ClientDTO clientDTO, UriComponentsBuilder uriComponentsBuilder) {
        ClientDTO clientDTO1 = service.createClient(clientDTO);
        URI address = uriComponentsBuilder.path("/clients/{id}").buildAndExpand(clientDTO1.getId()).toUri();
        return ResponseEntity.created(address).body(clientDTO);
    }

    @GetMapping()
    public Stream<ClientDTO> getAllClients() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getOneClient(@PathVariable @NotNull Long id) {
        return service.getOneClient(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> uptadeClientById(@PathVariable @NotNull Long id, @RequestBody @Valid ClientDTO clientDTO) {
        ClientDTO clientDTO1 = service.updateClient(id, clientDTO);
        return ResponseEntity.ok(clientDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneClientID(@PathVariable @NotNull long id){
        return service.deleteClient(id);
    }
}
