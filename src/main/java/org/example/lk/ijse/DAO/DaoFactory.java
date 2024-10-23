package org.example.lk.ijse.DAO;

import org.example.lk.ijse.DAO.impl.StudentDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT
    }

    public SuperDao getDAO(DAOTypes types){
        switch (types) {
            case STUDENT -> {
                return new StudentDaoImpl();
            }
        }
        return null;
    }
}
