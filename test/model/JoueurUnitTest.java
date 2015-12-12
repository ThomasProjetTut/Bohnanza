package model;

import model.Carte.Carte;
import model.Carte.Carte_Pata_Tecktonik;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 13/11/2015.
 */
public class JoueurUnitTest {

    @Test
    public void TestRecoisMain(){
        Pioche pioche = new Pioche();

        Joueur joueur1 =new Joueur("Henri",1);
        Joueur joueur2 =new Joueur("Henri2",2);

        joueur1.recoisMain(pioche);
        joueur2.recoisMain(pioche);

        Assert.assertNotSame(joueur1, joueur2);
    }

    @Test
    public void TestPiocher(){
        Pioche pioche = new Pioche();

        Joueur joueur1 =new Joueur("Henri",1);

        joueur1.recoisMain(pioche);

        int nbCartes = joueur1.getMain().size();

        joueur1.piocher(pioche);

        Assert.assertNotSame(nbCartes, joueur1.getMain().size());
    }

    /*
    @Test
    public void testPlanter() {
        Pioche pioche = new Pioche();

        Joueur joueur1 =new Joueur("Henri");

        joueur1.recoisMain();

        List<Carte> main = new ArrayList<>();

        for (Carte carte : joueur1.getMain()){
            main.add(carte.clone());
        }

        joueur1.acheterChamps();

        joueur1.planter(1);
        joueur1.planter(2);
        joueur1.planter(3);

        Assert.assertEquals(main.get(0), joueur1.getChamp(1).derniereCarte());
        Assert.assertEquals(main.get(1), joueur1.getChamp(2).derniereCarte());
        Assert.assertEquals(main.get(2), joueur1.getChamp(3).derniereCarte());

        Assert.assertTrue(joueur1.getMain().size() == 1);
    }
    */

    @Test
    public void testDonnerCarte(){
        Joueur joueur=new Joueur("truc",0);
        Carte_Pata_Tecktonik c2= Mockito.mock(Carte_Pata_Tecktonik.class);
        joueur.addCarte(c2);
        Joueur joueur2=new Joueur("machin",1);
        joueur.donnerCarte(c2,joueur2);
        Assert.assertEquals(joueur2.getZoneEchange().getZone().get(0),c2);
    }

    @Test
    public void testRecevoirCarte(){
        Joueur joueur=new Joueur("truc",0);
        Carte_Pata_Tecktonik c2= Mockito.mock(Carte_Pata_Tecktonik.class);
        joueur.recoisCarte(c2);
        Assert.assertEquals(c2,joueur.getZoneEchange().getZone().get(0));
    }
/*
    @Test
    public void testEchangeCarte(){
        Joueur joueur=new Joueur("test",0);
        Joueur joueur1=new Joueur("test1",1);
        Carte_Pata_Tecktonik c2= Mockito.mock(Carte_Pata_Tecktonik.class);
        Carte_Pata_Tecktonik c= Mockito.mock(Carte_Pata_Tecktonik.class);
        joueur.echangeCarte(c2,joueur1,c);
        Assert.assertEquals(c,joueur.getZoneEchange().getZone().get(0));
        Assert.assertEquals(c2,joueur1.getZoneEchange().getZone().get(0));
    }
*/
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
