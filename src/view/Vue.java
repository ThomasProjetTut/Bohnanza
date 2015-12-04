package view;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
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

    // Textures joueur
    private static Texture txtJoueur1 = new Texture();
    private static Texture txtJoueur2 = new Texture();
    private static Texture txtJoueur3 = new Texture();
    private static Texture txtJoueur4 = new Texture();

    //Textures echange
    private static Texture txtEchangeJ1 = new Texture();
    private static Texture txtEchangeJ2 = new Texture();
    private static Texture txtEchangeJ3 = new Texture();
    private static Texture txtEchangeJ4 = new Texture();

    private static Texture txtCarteTequila = new Texture();

    //Declaration sprite
    // sprites generaux
    private static Sprite sprFond = new Sprite();
    private static Sprite sprFinTour = new Sprite();

    //sprite champs
    private static Sprite[] sprChampJ1 = new Sprite[3];
    private static Sprite[] sprChampJ2 = new Sprite[3];
    private static Sprite[] sprChampJ3 = new Sprite[3];
    private static Sprite[] sprChampJ4 = new Sprite[3];

    private static Sprite sprCarteTequila = new Sprite();

    private static Vector2i positionFenetre = new Vector2i(0,0);

    ///////////////////////////////////////////////////////////////////////////////

    public Vue(){
        initAttribut();
        creerFenetre();
    }

    private void creerFenetre() {
        fenetre.create(new VideoMode(1000, 1000), "Bohnanza");

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

        fenetre.setIcon(icone);

        try {
            txtFond.loadFromFile(Paths.get("Sprites/fond.png"));
            txtFinTour.loadFromFile(Paths.get("Sprites/finDeTour.png"));
            txtChampDispo.loadFromFile(Paths.get("Sprites/Sprite_champ/champactif.png"));
            txtChampIndispo.loadFromFile(Paths.get("Sprites/Sprite_champ/champinactif.png"));

            txtJoueur1.loadFromFile(Paths.get("Sprites/Sprite_joueur/joueur1.png"));
            txtJoueur2.loadFromFile(Paths.get("Sprites/Sprite_joueur/joueur2.png"));
            txtJoueur3.loadFromFile(Paths.get("Sprites/Sprite_joueur/joueur3.png"));
            txtJoueur4.loadFromFile(Paths.get("Sprites/Sprite_joueur/joueur4.png"));

            txtEchangeJ1.loadFromFile(Paths.get("Sprites/Sprite_zone_echange/EchangeJ1.png"));
            txtEchangeJ2.loadFromFile(Paths.get("Sprites/Sprite_zone_echange/EchangeJ2.png"));
            txtEchangeJ3.loadFromFile(Paths.get("Sprites/Sprite_zone_echange/EchangeJ3.png"));
            txtEchangeJ4.loadFromFile(Paths.get("Sprites/Sprite_zone_echange/EchangeJ4.png"));

            txtEchangeJ4.loadFromFile(Paths.get("Sprites/Sprite_zone_echange/EchangeJ4.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //set Txt

        sprFond.setTexture(txtFond);
        sprFinTour.setTexture(txtFinTour);

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


        //position champ
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

        for(int i = 0; i < 2; i++){
            sprChampJ1[i].rotate(-90);
        }

        sprChampJ1[0].setPosition(767, 737);
        sprChampJ1[1].setPosition(767, 575);
        sprChampJ1[2].setPosition(767, 413);

        for(int i = 0; i < 2; i++){
            sprChampJ2[i].rotate(-90);
        }

        sprChampJ2[0].setPosition(250, 263);
        sprChampJ2[1].setPosition(250, 425);
        sprChampJ2[2].setPosition(250, 587);


        for(int i = 0; i < 2; i++){
            sprChampJ3[i].rotate(-90);
        }

        sprChampJ3[2].setPosition(268, 85);
        sprChampJ3[1].setPosition(425, 85);
        sprChampJ3[0].setPosition(587, 85);

        for(int i = 0; i < 2; i++){
            sprChampJ4[i].rotate(-90);
        }

        sprChampJ3[0].setPosition(765, 587);
        sprChampJ3[1].setPosition(765, 425);
        sprChampJ3[2].setPosition(765, 263);



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

        for(int i = 0; i < 2; i++){
            sprChampJ1[i].rotate(-90);
        }

        sprChampJ1[0].setPosition(736, 233);
        sprChampJ1[1].setPosition(574, 233);
        sprChampJ1[2].setPosition(412, 233);

        for(int i = 0; i < 2; i++){
            sprChampJ2[i].rotate(-90);
        }

        sprChampJ2[0].setPosition(263, 765);
        sprChampJ2[1].setPosition(425, 765);
        sprChampJ2[2].setPosition(587, 765);


        for(int i = 0; i < 2; i++){
            sprChampJ3[i].rotate(-90);
        }

        sprChampJ3[2].setPosition(85, 263);
        sprChampJ3[1].setPosition(85, 425);
        sprChampJ3[0].setPosition(85, 587);

        for(int i = 0; i < 2; i++){
            sprChampJ4[i].rotate(-90);
        }

        sprChampJ3[0].setPosition(263, 85);
        sprChampJ3[1].setPosition(425, 85);
        sprChampJ3[2].setPosition(587, 85);



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

        for(int i = 0; i < 2; i++){
            sprChampJ1[i].rotate(-90);
        }

        sprChampJ1[0].setPosition(233, 262);
        sprChampJ1[1].setPosition(233, 424);
        sprChampJ1[2].setPosition(233, 585);

        for(int i = 0; i < 2; i++){
            sprChampJ2[i].rotate(-90);
        }

        sprChampJ2[0].setPosition(263, 765);
        sprChampJ2[1].setPosition(425, 765);
        sprChampJ2[2].setPosition(587, 765);


        for(int i = 0; i < 2; i++){
            sprChampJ3[i].rotate(-90);
        }

        sprChampJ3[2].setPosition(85, 263);
        sprChampJ3[1].setPosition(85, 425);
        sprChampJ3[0].setPosition(85, 587);

        for(int i = 0; i < 2; i++){
            sprChampJ4[i].rotate(-90);
        }

        sprChampJ3[0].setPosition(263, 85);
        sprChampJ3[1].setPosition(425, 85);
        sprChampJ3[2].setPosition(587, 85);



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

        for(int i = 0; i < 2; i++){
            sprChampJ1[i].rotate(-90);
        }

        sprChampJ1[0].setPosition(263, 767);
        sprChampJ1[1].setPosition(425, 767);
        sprChampJ1[2].setPosition(587, 767);

        for(int i = 0; i < 2; i++){
            sprChampJ2[i].rotate(-90);
        }

        sprChampJ2[0].setPosition(263, 765);
        sprChampJ2[1].setPosition(425, 765);
        sprChampJ2[2].setPosition(587, 765);


        for(int i = 0; i < 2; i++){
            sprChampJ3[i].rotate(-90);
        }

        sprChampJ3[2].setPosition(85, 263);
        sprChampJ3[1].setPosition(85, 425);
        sprChampJ3[0].setPosition(85, 587);

        for(int i = 0; i < 2; i++){
            sprChampJ4[i].rotate(-90);
        }

        sprChampJ3[0].setPosition(263, 85);
        sprChampJ3[1].setPosition(425, 85);
        sprChampJ3[2].setPosition(587, 85);



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
}