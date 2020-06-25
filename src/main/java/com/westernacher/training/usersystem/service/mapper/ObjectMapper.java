package com.westernacher.training.usersystem.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to map one object to another
 * using the ModelMapper library. Its configuration is customized
 * so that ModelMapper can compare private fields in the mapping classes
 * and not strictly necessary that all fields with the same name
 * exist in both classes.
 *
 * @author Kristiyan SLavov
 */
@Service
public class ObjectMapper {

    private final ModelMapper modelMapper;

    public ObjectMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param <D>      type of result object.
     * @param <T>      type of source object to map from.
     * @param source   entity that needs to be mapped.
     * @param outClass class of result object.
     * @return new object of <code>outClass</code> type.
     */
    public <D, T> D map(final T source, Class<D> outClass) {
        return modelMapper.map(source, outClass);
    }

    /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param sourceList list of entities that needs to be mapped
     * @param outCLass   class of result list element
     * @param <D>        type of objects in result list
     * @param <T>        type of entity in <code>entityList</code>
     * @return list of mapped object with <code><D></code> type.
     */
    public <D, T> List<D> mapAll(final Collection<T> sourceList, Class<D> outCLass) {
        return sourceList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    /**
     * Maps {@code source} to {@code destination}.
     *
     * @param source      object to map from
     * @param destination object to map to
     */
    public <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}
