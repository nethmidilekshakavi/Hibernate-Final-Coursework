package org.example.lk.ijse.BO;

import org.example.lk.ijse.BO.impl.StudentBoImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
       STUDENT
    }

    //Object creation logic for BO objects
    public SuperBo getBO(BOTypes types){
        switch (types) {

            case STUDENT -> {
                return new StudentBoImpl();
            }

        }
        return null;
    }
}
