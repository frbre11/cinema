/*
 * FilmPanier.java
 * 
 * (C) 2013 Université Laval. Tous droits réservés.
 */
package ca.ulaval.dti.cinema;

import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;

public class FilmPanier implements Comparable<FilmPanier> {

    private Date presentation;
    private Film film;
    private DateFormat dateFormat = DateFormat.getDateInstance();

    public FilmPanier() {
        this.film = null;
        this.presentation = null;
    }

    public FilmPanier(Film film, Date presentation) {
        this.film = film;
        this.presentation = presentation;
    }

    public FilmPanier(FilmPanier filmPanier) {
        this.film = filmPanier.film;
        this.presentation = filmPanier.presentation;
    }

    public int getIdFilm() {
        return (film == null ? 0 : film.getId());
    }

    public Date getPresentation() {
        return presentation;
    }

    public void setPresentation(Date presentation) {
        this.presentation = presentation;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getTitre() {
        return (film == null ? "" : film.getTitre());
    }
    
    public void setTitre(String titre) {}

    public String getDateSortie() {
        return (film == null ? "" : dateFormat.format(film.getDateSortie()));
    }
    
    public void setDateSortie(String dateSortie) {}

    public String getClassement() {
        return (film == null ? "" : film.getClassement().toString());
    }
    
    public void setClassement(String classement) {}

    public String getGenres() {
        StringBuffer genresStr = new StringBuffer();
        if (film != null) {
            for (Genre genre : film.getGenres()) {
                if (genresStr.length() > 0) {
                    genresStr.append(", ");
                }
                genresStr.append(genre.toString());
            }
        }
        return genresStr.toString();
    }
    
    public void setGenres(String genres) {}

    public String getDuree() {
        String dureeStr = "";
        if (film != null) {
            double duree = film.getDuree();
            int heures = (int) duree;
            double minutesDouble = duree - Math.floor(duree);
            int minutes = (int) (minutesDouble * 60);
            dureeStr = (Integer.toString(heures) + "h" + Integer.toString(minutes));
        }
        return dureeStr;
    }
    
    public void setDuree(String duree) {}

    public String getSynopsis() {
        return (film == null ? "" : film.getSynopsis());
    }
    
    public void setSynopsis(String synopsis) {}

    public ArrayList<Date> getPresentations() {
        return (film == null ? null : film.getPresentations());
    }

    public String getImage() {
        return (film == null ? "" : film.getImage());
    }

    @Override
    public int compareTo(FilmPanier o) {
        int resultat = (getIdFilm() - o.getIdFilm());
        if (resultat == 0) {
            resultat = presentation.compareTo(o.getPresentation());
        }
        return resultat;
    }
}
