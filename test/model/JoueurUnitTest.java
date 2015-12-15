package model;

import model.Carte.Carte;
import model.Carte.Carte_Pata_Tecktonik;
import model.Carte.Carte_Pata_Testosterone;
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

    @Test
    public void testAcheterChamps() {
        Pioche pioche = new Pioche();

        Joueur joueur1 =new Joueur();

        joueur1.acheterChamps(pioche);
        Assert.assertEquals(joueur1.getMaxChamps(), 2);

        joueur1.addThunes(new Carte_Pata_Testosterone());
        joueur1.addThunes(new Carte_Pata_Testosterone());
        joueur1.addThunes(new Carte_Pata_Testosterone());
        joueur1.addThunes(new Carte_Pata_Testosterone());
        joueur1.addThunes(new Carte_Pata_Testosterone());

        joueur1.acheterChamps(pioche);
        Assert.assertEquals(joueur1.getMaxChamps(), 3);
    }

    @Test
    public void testPlanter() {
        Pioche pioche = new Pioche();

        Joueur joueur1 =new Joueur();

        joueur1.recoisMain(pioche);

        List<Carte> main = new ArrayList<>(joueur1.getMain());

        joueur1.planter(1, pioche);
        joueur1.planter(2, pioche);

        Assert.assertEquals(main.get(0), joueur1.getChamp(1).derniereCarte());
        Assert.assertEquals(main.get(1), joueur1.getChamp(2).derniereCarte());

        Assert.assertTrue(joueur1.getMain().size() != main.size());
    }

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

    @Test
    public void testEchangeCarteMainMain(){

        Joueur joueur=new Joueur("test",0);
        Joueur joueur1=new Joueur("test1",1);

        Carte_Pata_Tecktonik c2= Mockito.mock(Carte_Pata_Tecktonik.class);
        Carte_Pata_Tecktonik c= Mockito.mock(Carte_Pata_Tecktonik.class);

        joueur.echangeCarteMainMain(c2, joueur1, c);

        Assert.assertEquals(c, joueur.getZoneEchange().getZone().get(0));
        Assert.assertEquals(c2, joueur1.getZoneEchange().getZone().get(0));
    }

    @Test
    public void testEchangeCartePiocheMain(){

        Joueur joueur=new Joueur("test",0);

        Carte_Pata_Tecktonik c2= Mockito.mock(Carte_Pata_Tecktonik.class);
        Carte_Pata_Tecktonik c= Mockito.mock(Carte_Pata_Tecktonik.class);

        joueur.echangeCartePiocheMain(c2, joueur, c);

        Assert.assertEquals(c2, joueur.getZoneEchange().getZone().get(0));
        Assert.assertEquals(c, joueur.getZoneEchange().getZone().get(1));
    }

    @Test
    public void testHavecarteInMain(){

        Joueur joueur=new Joueur("test",0);

        Carte_Pata_Tecktonik c2= Mockito.mock(Carte_Pata_Tecktonik.class);
        joueur.addCarte(c2);

        Assert.assertTrue(joueur.haveCarteInMain(c2.getIdCarte()));
    }

    @Test
    public void testFindCarteById(){

        Joueur joueur=new Joueur("test",0);

        Carte_Pata_Tecktonik c2= Mockito.mock(Carte_Pata_Tecktonik.class);
        joueur.addCarte(c2);

        Assert.assertEquals(c2, joueur.findCarteById(c2.getIdCarte()));
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
