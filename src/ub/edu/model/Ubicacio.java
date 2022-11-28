package ub.edu.model;

public class Ubicacio {

    private float latitud, longitud, altura;

    public Ubicacio(float latitud, float longitud, float altura) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.altura = altura;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud(){
        return longitud;
    }

    public float getAltura(){
        return altura;
    }

    public float compareDistance(Ubicacio ubicacio){
        float dX, dY, resultat;

        dX = Math.abs(latitud - ubicacio.latitud);
        dY = Math.abs(longitud - ubicacio.longitud);
        resultat = (float)Math.sqrt(Math.pow(dX,2) + Math.pow(dY,2));

        return resultat;
    }

    public float compareAltura(Ubicacio ubicacio){return altura - ubicacio.altura;}


}
