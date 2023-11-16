/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pos.layered.supermarket.service.custom;

import pos.layered.supermarket.dto.OrderDto;
import pos.layered.supermarket.service.SuperService;

/**
 *
 * @author User
 */
public interface OrderService extends SuperService{
    String placeOrder(OrderDto dto) throws Exception;
}
