/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.supermarket.controller;

import java.util.ArrayList;
import pos.layered.supermarket.dto.CustomerDto;
import pos.layered.supermarket.service.ServiceFactory;
import pos.layered.supermarket.service.custom.CustomerService;

/**
 *
 * @author User
 */
public class CustomerController {
    
    CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public String addCustomer(CustomerDto customerDto) throws Exception {
        return customerService.addCustomer(customerDto);
    }

    public ArrayList<CustomerDto> getAllCustomers() throws Exception {
        return customerService.getAllCustomer();
    }
    
}
