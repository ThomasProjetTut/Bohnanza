package view;
import org.jsfml.graphics.*;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.Image;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Vue{

    private RenderWindow fenetre = new RenderWindow();
    private ArrayList<Sprite> spriteCliquable = new ArrayList<Sprite>();
    private Sprite[][] sprsChamps = new Sprite[4][3];
    private Sprite[] sprsMenuCartes = new Sprite[3];
    private Sprite[] sprsMenuCartesChoix = new Sprite[8];
    private Sprite[] sprsAutresJoueurs = new Sprite[4];
    private Sprite[] sprsBoutonsEtapes = new Sprite[4];
    private Sprite[] sprsMenuON = new Sprite[2];
    private Sprite[] sprsCartesPiochee = new Sprite[2];
    private Text[][] textChamps = new Text[4][3];
    private Font arial = new Font();
    private Image icone = new Image();

    //////////////////////////////////////////////////////////////////////////////////////
    //Declaration Textures
    // Textures generales
    private Texture txtDebut = new Texture();
    private Texture txtFond = new Texture();
    private Texture txtVictoire1 = new Texture();
    private Texture txtVictoire2 = new Texture();
    private Texture txtVictoire3 = new Texture();
    private Texture txtVictoire4 = new Texture();
    private Texture txtBouttonDebut = new Texture();
    private Texture txtBouttonRejouer = new Texture();
    private Texture txtBouttonQuitter = new Texture();

    //scores
    private Texture txtScore = new Texture();
    private Text scoreJ1 = new Text();
    private Text scoreJ2 = new Text();;
    private Text scoreJ3 = new Text();;
    private Text scoreJ4 = new Text();;


    //bouton
    private Texture txtBtEchange = new Texture();
    private Texture txtBtPlantage= new Texture();
    private Texture txtBtPioche = new Texture();
    private Texture txtFinTour = new Texture();

    //champ
    private Texture txtChampDispo = new Texture();
    private Texture txtChampIndispo = new Texture();

    //champs plantés

    private Texture txtChampTectonik = new Texture();
    private Texture txtChampTentacule = new Texture();
    private Texture txtChampTequila = new Texture();
    private Texture txtChampTerroriste = new Texture();
    private Texture txtChampTestosterone = new Texture();
    private Texture txtChampTetenucleaire = new Texture();
    private Texture txtChampTetraplegique = new Texture();
    private Texture txtChampTwerk = new Texture();

    //Textures menu
    //menu carte
    private Texture txtMCFond = new Texture();
    private Texture txtMCEchanger = new Texture();
    private Texture txtMCDonner = new Texture();
    private Texture txtMCGarder = new Texture();

    //menu oui non
    private Texture txtMenuOuiNonFond = new Texture();
    private Texture txtMenuOui = new Texture();
    private Texture txtMenuNon = new Texture();

    //menu choix carte
    private Texture txtMCCFond = new Texture();

    private Texture txtMCCTectonik = new Texture();
    private Texture txtMCCTequila = new Texture();
    private Texture txtMCCTentacule = new Texture();
    private Texture txtMCCTerroriste = new Texture();
    private Texture txtMCCTestosterone = new Texture();
    private Texture txtMCCTeteNucleaire = new Texture();
    private Texture txtMCCTetraplegique = new Texture();
    private Texture txtMCCTwerk = new Texture();

    //Textures joueurs attentes
    private Texture txtJoueur1AttenteActif = new Texture();
    private Texture txtJoueur2AttenteActif = new Texture();
    private Texture txtJoueur3AttenteActif = new Texture();
    private Texture txtJoueur4AttenteActif = new Texture();

    private Texture txtJoueur1AttenteInactif = new Texture();
    private Texture txtJoueur2AttenteInactif = new Texture();
    private Texture txtJoueur3AttenteInactif = new Texture();
    private Texture txtJoueur4AttenteInactif = new Texture();

    //Texture carte
    private Texture txtCarteVide = new Texture();
    private Texture txtCarteTequila = new Texture();
    private Texture txtCarteTentacule = new Texture();
    private Texture txtCarteTerroriste = new Texture();
    private Texture txtCarteTestosterone = new Texture();
    private Texture txtCarteTeteNucleaire = new Texture();
    private Texture txtCarteTetraplegique = new Texture();
    private Texture txtCarteTectonik = new Texture();
    private Texture txtCarteTwerk = new Texture();


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Declaration sprite
    // sprites generaux
    private Sprite sprFond = new Sprite();
    private Sprite etapeEnCours = new Sprite();
    private Sprite sprBouttonDepart = new Sprite();
    private Sprite sprBouttonRejouer = new Sprite();
    private Sprite sprBouttonQuitter = new Sprite();
    private Sprite sprScore = new Sprite();


    //sprites boutons
    private Sprite sprBtEchange = new Sprite();
    private Sprite sprBtPlantage = new Sprite();
    private Sprite sprBtPioche = new Sprite();
    private Sprite sprBtFinTour = new Sprite();

    //carte
    private Sprite sprCartePiochee1 = new Sprite();
    private Sprite sprCartePiochee2 = new Sprite();

    //sprites menu
    //menu carte
    private Sprite sprMCFond = new Sprite();
    private Sprite sprMCEchanger = new Sprite();
    private Sprite sprMCDonner = new Sprite();
    private Sprite sprMCGarder = new Sprite();

    //menu oui non
    private Sprite sprMenuOuiNonFond = new Sprite();
    private Sprite sprMenuOui = new Sprite();
    private Sprite sprMenuNon = new Sprite();

    //menu choix carte
    private Sprite sprMCCFond = new Sprite();

    private Sprite sprMCCTentacule = new Sprite();
    private Sprite sprMCCTequila = new Sprite();
    private Sprite sprMCCTestosterone = new Sprite();
    private Sprite sprMCCTerroriste = new Sprite();
    private Sprite sprMCCTetenucleaire = new Sprite();
    private Sprite sprMCCTetraplegique = new Sprite();
    private Sprite sprMCCTectonik = new Sprite();
    private Sprite sprMCCTwerk = new Sprite();

    //sprite champs
    private Sprite[] sprChampJ1 = new Sprite[3];
    private Sprite[] sprChampJ2 = new Sprite[3];
    private Sprite[] sprChampJ3 = new Sprite[3];
    private Sprite[] sprChampJ4 = new Sprite[3];

    private Sprite sprJoueurAttente1 = new Sprite();
    private Sprite sprJoueurAttente2 = new Sprite();
    private Sprite sprJoueurAttente3 = new Sprite();
    private Sprite sprJoueurAttente4 = new Sprite();

    //liste sprite
    //sprite main cartes
    private ArrayList<Sprite> mainJ1 = new ArrayList<Sprite>();
    private ArrayList<Sprite> mainJ2 = new ArrayList<Sprite>();
    private ArrayList<Sprite> mainJ3 = new ArrayList<Sprite>();
    private ArrayList<Sprite> mainJ4 = new ArrayList<Sprite>();


    //sprite carte à planter
    private ArrayList<Sprite> zoneEchangeJ1 = new ArrayList<Sprite>();
    private ArrayList<Sprite> zoneEchangeJ2 = new ArrayList<Sprite>();
    private ArrayList<Sprite> zoneEchangeJ3 = new ArrayList<Sprite>();
    private ArrayList<Sprite> zoneEchangeJ4 = new ArrayList<Sprite>();

    ///////////////////////////////////////////////////////////////////////////////

    private Vector2i positionFenetre = new Vector2i(0,0);

    public Vue(){
        initAttribut();
        creerFenetre();
    }

    private void initAttribut() {

        for(int i = 0; i < 3; i++){
            sprChampJ1[i] = new Sprite();
        }

        for(int i = 0; i < 3; i++){
            sprChampJ2[i] = new Sprite();
        }

        for(int i = 0; i < 3; i++) {
            sprChampJ3[i] = new Sprite();
        }

        for(int i = 0; i < 3; i++){
            sprChampJ4[i] = new Sprite();
        }

        try {
            icone.loadFromFile(Paths.get("Sprites/patate.png"));
            arial.loadFromFile(Paths.get("Sprites/arial.ttf"));

            txtFond.loadFromFile(Paths.get("Sprites/fond.png"));
            txtDebut.loadFromFile(Paths.get("Sprites/debut.png"));
            txtVictoire1.loadFromFile(Paths.get("Sprites/victoire_joueur_1.png"));
            txtVictoire2.loadFromFile(Paths.get("Sprites/victoire_joueur_2.png"));
            txtVictoire3.loadFromFile(Paths.get("Sprites/victoire_joueur_3.png"));
            txtVictoire4.loadFromFile(Paths.get("Sprites/victoire_joueur_4.png"));
            txtBouttonDebut.loadFromFile(Paths.get("Sprites/boutton_debut_tour.png"));
            txtBouttonQuitter.loadFromFile(Paths.get("Sprites/boutton_quitter.png"));
            txtBouttonRejouer.loadFromFile(Paths.get("Sprites/boutton_rejouer.png"));
            txtScore.loadFromFile(Paths.get("Sprites/Sprite_score.png"));

            txtMCFond.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/fondMCarte.png"));
            txtMCEchanger.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/echange.png"));
            txtMCDonner.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/don.png"));
            txtMCGarder.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/garder.png"));

            txtBtEchange.loadFromFile(Paths.get("Sprites/Sprite_bouton/phaseDechange.png"));
            txtBtPlantage.loadFromFile(Paths.get("Sprites/Sprite_bouton/phaseDePlantage.png"));
            txtBtPioche.loadFromFile(Paths.get("Sprites/Sprite_bouton/phaseDePioche.png"));
            txtFinTour.loadFromFile(Paths.get("Sprites/Sprite_bouton/finDeTour.png"));

            txtMenuOuiNonFond.loadFromFile(Paths.get("Sprites/Sprite_menu/oui_non/fond_oui_non.png"));
            txtMenuOui.loadFromFile(Paths.get("Sprites/Sprite_menu/oui_non/oui.png"));
            txtMenuNon.loadFromFile(Paths.get("Sprites/Sprite_menu/oui_non/non.png"));

            txtJoueur1AttenteActif.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_joueur/joueur1.png"));
            txtJoueur2AttenteActif.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_joueur/joueur2.png"));
            txtJoueur3AttenteActif.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_joueur/joueur3.png"));
            txtJoueur4AttenteActif.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_joueur/joueur4.png"));

            txtJoueur1AttenteInactif.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_joueur_desactive/joueur1.png"));
            txtJoueur2AttenteInactif.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_joueur_desactive/joueur2.png"));
            txtJoueur3AttenteInactif.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_joueur_desactive/joueur3.png"));
            txtJoueur4AttenteInactif.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_joueur_desactive/joueur4.png"));

            txtChampDispo.loadFromFile(Paths.get("Sprites/Sprite_champ/champactif.png"));
            txtChampIndispo.loadFromFile(Paths.get("Sprites/Sprite_champ/champinactif.png"));

            txtChampTectonik.loadFromFile(Paths.get("Sprites/Sprite_champ/champ_plante/champ_patatectonik_plante.png"));
            txtChampTentacule.loadFromFile(Paths.get("Sprites/Sprite_champ/champ_plante/champ_patatentacule_plante.png"));
            txtChampTequila.loadFromFile(Paths.get("Sprites/Sprite_champ/champ_plante/champ_patatequila_plante.png"));
            txtChampTerroriste.loadFromFile(Paths.get("Sprites/Sprite_champ/champ_plante/champ_pataterroriste_plante.png"));
            txtChampTestosterone.loadFromFile(Paths.get("Sprites/Sprite_champ/champ_plante/champ_patatestosterone_plante.png"));
            txtChampTetenucleaire.loadFromFile(Paths.get("Sprites/Sprite_champ/champ_plante/champ_patatetenucleaire_plante.png"));
            txtChampTetraplegique.loadFromFile(Paths.get("Sprites/Sprite_champ/champ_plante/champ_patatetraplegique_plante.png"));
            txtChampTwerk.loadFromFile(Paths.get("Sprites/Sprite_champ/champ_plante/champ_patatwerk_plante.png"));

            txtCarteVide.loadFromFile(Paths.get("Sprites/Sprite_carte/carte_vide.png"));
            txtCarteTectonik.loadFromFile(Paths.get("Sprites/Sprite_carte/patatectonik.png"));
            txtCarteTentacule.loadFromFile(Paths.get("Sprites/Sprite_carte/patatentacule.jpg"));
            txtCarteTequila.loadFromFile(Paths.get("Sprites/Sprite_carte/patatequila.jpg"));
            txtCarteTerroriste.loadFromFile(Paths.get("Sprites/Sprite_carte/pataterroriste.jpg"));
            txtCarteTestosterone.loadFromFile(Paths.get("Sprites/Sprite_carte/patatestosterone.jpg"));
            txtCarteTeteNucleaire.loadFromFile(Paths.get("Sprites/Sprite_carte/patatetenucleaire.jpg"));
            txtCarteTetraplegique.loadFromFile(Paths.get("Sprites/Sprite_carte/patatetraplegique.jpg"));
            txtCarteTwerk.loadFromFile(Paths.get("Sprites/Sprite_carte/patatwerk.png"));

            txtMCCFond.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/fondMCC.png"));
            txtMCCTectonik.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/MCCTectonik.png"));
            txtMCCTentacule.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/MCCTentacule.png"));
            txtMCCTequila.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/MCCTequila.png"));
            txtMCCTerroriste.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/MCCTerroriste.png"));
            txtMCCTestosterone.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/MCCTestosterone.png"));
            txtMCCTeteNucleaire.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/MCCTetenucleaire.png"));
            txtMCCTetraplegique.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/MCCTetraplegique.png"));
            txtMCCTwerk.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/menu_choix_carte/MCCTwerk.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //set Txt
        sprFond.setRotation(0);

        sprFond.setTexture(txtFond);
        sprBouttonRejouer.setTexture(txtBouttonRejouer);
        sprBouttonQuitter.setTexture(txtBouttonQuitter);
        sprScore.setTexture(txtScore);

        //menus
        sprMCFond.setTexture(txtMCFond);
        sprMCEchanger.setTexture(txtMCEchanger);
        sprMCDonner.setTexture(txtMCDonner);
        sprMCGarder.setTexture(txtMCGarder);


        //boutons
        sprBtEchange.setTexture(txtBtEchange);
        sprBtPlantage.setTexture(txtBtPlantage);
        sprBtPioche.setTexture(txtBtPioche);
        sprBtFinTour.setTexture(txtFinTour);

        //champs
        for(int i = 0; i < 2; i++){
            sprChampJ1[i].setTexture(txtChampDispo);
        }
        sprChampJ1[2].setTexture(txtChampIndispo);

        for(int i = 0; i < 2; i++){
            sprChampJ2[i].setTexture(txtChampDispo);
        }
        sprChampJ2[2].setTexture(txtChampIndispo);

        for(int i = 0; i < 2; i++){
            sprChampJ3[i].setTexture(txtChampDispo);
        }
        sprChampJ3[2].setTexture(txtChampIndispo);

        for(int i = 0; i < 2; i++){
            sprChampJ4[i].setTexture(txtChampDispo);
        }
        sprChampJ4[2].setTexture(txtChampIndispo);

        etapeEnCours.setTexture(txtBtPlantage);


        //menu carte choix
        sprMCCFond.setTexture(txtMCCFond);

        sprMCCTectonik.setTexture(txtMCCTectonik);
        sprMCCTentacule.setTexture(txtMCCTentacule);
        sprMCCTequila.setTexture(txtMCCTequila);
        sprMCCTerroriste.setTexture(txtMCCTerroriste);
        sprMCCTestosterone.setTexture(txtMCCTestosterone);
        sprMCCTetenucleaire.setTexture(txtMCCTeteNucleaire);
        sprMCCTetraplegique.setTexture(txtMCCTetraplegique);
        sprMCCTwerk.setTexture(txtMCCTwerk);

        sprMenuOuiNonFond.setTexture(txtMenuOuiNonFond);
        sprMenuOui.setTexture(txtMenuOui);
        sprMenuNon.setTexture(txtMenuNon);

        sprJoueurAttente1.setTexture(txtJoueur1AttenteInactif);
        sprJoueurAttente2.setTexture(txtJoueur2AttenteInactif);
        sprJoueurAttente3.setTexture(txtJoueur3AttenteInactif);
        sprJoueurAttente4.setTexture(txtJoueur4AttenteInactif);

        //creation tab sprites
        sprsBoutonsEtapes[0] = sprBtEchange;
        sprsBoutonsEtapes[1] = sprBtPlantage;
        sprsBoutonsEtapes[2] = sprBtPioche;
        sprsBoutonsEtapes[3] = sprBtFinTour;

        sprsChamps[0] = sprChampJ1;
        sprsChamps[1] = sprChampJ2;
        sprsChamps[2] = sprChampJ3;
        sprsChamps[3] = sprChampJ4;

        sprsCartesPiochee[0] = sprCartePiochee1;
        sprsCartesPiochee[1] = sprCartePiochee2;

        sprsMenuON[0] = sprMenuOui;
        sprsMenuON[1] = sprMenuNon;

        sprsMenuCartes[0] = sprMCEchanger;
        sprsMenuCartes[1] = sprMCDonner;
        sprsMenuCartes[2] = sprMCGarder;

        sprsMenuCartesChoix[0] = sprMCCTectonik;
        sprsMenuCartesChoix[1] = sprMCCTentacule;
        sprsMenuCartesChoix[2] = sprMCCTequila;
        sprsMenuCartesChoix[3] = sprMCCTerroriste;
        sprsMenuCartesChoix[4] = sprMCCTestosterone;
        sprsMenuCartesChoix[5] = sprMCCTetenucleaire;
        sprsMenuCartesChoix[6] = sprMCCTetraplegique;
        sprsMenuCartesChoix[7] = sprMCCTwerk;

        sprsAutresJoueurs[0] = sprJoueurAttente1;
        sprsAutresJoueurs[1] = sprJoueurAttente2;
        sprsAutresJoueurs[2] = sprJoueurAttente3;
        sprsAutresJoueurs[3] = sprJoueurAttente4;

        //set positions
        //generaux
        etapeEnCours.setPosition(55, 25);
        sprScore.setPosition(750, 0);

        //bouton
        sprBtEchange.setPosition(810, 775);
        sprBtPlantage.setPosition(810, 830);
        sprBtPioche.setPosition(810, 885);
        sprBtFinTour.setPosition(810, 940);

        //////////////////////

        sprJoueurAttente1.setPosition(35, 775);
        sprJoueurAttente2.setPosition(35, 825);
        sprJoueurAttente3.setPosition(35, 875);
        sprJoueurAttente4.setPosition(35, 925);

        scoreJ1.setString("0");
        scoreJ2.setString("0");
        scoreJ3.setString("0");
        scoreJ4.setString("0");

        scoreJ1.setPosition(870, 37);
        scoreJ2.setPosition(870, 87);
        scoreJ3.setPosition(870, 137);
        scoreJ4.setPosition(870, 187);

        scoreJ1.setFont(arial);
        scoreJ2.setFont(arial);
        scoreJ3.setFont(arial);
        scoreJ4.setFont(arial);

        scoreJ1.setCharacterSize(45);
        scoreJ2.setCharacterSize(45);
        scoreJ3.setCharacterSize(45);
        scoreJ4.setCharacterSize(45);

        scoreJ1.setColor(Color.BLACK);
        scoreJ2.setColor(Color.BLACK);
        scoreJ3.setColor(Color.BLACK);
        scoreJ4.setColor(Color.BLACK);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                textChamps[i][j] = new Text();
                textChamps[i][j].setString("0");
                textChamps[i][j].setFont(arial);
                textChamps[i][j].setCharacterSize(35);
                textChamps[i][j].setColor(Color.BLACK);
            }
        }

        //position champ d?part
        //J1

        sprChampJ1[0].setRotation(0);
        sprChampJ1[1].setRotation(0);
        sprChampJ1[2].setRotation(0);

        sprChampJ1[0].setPosition(263, 767);
        sprChampJ1[1].setPosition(425, 767);
        sprChampJ1[2].setPosition(587, 767);

        textChamps[0][0].setString("0");
        textChamps[0][1].setString("0");
        textChamps[0][2].setString("0");

        textChamps[0][0].setPosition(268, 828);
        textChamps[0][1].setPosition(431,828);
        textChamps[0][2].setPosition(592,828);

        // J2

        sprChampJ2[0].setRotation(-270);
        sprChampJ2[1].setRotation(-270);
        sprChampJ2[2].setRotation(-270);

        sprChampJ2[0].setPosition(235, 262);
        sprChampJ2[1].setPosition(235, 425);
        sprChampJ2[2].setPosition(235, 587);

        textChamps[1][0].setString("0");
        textChamps[1][1].setString("0");
        textChamps[1][2].setString("0");

        textChamps[1][2].setPosition(140, 583);
        textChamps[1][1].setPosition(140, 423);
        textChamps[1][0].setPosition(140, 258);

        //J3

        sprChampJ3[0].setRotation(-180);
        sprChampJ3[1].setRotation(-180);
        sprChampJ3[2].setRotation(-180);

        sprChampJ3[2].setPosition(413, 235);
        sprChampJ3[1].setPosition(575, 235);
        sprChampJ3[0].setPosition(737, 235);

        textChamps[2][0].setString("0");
        textChamps[2][1].setString("0");
        textChamps[2][2].setString("0");

        textChamps[2][2].setPosition(388, 130);
        textChamps[2][1].setPosition(550, 130);
        textChamps[2][0].setPosition(716, 130);


        //J4

        sprChampJ4[0].setRotation(-90);
        sprChampJ4[1].setRotation(-90);
        sprChampJ4[2].setRotation(-90);

        sprChampJ4[0].setPosition(765, 737);
        sprChampJ4[1].setPosition(765, 575);
        sprChampJ4[2].setPosition(765, 413);

        textChamps[3][0].setString("0");
        textChamps[3][1].setString("0");
        textChamps[3][2].setString("0");

        textChamps[3][0].setPosition(842, 697);
        textChamps[3][1].setPosition(842, 535);
        textChamps[3][2].setPosition(842, 373);

    }

    private void creerFenetre() {
        fenetre.create(new VideoMode(1000, 1000), "Bohnanza", WindowStyle.CLOSE);

        fenetre.setIcon(icone);

        fenetre.setPosition(positionFenetre);

        fenetre.clear();
    }

    public void addCarteMain(int idJoueur,Texture txt){
        switch (idJoueur){
            case 1:
                mainJ1.add(mainJ1.size(), new Sprite());
                mainJ1.get(mainJ1.size()-1).setTexture(txt);
                break;
            case 2:
                mainJ2.add(mainJ2.size(), new Sprite());
                mainJ2.get(mainJ2.size()-1).setTexture(txt);
                break;
            case 3:
                mainJ3.add(mainJ3.size(), new Sprite());
                mainJ3.get(mainJ3.size()-1).setTexture(txt);
                break;
            case 4:
                mainJ4.add(mainJ4.size(), new Sprite());
                mainJ4.get(mainJ4.size()-1).setTexture(txt);
                break;
        }

    }

    public void clearMain(int idJoueur){
        switch (idJoueur){
            case 1:
                mainJ1.clear();
                break;
            case 2:
                mainJ2.clear();
                break;
            case 3:
                mainJ3.clear();
                break;
            case 4:
                mainJ4.clear();
                break;
        }
    }

    public void rotationJ1(){

        //rotation fond
        sprFond.setRotation(0);
        sprFond.setPosition(0, 0);

        /////////////////////////////////////////////////////////////////////////////
        //rotation champ

        for(int i = 0; i < 3; i++){
            sprChampJ1[i].setRotation(0);
        }

        sprChampJ1[0].setPosition(263, 767);
        sprChampJ1[1].setPosition(425, 767);
        sprChampJ1[2].setPosition(587, 767);

        for(int i = 0; i < 3; i++){
            sprChampJ2[i].setRotation(-270);
        }

        sprChampJ2[0].setPosition(235, 262);
        sprChampJ2[1].setPosition(235, 425);
        sprChampJ2[2].setPosition(235, 587);


        for(int i = 0; i < 3; i++){
            sprChampJ3[i].setRotation(-180);
        }

        sprChampJ3[2].setPosition(413, 235);
        sprChampJ3[1].setPosition(575, 235);
        sprChampJ3[0].setPosition(737, 235);

        for(int i = 0; i < 3; i++){
            sprChampJ4[i].setRotation(-90);
        }

        sprChampJ4[0].setPosition(765, 413);
        sprChampJ4[1].setPosition(765, 575);
        sprChampJ4[2].setPosition(765, 737);

        textChamps[0][0].setPosition(268, 828);
        textChamps[0][1].setPosition(431, 828);
        textChamps[0][2].setPosition(592, 828);

        textChamps[1][2].setPosition(140, 583);
        textChamps[1][1].setPosition(140, 423);
        textChamps[1][0].setPosition(140, 258);

        textChamps[2][2].setPosition(388, 130);
        textChamps[2][1].setPosition(550, 130);
        textChamps[2][0].setPosition(716, 130);

        textChamps[3][2].setPosition(842, 697);
        textChamps[3][1].setPosition(842, 535);
        textChamps[3][0].setPosition(842, 373);

    }
    public void rotationJ2(){

        //rotation fond
        sprFond.setRotation(-90);
        sprFond.setPosition(0, 1000);

        /////////////////////////////////////////////////////////////////////////////
        //rotation champ

        for(int i = 0; i < 3; i++){
            sprChampJ1[i].setRotation(-90);
        }

        sprChampJ1[0].setPosition(767, 737);
        sprChampJ1[1].setPosition(767, 575);
        sprChampJ1[2].setPosition(767, 413);

        for(int i = 0; i < 3; i++){
            sprChampJ2[i].setRotation(0);
        }

        sprChampJ2[0].setPosition(263, 767);
        sprChampJ2[1].setPosition(425, 767);
        sprChampJ2[2].setPosition(587, 767);


        for(int i = 0; i < 3; i++){
            sprChampJ3[i].setRotation(-270);
        }

        sprChampJ3[0].setPosition(235, 263);
        sprChampJ3[1].setPosition(235, 425);
        sprChampJ3[2].setPosition(235, 587);

        for(int i = 0; i < 3; i++){
            sprChampJ4[i].setRotation(-180);
        }

        sprChampJ4[2].setPosition(413, 235);
        sprChampJ4[1].setPosition(575, 235);
        sprChampJ4[0].setPosition(737, 235);

        textChamps[1][0].setPosition(268, 828);
        textChamps[1][1].setPosition(431, 828);
        textChamps[1][2].setPosition(592, 828);

        textChamps[2][0].setPosition(140, 583);
        textChamps[2][1].setPosition(140, 423);
        textChamps[2][2].setPosition(140, 258);

        textChamps[3][2].setPosition(388, 130);
        textChamps[3][1].setPosition(550, 130);
        textChamps[3][0].setPosition(716, 130);

        textChamps[0][2].setPosition(842, 697);
        textChamps[0][1].setPosition(842, 535);
        textChamps[0][0].setPosition(842, 373);
    }
    public void rotationJ3(){

        //rotation fond
        sprFond.setRotation(-180);
        sprFond.setPosition(1000, 1000);

        /////////////////////////////////////////////////////////////////////////////
        //rotation champ

        for(int i = 0; i < 3; i++){
            sprChampJ1[i].setRotation(-180);
        }

        sprChampJ1[2].setPosition(418, 238);
        sprChampJ1[1].setPosition(575, 238);
        sprChampJ1[0].setPosition(737, 238);

        for(int i = 0; i < 3; i++){
            sprChampJ2[i].setRotation(-90);
        }

        sprChampJ2[0].setPosition(767, 737);
        sprChampJ2[1].setPosition(767, 575);
        sprChampJ2[2].setPosition(767, 413);


        for(int i = 0; i < 3; i++){
            sprChampJ3[i].setRotation(0);
        }

        sprChampJ3[0].setPosition(263, 767);
        sprChampJ3[1].setPosition(425, 767);
        sprChampJ3[2].setPosition(587, 767);

        for(int i = 0; i < 3; i++) {
            sprChampJ4[i].setRotation(-270);
        }

        sprChampJ4[0].setPosition(235, 263);
        sprChampJ4[1].setPosition(235, 425);
        sprChampJ4[2].setPosition(235, 587);

        textChamps[2][0].setPosition(268, 828);
        textChamps[2][1].setPosition(431, 828);
        textChamps[2][2].setPosition(592, 828);

        textChamps[3][0].setPosition(140, 583);
        textChamps[3][1].setPosition(140, 423);
        textChamps[3][2].setPosition(140, 258);

        textChamps[0][2].setPosition(388, 130);
        textChamps[0][1].setPosition(550, 130);
        textChamps[0][0].setPosition(716, 130);

        textChamps[1][2].setPosition(842, 697);
        textChamps[1][1].setPosition(842, 535);
        textChamps[1][0].setPosition(842, 373);



    }
    public void rotationJ4(){

        //rotation fond
        sprFond.setRotation(-270);
        sprFond.setPosition(1000, 0);

        /////////////////////////////////////////////////////////////////////////////
        //rotation champ

        for(int i = 0; i < 3; i++){
            sprChampJ1[i].setRotation(-270);
        }

        sprChampJ1[0].setPosition(235, 263);
        sprChampJ1[1].setPosition(235, 425);
        sprChampJ1[2].setPosition(235, 587);

        for(int i = 0; i < 3; i++){
            sprChampJ2[i].setRotation(-180);
        }

        sprChampJ2[0].setPosition(418, 238);
        sprChampJ2[1].setPosition(575, 238);
        sprChampJ2[2].setPosition(737, 238);


        for(int i = 0; i < 3; i++){
            sprChampJ3[i].setRotation(-90);
        }

        sprChampJ3[2].setPosition(765, 737);
        sprChampJ3[1].setPosition(765, 575);
        sprChampJ3[0].setPosition(765, 413);

        for(int i = 0; i < 3; i++){
            sprChampJ4[i].setRotation(0);
        }

        sprChampJ4[0].setPosition(263, 765);
        sprChampJ4[1].setPosition(425, 765);
        sprChampJ4[2].setPosition(587, 765);

        textChamps[3][0].setPosition(268,828);
        textChamps[3][1].setPosition(431,828);
        textChamps[3][2].setPosition(592,828);

        textChamps[0][2].setPosition(140, 583);
        textChamps[0][1].setPosition(140, 423);
        textChamps[0][0].setPosition(140, 258);

        textChamps[1][2].setPosition(388, 130);
        textChamps[1][1].setPosition(550, 130);
        textChamps[1][0].setPosition(716, 130);

        textChamps[2][2].setPosition(842, 697);
        textChamps[2][1].setPosition(842, 535);
        textChamps[2][0].setPosition(842, 373);
    }

    public Sprite[] getSprsBoutonsEtapes(){
        return sprsBoutonsEtapes;
    }
    public Sprite[][] getSprsChamps(){
        return sprsChamps;
    }
    public Sprite[] getSprsMenuCartes(){
        return sprsMenuCartes;
    }
    public Sprite[] getSprsMenuCartesChoix(){
        return sprsMenuCartesChoix;
    }
    public Sprite[] getSprsJoueurs(){
        return sprsAutresJoueurs;
    }
    public Sprite[] getSprsCartesPiochee(){
        return sprsCartesPiochee;
    }
    public Sprite[] getSprsAutresJoueurs(int joueur){
        Sprite[] retour = new Sprite[3];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            if(i + 1 == joueur){
                index++;
            }

            retour[i] = sprsAutresJoueurs[index];
            index++;

        }

        System.out.println("Fonction getSprsAutresJoueurs :");

        for (int i = 0; i < 3; i++) {
            System.out.println(i + " = " + retour[i].getPosition().x + ", " + retour[i].getPosition().y);

        }


        return retour;
    }
    public Sprite[] getSprsMenuON(){
        return sprsMenuON;
    }
    public Sprite getSprCartePiochee1(){
        return sprCartePiochee1;
    }
    public Sprite getSprCartePiochee2(){
        return sprCartePiochee2;
    }
    public Sprite getFond() {
        return sprFond;
    }
    public Sprite getSprBouttonRejouer(){
        return sprBouttonRejouer;
    }
    public Sprite getSprBouttonQuitter(){
        return sprBouttonQuitter;
    }

    public ArrayList<Sprite> getMainJ1(){
        return mainJ1;
    }
    public ArrayList<Sprite> getMainJ2(){
        return mainJ2;
    }
    public ArrayList<Sprite> getMainJ3(){
        return mainJ3;
    }
    public ArrayList<Sprite> getMainJ4(){
        return mainJ4;
    }

    public ArrayList<Sprite> getZoneEchangeJ1(){
        return zoneEchangeJ1;
    }
    public ArrayList<Sprite> getZoneEchangeJ2(){
        return zoneEchangeJ2;
    }
    public ArrayList<Sprite> getZoneEchangeJ3(){
        return zoneEchangeJ3;
    }
    public ArrayList<Sprite> getZoneEchangeJ4(){
        return zoneEchangeJ4;
    }
    public ArrayList<Sprite> getZoneEchangeJoueurCourant(int joueurCourant){
        if(joueurCourant == 0){
            return getZoneEchangeJ1();
        }else if (joueurCourant == 1){
            return getZoneEchangeJ2();
        }else if (joueurCourant == 2){
            return getZoneEchangeJ3();
        }else{
            return getZoneEchangeJ4();
        }
    }

    private void afficherCarteTentacule(int posX, int posY, float rotate){
        mainJ1.add(new Sprite());
        mainJ1.get(mainJ1.size() - 1).setTexture(txtCarteTentacule);
        mainJ1.get(mainJ1.size() - 1).setPosition(posX, posY);
        mainJ1.get(mainJ1.size() - 1).rotate(rotate);
        fenetre.draw(mainJ1.get(mainJ1.size() - 1));
    }
    private void afficherCarteTequila(int posX, int posY, float rotate){
        mainJ1.add(new Sprite());
        mainJ1.get(mainJ1.size() - 1).setTexture(txtCarteTequila);
        mainJ1.get(mainJ1.size() - 1).setPosition(posX, posY);
        mainJ1.get(mainJ1.size() - 1).rotate(rotate);
        fenetre.draw(mainJ1.get(mainJ1.size() - 1));
    }
    private void afficherCarteTerroriste(int posX, int posY, float rotate){
        mainJ1.add(new Sprite());
        mainJ1.get(mainJ1.size() - 1).setTexture(txtCarteTerroriste);
        mainJ1.get(mainJ1.size() - 1).setPosition(posX, posY);
        mainJ1.get(mainJ1.size() - 1).rotate(rotate);
        fenetre.draw(mainJ1.get(mainJ1.size() - 1));
    }
    private void afficherCarteTestosteorne(int posX, int posY, float rotate){
        mainJ1.add(new Sprite());
        mainJ1.get(mainJ1.size() - 1).setTexture(txtCarteTestosterone);
        mainJ1.get(mainJ1.size() - 1).setPosition(posX, posY);
        mainJ1.get(mainJ1.size() - 1).rotate(rotate);
        fenetre.draw(mainJ1.get(mainJ1.size() - 1));
    }
    private void afficherCarteTetenucleaire(int posX, int posY, float rotate){
        mainJ1.add(new Sprite());
        mainJ1.get(mainJ1.size() - 1).setTexture(txtCarteTeteNucleaire);
        mainJ1.get(mainJ1.size() - 1).setPosition(posX, posY);
        mainJ1.get(mainJ1.size() - 1).rotate(rotate);
        fenetre.draw(mainJ1.get(mainJ1.size() - 1));
    }
    private void afficherCarteTetraplegique(int posX, int posY, float rotate){
        mainJ1.add(new Sprite());
        mainJ1.get(mainJ1.size() - 1).setTexture(txtCarteTetraplegique);
        mainJ1.get(mainJ1.size() - 1).setPosition(posX, posY);
        mainJ1.get(mainJ1.size() - 1).rotate(rotate);
        fenetre.draw(mainJ1.get(mainJ1.size() - 1));
    }

    public void afficherEtape(int etape){
        switch (etape){
            case 1 :
                etapeEnCours.setTexture(txtBtPlantage);
                break;
            case 2 :
                etapeEnCours.setTexture(txtBtEchange);
                afficherCartePiochee();
                break;
            case 3 :
                etapeEnCours.setTexture(txtBtPlantage);
                break;
            case 4 :
                etapeEnCours.setTexture(txtBtPioche);
                break;
        }

    }

    public void afficherMain(int idJoueurActif){
        switch (idJoueurActif){
            case 1:
                afficherMainJ1();
                break;
            case 2:
                afficherMainJ2();
                break;
            case 3:
                afficherMainJ3();
                break;
            case 4:
                afficherMainJ4();
                break;
        }
    }

    public void actualiserFenetre(int idJoueurActif){
        System.out.println("act");

        sprFond.setTexture(txtFond);

        fenetre.draw(sprFond);
        for (Sprite sprite : sprChampJ1){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ2){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ3){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ4){
            fenetre.draw(sprite);
        }

        for (Sprite sprite : sprsBoutonsEtapes){
            fenetre.draw(sprite);
        }

        if(spriteCliquable.contains(sprJoueurAttente1)){
            sprJoueurAttente1.setTexture(txtJoueur1AttenteActif);
        }else{
            sprJoueurAttente1.setTexture(txtJoueur1AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente2)){
            sprJoueurAttente2.setTexture(txtJoueur2AttenteActif);
        }else{
            sprJoueurAttente2.setTexture(txtJoueur2AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente3)){
            sprJoueurAttente3.setTexture(txtJoueur3AttenteActif);
        }else{
            sprJoueurAttente3.setTexture(txtJoueur3AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente4)){
            sprJoueurAttente4.setTexture(txtJoueur4AttenteActif);
        }else{
            sprJoueurAttente4.setTexture(txtJoueur4AttenteInactif);
        }

        for(Sprite sprite : sprsAutresJoueurs){
            fenetre.draw(sprite);
        }

        afficherScore();

        afficherZonesEchanges();

        afficherMain(idJoueurActif);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(!textChamps[i][j].getString().equals("0")){
                    fenetre.draw(textChamps[i][j]);
                }
            }
        }

        fenetre.draw(etapeEnCours);

        fenetre.display();

    }
    public void actualiserFenetreEchange(int idJoueurActif){
        System.out.println("actu echange");
        fenetre.draw(sprFond);
        for (Sprite sprite : sprChampJ1){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ2){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ3){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ4){
            fenetre.draw(sprite);
        }

        for (Sprite sprite : sprsBoutonsEtapes){
            fenetre.draw(sprite);
        }

        if(spriteCliquable.contains(sprJoueurAttente1)){
            sprJoueurAttente1.setTexture(txtJoueur1AttenteActif);
        }else{
            sprJoueurAttente1.setTexture(txtJoueur1AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente2)){
            sprJoueurAttente2.setTexture(txtJoueur2AttenteActif);
        }else{
            sprJoueurAttente2.setTexture(txtJoueur2AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente3)){
            sprJoueurAttente3.setTexture(txtJoueur3AttenteActif);
        }else{
            sprJoueurAttente3.setTexture(txtJoueur3AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente4)){
            sprJoueurAttente4.setTexture(txtJoueur4AttenteActif);
        }else{
            sprJoueurAttente4.setTexture(txtJoueur4AttenteInactif);
        }


        for(Sprite sprite : sprsAutresJoueurs){
            fenetre.draw(sprite);
        }

        afficherZonesEchanges();

        afficherScore();

        afficherMain(idJoueurActif);

        if(sprCartePiochee1.getTexture() != txtCarteVide){
            fenetre.draw(sprCartePiochee1);
        }

        if(sprCartePiochee2.getTexture() != txtCarteVide){
            fenetre.draw(sprCartePiochee2);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(!textChamps[i][j].getString().equals("0")){
                    fenetre.draw(textChamps[i][j]);
                }
            }
        }

        fenetre.draw(etapeEnCours);

        fenetre.display();

    }
    public void actualiserFenetreEchangeMenu(int idJoueurActif) {
        System.out.println("actu menu");
        fenetre.draw(sprFond);
        for (Sprite sprite : sprChampJ1){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ2){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ3){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ4){
            fenetre.draw(sprite);
        }

        for (Sprite sprite : sprsBoutonsEtapes){
            fenetre.draw(sprite);
        }

        if(spriteCliquable.contains(sprJoueurAttente1)){
            sprJoueurAttente1.setTexture(txtJoueur1AttenteActif);
        }else{
            sprJoueurAttente1.setTexture(txtJoueur1AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente2)){
            sprJoueurAttente2.setTexture(txtJoueur2AttenteActif);
        }else{
            sprJoueurAttente2.setTexture(txtJoueur2AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente3)){
            sprJoueurAttente3.setTexture(txtJoueur3AttenteActif);
        }else{
            sprJoueurAttente3.setTexture(txtJoueur3AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente4)){
            sprJoueurAttente4.setTexture(txtJoueur4AttenteActif);
        }else{
            sprJoueurAttente4.setTexture(txtJoueur4AttenteInactif);
        }

        for(Sprite sprite : sprsAutresJoueurs){
            fenetre.draw(sprite);
        }

        afficherZonesEchanges();

        afficherScore();

        if(sprCartePiochee1.getTexture() != txtCarteVide){
            fenetre.draw(sprCartePiochee1);
        }

        if(sprCartePiochee2.getTexture() != txtCarteVide){
            fenetre.draw(sprCartePiochee2);
        }

        fenetre.draw(sprMCFond);
        fenetre.draw(sprMCEchanger);
        fenetre.draw(sprMCDonner);
        fenetre.draw(sprMCGarder);

        afficherMain(idJoueurActif);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(!textChamps[i][j].getString().equals("0")){
                    fenetre.draw(textChamps[i][j]);
                }
            }
        }

        fenetre.draw(etapeEnCours);

        fenetre.display();
    }
    public void actualisationFenetreMenuOuiNon(int idJoueurActif){
        System.out.println("actu menu oui non");
        fenetre.draw(sprFond);
        for (Sprite sprite : sprChampJ1){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ2){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ3){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ4){
            fenetre.draw(sprite);
        }

        for (Sprite sprite : sprsBoutonsEtapes){
            fenetre.draw(sprite);
        }

        if(spriteCliquable.contains(sprJoueurAttente1)){
            sprJoueurAttente1.setTexture(txtJoueur1AttenteActif);
        }else{
            sprJoueurAttente1.setTexture(txtJoueur1AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente2)){
            sprJoueurAttente2.setTexture(txtJoueur2AttenteActif);
        }else{
            sprJoueurAttente2.setTexture(txtJoueur2AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente3)){
            sprJoueurAttente3.setTexture(txtJoueur3AttenteActif);
        }else{
            sprJoueurAttente3.setTexture(txtJoueur3AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente4)){
            System.out.println("oui !");
            sprJoueurAttente4.setTexture(txtJoueur4AttenteActif);
        }else{

            System.out.println("non !");
            sprJoueurAttente4.setTexture(txtJoueur4AttenteInactif);
        }

        for(Sprite sprite : getSprsJoueurs()){
            fenetre.draw(sprite);
        }

        afficherZonesEchanges();

        afficherScore();

        if(sprCartePiochee1.getTexture() != txtCarteVide){
            fenetre.draw(sprCartePiochee1);
        }

        if(sprCartePiochee2.getTexture() != txtCarteVide){
            fenetre.draw(sprCartePiochee2);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(!textChamps[i][j].getString().equals("0")){
                    fenetre.draw(textChamps[i][j]);
                }
            }
        }


        afficherMain(idJoueurActif);

        fenetre.draw(sprMenuOuiNonFond);
        fenetre.draw(sprMenuOui);
        fenetre.draw(sprMenuNon);

        fenetre.draw(etapeEnCours);

        fenetre.display();
    }
    public void actualiserFenetreEchangeMenuChoix(int idJoueurActif) {
        System.out.println("actu menu choix");
        fenetre.draw(sprFond);
        for (Sprite sprite : sprChampJ1){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ2){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ3){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ4){
            fenetre.draw(sprite);
        }

        for (Sprite sprite : sprsBoutonsEtapes){
            fenetre.draw(sprite);
        }

        if(spriteCliquable.contains(sprJoueurAttente1)){
            sprJoueurAttente1.setTexture(txtJoueur1AttenteActif);
        }else{
            sprJoueurAttente1.setTexture(txtJoueur1AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente2)){
            sprJoueurAttente2.setTexture(txtJoueur2AttenteActif);
        }else{
            sprJoueurAttente2.setTexture(txtJoueur2AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente3)){
            sprJoueurAttente3.setTexture(txtJoueur3AttenteActif);
        }else{
            sprJoueurAttente3.setTexture(txtJoueur3AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente4)){
            sprJoueurAttente4.setTexture(txtJoueur4AttenteActif);
        }else{
            sprJoueurAttente4.setTexture(txtJoueur4AttenteInactif);
        }


        for(Sprite sprite : sprsAutresJoueurs){
            fenetre.draw(sprite);
        }

        afficherZonesEchanges();

        afficherScore();

        if(sprCartePiochee1.getTexture() != txtCarteVide){
            fenetre.draw(sprCartePiochee1);
        }

        if(sprCartePiochee2.getTexture() != txtCarteVide){
            fenetre.draw(sprCartePiochee2);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(!textChamps[i][j].getString().equals("0")){
                    fenetre.draw(textChamps[i][j]);
                }
            }
        }


        fenetre.draw(sprMCFond);
        fenetre.draw(sprMCEchanger);
        fenetre.draw(sprMCDonner);
        fenetre.draw(sprMCGarder);


        fenetre.draw(sprMCCFond);

        fenetre.draw(sprMCCTectonik);
        fenetre.draw(sprMCCTentacule);
        fenetre.draw(sprMCCTequila);
        fenetre.draw(sprMCCTerroriste);
        fenetre.draw(sprMCCTestosterone);
        fenetre.draw(sprMCCTetenucleaire);
        fenetre.draw(sprMCCTetraplegique);
        fenetre.draw(sprMCCTwerk);

        afficherMain(idJoueurActif);

        fenetre.draw(etapeEnCours);

        fenetre.display();

    }
    public void actualiserFenetrePlantagePostEchange(int idJoueurActif){
        System.out.println("actu plantage post échange j"+idJoueurActif);

        fenetre.draw(sprFond);
        for (Sprite sprite : sprChampJ1){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ2){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ3){
            fenetre.draw(sprite);
        }
        for (Sprite sprite : sprChampJ4){
            fenetre.draw(sprite);
        }

        for (Sprite sprite : sprsBoutonsEtapes){
            fenetre.draw(sprite);
        }

        if(spriteCliquable.contains(sprJoueurAttente1)){
            sprJoueurAttente1.setTexture(txtJoueur1AttenteActif);
        }else{
            sprJoueurAttente1.setTexture(txtJoueur1AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente2)){
            sprJoueurAttente2.setTexture(txtJoueur2AttenteActif);
        }else{
            sprJoueurAttente2.setTexture(txtJoueur2AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente3)){
            sprJoueurAttente3.setTexture(txtJoueur3AttenteActif);
        }else{
            sprJoueurAttente3.setTexture(txtJoueur3AttenteInactif);
        }

        if(spriteCliquable.contains(sprJoueurAttente4)){
            sprJoueurAttente4.setTexture(txtJoueur4AttenteActif);
        }else{
            sprJoueurAttente4.setTexture(txtJoueur4AttenteInactif);
        }


        for(Sprite sprite : sprsAutresJoueurs){
            fenetre.draw(sprite);
        }

        afficherZonesEchanges();

        afficherScore();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(!textChamps[i][j].getString().equals("0")){
                    fenetre.draw(textChamps[i][j]);
                }
            }
        }


        afficherMain(idJoueurActif);

        fenetre.draw(etapeEnCours);

        fenetre.display();
    }
    public void actualisationDepart(){
        sprBouttonDepart.setPosition(231, 798);
        sprFond.setTexture(txtDebut);

        fenetre.draw(sprFond);

        sprBouttonDepart.setTexture(txtBouttonDebut);

        fenetre.draw(sprBouttonDepart);

        fenetre.display();
    }
    public void actualiserFenetreFinDePartie(int vainqueur) {
        sprFond.setRotation(0);

        switch (vainqueur){
            case 1 :
                sprFond.setTexture(txtVictoire1);
                break;
            case 2 :
                sprFond.setTexture(txtVictoire2);
                break;
            case 3 :
                sprFond.setTexture(txtVictoire3);
                break;
            case 4 :
                sprFond.setTexture(txtVictoire4);
                break;
        }

        fenetre.draw(sprFond);

        sprBouttonQuitter.setPosition(753, 74);

        fenetre.draw(sprBouttonQuitter);

        sprBouttonRejouer.setPosition(363, 777);

        fenetre.draw(sprBouttonRejouer);

        fenetre.display();

    }

    private void afficherScore() {
        fenetre.draw(sprScore);

        fenetre.draw(scoreJ1);
        fenetre.draw(scoreJ2);
        fenetre.draw(scoreJ3);
        fenetre.draw(scoreJ4);
    }

    public void actualiserScores(int score1, int score2, int score3, int score4){
        scoreJ1.setString(String.valueOf(score1));
        scoreJ2.setString(String.valueOf(score2));
        scoreJ3.setString(String.valueOf(score3));
        scoreJ4.setString(String.valueOf(score4));
    }

    public void actualiserNbPatateChamp(int[][] nbPatates){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                textChamps[i][j].setString(String.valueOf(nbPatates[i][j]));
            }
        }

    }


    public boolean cliqueSprite(Event event, Sprite sprite, RenderWindow fenetre){
        if(sprite.getRotation() == -180){
            if(isCliquable(sprite)) {
                event.asMouseEvent();
                Vector2i posMouse = Mouse.getPosition(fenetre);
                Vector2f positionSprite = sprite.getPosition();
                FloatRect tailleSprite = sprite.getGlobalBounds();

                if (posMouse.x < positionSprite.x && posMouse.x > positionSprite.x - tailleSprite.width && posMouse.y < positionSprite.y && posMouse.y > positionSprite.y - tailleSprite.height) {
                    System.out.println("clique sprite oui");
                    return true;
                } else {
                    System.out.println("clique sprite non position");
                    return false;
                }
            }else{
                System.out.println("clique sprite non cliquable");
                return false;
            }
        }else if (sprite.getRotation() == -270){
            if(isCliquable(sprite)) {
                event.asMouseEvent();
                Vector2i posMouse = Mouse.getPosition(fenetre);
                Vector2f positionSprite = sprite.getPosition();
                FloatRect tailleSprite = sprite.getGlobalBounds();

                if (posMouse.x < positionSprite.x && posMouse.x > positionSprite.x - tailleSprite.width && posMouse.y > positionSprite.y && posMouse.y < positionSprite.y + tailleSprite.height) {
                    System.out.println("clique sprite oui");
                    return true;
                } else {
                    System.out.println("clique sprite non position");
                    return false;
                }
            }else{
                System.out.println("clique sprite non cliquable");
                return false;
            }
        }else{
            if(isCliquable(sprite)) {
                event.asMouseEvent();
                Vector2i posMouse = Mouse.getPosition(fenetre);
                Vector2f positionSprite = sprite.getPosition();
                FloatRect tailleSprite = sprite.getGlobalBounds();

                if (posMouse.x > positionSprite.x && posMouse.x < positionSprite.x + tailleSprite.width && posMouse.y > positionSprite.y && posMouse.y < positionSprite.y + tailleSprite.height) {
                    System.out.println("clique sprite oui");
                    return true;
                } else {
                    System.out.println("clique sprite non position");
                    return false;
                }
            }else{
                System.out.println("clique sprite non cliquable");
                return false;
            }
        }



    }
    public boolean isCliquable(Sprite sprite){
        if(spriteCliquable.contains(sprite)){
            return true;
        }else{
            return false;
        }

    }
    public void setSpriteCliquable(Sprite sprite){
        if(!spriteCliquable.contains(sprite)){
            spriteCliquable.add(sprite);
        }

    }
    public void delSpriteCliquable(Sprite sprite){
        if(spriteCliquable.contains(sprite)){
            spriteCliquable.remove(sprite);
        }

    }
    public void creationSpriteCliquableDon(int joueur) {
        System.out.println("creation sprite don");
        spriteCliquable.clear();
        spriteCliquable.add(getFond());

        for(Sprite sprite : getSprsAutresJoueurs(joueur)){
            spriteCliquable.add(sprite);
        }

    }
    public void creationSpriteCliquableEtape1(int joueur){
        spriteCliquable.clear();

        for(Sprite sprite : getSprsChamps()[joueur - 1]){
            spriteCliquable.add(sprite);
        }

    }
    public void creationSpriteCliquableMenuCarte(){
        System.out.println("creationSpriteCliquableMenuCarte");
        spriteCliquable.clear();

        for(Sprite sprite : sprsMenuCartes){
            spriteCliquable.add(sprite);
        }

        spriteCliquable.add(sprFond);


    }
    public void creationSpriteCliquableMenuCarteChoix(){
        System.out.println("creationSpriteCliquableMenuCarteChoix");
        spriteCliquable.clear();

        for(Sprite sprite : sprsMenuCartesChoix){
            spriteCliquable.add(sprite);
        }

        spriteCliquable.add(sprFond);

    }
    public void creationSpriteCliquableCarte() {
        clearSpritesCliquables();
        spriteCliquable.add(sprCartePiochee1);
        spriteCliquable.add(sprCartePiochee2);
        spriteCliquable.add(sprBtPlantage);

    }
    public void clearSpritesCliquables(){
        spriteCliquable.clear();
    }
    public void creationSpriteCliquablePlantagePostEchange(int joueur) {
        for(Sprite sprite : sprsChamps[joueur]){
            spriteCliquable.add(sprite);
        }
    }
    public ArrayList<Sprite> getSpriteCliquable(){
        return spriteCliquable;
    }
    public void addToSpriteCliquable(Sprite sprite){
        spriteCliquable.add(sprite);
    }

    public void creerMenuCarte(float posX, float posY){
        float hauteurBouton = sprMCEchanger.getGlobalBounds().height;
        int espaceInterBouton = 10;

        sprMCFond.setPosition(posX,posY);
        sprMCEchanger.setPosition(posX + 10, posY + 1 * espaceInterBouton + 0 * hauteurBouton);
        sprMCDonner.setPosition(posX + 10, posY + 2 * espaceInterBouton + 1 * hauteurBouton);
        sprMCGarder.setPosition(posX + 10, posY + 3 * espaceInterBouton + 2 * hauteurBouton);
    }
    public void creerMenuOuiNon(float x, float y){
        float hauteurBouton = sprMCEchanger.getGlobalBounds().height;
        int espaceInterBouton = 10;

        sprMenuOuiNonFond.setPosition(x, y);
        sprMenuOui.setPosition(x + 5, y + espaceInterBouton);
        sprMenuNon.setPosition(x + 5, y + hauteurBouton + espaceInterBouton);

        spriteCliquable.add(sprMenuOui);
        spriteCliquable.add(sprMenuNon);

    }
    public void creerMenuCarteChoix(float posX, float posY){

        float hauteurBouton = sprMCEchanger.getGlobalBounds().height;
        int espaceFond = 5;
        int espaceInterBouton = 17;

        sprMCCFond.setPosition(posX,posY);
        sprMCCTectonik.setPosition(posX + 10, posY + 1 * espaceFond + 0 * hauteurBouton);
        sprMCCTentacule.setPosition(posX + 10, posY +  1 * espaceFond + 1 * espaceInterBouton + 1 * hauteurBouton);
        sprMCCTequila.setPosition(posX + 10, posY +  1 * espaceFond + 2 * espaceInterBouton + 2 * hauteurBouton);
        sprMCCTerroriste.setPosition(posX + 10, posY +  1 * espaceFond + 3 * espaceInterBouton + 3 * hauteurBouton);
        sprMCCTestosterone.setPosition(posX + 10, posY +  1 * espaceFond + 4 * espaceInterBouton + 4 * hauteurBouton);
        sprMCCTetenucleaire.setPosition(posX + 10, posY +  1 * espaceFond + 5 * espaceInterBouton + 5 * hauteurBouton);
        sprMCCTetraplegique.setPosition(posX + 10, posY +  1 * espaceFond + 6 * espaceInterBouton + 6 * hauteurBouton);
        sprMCCTwerk.setPosition(posX + 10, posY +  1 * espaceFond + 7 * espaceInterBouton + 7 * hauteurBouton);
    }

    public void afficherCartePiochee(){
        System.out.println("carte piochee");

        sprCartePiochee1.setPosition(509, 495);
        sprCartePiochee2.setPosition(417, 495);

    }
    public void setTxtCartePiochee1(Texture txtCarte){
        sprCartePiochee1.setTexture(txtCarte);
    }
    public void setTxtCartePiochee2(Texture txtCarte){
        sprCartePiochee2.setTexture(txtCarte);
    }

    public void garderCarte(int id, int joueur) {
        System.out.println("garder carte" + id + " " + joueur);
        if(id == 1){
            System.out.println("garder carte 1");
            delSpriteCliquable(getSprCartePiochee1());
            getZoneEchangeJoueurCourant(joueur - 1).add(sprCartePiochee1);
            sprCartePiochee1.setTexture(txtCarteVide);
        }else{
            System.out.println("garder carte 2");
            delSpriteCliquable(getSprCartePiochee2());
            getZoneEchangeJoueurCourant(joueur - 1).add(sprCartePiochee2);
            sprCartePiochee2.setTexture(txtCarteVide);
        }

    }
    public void donnerCarte(int id, int joueur){
        System.out.println("donner carte" + id + " " + joueur);
        if(id == 1){
            System.out.println("donner carte 1");
            delSpriteCliquable(getSprCartePiochee1());
            getZoneEchangeJoueurCourant(joueur - 1).add(0, sprCartePiochee1);
            sprCartePiochee1.setTexture(txtCarteVide);
        }else{
            System.out.println("donner carte 2");
            delSpriteCliquable(getSprCartePiochee2());
            getZoneEchangeJoueurCourant(joueur - 1).add(sprCartePiochee2);
            sprCartePiochee2.setTexture(txtCarteVide);
        }

    }

    public void afficherMainJ1(){
        switch((int) getFond().getRotation()){
            case 0 :
                afficherMainBas(mainJ1);
                break;
            case -90 :
                afficherMainDroite(mainJ1);
                break;
            case -180 :
                afficherMainHaut(mainJ1);
                break;
            case -270 :
                afficherMainGauche(mainJ1);
                break;
        }
    }
    public void afficherMainJ2(){
        switch((int) getFond().getRotation()){
            case 0 :
                afficherMainGauche(mainJ2);
                break;
            case -90 :
                afficherMainBas(mainJ2);
                break;
            case -180 :
                afficherMainDroite(mainJ2);
                break;
            case -270 :
                afficherMainHaut(mainJ2);
                break;
        }
    }
    public void afficherMainJ3(){
        switch((int) getFond().getRotation()){
            case 0 :
                afficherMainHaut(mainJ3);
                break;
            case -90 :
                afficherMainGauche(mainJ3);
                break;
            case -180 :
                afficherMainBas(mainJ3);
                break;
            case -270 :
                afficherMainDroite(mainJ3);
                break;
        }

    }
    public void afficherMainJ4(){
        switch((int) getFond().getRotation()){
            case 0 :
                afficherMainDroite(mainJ4);
                break;
            case -90 :
                afficherMainHaut(mainJ4);
                break;
            case -180 :
                afficherMainGauche(mainJ4);
                break;
            case -270 :
                afficherMainBas(mainJ4);
                break;
        }

    }
    private void afficherMainBas(ArrayList<Sprite> main){
        int espaceEntreCarte;
        if (main.size()>0){
            espaceEntreCarte = 380%(75*main.size())/main.size();
        }
        else {
            espaceEntreCarte = 0;
        }

        while(main.size()*(75+espaceEntreCarte) > 370){
            espaceEntreCarte = espaceEntreCarte - 5;
        }

        for(int i = main.size() - 1; i >= 0; i--){
            main.get(i).setRotation(0);
            main.get(i).setPosition(i * (75 + espaceEntreCarte) + 310 , 905);
            fenetre.draw(main.get(i));
        }
    }
    private void afficherMainHaut(ArrayList<Sprite> main){
        int espaceEntreCarte;
        if (main.size()>0){
            espaceEntreCarte = 380%(75*main.size())/main.size();
        }
        else {
            espaceEntreCarte = 0;
        }

        while(main.size()*(75+espaceEntreCarte) > 370){
            espaceEntreCarte = espaceEntreCarte - 5;
        }

        for(int i = main.size() - 1; i >= 0; i--){
            main.get(i).setRotation(-180);
            main.get(i).setPosition(i * (75 + espaceEntreCarte) + 410 , 95);
            fenetre.draw(main.get(i));
        }
    }
    private void afficherMainGauche(ArrayList<Sprite> main){
        int espaceEntreCarte;
        if (main.size()>0){
            espaceEntreCarte = 380%(75*main.size())/main.size();
        }
        else {
            espaceEntreCarte = 0;
        }

        while(main.size()*(75+espaceEntreCarte) > 370){
            espaceEntreCarte = espaceEntreCarte - 5;
        }

        for(int i = main.size() - 1; i >= 0; i--){
            main.get(i).setRotation(-270);
            main.get(i).setPosition(95 , i * (75 + espaceEntreCarte) +  330);
            fenetre.draw(main.get(i));
        }
    }
    private void afficherMainDroite(ArrayList<Sprite> main){
        int espaceEntreCarte;
        if (main.size()>0){
            espaceEntreCarte = 380%(75*main.size())/main.size();
        }
        else {
            espaceEntreCarte = 0;
        }

        while(main.size()*(75+espaceEntreCarte) > 370){
            espaceEntreCarte = espaceEntreCarte - 5;
        }

        for(int i = main.size() - 1; i >= 0; i--){
            main.get(i).setRotation(-90);
            main.get(i).setPosition(905 , i * (75 + espaceEntreCarte) + 410);
            fenetre.draw(main.get(i));
        }
    }

    private void afficherZonesEchanges(){
        System.out.println("actu zones echanges");
        afficherZoneEchangeJ1();
        afficherZoneEchangeJ2();
        afficherZoneEchangeJ3();
        afficherZoneEchangeJ4();
    }
    private void afficherZoneEchangeJ1(){
        switch ((int) getFond().getRotation()){
            case 0 :
                afficherZoneEchangeBas(zoneEchangeJ1);
                break;
            case -90 :
                afficherZoneEchangeDroite(zoneEchangeJ1);
                break;
            case -180 :
                afficherZoneEchangeHaut(zoneEchangeJ1);
                break;
            case -270 :
                afficherZoneEchangeGauche(zoneEchangeJ1);
                break;
        }
    }
    private void afficherZoneEchangeJ2() {
        switch ((int) getFond().getRotation()){
            case -90 :
                afficherZoneEchangeBas(zoneEchangeJ2);
                break;
            case -180 :
                afficherZoneEchangeDroite(zoneEchangeJ2);
                break;
            case -270 :
                afficherZoneEchangeHaut(zoneEchangeJ2);
                break;
            case -0 :
                afficherZoneEchangeGauche(zoneEchangeJ2);
                break;
        }
    }
    private void afficherZoneEchangeJ3() {
        switch ((int) getFond().getRotation()){
            case -180 :
                afficherZoneEchangeBas(zoneEchangeJ3);
                break;
            case -270 :
                afficherZoneEchangeDroite(zoneEchangeJ3);
                break;
            case 0 :
                afficherZoneEchangeHaut(zoneEchangeJ3);
                break;
            case -90 :
                afficherZoneEchangeGauche(zoneEchangeJ3);
                break;
        }
    }
    private void afficherZoneEchangeJ4() {
        switch ((int) getFond().getRotation()){
            case -270 :
                afficherZoneEchangeBas(zoneEchangeJ4);
                break;
            case 0 :
                afficherZoneEchangeDroite(zoneEchangeJ4);
                break;
            case -90 :
                afficherZoneEchangeHaut(zoneEchangeJ4);
                break;
            case -180 :
                afficherZoneEchangeGauche(zoneEchangeJ4);
                break;
        }
    }
    private void afficherZoneEchangeBas(ArrayList<Sprite> listeCarte){
        switch(listeCarte.size()){
            case 0 :
                return;
            case 1 :
                listeCarte.get(0).setRotation(0);
                listeCarte.get(0).setPosition(509, 625);
                fenetre.draw(listeCarte.get(0));
                break;
            case 2 :
                listeCarte.get(0).setRotation(0);
                listeCarte.get(0).setPosition(509, 625);
                listeCarte.get(1).setRotation(0);
                listeCarte.get(1).setPosition(417, 625);
                fenetre.draw(listeCarte.get(0));
                fenetre.draw(listeCarte.get(1));
                break;
        }

    }
    private void afficherZoneEchangeHaut(ArrayList<Sprite> listeCarte){
        switch(listeCarte.size()){
            case 0 :
                return;
            case 1 :
                listeCarte.get(0).setRotation(-180);
                listeCarte.get(0).setPosition(490, 375);
                fenetre.draw(listeCarte.get(0));
                break;
            case 2 :
                listeCarte.get(1).setRotation(-180);
                listeCarte.get(1).setPosition(585, 375);
                listeCarte.get(0).setRotation(-180);
                listeCarte.get(0).setPosition(490, 375);
                fenetre.draw(listeCarte.get(0));
                fenetre.draw(listeCarte.get(1));
                break;
        }
    }
    private void afficherZoneEchangeDroite(ArrayList<Sprite> listeCarte){
        switch(listeCarte.size()){
            case 0 :
                return;
            case 1 :
                listeCarte.get(0).setRotation(-90);
                listeCarte.get(0).setPosition(625, 490);
                fenetre.draw(listeCarte.get(0));
                break;
            case 2 :
                listeCarte.get(1).setRotation(-90);
                listeCarte.get(1).setPosition(625, 585);
                listeCarte.get(0).setRotation(-90);
                listeCarte.get(0).setPosition(625, 490);
                fenetre.draw(listeCarte.get(0));
                fenetre.draw(listeCarte.get(1));
                break;
        }
    }
    private void afficherZoneEchangeGauche(ArrayList<Sprite> listeCarte){
        switch(listeCarte.size()){
            case 0 :
                return;
            case 1 :
                listeCarte.get(0).setRotation(-270);
                listeCarte.get(0).setPosition(380, 510);
                fenetre.draw(listeCarte.get(0));
                break;
            case 2 :
                listeCarte.get(1).setRotation(-270);
                listeCarte.get(1).setPosition(380, 420);
                listeCarte.get(0).setRotation(-270);
                listeCarte.get(0).setPosition(380, 510);
                fenetre.draw(listeCarte.get(0));
                fenetre.draw(listeCarte.get(1));
                break;
        }
    }
    public void clearZonesEchanges() {
        zoneEchangeJ1.clear();
        zoneEchangeJ2.clear();
        zoneEchangeJ3.clear();
        zoneEchangeJ4.clear();

    }
    public void addSpriteIntoZoneEchange(int numZone, int idCarte){
        switch (numZone){
            case 0:
                zoneEchangeJ1.add(getSpriteById(idCarte));
                break;
            case 1:
                zoneEchangeJ2.add(getSpriteById(idCarte));
                break;
            case 2:
                zoneEchangeJ3.add(getSpriteById(idCarte));
                break;
            case 3:
                zoneEchangeJ4.add(getSpriteById(idCarte));
                break;
        }
        System.out.println("taille ZJ1 = " + zoneEchangeJ1.size());
        System.out.println("taille ZJ2 = " + zoneEchangeJ2.size());
        System.out.println("taille ZJ3 = " + zoneEchangeJ3.size());
        System.out.println("taille ZJ4 = " + zoneEchangeJ4.size());

    }

    public Sprite getSpriteById(int idCarte){

        Sprite spriteRetour = new Sprite();

        switch (idCarte){
            case 1:
                System.out.println("techtonique");
                spriteRetour.setTexture(txtCarteTectonik);
                break ;
            case 2:
                System.out.println("tentacule");
                spriteRetour.setTexture(txtCarteTentacule);
                break;
            case 3:
                System.out.println("tequila");
                spriteRetour.setTexture(txtCarteTequila);
                break;
            case 4:
                System.out.println("terrorriste");
                spriteRetour.setTexture(txtCarteTerroriste);
                break;
            case 5:
                System.out.println("testostérone");
                spriteRetour.setTexture(txtCarteTestosterone);
                break;
            case 6:
                System.out.println("tetenucleaire");
                spriteRetour.setTexture(txtCarteTeteNucleaire);
                break;
            case 7:
                System.out.println("tetraplégique");
                spriteRetour.setTexture(txtCarteTetraplegique);
                break;
            case 8:
                System.out.println("twerk");
                spriteRetour.setTexture(txtCarteTwerk);
                break;
        }

        return spriteRetour;
    }

    //GETTER AND SETTER
    public RenderWindow getFenetre(){
        return fenetre;
    }
    public Texture getTxtCarteTequila() {
        return txtCarteTequila;
    }
    public Texture getTxtCarteTentacule() {
        return txtCarteTentacule;
    }
    public Texture getTxtCarteTerroriste() {
        return txtCarteTerroriste;
    }
    public Texture getTxtCarteTestosterone() {
        return txtCarteTestosterone;
    }
    public Texture getTxtCarteTeteNucleaire() {
        return txtCarteTeteNucleaire;
    }
    public Texture getTxtCarteTetraplegique() {
        return txtCarteTetraplegique;
    }
    public Texture getTxtCarteTectonik() {
        return txtCarteTectonik;
    }
    public Texture getTxtCarteTwerk() {
        return txtCarteTwerk;
    }

    public Sprite[] getSprsAutresJoueurs() {
        return sprsAutresJoueurs;
    }
    public Sprite getSprJoueurAttente1() {
        return sprJoueurAttente1;
    }
    public Sprite getSprJoueurAttente2() {
        return sprJoueurAttente2;
    }
    public Sprite getSprJoueurAttente3() {
        return sprJoueurAttente3;
    }
    public Sprite getSprJoueurAttente4() {
        return sprJoueurAttente4;
    }
    public Sprite getSprBouttonDepart(){
        return sprBouttonDepart;
    }

    public void planterChamp(int joueur, int champ, int idCarte){
        switch(joueur){
            case 0 :
                planterChampJ1(champ, idCarte);
                break;
            case 1 :
                planterChampJ2(champ, idCarte);
                break;
            case 2 :
                planterChampJ3(champ, idCarte);
                break;
            case 3 :
                planterChampJ4(champ, idCarte);
                break;

        }
    }
    private void planterChampJ1(int champ, int idCarte) {
        switch (idCarte){
            case 1 :
                sprChampJ1[champ].setTexture(txtChampTectonik);
                break;
            case 2 :
                sprChampJ1[champ].setTexture(txtChampTentacule);
                break;
            case 3 :
                sprChampJ1[champ].setTexture(txtChampTequila);
                break;
            case 4 :
                sprChampJ1[champ].setTexture(txtChampTerroriste);
                break;
            case 5 :
                sprChampJ1[champ].setTexture(txtChampTestosterone);
                break;
            case 6 :
                sprChampJ1[champ].setTexture(txtChampTetenucleaire);
                break;
            case 7 :
                sprChampJ1[champ].setTexture(txtChampTetraplegique);
                break;
            case 8 :
                sprChampJ1[champ].setTexture(txtChampTwerk);
                break;

        }
        actualiserFenetrePlantagePostEchange(1);
    }
    private void planterChampJ2(int champ, int idCarte) {
        switch (idCarte){
            case 1 :
                sprChampJ2[champ].setTexture(txtChampTectonik);
                break;
            case 2 :
                sprChampJ2[champ].setTexture(txtChampTentacule);
                break;
            case 3 :
                sprChampJ2[champ].setTexture(txtChampTequila);
                break;
            case 4 :
                sprChampJ2[champ].setTexture(txtChampTerroriste);
                break;
            case 5 :
                sprChampJ2[champ].setTexture(txtChampTestosterone);
                break;
            case 6 :
                sprChampJ2[champ].setTexture(txtChampTetenucleaire);
                break;
            case 7 :
                sprChampJ2[champ].setTexture(txtChampTetraplegique);
                break;
            case 8 :
                sprChampJ2[champ].setTexture(txtChampTwerk);
                break;

        }
        actualiserFenetrePlantagePostEchange(2);
    }
    private void planterChampJ3(int champ, int idCarte) {
        switch (idCarte){
            case 1 :
                sprChampJ3[champ].setTexture(txtChampTectonik);
                break;
            case 2 :
                sprChampJ3[champ].setTexture(txtChampTentacule);
                break;
            case 3 :
                sprChampJ3[champ].setTexture(txtChampTequila);
                break;
            case 4 :
                sprChampJ3[champ].setTexture(txtChampTerroriste);
                break;
            case 5 :
                sprChampJ3[champ].setTexture(txtChampTestosterone);
                break;
            case 6 :
                sprChampJ3[champ].setTexture(txtChampTetenucleaire);
                break;
            case 7 :
                sprChampJ3[champ].setTexture(txtChampTetraplegique);
                break;
            case 8 :
                sprChampJ3[champ].setTexture(txtChampTwerk);
                break;

        }
        actualiserFenetrePlantagePostEchange(3);
    }
    private void planterChampJ4(int champ, int idCarte) {
        switch (idCarte){
            case 1 :
                sprChampJ4[champ].setTexture(txtChampTectonik);
                break;
            case 2 :
                sprChampJ4[champ].setTexture(txtChampTentacule);
                break;
            case 3 :
                sprChampJ4[champ].setTexture(txtChampTequila);
                break;
            case 4 :
                sprChampJ4[champ].setTexture(txtChampTerroriste);
                break;
            case 5 :
                sprChampJ4[champ].setTexture(txtChampTestosterone);
                break;
            case 6 :
                sprChampJ4[champ].setTexture(txtChampTetenucleaire);
                break;
            case 7 :
                sprChampJ4[champ].setTexture(txtChampTetraplegique);
                break;
            case 8 :
                sprChampJ4[champ].setTexture(txtChampTwerk);
                break;

        }
        actualiserFenetrePlantagePostEchange(4);
    }
    public void planterEchange(int joueur, int champChoisi, int idCarte, int index) {
        switch (idCarte) {
            case 1:
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampDispo);
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampTectonik);
                break;
            case 2:
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampDispo);
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampTentacule);
                break;
            case 3:
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampDispo);
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampTequila);
                break;
            case 4:
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampDispo);
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampTerroriste);
                break;
            case 5:
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampDispo);
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampTestosterone);
                break;
            case 6:
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampDispo);
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampTetenucleaire);
                break;
            case 7:
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampDispo);
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampTetraplegique);
                break;
            case 8:
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampDispo);
                getSprsChamps()[joueur][champChoisi - 1].setTexture(txtChampTwerk);
                break;
        }

        switch (joueur){
            case 0 :
                zoneEchangeJ1.get(index).setTexture(txtCarteVide);
                actualiserFenetrePlantagePostEchange(1);
                break;
            case 1 :
                zoneEchangeJ2.get(index).setTexture(txtCarteVide);
                actualiserFenetrePlantagePostEchange(2);
                break;
            case 2 :
                zoneEchangeJ3.get(index).setTexture(txtCarteVide);
                actualiserFenetrePlantagePostEchange(3);
                break;
            case 3 :
                zoneEchangeJ4.get(index).setTexture(txtCarteVide);
                actualiserFenetrePlantagePostEchange(4);
                break;
        }

    }

    public void acheter3emeChamp(int idJoueur) {
        sprsChamps[idJoueur - 1][2].setTexture(txtChampDispo);
    }

}
