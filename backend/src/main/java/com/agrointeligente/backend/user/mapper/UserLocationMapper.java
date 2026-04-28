package com.agrointeligente.backend.user.mapper;

import com.agrointeligente.backend.user.dto.UserLocationDto;
import com.agrointeligente.backend.user.entity.UserLocation;
import java.math.BigDecimal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserLocationMapper {

    @Mapping(target = "latitude", source = "latitude", qualifiedByName = "bigDecimalToDouble")
    @Mapping(target = "longitude", source = "longitude", qualifiedByName = "bigDecimalToDouble")
    UserLocationDto toDto(UserLocation userLocation);

    @Mapping(target = "latitude", source = "latitude", qualifiedByName = "doubleToBigDecimal")
    @Mapping(target = "longitude", source = "longitude", qualifiedByName = "doubleToBigDecimal")
    @Mapping(target = "user", ignore = true)
    UserLocation toEntity(UserLocationDto dto);

    @Named("bigDecimalToDouble")
    default Double bigDecimalToDouble(BigDecimal value) {
        return value != null ? value.doubleValue() : null;
    }

    @Named("doubleToBigDecimal")
    default BigDecimal doubleToBigDecimal(Double value) {
        return value != null ? new BigDecimal(value) : null;
    }
}
