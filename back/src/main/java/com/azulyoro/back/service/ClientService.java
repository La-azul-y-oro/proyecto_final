package com.azulyoro.back.service;

import com.azulyoro.back.dto.CustomPage;
import com.azulyoro.back.dto.request.ClientRequestDto;
import com.azulyoro.back.dto.response.ClientResponseDto;
import com.azulyoro.back.exception.CannotDeleteActiveServicesException;
import com.azulyoro.back.exception.CannotDeleteEntityException;
import com.azulyoro.back.mapper.Mapper;
import com.azulyoro.back.mapper.PageMapper;
import com.azulyoro.back.model.Client;
import com.azulyoro.back.model.ServiceStatus;
import com.azulyoro.back.model.Services;
import com.azulyoro.back.repository.ClientRepository;
import com.azulyoro.back.util.MessageUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements EntityService<ClientRequestDto, ClientResponseDto> {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private Mapper<Client, ClientRequestDto, ClientResponseDto> clientMapper;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public ClientResponseDto create(ClientRequestDto clientRequestDto) {
        Client client = clientRepository.save(clientMapper.dtoToEntity(clientRequestDto));
        return clientMapper.entityToDto(client);
    }

    @Override
    public ClientResponseDto update(Long id, ClientRequestDto clientRequestDto) {
        Client currentClient = getClientById(id);

        Client clientToUpdate = clientMapper.dtoToEntity(clientRequestDto);
        clientToUpdate.setId(id);
        clientToUpdate.setServices(currentClient.getServices());

        return clientMapper.entityToDto(clientRepository.save(clientToUpdate));
    }

    @Override
    public ClientResponseDto getById(Long id) {
        return clientMapper.entityToDto(getClientById(id));
    }

    @Override
    public List<ClientResponseDto> getAll() {
        return clientRepository
                .findAll()
                .stream()
                .map(clientMapper::entityToDto)
                .toList();
    }

    @Override
    public CustomPage<ClientResponseDto> getByPage(Pageable pageable) {
        Page<ClientResponseDto> page = clientRepository
                .findAll(pageable)
                .map(clientMapper::entityToDto);

        return pageMapper.pageToCustomPage(page);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        validateRelatedServices(id);

        try {
            clientRepository.softDelete(id);
        } catch (Exception e) {
            throw new CannotDeleteEntityException(MessageUtil.entityCannotDelete(id, e.getMessage()));
        }
    }

    private Client getClientById(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.entityNotFound(id)));
    }

    private void validateRelatedServices(Long id){
        List<Services> servicesRelated = clientRepository.findServicesByClientId(id);

        boolean hasRelatedIncomplete = servicesRelated.stream().anyMatch(
                e ->
                        e.getStatus().equals(ServiceStatus.TO_DO) ||
                        e.getStatus().equals(ServiceStatus.IN_PROGRESS) ||
                        (e.getStatus().equals(ServiceStatus.FINISHED) && e.getPay() == null)
        );

        if(hasRelatedIncomplete) throw new CannotDeleteActiveServicesException(MessageUtil.entityRelatedCannotDelete(id));
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }
}
