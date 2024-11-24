package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.BO.BOFactory;
import org.example.lk.ijse.BO.custom.StudentBo;
import org.example.lk.ijse.DAO.cutom.UserDao;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.Entity.User;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.management.relation.Role;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    StudentBo studentBo = (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    @Override
    public boolean saveUser(User user) {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public User getUserByUsername(String username) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getaAll() throws IOException {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }

    @Override
    public boolean save(Student enitiy) throws IOException {
        // Implement this method if needed
        return false;
    }

    @Override
    public boolean update(User user) throws IOException {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();

            // Encrypt the password before saving
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            session.update(user);
            transaction.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int userId) throws IOException {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();

            NativeQuery<?> nativeQuery = session.createNativeQuery("DELETE FROM users WHERE id = :id");
            nativeQuery.setParameter("id", userId);
            nativeQuery.executeUpdate();

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> SearchUID(int uid) throws IOException {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("FROM User WHERE id = :uid", User.class)
                    .setParameter("uid", uid)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = FactoryConfiguration.getSessionFactory().openSession();
        User user = null;
        try {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }



}
