/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.supermarket.service.custom.impl;

import pos.layered.supermarket.dao.DaoFactory;
import pos.layered.supermarket.dao.custom.CustomerDao;
import pos.layered.supermarket.dto.CustomerDto;
import pos.layered.supermarket.entity.CustomerEntity;
import pos.layered.supermarket.service.custom.CustomerService;

/**
 *
 * @author User
 */
public class CustomerServiceImpl implements CustomerService {
    
    CustomerDao customerDao = DaoFactory.grtInstance().getDao();

    @Override
    public String addCustomer(CustomerDto dto) throws Exception {
        CustomerEntity ce = new CustomerEntity(dto.getId(),
                dto.getTitle(), dto.getName(), dto.getDob(), dto.getSalary(),
                dto.getAddress(), dto.getCity(), dto.getProvince(), dto.getZip());
        return null;
    }

}
