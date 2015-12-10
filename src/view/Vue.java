package view;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Vue{

    private RenderWindow fenetre = new RenderWindow();
    private ArrayList<Sprite> spriteCliquable = new ArrayList<>();
    private Sprite[][] sprsChamps = new Sprite[4][3];
    private Sprite[] sprsMenuCartes = new Sprite[3];
    private Sprite[] sprsMenuCartesChoix = new Sprite[8];
    private Sprite[] sprsAutresJoueurs = new Sprite[4];
    private Sprite[] sprsBoutonsEtapes = new Sprite[4];
    private Sprite[] sprsMenuON = new Sprite[2];
    private Sprite[] sprsCartesPiochee = new Sprite[2];

    private Image icone = new Image();

    //////////////////////////////////////////////////////////////////////////////////////
    //Declaration Textures
    // Textures generales
    private Texture txtFond = new Texture();

    //bouton
    private Texture txtBtEchange = new Texture();
    private Texture txtBtPlantage= new Texture();
    private Texture txtBtPioche = new Texture();
    private Texture txtFinTour = new Texture();

    //champ
    private Texture txtChampDispo = new Texture();
    private Texture txtChampIndispo = new Texture();

    //Textures menu
    //menu carte
    private Texture txtMCFond = new Texture();
    private Texture txtMCEchanger = new Texture();
    private Texture txtMCDonner = new Texture();
    private Texture txtMCGarder = new Texture();

    //menu choix carte

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
    private Texture txtMCCFond = new Texture();

    private Texture txtCarteTequila = new Texture();
    private Texture txtCarteTentacule = new Texture();
    private Texture txtCarteTerroriste = new Texture();
    private Texture txtCarteTestosterone = new Texture();
    private Texture txtCarteTeteNucleaire = new Texture();
    private Texture txtCarteTetraplegique = new Texture();
    private Texture txtCarteTectonik = new Texture();
    private Texture txtCarteTwerk = new Texture();

    //Declaration sprite
    // sprites generaux
    private Sprite sprFond = new Sprite();
    private Sprite etapeEnCours = new Sprite();

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

    //sprite cartes
    private ArrayList<Sprite> mainJ1 = new ArrayList<Sprite>();

    private Vector2i positionFenetre = new Vector2i(0,0);
    ///////////////////////////////////////////////////////////////////////////////

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


        try{
            icone.loadFromFile(Paths.get("Sprites/patate.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            txtFond.loadFromFile(Paths.get("Sprites/fond.png"));

            txtMCFond.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/fondMCarte.png"));
            txtMCEchanger.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/echange.png"));
            txtMCDonner.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/don.png"));
            txtMCGarder.loadFromFile(Paths.get("Sprites/Sprite_menu/menu_carte/garder.png"));

            txtBtEchange.loadFromFile(Paths.get("Sprites/Sprite_bouton/phaseDechange.png"));
            txtBtPlantage.loadFromFile(Paths.get("Sprites/Sprite_bouton/phaseDePlantage.png"));
            txtBtPioche.loadFromFile(Paths.get("Sprites/Sprite_bouton/phaseDePioche.png"));
            txtFinTour.loadFromFile(Paths.get("Sprites/Sprite_bouton/finDeTour.png"));

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

            txtCarteTectonik.loadFromFile(Paths.get("Sprites/Sprite_carte/patatentacule.jpg"));
            txtCarteTentacule.loadFromFile(Paths.get("Sprites/Sprite_carte/patatentacule.jpg"));
            txtCarteTequila.loadFromFile(Paths.get("Sprites/Sprite_carte/patatequila.jpg"));
            txtCarteTerroriste.loadFromFile(Paths.get("Sprites/Sprite_carte/pataterroriste.jpg"));
            txtCarteTestosterone.loadFromFile(Paths.get("Sprites/Sprite_carte/patatestosterone.jpg"));
            txtCarteTeteNucleaire.loadFromFile(Paths.get("Sprites/Sprite_carte/patatetenucleaire.jpg"));
            txtCarteTetraplegique.loadFromFile(Paths.get("Sprites/Sprite_carte/patatetraplegique.jpg"));
            txtCarteTwerk.loadFromFile(Paths.get("Sprites/Sprite_carte/patatetraplegique.jpg"));

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
        sprFond.setTexture(txtFond);

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

        //bouton
        sprBtEchange.setPosition(810, 775);
        sprBtPlantage.setPosition(810, 830);
        sprBtPioche.setPosition(810, 885);
        sprBtFinTour.setPosition(810, 940);


        //position champ d?part
        //J1

        sprChampJ1[0].setPosition(263, 767);
        sprChampJ1[1].setPosition(425, 767);
        sprChampJ1[2].setPosition(587, 767);

        //J2

        sprChampJ2[0].rotate(-90);
        sprChampJ2[1].rotate(-90);
        sprChampJ2[2].rotate(-90);

        sprChampJ2[0].setPosition(135, 413);
        sprChampJ2[1].setPosition(135, 575);
        sprChampJ2[2].setPosition(135, 737);


        //J3

        sprChampJ3[0].setPosition(587, 135);
        sprChampJ3[1].setPosition(425, 135);
        sprChampJ3[2].setPosition(263, 135);

        //J4

        sprChampJ4[0].rotate(-90);
        sprChampJ4[1].rotate(-90);
        sprChampJ4[2].rotate(-90);

        sprChampJ4[0].setPosition(765, 737);
        sprChampJ4[1].setPosition(765, 575);
        sprChampJ4[2].setPosition(765, 413);

        //////////////////////

        sprJoueurAttente1.setPosition(35, 775);
        sprJoueurAttente2.setPosition(35, 825);
        sprJoueurAttente3.setPosition(35, 875);
        sprJoueurAttente4.setPosition(35, 925);


    }

    private void creerFenetre() {
        fenetre.create(new VideoMode(1000, 1000), "Bohnanza", WindowStyle.CLOSE);

        fenetre.setIcon(icone);

        fenetre.setPosition(positionFenetre);

        fenetre.clear();
    }

    public void rotationJ1(){

        //rotation fond
        sprFond.rotate(-90);
        sprFond.setPosition(0, 0);

        /////////////////////////////////////////////////////////////////////////////
        //rotation champ

        for(int i = 0; i < 3; i++){
            sprChampJ1[i].rotate(-90);
        }

        sprChampJ1[0].setPosition(263, 767);
        sprChampJ1[1].setPosition(425, 767);
        sprChampJ1[2].setPosition(587, 767);

        for(int i = 0; i < 3; i++){
            sprChampJ2[i].rotate(-90);
        }

        sprChampJ2[0].setPosition(135, 413);
        sprChampJ2[1].setPosition(135, 575);
        sprChampJ2[2].setPosition(135, 737);


        for(int i = 0; i < 3; i++){
            sprChampJ3[i].rotate(-90);
        }

        sprChampJ3[0].setPosition(587, 135);
        sprChampJ3[1].setPosition(425, 135);
        sprChampJ3[2].setPosition(268, 135);

        for(int i = 0; i < 3; i++){
            sprChampJ4[i].rotate(-90);
        }

        sprChampJ4[0].setPosition(765, 413);
        sprChampJ4[1].setPosition(765, 575);
        sprChampJ4[2].setPosition(765, 737);

        actualiserFenetre();

    }
    public void rotationJ2(){

        //rotation fond
        sprFond.rotate(-90);
        sprFond.setPosition(0, 1000);

        /////////////////////////////////////////////////////////////////////////////
        //rotation champ

        for(int i = 0; i < 3; i++){
            sprChampJ1[i].rotate(-90);
        }

        sprChampJ1[0].setPosition(767, 737);
        sprChampJ1[1].setPosition(767, 575);
        sprChampJ1[2].setPosition(767, 413);

        for(int i = 0; i < 3; i++){
            sprChampJ2[i].rotate(-90);
        }

        sprChampJ2[0].setPosition(415, 862);
        sprChampJ2[1].setPosition(578, 862);
        sprChampJ2[2].setPosition(740, 862);


        for(int i = 0; i < 3; i++){
            sprChampJ3[i].rotate(-90);
        }

        sprChampJ3[0].setPosition(135, 413);
        sprChampJ3[1].setPosition(135, 575);
        sprChampJ3[2].setPosition(135, 737);

        for(int i = 0; i < 3; i++){
            sprChampJ4[i].rotate(-90);
        }

        sprChampJ4[2].setPosition(413, 235);
        sprChampJ4[1].setPosition(575, 235);
        sprChampJ4[0].setPosition(737, 235);

        actualiserFenetre();


    }
    public void rotationJ3(){

        //rotation fond
        sprFond.rotate(-90);
        sprFond.setPosition(1000, 1000);

        /////////////////////////////////////////////////////////////////////////////
        //rotation champ

        for(int i = 0; i < 3; i++){
            sprChampJ1[i].rotate(-90);
        }

        sprChampJ1[2].setPosition(418, 238);
        sprChampJ1[1].setPosition(575, 238);
        sprChampJ1[0].setPosition(737, 238);

        for(int i = 0; i < 3; i++){
            sprChampJ2[i].rotate(-90);
        }

        sprChampJ2[0].setPosition(865, 587);
        sprChampJ2[1].setPosition(865, 425);
        sprChampJ2[2].setPosition(865, 263);


        for(int i = 0; i < 3; i++){
            sprChampJ3[i].rotate(-90);
        }

        sprChampJ3[0].setPosition(415, 865);
        sprChampJ3[1].setPosition(575, 865);
        sprChampJ3[2].setPosition(737, 865);

        for(int i = 0; i < 3; i++) {
            sprChampJ4[i].rotate(-90);
        }

        sprChampJ4[0].setPosition(235, 263);
        sprChampJ4[1].setPosition(235, 425);
        sprChampJ4[2].setPosition(235, 587);

        actualiserFenetre();

    }
    public void rotationJ4(){

        //rotation fond
        sprFond.rotate(-90);
        sprFond.setPosition(1000, 0);

        /////////////////////////////////////////////////////////////////////////////
        //rotation champ

        for(int i = 0; i < 3; i++){
            sprChampJ1[i].rotate(-90);
        }

        sprChampJ1[0].setPosition(235, 263);
        sprChampJ1[1].setPosition(235, 425);
        sprChampJ1[2].setPosition(235, 587);

        for(int i = 0; i < 3; i++){
            sprChampJ2[i].rotate(-90);
        }

        sprChampJ2[0].setPosition(587, 135);
        sprChampJ2[1].setPosition(425, 135);
        sprChampJ2[2].setPosition(263, 135);


        for(int i = 0; i < 3; i++){
            sprChampJ3[i].rotate(-90);
        }

        sprChampJ3[2].setPosition(865, 263);
        sprChampJ3[1].setPosition(865, 425);
        sprChampJ3[0].setPosition(865, 587);

        for(int i = 0; i < 3; i++){
            sprChampJ4[i].rotate(-90);
        }

        sprChampJ4[2].setPosition(263, 765);
        sprChampJ4[1].setPosition(425, 765);
        sprChampJ4[0].setPosition(587, 765);

        actualiserFenetre();

    }

    public RenderWindow getFenetre(){
        return fenetre;
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
                etapeEnCours.setTexture(txtFinTour);
                break;
            case 4 :
                etapeEnCours.setTexture(txtBtPioche);
                break;
        }

    }
    public void actualiserFenetre(){
        System.out.println("act");
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

        fenetre.draw(etapeEnCours);

        fenetre.display();

    }
    public void actualiserFenetreEchange(){
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

        fenetre.draw(sprCartePiochee1);
        fenetre.draw(sprCartePiochee2);

        fenetre.draw(etapeEnCours);

        fenetre.display();

    }
    public void actualiserFenetreEchangeMenu() {
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

        fenetre.draw(sprCartePiochee1);
        fenetre.draw(sprCartePiochee2);

        fenetre.draw(sprMCFond);
        fenetre.draw(sprMCEchanger);
        fenetre.draw(sprMCDonner);
        fenetre.draw(sprMCGarder);

        fenetre.draw(etapeEnCours);

        fenetre.display();
    }
    public void actualiserFenetreEchangeMenuChoix() {
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

        fenetre.draw(sprCartePiochee1);
        fenetre.draw(sprCartePiochee2);


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

        fenetre.draw(etapeEnCours);

        fenetre.display();

    }


    public boolean cliqueSprite(Event event, Sprite sprite, RenderWindow fenetre){
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

    public void creationSpriteCliquableEtape3(int joueur){

    }

    public void creationSpriteCliquableEtape4(int joueur){

    }

    public void creerMenuCarte(float posX, float posY){

        float hauteurBouton = sprMCEchanger.getGlobalBounds().height;
        int espaceInterBouton = 10;

        sprMCFond.setPosition(posX,posY);
        sprMCEchanger.setPosition(posX + 10, posY + 1 * espaceInterBouton + 0 * hauteurBouton);
        sprMCDonner.setPosition(posX + 10, posY + 2 * espaceInterBouton + 1 * hauteurBouton);
        sprMCGarder.setPosition(posX + 10, posY + 3 * espaceInterBouton + 2 * hauteurBouton);
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

    public void creationSpriteCliquableCarte() {
        clearSpritesCliquables();
        spriteCliquable.add(sprCartePiochee1);
        spriteCliquable.add(sprCartePiochee2);
        spriteCliquable.add(sprBtPlantage);

    }

    public void clearSpritesCliquables(){
        spriteCliquable.clear();
    }

    public ArrayList<Sprite> getSpriteCliquable(){
        return spriteCliquable;
    }

    public void afficherCartePiochee(){
        System.out.println("carte piochee");
        sprCartePiochee1.setTexture(txtCarteTentacule);
        sprCartePiochee2.setTexture(txtCarteTeteNucleaire);

        sprCartePiochee1.setPosition(509, 495);
        sprCartePiochee2.setPosition(417, 495);

    }

    public Sprite getFond() {
        return sprFond;
    }

    public void garderCarte(int id) {
        System.out.println("garder carte");
        if(id == 1){
            System.out.println("garder carte 1");
            delSpriteCliquable(getSprCartePiochee1());
            sprCartePiochee1.setPosition(509, 625);
        }else{
            System.out.println("garder carte 2");
            delSpriteCliquable(getSprCartePiochee2());
            sprCartePiochee2.setPosition(417, 625);
        }

        actualiserFenetreEchange();
    }

    public void creationSpriteCliquableDon(int joueur) {
        System.out.println("creation sprite don");
        spriteCliquable.clear();
        spriteCliquable.add(getFond());

        for(Sprite sprite : getSprsAutresJoueurs(joueur)){
            spriteCliquable.add(sprite);
        }

    }

    public void donnerCarteJ1(int carte) {
        switch((int) sprFond.getRotation()){
            case -90 :
                sprsCartesPiochee[carte - 1].rotate(-90);
                sprsCartesPiochee[carte - 1].setPosition(725, 275);
                break;
            case -180 :
                sprsCartesPiochee[carte - 1].rotate(-180);
                sprsCartesPiochee[carte - 1].setPosition(275, 225);
                break;
            case -270 :
                sprsCartesPiochee[carte - 1].rotate(-270);
                sprsCartesPiochee[carte - 1].setPosition(225, 275);
                break;
        }

    }

    public void donnerCarteJ2(int carte) {
        switch(carte){
            case 1 :
                switch((int) sprFond.getRotation()){
                    case 0 :
                        sprsCartesPiochee[0].rotate(90);
                        sprsCartesPiochee[0].setPosition(380, 510);
                        break;
                    case -180 :
                        sprsCartesPiochee[0].rotate(-90);
                        sprsCartesPiochee[0].setPosition(725, 275);
                        break;
                    case -270 :
                        sprsCartesPiochee[0].rotate(-180);
                        sprsCartesPiochee[0].setPosition(275, 225);
                        break;
                }
                break;
            case 2 :
                switch((int) sprFond.getRotation()){
                    case 0 :
                        sprsCartesPiochee[1].rotate(90);
                        sprsCartesPiochee[1].setPosition(380, 420);
                        break;
                    case -180 :
                        sprsCartesPiochee[1].rotate(-90);
                        sprsCartesPiochee[1].setPosition(725, 275);
                        break;
                    case -270 :
                        sprsCartesPiochee[1].rotate(-180);
                        sprsCartesPiochee[1].setPosition(275, 225);
                        break;
                }



        }

    }

    public void donnerCarteJ3(int carte) {
        switch(carte){
            case 1 :
                switch((int) sprFond.getRotation()){
                    case -90 :
                        sprsCartesPiochee[carte - 1].rotate(90);
                        sprsCartesPiochee[carte - 1].setPosition(725, 275);
                        break;
                    case -270 :
                        sprsCartesPiochee[carte - 1].rotate(-90);
                        sprsCartesPiochee[carte - 1].setPosition(275, 225);
                        break;
                    case 0 :
                        sprsCartesPiochee[carte - 1].rotate(-180);
                        sprsCartesPiochee[carte - 1].setPosition(490, 380);
                        break;
                }
                break;

            case 2 :
                switch((int) sprFond.getRotation()){
                    case -90 :
                        sprsCartesPiochee[carte - 1].rotate(90);
                        sprsCartesPiochee[carte - 1].setPosition(725, 275);
                        break;
                    case -270 :
                        sprsCartesPiochee[carte - 1].rotate(-90);
                        sprsCartesPiochee[carte - 1].setPosition(275, 225);
                        break;
                    case 0 :
                        sprsCartesPiochee[carte - 1].rotate(-180);
                        sprsCartesPiochee[carte - 1].setPosition(585, 380);
                        break;
                }
                break;
        }

    }

    public void donnerCarteJ4(int carte) {
        switch(carte){
            case 1 :
                switch((int) sprFond.getRotation()){
                    case -90 :
                        sprsCartesPiochee[0].rotate(-180);
                        sprsCartesPiochee[0].setPosition(725, 275);
                        break;
                    case -180 :
                        sprsCartesPiochee[0].rotate(90);
                        sprsCartesPiochee[0].setPosition(275, 225);
                        break;
                    case 0 :
                        sprsCartesPiochee[0].rotate(-90);
                        sprsCartesPiochee[0].setPosition(620, 490);
                        break;
                }
                break;
            case 2 :
                switch((int) sprFond.getRotation()){
                    case -90 :
                        sprsCartesPiochee[1].rotate(-180);
                        sprsCartesPiochee[1].setPosition(725, 275);
                        break;
                    case -180 :
                        sprsCartesPiochee[1].rotate(90);
                        sprsCartesPiochee[1].setPosition(275, 225);
                        break;
                    case 0 :
                        sprsCartesPiochee[1].rotate(-90);
                        sprsCartesPiochee[1].setPosition(620, 585);
                        break;
                }
                break;
        }

    }
}