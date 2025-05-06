package de.telran.onlineshopgarden.mapper;

import de.telran.onlineshopgarden.dto.OrderCreateDto;
import de.telran.onlineshopgarden.dto.OrderDto;
import de.telran.onlineshopgarden.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "items", source = "orderItems")
    @Mapping(target = "userId", source = "user.userId")
    OrderDto entityToDto(Order order);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "orderItems", source = "items")
    @Mapping(target = "status", constant = "CREATED")
    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Order createDtoToEntity(OrderCreateDto orderCreateDto);

    List<OrderDto> entityListToDtoList(List<Order> orders);

}
