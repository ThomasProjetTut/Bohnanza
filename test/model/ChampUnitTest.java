package model;

import model.Carte.Carte;
import model.Carte.Carte_Pata_Tecktonik;
import model.Carte.Carte_Pata_Tentacule;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

/**
 * Created by Maxime on 13/11/2015.
 */
public class ChampUnitTest {

    @Test
    public void TestChamp(){
        Champ champ = new Champ(1);
    }

    @Test
    public void TestDerniereCarte(){
        Carte_Pata_Tecktonik c1=Mockito.mock(Carte_Pata_Tecktonik.class);
        Mockito.when(c1.getNom()).thenReturn("test");
        Champ champ=new Champ(1);
        Assert.assertNull(champ.derniereCarte());

        ArrayList<Carte> list=new ArrayList<Carte>();
        list.add(c1);
        Champ champ1=new Champ(1,list);
        Assert.assertEquals(champ1.derniereCarte().getNom(),"test");
    }

    @Test
    public void TestCompareDerniereCarte(){
        Carte_Pata_Tecktonik c1=Mockito.mock(Carte_Pata_Tecktonik.class);
        Carte_Pata_Tecktonik c2=Mockito.mock(Carte_Pata_Tecktonik.class);
        Carte_Pata_Tentacule c3=Mockito.mock(Carte_Pata_Tentacule.class);
        Mockito.when(c1.isPataTecktonik()).thenReturn(true);
        Mockito.when(c2.isPataTecktonik()).thenReturn(true);
        Mockito.when(c3.isPataTecktonik()).thenReturn(false);
        ArrayList<Carte> list=new ArrayList<Carte>();
        list.add(c1);
        Champ champ=new Champ(1,list);
        //Comparer une carte de la meme instance
        Assert.assertTrue(champ.CompareDerniereCarte(c2));
        //Comparer une carte différente
        Assert.assertFalse(champ.CompareDerniereCarte(c3));
    }

    @Test
    public void TestPlanter(){
        //Planter lorsqu'un champ est vide
        Champ champ=new Champ(1);
        Carte_Pata_Tecktonik c1=new Carte_Pata_Tecktonik();
        int a=champ.planter(c1);
        Assert.assertEquals(a,0);
        Assert.assertEquals(champ.derniereCarte(),c1);

        //Planter lorsqu'une carte est deja planter
            // De la meme instance
        Carte_Pata_Tecktonik c3=new Carte_Pata_Tecktonik();
        ArrayList<Carte> list=new ArrayList<Carte>();
        list.add(c3);
        Champ champ2=new Champ(2,list);
        Carte_Pata_Tecktonik c2=new Carte_Pata_Tecktonik();
        int b =champ2.planter(c2);
        Assert.assertEquals(b,0);
        Assert.assertEquals(champ2.derniereCarte(),c2);

            // Instance differente
        Carte_Pata_Tecktonik c4=new Carte_Pata_Tecktonik();
        ArrayList<Carte> list3=new ArrayList<Carte>();
        list3.add(c4);
        Champ champ1=new Champ(1,list3);
        Carte_Pata_Tentacule c5=new Carte_Pata_Tentacule();
        champ1.planter(c5);
        Assert.assertEquals(c5,champ1.derniereCarte());

            //Instance differente et 4 carte deja de plantees
        Carte_Pata_Tecktonik c6 = new Carte_Pata_Tecktonik();
        Carte_Pata_Tecktonik c7 = new Carte_Pata_Tecktonik();
        ArrayList<Carte> list4=new ArrayList<Carte>();
        list4.add(c6);
        list4.add(c7);
        Champ champ3=new Champ(3,list4);
        Carte_Pata_Tentacule c8=new Carte_Pata_Tentacule();
        Assert.assertEquals(c7,champ3.derniereCarte());
        int d=champ3.planter(c8);
        Assert.assertEquals(2,d);
        Assert.assertEquals(c8,champ3.derniereCarte());

    }

    /* A REFAIRE !!!!
    @Test
    public void TestRecolterChamp(){
        Carte_Pata_Tecktonik c1 = new Carte_Pata_Tecktonik();
        Carte_Pata_Tecktonik c2 = new Carte_Pata_Tecktonik();
        Carte_Pata_Tecktonik c3 = new Carte_Pata_Tecktonik();
        Carte_Pata_Tecktonik c4 = new Carte_Pata_Tecktonik();
        Carte_Pata_Tecktonik c5 = new Carte_Pata_Tecktonik();
        ArrayList<Carte> list=new ArrayList<Carte>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        Champ champ=new Champ(1,list);
        int a =champ.recolter();
        Assert.assertEquals(3,a);
        Assert.assertEquals(c2,champ.derniereCarte());
    }
    */

}
