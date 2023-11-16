/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.supermarket.dao;

import pos.layered.supermarket.dao.custom.impl.CustomerDaoImpl;
import pos.layered.supermarket.dao.custom.impl.ItemdaoImpl;
import pos.layered.supermarket.dao.custom.impl.OrderDaoImpl;
import pos.layered.supermarket.dao.custom.impl.OrderDetailDaoImpl;

/**
 *
 * @author User
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemdaoImpl();
                case ORDER:
                return new OrderDaoImpl();
                case ORDERDETAIL:
                return new OrderDetailDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoTypes {
        CUSTOMER, ITEM,ORDER,ORDERDETAIL

    }

}
