package view;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;
import org.jsfml.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Vue{

    private static RenderWindow fenetre = new RenderWindow();

    private static Image icone = new Image();

    //////////////////////////////////////////////////////////////////////////////////////
    //Declaration Textures
    // Textures generales
    private static Texture txtFond = new Texture();
    private static Texture txtFinTour = new Texture();
    private static Texture txtChampDispo = new Texture();
    private static Texture txtChampIndispo = new Texture();

    //Textures menu
    //menu carte
    private static Texture txtMCFond = new Texture();
    private static Texture txtMCEchanger = new Texture();
    private static Texture txtMCDonner = new Texture();
    private static Texture txtMCGarder = new Texture();

    //Texture carte
    private static Texture txtCarteTequila = new Texture();
    private static Texture txtCarteTentacule = new Texture();
    private static Texture txtCarteTerroriste = new Texture();
    private static Texture txtCarteTestosterone = new Texture();
    private static Texture txtCarteTeteNucleaire = new Texture();
    private static Texture txtCarteTetraplegique = new Texture();

    //Declaration sprite
    // sprites generaux
    private static Sprite sprFond = new Sprite();

    //sprites boutons
    private static Sprite sprFinTour = new Sprite();

    //sprites menu
        //menu carte
    private static Sprite sprMCFond = new Sprite();
    private static Sprite sprMCEchanger = new Sprite();
    private static Sprite sprMCDonner = new Sprite();
    private static Sprite sprMCGarder = new Sprite();

    //sprite champs
    private static Sprite[] sprChampJ1 = new Sprite[3];
    private static Sprite[] sprChampJ2 = new Sprite[3];
    private static Sprite[] sprChampJ3 = new Sprite[3];
    private static Sprite[] sprChampJ4 = new Sprite[3];

    //sprite cartes
    private static ArrayList<Sprite> mainJ1 = new ArrayList<Sprite>();

    private static Vector2i positionFenetre = new Vector2i(0,0);
    ///////////////////////////////////////////////////////////////////////////////

    public Vue(){
        initAttribut();
        creerFenetre();
    }

    private void creerFenetre() {
        fenetre.create(new VideoMode(1000, 1000), "Bohnanza", WindowStyle.CLOSE);

        fenetre.setIcon(icone);

        fenetre.setPosition(positionFenetre);

        fenetre.clear();

        fenetre.draw(sprFond);
        fenetre.draw(sprFinTour);

        for(int i = 0; i < 3; i++){
           fenetre.draw(sprChampJ1[i]);
        }

        for(int i = 0; i < 3; i++){
            fenetre.draw(sprChampJ2[i]);
        }

        for(int i = 0; i < 3; i++) {
           fenetre.draw(sprChampJ3[i]);
        }

        for(int i = 0; i < 3; i++){
           fenetre.draw(sprChampJ4[i]);
        }

        creerMenuCarte(500, 500);

        fenetre.display();

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

            txtFinTour.loadFromFile(Paths.get("Sprites/Sprite_bouton/finDeTour.png"));

            txtChampDispo.loadFromFile(Paths.get("Sprites/Sprite_champ/champactif.png"));
            txtChampIndispo.loadFromFile(Paths.get("Sprites/Sprite_champ/champinactif.png"));

            txtCarteTentacule.loadFromFile(Paths.get("Sprites/Sprite_carte/patatentacule.jpg"));
            txtCarteTequila.loadFromFile(Paths.get("Sprites/Sprite_carte/patatequila.jpg"));
            txtCarteTerroriste.loadFromFile(Paths.get("Sprites/Sprite_carte/pataterroriste.jpg"));
            txtCarteTestosterone.loadFromFile(Paths.get("Sprites/Sprite_carte/patatestosterone.jpg"));
            txtCarteTeteNucleaire.loadFromFile(Paths.get("Sprites/Sprite_carte/patatetenucleaire.jpg"));
            txtCarteTetraplegique.loadFromFile(Paths.get("Sprites/Sprite_carte/patatetraplegique.jpg"));

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
        sprFinTour.setTexture(txtFinTour);

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


        //set positions

        sprFinTour.setPosition(775, 775);


        //position champ départ
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

        for(int i = 0; i < 2; i++) {
            sprChampJ1[i].setColor(Color.BLACK);
        }

        for(int i = 0; i < 2; i++) {
            sprChampJ1[i].setColor(Color.WHITE);
        }

        for(int i = 0; i < 2; i++) {
            sprChampJ1[i].setColor(Color.GREEN);
        }

        for(int i = 0; i < 2; i++) {
            sprChampJ1[i].setColor(Color.YELLOW);
        }



    }
    public boolean cliqueSprite(Event event, Sprite sprite, RenderWindow fenetre){

        event.asMouseEvent();
        Vector2i posMouse = Mouse.getPosition(fenetre);
        Vector2f positionSprite = sprite.getPosition();
        FloatRect tailleSprite = sprite.getGlobalBounds();

        if(posMouse.x > positionSprite.x && posMouse.x < positionSprite.x + tailleSprite.width && posMouse.y > positionSprite.y && posMouse.y < positionSprite.y + tailleSprite.height){
            return true;
        }else{
            return false;
        }

    }

    public void rotationJ1(){
        System.out.println("Joueur 1 en position");
        //rotation fond
        sprFond.rotate(-90);
        sprFond.setPosition(0, 0);

        fenetre.draw(sprFond);

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


        for(int i = 0; i < 3; i++){
           fenetre.draw(sprChampJ1[i]);
        }

        for(int i = 0; i < 3; i++){
            fenetre.draw(sprChampJ2[i]);
        }

        for(int i = 0; i < 3; i++) {
            fenetre.draw(sprChampJ3[i]);
        }

        for(int i = 0; i < 3; i++){
            fenetre.draw(sprChampJ4[i]);
        }



        fenetre.draw(sprFinTour);

        fenetre.display();

    }
    public void rotationJ2(){
        System.out.println("Joueur 2 en position");

        //rotation fond
        sprFond.rotate(-90);
        sprFond.setPosition(0, 1000);

        fenetre.draw(sprFond);


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


        for(int i = 0; i < 3; i++){
          fenetre.draw(sprChampJ1[i]);
        }

        for(int i = 0; i < 3; i++){
           fenetre.draw(sprChampJ2[i]);
        }

        for(int i = 0; i < 3; i++) {
            fenetre.draw(sprChampJ3[i]);
        }

        for(int i = 0; i < 3; i++){
           fenetre.draw(sprChampJ4[i]);
        }




        fenetre.draw(sprFinTour);

        fenetre.display();


    }
    public void rotationJ3(){
        System.out.println("Joueur 3 en position");

        //rotation fond
        sprFond.rotate(-90);
        sprFond.setPosition(1000, 1000);

        fenetre.draw(sprFond);


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



        for(int i = 0; i < 3; i++){
            fenetre.draw(sprChampJ1[i]);
        }

        for(int i = 0; i < 3; i++){
            fenetre.draw(sprChampJ2[i]);
        }

        for(int i = 0; i < 3; i++) {
            fenetre.draw(sprChampJ3[i]);
        }

        for(int i = 0; i < 3; i++){
            fenetre.draw(sprChampJ4[i]);
        }



        fenetre.draw(sprFinTour);

        fenetre.display();

    }
    public void rotationJ4(){
        System.out.println("Joueur 4 en position");

        //rotation fond
        sprFond.rotate(-90);
        sprFond.setPosition(1000, 0);

        fenetre.draw(sprFond);

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



        for(int i = 0; i < 3; i++){
           fenetre.draw(sprChampJ1[i]);
        }

        for(int i = 0; i < 3; i++){
            fenetre.draw(sprChampJ2[i]);
        }

        for(int i = 0; i < 3; i++) {
            fenetre.draw(sprChampJ3[i]);
        }

        for(int i = 0; i < 3; i++){
            fenetre.draw(sprChampJ4[i]);
        }


        fenetre.draw(sprFinTour);

        fenetre.display();

    }

    public RenderWindow getFenetre(){
        return fenetre;
    }

    public Sprite getFinDeTour(){
        return sprFinTour;
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


    public void creerMenuCarte(int posX, int posY){

        sprMCFond.setPosition(posX,posY);
        sprMCEchanger.setPosition(posX + 10, posY + 5);
        sprMCDonner.setPosition(posX + 10, posY + 5 + 50 + 5);
        sprMCGarder.setPosition(posX + 10, posY + 5 + 50 + 5 + 50 + 5);

        fenetre.draw(sprMCFond);
        fenetre.draw(sprMCEchanger);
        fenetre.draw(sprMCDonner);
        fenetre.draw(sprMCGarder);
    }

}