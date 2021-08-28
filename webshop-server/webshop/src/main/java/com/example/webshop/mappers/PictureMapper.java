package com.example.webshop.mappers;

import com.example.webshop.model.Picture;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PictureMapper implements MapperInterface<Picture, String> {

    @Override
    public Picture toEntity(String dto) {
        return new Picture(dto);
    }

    @Override
    public String toDTO(Picture entity) {
        return entity.getPicture();
    }

    @Override
    public List<Picture> toEntityList(List<String> dtos) {
        List<Picture> pictures = new ArrayList<>();
        for(String dto: dtos) {
            pictures.add(this.toEntity(dto));
        }
        return pictures;
    }


    public Set<Picture> toEntitySet(List<String> dtos) {
        HashSet<Picture> pictures = new HashSet<>();
        for(String dto: dtos) {
            pictures.add(this.toEntity(dto));
        }
        return pictures;
    }

    @Override
    public List<String> toDTOList(List<Picture> entities) {
        List<String> dtos = new ArrayList<>();
        for(Picture picture: entities) {
            dtos.add(this.toDTO(picture));
        }
        return dtos;
    }

    public List<String> toDTOSet(Set<Picture> entities) {
        List<String> dtos = new ArrayList<>();
        for(Picture picture: entities) {
            dtos.add(this.toDTO(picture));
        }
        return dtos;
    }
}
