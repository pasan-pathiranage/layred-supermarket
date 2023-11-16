/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.supermarket.controller;

import pos.layered.supermarket.dto.OrderDto;
import pos.layered.supermarket.service.ServiceFactory;
import pos.layered.supermarket.service.custom.OrderService;

/**
 *
 * @author User
 */
public class OrderController {

    private OrderService orderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);

    public String placeOrder(OrderDto orderDto) throws Exception {
        return orderService.placeOrder(orderDto);
    }

}
