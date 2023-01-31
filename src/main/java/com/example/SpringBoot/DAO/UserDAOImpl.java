package com.example.SpringBoot.DAO;

import com.example.SpringBoot.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getOneUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        //       entityManager.flush();
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

}
