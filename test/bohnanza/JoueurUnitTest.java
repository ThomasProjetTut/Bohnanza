package bohnanza;

import bohnanza.Carte.Carte;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 13/11/2015.
 */
public class JoueurUnitTest {

    @Test
    public void TestRecoisMain(){
        Jeu jeu = new Jeu();

        Joueur joueur1 =new Joueur("Henri");
        Joueur joueur2 =new Joueur("Henri2");

        joueur1.recoisMain();
        joueur2.recoisMain();

        Assert.assertNotEquals(joueur1, joueur2);
    }

    @Test
    public void TestPiocher(){
        Jeu jeu = new Jeu();

        Joueur joueur1 =new Joueur("Henri");

        joueur1.recoisMain();

        int nbCartes = joueur1.getMain().size();

        joueur1.piocher();

        Assert.assertNotEquals(nbCartes, joueur1.getMain().size());
    }

    /*
    @Test
    public void testJouerCoup(){
        Joueur joueur=new Joueur("test");
        Carte c1=new Carte("1",1,2,3,4);
        Carte c2=new Carte("2",1,2,3,4);
        Carte c3=new Carte("3",1,2,3,4);
        Carte c4=new Carte("4",1,2,3,4);
        ArrayList<Carte> main=new ArrayList<Carte>();
        main.add(c1);
        main.add(c2);
        main.add(c3);
        main.add(c4);
        joueur.recoisMain(main);
        joueur.jouerCoup();
        Assert.assertEquals("1",joueur.getChamp1().haricots.get(0).getNom());
    }
    */
}
