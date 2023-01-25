package ub.edu.controller;

import ub.edu.model.TripUB;

public class GeneralDataController {
    private volatile static GeneralDataController uniqueInstance;
    String nomUsuariActual;
    TripUB tripUB;
    private GeneralDataController(){
        nomUsuariActual = "ajaleo@gmail.com";
        tripUB = TripUB.getInstance();
    }

    public static GeneralDataController getInstance(){
        if (uniqueInstance == null){
            synchronized (Controller.class){
                if (uniqueInstance == null){
                    uniqueInstance = new GeneralDataController();
                }
            }
        }
        return uniqueInstance;
    }

    public String nomPersona(){
        return nomUsuariActual;
    }

    public void setNomUsuariActual(String n){
        nomUsuariActual = n;
    }

    public TripUB tripUB(){
        return tripUB;
    }
}
