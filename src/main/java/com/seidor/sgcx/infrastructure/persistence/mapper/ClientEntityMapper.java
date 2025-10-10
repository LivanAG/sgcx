package com.seidor.sgcx.infrastructure.persistence.mapper;
import com.seidor.sgcx.domain.model.Client;
import com.seidor.sgcx.infrastructure.persistence.entitity.ClientEntity;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientEntityMapper {

    private final CommercialSectorEntityMapper commercialSectorMapper;

    public Client toDomain(ClientEntity entity) {
        if (entity == null) return null;
        Client client = new Client();
        client.setId(entity.getId());
        client.setName(entity.getName());
        client.setSector(commercialSectorMapper.toDomain(entity.getCommercialSector()));
        return client;
    }

    public ClientEntity toEntity(Client domain) {
        if (domain == null) return null;
        ClientEntity entity = new ClientEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setCommercialSector(commercialSectorMapper.toEntity(domain.getSector()));
        return entity;
    }
}