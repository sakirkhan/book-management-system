package com.getir.assignment.dto;

import com.getir.assignment.entity.Order;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
public class OrderDTO {

    private Long id;
    private Long customerId;
    private Long bookId;
    private Integer quantities;

    public static OrderDTO toDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setBookId(order.getBookId());
        orderDTO.setCustomerId(order.getCustomerId());
        orderDTO.setQuantities(order.getQuantities());

        return orderDTO;
    }

}
