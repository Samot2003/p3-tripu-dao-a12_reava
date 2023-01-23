package ub.edu.model;

import ub.edu.model.ValoracioStrategy.Valoracio;
import ub.edu.model.ValoracioStrategy.ValorarStrategy;

public class PuntDeControl{
    private String ID;
    private Ubicacio ubicacio;
    private Valoracio valoracio;
    public PuntDeControl(String ID, Ubicacio ubicacio) {
        this.ID = ID;
        valoracio = new Valoracio();
    }

    public void setValoracio(ValorarStrategy str, int val) throws Exception {
        valoracio.valorar(str,val);
        System.out.println(valoracio.getValoracions());
    }

    public String getID(){
        return ID;
    }

    public Ubicacio getUbicacio() {
        return ubicacio;
    }

    public Valoracio getValoracio() {
        return valoracio;
    }
}
