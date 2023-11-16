/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.supermarket.service;

import pos.layered.supermarket.service.custom.impl.ItemServiceImpl;
import pos.layered.supermarket.service.custom.impl.CustomerServiceImpl;
import pos.layered.supermarket.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author User
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}
    
    public static ServiceFactory getInstance(){
        if(serviceFactory==null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }
    public SuperService getService(ServiceType type){
        switch (type) {
            case CUSTOMER:
                return new CustomerServiceImpl();
             case ITEM:
                return new ItemServiceImpl(); 
                case ORDER:
                return new OrderServiceImpl();  
            default:
                return null;
        }
    }
    
    public enum ServiceType{
        CUSTOMER,ITEM,ORDER
        
    }
}
