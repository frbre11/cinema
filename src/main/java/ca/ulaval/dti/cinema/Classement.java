/*
 * Classement.java
 * 
 * (C) 2013 Université Laval. Tous droits réservés.
 */
package ca.ulaval.dti.cinema;

public enum Classement {
    GENERAL("../img/General.gif"), TREIZEPLUS("../img/13+.gif"), SEIZEPLUS("../img/16+.gif"), DIXHUITPLUS("../img/18+.gif");
    private String image;
    
    Classement(String image) {
        this.image = image;
    }
    
    public String getImage() {
        return image;
    }
}
