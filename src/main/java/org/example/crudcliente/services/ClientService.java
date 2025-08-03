package org.example.crudcliente.services;

import jakarta.validation.Valid;
import org.example.crudcliente.dtos.ClientDto;
import org.example.crudcliente.entities.Client;
import org.example.crudcliente.repositories.ClientRepository;
import org.example.crudcliente.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDto findById(Long id){
        Client client = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("cliente inexistente")
        );
        return new ClientDto(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDto(x));
    }

    @jakarta.transaction.Transactional
    public ClientDto insert(ClientDto dto) {
        Client client = new Client();
        copyDtoToEntity(dto, client);
        client = repository.save(client);
        return new ClientDto(client);

    }

    @Transactional
    public @Valid ClientDto update(Long id, @Valid ClientDto dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente inexistente");
        }
        Client client = repository.getReferenceById(id);
        copyDtoToEntity(dto, client);
        client = repository.save(client);
        return new ClientDto(client);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente inexistente");
        }
        repository.deleteById(id);
    }

    private void copyDtoToEntity(@Valid ClientDto dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }
}
