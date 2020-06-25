package com.westernacher.training.usersystem.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author Kristiyan SLavov
 */
@Service
public class ObjectMapper {

    private ModelMapper modelMapper;

    public ObjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
