/*
 * CinemaApplication.java
 * 
 * (C) 2013 Université Laval. Tous droits réservés.
 */
package ca.ulaval.dti.cinema;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.Table.ColumnHeaderMode;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Theme("cinema")
@PreserveOnRefresh
public class CinemaUI extends UI {

    private static final double PRIX_BILLET = 10.00;

    private GridLayout grlPrincipal;
    private GridLayout grlDescription;
    private ExternalResource resCinemaCineplex;
    private ExternalResource resImage;
    private ExternalResource resImageBlank;
    private ExternalResource resClassement;
    private ExternalResource resClassementBlank;
    private Embedded embCinemaCineplex;
    private Embedded embFilmImage;
    private Embedded embFilmClassement;
    private Panel pnlFilms;
    private Panel pnlFilmsPanier;
    private Panel pnlFilmDescription;
    private Table tblFilms;
    private Table tblFilmsPanier;
    private Label lblTotal;
    private Button btnSupprimer;
    private Button btnReinitialiser;
    private TabSheet tabSynopsis;
    private TabSheet tabPresentations;
    private TextField txtTitre;
    private TextField txtDateSortie;
    private TextField txtGenres;
    private TextField txtDuree;
    private TextArea txtSynopsis;
    private CssLayout cslPresentations;
    private BeanItemContainer<Film> cntFilms;
    private BeanItemContainer<FilmPanier> cntFilmsPanier;
    private BeanItem<FilmPanier> itmFilmPanier;
    private DateFormat dateFormat;
    private NumberFormat numberFormat;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Cinéma");
        resImageBlank = new ExternalResource("../img/blank.jpg");
        resClassementBlank = new ExternalResource("../img/blank.gif");
        grlPrincipal = new GridLayout(4, 12);
        setContent(grlPrincipal);
        HorizontalLayout horizontalLayoutTmp = new HorizontalLayout();
        grlPrincipal.addComponent(horizontalLayoutTmp, 0, 0, 3, 0);
        resCinemaCineplex = new ExternalResource("../img/cinemacineplexodeon.png");
        embCinemaCineplex = new Embedded(null, resCinemaCineplex);
        horizontalLayoutTmp.setWidth("100%");
        horizontalLayoutTmp.addComponent(embCinemaCineplex);
        horizontalLayoutTmp.setComponentAlignment(embCinemaCineplex, Alignment.MIDDLE_CENTER);
        pnlFilms = new Panel("Films à l'affiche");
        grlPrincipal.addComponent(pnlFilms, 0, 1, 2, 5);
        cntFilms = new BeanItemContainer<Film>(Film.class);
        cntFilms.addAll(Film.chargerFilms());
        tblFilms = new Table();
        tblFilms.setContainerDataSource(cntFilms);
        tblFilms.setVisibleColumns(new Object[] { "titre" });
        tblFilms.setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
        tblFilms.setWidth("400px");
        tblFilms.setHeight("280px");
        tblFilms.setSelectable(true);
        tblFilms.setImmediate(true);
        pnlFilms.setWidth("438px");
        pnlFilms.setContent(tblFilms);
        pnlFilmsPanier = new Panel("Panier");
        grlPrincipal.addComponent(pnlFilmsPanier, 0, 6, 2, 10);
        cntFilmsPanier = new BeanItemContainer<FilmPanier>(FilmPanier.class);
        tblFilmsPanier = new Table();
        tblFilmsPanier.setContainerDataSource(cntFilmsPanier);
        tblFilmsPanier.addGeneratedColumn("titrePresentation", new ColumnGenerator() {

            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
                Object cell = null;
                if (columnId.equals("titrePresentation")) {
                    FilmPanier filmPanier = (FilmPanier) itemId;
                    cell = new Label(filmPanier.getFilm().getTitre() + " à " + filmPanier.getPresentation());
                }
                return cell;
            }
        });
        tblFilmsPanier.setVisibleColumns(new Object[] { "titrePresentation" });
        tblFilmsPanier.setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
        tblFilmsPanier.setWidth("400px");
        tblFilmsPanier.setHeight("115px");
        tblFilmsPanier.setSelectable(true);
        pnlFilmsPanier.setContent(tblFilmsPanier);
        numberFormat = NumberFormat.getCurrencyInstance();
        lblTotal = new Label();
        afficherTotal();
        grlPrincipal.addComponent(lblTotal, 0, 11);
        btnSupprimer = new Button("Supprimer");
        grlPrincipal.addComponent(btnSupprimer, 1, 11);
        btnReinitialiser = new Button("Réinitialiser");
        grlPrincipal.addComponent(btnReinitialiser, 2, 11);

        itmFilmPanier = new BeanItem<FilmPanier>(new FilmPanier());
        pnlFilmDescription = new Panel("Description du film");
        pnlFilmDescription.setWidth("438px");
        pnlFilmDescription.setHeight("100%");
        grlPrincipal.addComponent(pnlFilmDescription, 3, 1, 3, 11);
        grlDescription = new GridLayout(3, 12);
        pnlFilmDescription.setContent(grlDescription);
        embFilmImage = new Embedded();
        embFilmImage.setWidth("130px");
        embFilmImage.setHeight("193px");
        grlDescription.addComponent(embFilmImage, 0, 0, 0, 4);
        Label lblTmp = new Label("Titre");
        grlDescription.addComponent(lblTmp, 1, 0);
        lblTmp.setWidth("100px");
        txtTitre = new TextField();
        txtTitre.setPropertyDataSource(itmFilmPanier.getItemProperty("titre"));
        grlDescription.addComponent(txtTitre, 2, 0);
        lblTmp = new Label("Date&nbsp;sortie", ContentMode.HTML);
        grlDescription.addComponent(lblTmp, 1, 1);
        txtDateSortie = new TextField();
        txtDateSortie.setPropertyDataSource(itmFilmPanier.getItemProperty("dateSortie"));
        grlDescription.addComponent(txtDateSortie, 2, 1);
        lblTmp = new Label("Classement");
        grlDescription.addComponent(lblTmp, 1, 2);
        embFilmClassement = new Embedded();
        embFilmClassement.setWidth("51px");
        embFilmClassement.setHeight("25px");
        grlDescription.addComponent(embFilmClassement, 2, 2);
        lblTmp = new Label("Genres");
        grlDescription.addComponent(lblTmp, 1, 3);
        txtGenres = new TextField();
        txtGenres.setPropertyDataSource(itmFilmPanier.getItemProperty("genres"));
        grlDescription.addComponent(txtGenres, 2, 3);
        lblTmp = new Label("Durée");
        grlDescription.addComponent(lblTmp, 1, 4);
        txtDuree = new TextField();
        txtDuree.setPropertyDataSource(itmFilmPanier.getItemProperty("duree"));
        grlDescription.addComponent(txtDuree, 2, 4);
        tabSynopsis = new TabSheet();
        lblTmp = new Label("&nbsp;", ContentMode.HTML);
        lblTmp.setHeight("15px");
        grlDescription.addComponent(lblTmp, 0, 5);
        grlDescription.addComponent(tabSynopsis, 0, 6, 2, 8);
        txtSynopsis = new TextArea();
        txtSynopsis.setWidth("427px");
        txtSynopsis.setPropertyDataSource(itmFilmPanier.getItemProperty("synopsis"));
        tabSynopsis.setWidth("430px");
        tabSynopsis.addTab(txtSynopsis, "Synopsis");
        lblTmp = new Label("&nbsp;", ContentMode.HTML);
        lblTmp.setHeight("15px");
        grlDescription.addComponent(lblTmp, 0, 9);
        tabPresentations = new TabSheet();
        grlDescription.addComponent(tabPresentations, 0, 10, 2, 11);
        cslPresentations = new CssLayout();
        cslPresentations.setWidth("427px");
        cslPresentations.setHeight("50px");
        tabPresentations.addTab(cslPresentations, "Présentations");
        dateFormat = DateFormat.getTimeInstance();

        tblFilms.addValueChangeListener(new Table.ValueChangeListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void valueChange(ValueChangeEvent event) {
                Film film = (Film) tblFilms.getValue();
                if (film != null) {
                    itmFilmPanier.getItemProperty("film").setValue(film);
                    // Bidon. Juste pour rafraîchir les contrôles...
                    itmFilmPanier.getItemProperty("titre").setValue("");
                    itmFilmPanier.getItemProperty("dateSortie").setValue("");
                    itmFilmPanier.getItemProperty("genres").setValue("");
                    itmFilmPanier.getItemProperty("duree").setValue("");
                    itmFilmPanier.getItemProperty("synopsis").setValue("");
                    resClassement = new ExternalResource(film.getClassement().getImage());
                    embFilmClassement.setSource(resClassement);
                    resImage = new ExternalResource(film.getImage());
                    embFilmImage.setSource(resImage);
                    cslPresentations.removeAllComponents();
                    for (Date presentation : film.getPresentations()) {
                        Button btnTmp = new Button(dateFormat.format(presentation));
                        btnTmp.setData(presentation);
                        btnTmp.setStyleName("link-margin");
                        cslPresentations.addComponent(btnTmp);
                        btnTmp.addClickListener(new Button.ClickListener() {

                            @Override
                            public void buttonClick(ClickEvent event) {
                                itmFilmPanier.getItemProperty("presentation").setValue(event.getButton().getData());
                                cntFilmsPanier.addBean(new FilmPanier(itmFilmPanier.getBean()));
                                afficherTotal();
                            }
                        });
                    }
                }
            }
        });

        btnSupprimer.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                if (tblFilmsPanier.getValue() != null) {
                    cntFilmsPanier.removeItem(tblFilmsPanier.getValue());
                    afficherTotal();
                }
            }
        });

        btnReinitialiser.addClickListener(new Button.ClickListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void buttonClick(ClickEvent event) {
                cntFilmsPanier.removeAllItems();
                afficherTotal();
                tblFilms.setValue(null);
                itmFilmPanier.getItemProperty("film").setValue(null);
                // Bidon. Juste pour rafraîchir les contrôles...
                itmFilmPanier.getItemProperty("titre").setValue("");
                itmFilmPanier.getItemProperty("dateSortie").setValue("");
                itmFilmPanier.getItemProperty("genres").setValue("");
                itmFilmPanier.getItemProperty("duree").setValue("");
                itmFilmPanier.getItemProperty("synopsis").setValue("");
                embFilmClassement.setSource(resClassementBlank);
                embFilmImage.setSource(resImageBlank);
                cslPresentations.removeAllComponents();
            }
        });
    }

    private void afficherTotal() {
        lblTotal.setValue("Total: " + numberFormat.format(cntFilmsPanier.size() * PRIX_BILLET));
    }
}
