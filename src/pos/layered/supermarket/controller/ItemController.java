/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.supermarket.controller;

import java.util.ArrayList;
import pos.layered.supermarket.dto.ItemDto;
import pos.layered.supermarket.service.ServiceFactory;
import pos.layered.supermarket.service.custom.ItemService;

/**
 *
 * @author User
 */
public class ItemController {
    ItemService itemService = (ItemService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);

    public String addItem(ItemDto itemDto) throws Exception {
        return itemService.addItem(itemDto);
    }

    public ArrayList<ItemDto> getAllItem() throws Exception {
        return itemService.getAllItems();
    }

    public String updateItem(ItemDto itemDto) throws Exception {
        return itemService.updateItem(itemDto);
    }

    public String deleteItem(String id) throws Exception {
        return itemService.deleteItem(id);
    }

    public ItemDto getItem(String id) throws Exception {
        return itemService.getItem(id);
    }
}
