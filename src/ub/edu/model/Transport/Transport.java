package ub.edu.model.Transport;

public class Transport {
    private String id;
    private float velocitat;
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

}
