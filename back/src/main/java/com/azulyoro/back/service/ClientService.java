package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.model.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements EntityService<Client, Client> {

    @Override
    public Client create(Client client) {
        return null;
    }

    @Override
    public Client update(Long id, Client client) {
        return null;
    }

    @Override
    public Client getById(Long id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return List.of();
    }

    @Override
    public CustomPage<Client> getByPage(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) { }
}
