package dao.custom.impl;

import dao.CrudDAOImpl;
import dao.custom.ItemDAO;
import entity.Item;

public class ItemDAOImpl extends CrudDAOImpl<Item,String>implements ItemDAO {


    public String getLastItemCode() throws Exception {
      //HQL
        return (String) entityManager.createQuery("SELECT i.code FROM entity.Item i ORDER BY i.code DESC").
                setMaxResults(1).getResultList().get(0);
    }


}
