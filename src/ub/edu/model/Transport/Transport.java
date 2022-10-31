package ub.edu.model.Transport;

import java.util.ArrayList;
import java.util.List;

public class Transport {
    private String id;
    private float velocitat;

    private final String[] tipusTransports = {"Bici","Cotxe","APeu"};
    public Transport (String id, float velocitat){
        this.id = id;
        this.velocitat = velocitat;
    }

    public String getId(){ return id;}

    public void setId (String id){
        this.id = id;
    }

    public float getVelocitat(){
        return velocitat;
    }

    public void setVelocitat (float velocitat){
        this.velocitat = velocitat;
    }
    public String[] getTipusTransport(String nom){
        return tipusTransports;
    }

}
