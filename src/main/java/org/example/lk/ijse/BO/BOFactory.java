package org.example.lk.ijse.BO;

import org.example.lk.ijse.BO.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
       STUDENT,USER,COURSE,REGISTRATION,PAYMENT
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
            case PAYMENT ->
            {
                return new PaymentBOImpl();
            }

        }
        return null;
    }
}
