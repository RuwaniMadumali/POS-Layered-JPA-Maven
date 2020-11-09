package dao.custom.impl;

import dao.CrudDAOImpl;
import dao.custom.OrderDAO;
import entity.Order;

public class OrderDAOImpl extends CrudDAOImpl<Order,String>implements OrderDAO {

    public String getLastOrderId() throws Exception {
       return (String) entityManager.createQuery("SELECT o.id FROM Order o ORDER BY o.id DESC ").setMaxResults(1).getResultList().get(0);
    }


}
