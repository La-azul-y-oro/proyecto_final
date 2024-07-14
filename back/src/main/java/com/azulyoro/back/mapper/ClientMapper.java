package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.request.ClientRequestDto;
import com.azulyoro.back.dto.response.ClientResponseDto;
import com.azulyoro.back.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements Mapper<Client, ClientRequestDto, ClientResponseDto>{

    @Override
    public ClientResponseDto entityToDto(Client client) {
        ClientResponseDto clientDto = new ClientResponseDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setLastName(client.getLastName());
        clientDto.setCategory(client.getCategory());
        clientDto.setIdentificationNumber(client.getIdentificationNumber());
        clientDto.setEmail(client.getEmail());
        clientDto.setBusinessName(client.getBusinessName());
        //TODO ajustar agregando servicesDTO cuando el mismo esta realizado
        return clientDto;
    }

    @Override
    public Client dtoToEntity(ClientRequestDto requestDto) {
        Client client = new Client();
        client.setName(requestDto.getName());
        client.setLastName(requestDto.getLastName());
        client.setCategory(requestDto.getCategory());
        client.setIdentificationNumber(requestDto.getIdentificationNumber());
        client.setEmail(requestDto.getEmail());
        client.setBusinessName(requestDto.getBusinessName());
        return client;
    }
}
