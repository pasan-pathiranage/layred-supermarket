/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pos.layered.supermarket.service.custom;

import java.util.ArrayList;
import pos.layered.supermarket.dto.ItemDto;
import pos.layered.supermarket.service.SuperService;

/**
 *
 * @author User
 */
public interface ItemService extends SuperService{
    String addItem(ItemDto itemDto) throws Exception;

    String updateItem(ItemDto itemDto) throws Exception;

    String deleteItem(String id) throws Exception;

    ItemDto getItem(String id) throws Exception;

    ArrayList<ItemDto> getAllItems() throws Exception;
}
