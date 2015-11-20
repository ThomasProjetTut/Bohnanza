package bohnanza;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Maxime on 13/11/2015.
 */
public class JoueurUnitTest {
    @Test
    public void TestJoueur(){
        Joueur joueur=new Joueur("TestJoueur");

    }

    @Test
    public void TestRecoisMain(){
        Joueur joueur=new Joueur("Henri");
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
        Assert.assertEquals(c1, joueur.getMain().get(0));
        Assert.assertEquals(c2, joueur.getMain().get(1));
        Assert.assertEquals(c3, joueur.getMain().get(2));
        Assert.assertEquals(c4, joueur.getMain().get(3));

    }
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
}
