/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.supermarket.dao.custom.impl;

import java.util.ArrayList;
import pos.layered.supermarket.dao.CrudUtil;
import pos.layered.supermarket.dao.custom.CustomerDao;
import pos.layered.supermarket.entity.CustomerEntity;
import java.sql.ResultSet;
/**
 *
 * @author User
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean add(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)",
                t.getId(), t.getTitle(), t.getName(), t.getDob(),
                t.getSalary(), t.getAddress(), t.getCity(),
                t.getProvince(), t.getZip());
    }

    @Override
    public boolean update(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Customer SET CustTitle=?, CustName=?, "
                + "DPB=?, Salary=?, CustAddress=?, City=?, Province=?, "
                + "PostalCode=? WHERE CustID=? ",
                t.getTitle(), t.getName(), t.getDob(),
                t.getSalary(), t.getAddress(), t.getCity(),
                t.getProvince(), t.getZip(), t.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE CustID=?", id);
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer WHERE CustID = ?", id);
        while(rst.next()){
            CustomerEntity customerEntity = new CustomerEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4), 
                    rst.getDouble(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9));
            
            return customerEntity;
        }
        return null;
    }

    public ArrayList<CustomerEntity> getAll() throws Exception {
        ArrayList<CustomerEntity> customerEntitys = new ArrayList<>();
        
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer");
         while(rst.next()){
            CustomerEntity customerEntity = new CustomerEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4), 
                    rst.getDouble(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9));
            
            customerEntitys.add(customerEntity);
        }
         return customerEntitys;
    }

}
