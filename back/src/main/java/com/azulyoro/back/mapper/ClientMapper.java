package com.azulyoro.back.mapper;

import com.azulyoro.back.dto.request.ClientRequestDto;
import com.azulyoro.back.dto.response.ClientBasicResponseDto;
import com.azulyoro.back.dto.response.ClientResponseDto;
import com.azulyoro.back.dto.response.ServicesBasicResponseDto;
import com.azulyoro.back.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ClientMapper implements Mapper<Client, ClientRequestDto, ClientResponseDto>{

    @Autowired
    private ServicesMapper servicesMapper;

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
        clientDto.setServices(getServicesBasicDto(client));
        clientDto.setDeleted(client.isDeleted());

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
    private List<ServicesBasicResponseDto> getServicesBasicDto(Client client) {
        return Optional.ofNullable(client.getServices())
                .orElse(Collections.emptyList())
                .stream()
                .map(servicesMapper::entityToBasicDto)
                .toList();
    }

    public ClientBasicResponseDto entityToBasicDto(Client client) {
        ClientBasicResponseDto clientDto = new ClientBasicResponseDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setLastName(client.getLastName());
        clientDto.setCategory(client.getCategory());
        clientDto.setIdentificationNumber(client.getIdentificationNumber());
        clientDto.setEmail(client.getEmail());
        clientDto.setBusinessName(client.getBusinessName());
        clientDto.setDeleted(client.isDeleted());

        return clientDto;
    }
}
