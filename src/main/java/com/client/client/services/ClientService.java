package com.client.client.services;

import com.client.client.dto.ClientDTO;
import com.client.client.model.Client;
import com.client.client.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        repository.save(client);
        return  modelMapper.map(client, ClientDTO.class);
    }

    public Stream<ClientDTO> getAllClients(){
        return repository.findAll().stream().map(c -> modelMapper.map(c, ClientDTO.class));
    }
    public ClientDTO getOneClient(Long id){
        Optional<Client> client = repository.findById(id);
        if(client.isPresent()){
            return modelMapper.map(client, ClientDTO.class);
        }
        throw new RuntimeException();
    }
    public ResponseEntity<Void> deleteClient(Long id ){
        repository.deleteById(id);
        return null;
    }
    public ClientDTO updateClient(Long id, ClientDTO clientDTO){
        Optional<Client> client = repository.findById(id);
        if(client.isPresent()){
            client.get().setName(clientDTO.getName());
            client.get().setCPF(clientDTO.getCPF());
            client.get().setEmail(clientDTO.getEmail());
            client.get().setPhone(clientDTO.getPhone());
            client.get().setAddress(clientDTO.getAddress());
            client.get().setDistrict(clientDTO.getDistrict());
            client.get().setCity(clientDTO.getCity());
            client.get().setState(clientDTO.getState());
            repository.save(client.get());
            return modelMapper.map(client, ClientDTO.class);
        }
        throw new RuntimeException();
    }
}
