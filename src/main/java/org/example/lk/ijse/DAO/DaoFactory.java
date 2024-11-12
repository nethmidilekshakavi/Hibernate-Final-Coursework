package org.example.lk.ijse.DAO;

import org.example.lk.ijse.DAO.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT,USER,COURSE,REGISTRATION,PAYMENT
    }

    public SuperDao getDAO(DAOTypes types){
        switch (types) {
            case STUDENT -> {
                return new StudentDaoImpl();
            }
            case USER -> {
                return new UserDaoImpl();
            }
            case COURSE -> {
                return new CourseDaoImpl();
            }
            case REGISTRATION -> {
                return new RegistrationDaoImpl();
            }
            case PAYMENT ->
            {
                return new PaymentDaoImpl();
            }
        }
        return null;
    }
}
