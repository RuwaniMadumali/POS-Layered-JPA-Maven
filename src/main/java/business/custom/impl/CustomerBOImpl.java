package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CustomerDAO;
import db.JPAUtil;
import entity.Customer;
import org.hibernate.Transaction;
import util.CustomerTM;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    // Field Injection
    private CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);

    public List<CustomerTM> getAllCustomers() throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        customerDAO.setEntityManager(entityManager);
        List<Customer> allCustomers = null;
        try {
            entityManager.getTransaction().begin();
            allCustomers = customerDAO.findAll();
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        }finally {
            entityManager.close();
        }
        List<CustomerTM>customers = new ArrayList<>();
        for (Customer customer:allCustomers) {
            customers.add(new CustomerTM(customer.getId(),customer.getName(),customer.getAddress()));

        }
        return customers;
    }

    public void saveCustomer(String id, String name, String address) throws Exception {
       EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        customerDAO.setEntityManager(entityManager);

        try {
            entityManager.getTransaction().begin();
            customerDAO.save(new Customer(id,name,address));
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        }finally {
            entityManager.close();
        }
    }

    public void deleteCustomer(String customerId) throws Exception {
       EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        customerDAO.setEntityManager(entityManager);
        try {
            entityManager.getTransaction().begin();
            customerDAO.delete(customerId);
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        }finally {
            entityManager.close();
        }
    }

    public void updateCustomer(String name, String address, String customerId) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        customerDAO.setEntityManager(entityManager);
        try {
           entityManager.getTransaction().begin();
            customerDAO.update(new Customer(customerId,name,address));
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        }finally {
            entityManager.close();
        }


    }

    public String getNewCustomerId() throws Exception {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        customerDAO.setEntityManager(entityManager);
        try {
            entityManager.getTransaction().begin();
            String lastCustomerId = customerDAO.getLastCustomerId();
            entityManager.getTransaction().commit();
            if (lastCustomerId == null) {
                return "C001";
            } else {
                int maxId = Integer.parseInt(lastCustomerId.replace("C", ""));
                maxId = maxId + 1;
                String id = "";
                if (maxId < 10) {
                    id = "C00" + maxId;
                } else if (maxId < 100) {
                    id = "C0" + maxId;
                } else {
                    id = "C" + maxId;
                }
                return id;
            }
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        } finally {
            entityManager.close();
        }

    }
}
