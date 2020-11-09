package dao.custom.impl;

import dao.custom.QueryDAO;
import entity.CustomEntity;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.Date;

public class QueryDAOImpl implements QueryDAO {
private EntityManager entityManager;
    @Override
    public CustomEntity getOrderDetail(String orderId) throws Exception {

        try {
            Object[]result = (Object[]) entityManager.createNativeQuery("SELECT o.id AS orderId,c.name AS " +
                    "customerName,o.date AS OrderDate FROM `Order o INNER JOIN Customer c ON o.customerId = c.id WHERE o.id=?1`").
                    setParameter(1,orderId).getSingleResult();
            return new CustomEntity((String) result[0],(String) result[1],(Date) result[2]);
        } catch (NoResultException e) {
            return null;
        }


    }

    @Override
    public CustomEntity getOrderDetail2(String orderId) throws Exception {
        try {
            return (CustomEntity) entityManager.createQuery("SELECT NEW entity.CustomEntity(C.id,C.name,O.id)" +
                    "FROM Order O INNER JOIN O.customer C WHERE O.id=:id ").setParameter("id",orderId).
                    getSingleResult();
    } catch (NoResultException e) {
            return null;
        }


    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
