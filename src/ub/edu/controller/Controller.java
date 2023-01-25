package ub.edu.controller;

import ub.edu.model.*;

import ub.edu.model.ValoracioStrategy.ValorarStrategy;

import java.util.*;


public class Controller {

    //ControllerData es una classe que inicialitza i emagatzema les dades
    private volatile static Controller uniqueIstance;

    private ControllerUsuari controllerUsuari;
    private ControllerRuta controllerRuta;
    private  ControllerPuntDePas controllerPuntDePas;
    private ControllerGrups controllerGrups;

    private Controller() {
        controllerUsuari = new ControllerUsuari();
        controllerRuta = new ControllerRuta();
        controllerPuntDePas = new ControllerPuntDePas();
        controllerGrups = new ControllerGrups();
    }

    public static Controller getInstance(){
        if (uniqueIstance == null){
            synchronized (Controller.class){
                if (uniqueIstance == null){
                    uniqueIstance = new Controller();
                }
            }
        }
        return uniqueIstance;
    }

    public ControllerUsuari getControllerUsuari(){
        return controllerUsuari;
    }
    public ControllerRuta getControllerRuta(){
        return controllerRuta;
    }
    public ControllerGrups getControllerGrups(){return controllerGrups;}
    public ControllerPuntDePas getControllerPuntDePas(){return controllerPuntDePas;}
}