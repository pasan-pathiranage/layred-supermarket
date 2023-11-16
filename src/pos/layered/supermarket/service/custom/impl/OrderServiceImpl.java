/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered.supermarket.service.custom.impl;

import pos.layered.supermarket.dao.DaoFactory;
import pos.layered.supermarket.dao.custom.ItemDao;
import pos.layered.supermarket.dao.custom.OrderDao;
import pos.layered.supermarket.dao.custom.OrderDetailDao;
import pos.layered.supermarket.dto.OrderDto;
import pos.layered.supermarket.service.custom.OrderService;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import pos.layered.supermarket.db.DBConnection;
import pos.layered.supermarket.dto.OrderDetailDto;
import pos.layered.supermarket.entity.ItemEntity;
import pos.layered.supermarket.entity.OrderDetailEntity;
import pos.layered.supermarket.entity.OrderEntity;

/**
 *
 * @author User
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDERDETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String placeOrder(OrderDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (orderDao.add(new OrderEntity(dto.getOrderId(), sdf.format(new Date()), dto.getCustomerId()))) {
                boolean isOrderSaved = true;
                for (OrderDetailDto orderDetailDto : dto.getOrderDetailDtos()) {
                    if (!orderDetailDao.add(new OrderDetailEntity(dto.getOrderId(),
                            orderDetailDto.getItemId(),
                            orderDetailDto.getQty(),
                            orderDetailDto.getDiscount()))) {

                        isOrderSaved = false;
                    }

                }
                if (isOrderSaved) {
                    boolean isItemUpdated = true;

                    for (OrderDetailDto orderDetailDto : dto.getOrderDetailDtos()) {

                        ItemEntity entity = itemDao.get(orderDetailDto.getItemId());
                        entity.setQoh(entity.getQoh() - orderDetailDto.getQty());
                        if (!itemDao.update(entity)) {
                            isItemUpdated = false;
                        }
                    }
                    if (isItemUpdated) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }

                } else {
                    connection.rollback();
                    return "OrderDetail Save Error";
                }

            } else {
                connection.rollback();
                return "Order Save Error";
            }

        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
