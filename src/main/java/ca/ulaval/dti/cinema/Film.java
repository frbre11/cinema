/*
 * Film.java
 * 
 * (C) 2013 Universit� Laval. Tous droits r�serv�s.
 */
package ca.ulaval.dti.cinema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Film implements Comparable<Film> {

    private int id;
    private String titre;
    private Date dateSortie;
    private Classement classement;
    private ArrayList<Genre> genres;
    private double duree;
    private String synopsis;
    private ArrayList<Date> presentations;
    private String image;
    private static ArrayList<Film> films;
    private static int dernierId = 0;

    public Film() {
        this.id = 0;
        this.titre = "";
        this.dateSortie = new Date();
        this.classement = null;
        this.genres = new ArrayList<Genre>();
        this.duree = 0.0;
        this.synopsis = "";
        this.presentations = new ArrayList<Date>();
        this.image = "";
    }

    public Film(int id, String titre, Date dateSortie, Classement classement, ArrayList<Genre> genres, double duree,
            String synopsis, ArrayList<Date> presentations, String image) {
        this.id = id;
        this.titre = titre;
        this.dateSortie = dateSortie;
        this.classement = classement;
        this.genres = genres;
        this.duree = duree;
        this.synopsis = synopsis;
        this.presentations = presentations;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Classement getClassement() {
        return classement;
    }

    public void setClassement(Classement classement) {
        this.classement = classement;
    }
    
    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public ArrayList<Date> getPresentations() {
        return presentations;
    }

    public void setPresentations(ArrayList<Date> presentations) {
        this.presentations = presentations;
        Collections.sort(this.presentations);
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    static {
        ArrayList<Genre> genres;
        ArrayList<Date> presentations;
        Calendar cal = Calendar.getInstance();
        films = new ArrayList<Film>();

        genres = new ArrayList<Genre>();
        genres.add(Genre.DRAME);
        genres.add(Genre.MUSIQUE);
        genres.add(Genre.ROMANCE);
        presentations = new ArrayList<Date>();
        cal.set(0, 0, 0, 12, 5, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 14, 35, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 17, 0, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 19, 40, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 22, 10, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 6, 27, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "Dansez dans les rues 4",
                cal.getTime(),
                Classement.GENERAL,
                genres,
                1.66,
                "Emilie, jeune femme aspirant � une carri�re de danseuse professionnelle, arrive � Miami o� elle fait la connaissance de Sean, chef du groupe de danse The Mob. Cette troupe organise des flash-mob d�cal�s et s'entra�ne dans le but de gagner une comp�tition. La situation devient critique le jour o� un riche homme d'affaires d�cide de d�truire le quartier historique o� op�re The Mob afin d'y implanter des constructions modernes. Entour�e de ses nouveaux amis, Emilie va tenter de l'en dissuader...",
                presentations,
                "../img/StepUpRevolutionFR.jpg"));
        
        genres = new ArrayList<Genre>();
        genres.add(Genre.ACTION);
        genres.add(Genre.CRIME);
        genres.add(Genre.DRAME);
        presentations = new ArrayList<Date>();
        cal.set(0, 0, 0, 12, 0, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 13, 10, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 15, 30, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 16, 45, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 19, 0, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 20, 20, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 22, 30, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 6, 20, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "L'ascension du Chevalier noir",
                cal.getTime(),
                Classement.GENERAL,
                genres,
                2.75,
                "L'�pique finale de la l�gende du chevalier noir sign�e par le r�alisateur Christopher Nolan. Pr�tant une fois de plus ses traits � Bruce Wayne � alias Batman -, l'oscaris� Christian Bale m�ne une distribution de stars internationales. Le film met �galement en vedette Anne Hathaway (qui incarne Selina Kyle), Tom Hardy (qui joue Bane), la laur�ate d'un Oscar Marion Cotillard (qui devient Miranda Tate) et Joseph Gordon-Levitt (qui se transforme en John Blake). Retrouvant le cin�aste pour cette nouvelle aventure, on note l'acteur prim� aux Oscars Michael Cayne (qui incarne Alfred), Gary Oldman (qui joue le commissaire Gordon) et un autre laur�at dun Oscar, Morgan Freeman (qui devient une fois de plus Lucius Fox).",
                presentations,
                "../img/DarkKnightRisesFR.jpg"));
        
        genres = new ArrayList<Genre>();
        genres.add(Genre.COMEDIE);
        genres.add(Genre.ANIMATION);
        genres.add(Genre.AVENTURE);
        presentations = new ArrayList<Date>();
        cal.set(0, 0, 0, 12, 0, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 14, 25, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 16, 50, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 19, 10, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 21, 30, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 6, 13, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "L'�re de glace: la d�rive des continents",
                cal.getTime(),
                Classement.GENERAL,
                genres,
                1.55,
                "L'incessante tentative de Scrat d'attraper son gland, qu'il poursuit depuis la nuit des temps, aura cette fois-ci des cons�quences d�sastreuses qui vont changer le monde. Manny, Diego et Sid se lancent dans leur plus grand p�riple alors qu'un cataclysme donne naissance � un continent � la d�rive. � la suite de ces bouleversements, Sid est r�uni avec sa grand-m�re acari�tre et la troupe fait la rencontre d'une m�nagerie de pirates d�termin�s � les emp�cher de rentrer chez eux.", 
                presentations,
                "../img/IceAge4FR.jpg"));
        
        genres = new ArrayList<Genre>();
        genres.add(Genre.COMEDIE);
        genres.add(Genre.DRAME);
        cal.set(0, 0, 0, 14, 0, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 16, 30, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 19, 20, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 21, 50, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 7, 8, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "L'espoir est � Hope Springs",
                cal.getTime(),
                Classement.TREIZEPLUS,
                genres,
                1.66,
                "Kay (Meryl Streep) et Arnold (Tommy Lee Jones) forment un couple d�vou�. Mais des d�cennies de mariage ont fait en sorte que Kay ressent le besoin de mettre un peu de piquant dans sa relation et de resserrer ses liens avec son mari. Quand elle entend parler qu'un renomm� sp�cialiste des histoires de couple (Steve Carell) se trouve dans la petite ville de Great Hope Springs, elle tente de persuader son �poux sceptique - un homme tenace lorsqu'il est question de routine �- d'embarquer avec elle dans un avion pour s'envoler vers une semaine de th�rapie matrimoniale. Juste de convaincre l'ent�t� Arnold est une lourde t�che; par contre, le vrai d�fi de Kay et son mari survient quand ils doivent partager leurs probl�mes au lit et tenter de rallumer la flamme qui leur a permis de tomber amoureux il a longtemps. ",
                presentations,
                "../img/HopeSpringsFR.jpg"));
        
        genres = new ArrayList<Genre>();
        genres.add(Genre.ACTION);
        presentations = new ArrayList<Date>();
        cal.set(0, 0, 0, 11, 55, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 14, 55, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 10, 25, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 6, 27, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "L'extraordinaire Spiderman",
                cal.getTime(),
                Classement.GENERAL,
                genres,
                2.26,
                "Il met en vedette Andrew Garfield, Emma Stone, Rhys Ifans, Denis Leary, Martin Sheen et Sally Field. Le long m�trage est r�alis� par Marc Webb d'apr�s un sc�nario r�dig� par James Vanderbilt, Alvin Sargent et Steve Kloves qui se sont bas�s sur la bande dessin�e de la compagnie Marvel cr��e par Stan Lee. Ce sont Steve Ditko, Laura Ziskin, Avi Arad et Matt Tolmach qui produisent l'aventure via Marvel Entertainment pour les studios Columbia Pictures.",
                presentations,
                "../img/TheAmazingSpidermanFR.jpg"));
        
        genres = new ArrayList<Genre>();
        genres.add(Genre.CRIME);
        genres.add(Genre.DRAME);
        genres.add(Genre.THRILLER);
        presentations = new ArrayList<Date>();
        cal.set(0, 0, 0, 13, 25, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 16, 10, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 18, 50, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 21, 30, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 6, 11, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "Omert�",
                cal.getTime(),
                Classement.TREIZEPLUS,
                genres,
                1.86,
                "Pierre Gauthier, � la t�te de Pulsar International, une agence de s�curit� de haut niveau, est appel� par Gilbert Tanguay � faire enqu�te sur un vaste complot. Il recrute Sophie, ex-agent du Service de renseignement canadien, afin qu'elle infiltre le milieu criminel montr�alais. Son mandat: gagner la confiance de Sam Cohen et Steve B�langer, associ�s � la mafia italienne. Les deux hommes participent � une arnaque visant � d�tourner l'or qui repose dans les coffres des banques centrales nord-am�ricaines." ,
                presentations,
                "../img/OmertaV2.jpg"));
        
        genres = new ArrayList<Genre>();
        genres.add(Genre.COMEDIE);
        presentations = new ArrayList<Date>();
        cal.set(0, 0, 0, 15, 20, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 17, 45, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 20, 10, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 22, 35, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 6, 27, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "Surveillance",
                cal.getTime(),
                Classement.GENERAL,
                genres,
                1.77,
                "Quatre banlieusards se r�unissent pour former un groupe de surveillance. Mais en r�alit�, ce n'est quune excuse pour �chapper � leur quotidien monotone un soir par semaine. Ils viennent � d�couvrir par hasard que leur ville est envahie par des extraterrestres qui se cachent sous une apparence de banlieusards ordinaires. Ils n'ont alors d'autres choix que de sauver leur quartier, ainsi que le reste du monde, de l'extermination totale.",
                presentations,
                "../img/TheWatchFR.jpg"));
        
        genres = new ArrayList<Genre>();
        genres.add(Genre.ACTION);
        genres.add(Genre.AVENTURE);
        genres.add(Genre.SCIENCE_FICTION);
        presentations = new ArrayList<Date>();
        cal.set(0, 0, 0, 13, 20, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 16, 10, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 19, 0, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 21, 45, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 7, 3, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "Total Recall: M�moires programm�es",
                cal.getTime(),
                Classement.TREIZEPLUS,
                genres,
                1.96,
                "Total Recall est un thriller d'action s'int�ressant � la r�alit� et � la m�moire, et dont le sc�nario est inspir� de la nouvelle � Souvenirs � vendre � r�dig�e par Philip K. Dick. Bienvenue � Rekall, la compagnie qui peut transformer vos r�ves en de v�ritables souvenirs. Pour le travailleur d'usine Douglas Quaid (Colin Farrell) -� pourtant mari� � une splendide femme (Kate Beckinsale) qu'il aime follement -, ce voyage de l'esprit semble �tre synonyme de vacances parfaites, lui qui est aux prises avec une vie remplie de frustrations. De vrais souvenirs d'une existence de super espion forment peut-�tre le rem�de id�al. Mais l'intervention tourne mal. R�sultat : Quaid devient un homme traqu�. Poursuivi par la police �- contr�l�e par le chancelier Cohaagen (Bryan Cranstron), chef d'un monde libre -� il fait �quipe avec une combattante rebelle (Jessica Biel) pour trouver la t�te dirigeante de la force r�sistante (Bill Nighy) et ainsi stopper Cohaagen. La ligne entre le fantastique et la r�alit�...",
                presentations,
                "../img/TotalRecall.jpg"));
        
        genres = new ArrayList<Genre>();
        genres.add(Genre.COMEDIE);
        presentations = new ArrayList<Date>();
        cal.set(0, 0, 0, 12, 10, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 14, 50, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 17, 25, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 20, 0, 0);
        presentations.add(cal.getTime());
        cal.set(0, 0, 0, 22, 35, 0);
        presentations.add(cal.getTime());
        cal.set(2013, 5, 29, 0, 0, 0);
        films.add(new Film(
                ++dernierId,
                "Ted",
                cal.getTime(),
                Classement.GENERAL,
                genres,
                1.77,
                "Le cr�ateur de la s�rie t�l�vis�e d'animation Les Griffin (Family Guy) Seth MacFarlane porte pour la premi�re fois au grand �cran son humour absurde comme sc�nariste, r�alisateur et com�dien qui pr�te sa voix � la vedette du film, Ted. Cette com�die int�grant prises r�elles et animation par ordinateur raconte l'histoire de John Bennett (Mark Wahlberg), un homme adulte qui doit g�rer le fait que son ours en peluche, qui a pris vie apr�s un souhait d'enfance, refuse de le quitter depuis.",
                presentations,
                "../img/TedFr.jpg"));

        Collections.sort(films);
    }

    public static List<Film> chargerFilms() {
        return films;
    }

    @Override
    public int compareTo(Film o) {
        return (id - o.getId());
    }
}
