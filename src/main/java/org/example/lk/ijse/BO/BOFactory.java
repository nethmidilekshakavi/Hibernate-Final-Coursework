package org.example.lk.ijse.BO;

import org.example.lk.ijse.BO.impl.CourseBOImpl;
import org.example.lk.ijse.BO.impl.RegistrationBOImpl;
import org.example.lk.ijse.BO.impl.StudentBoImpl;
import org.example.lk.ijse.BO.impl.UserBoImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
       STUDENT,USER,COURSE,REGISTRATION
    }

    //Object creation logic for BO objects
    public SuperBo getBO(BOTypes types){
        switch (types) {

            case STUDENT -> {
                return new StudentBoImpl();
            }

            case USER -> {
                return new UserBoImpl();
            }
            case COURSE ->
            {
                return new CourseBOImpl();
            }
            case REGISTRATION ->
            {
                return new RegistrationBOImpl();
            }

        }
        return null;
    }
}
