package com.example.webshop.mappers;

import com.example.webshop.model.Sale;
import com.example.webshop.model.dto.SaleDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleMapper implements MapperInterface<Sale, SaleDTO> {

    @Override
    public Sale toEntity(SaleDTO dto) {
        return new Sale(dto.getId(), dto.getPercent());
    }

    @Override
    public SaleDTO toDTO(Sale entity) {
        return new SaleDTO(entity.getId(), entity.getPercent());
    }

    @Override
    public List<Sale> toEntityList(List<SaleDTO> dtos) {
        List<Sale> toReturn = new ArrayList<>();
        for(SaleDTO dto : dtos) {
            toReturn.add(this.toEntity(dto));
        }
        return toReturn;
    }

    @Override
    public List<SaleDTO> toDTOList(List<Sale> entities) {
        List<SaleDTO> toReturn = new ArrayList<>();
        for(Sale sale : entities) {
            toReturn.add(this.toDTO(sale));
        }
        return toReturn;
    }
}
