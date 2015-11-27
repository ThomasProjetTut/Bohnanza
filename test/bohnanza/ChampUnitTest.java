package bohnanza;

import bohnanza.Carte.Carte;
import bohnanza.Carte.Carte_Pata_Tecktonik;
import bohnanza.Carte.Carte_Pata_Tentacule;
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
    //Ne fonctionne pas
    public void TestDerniereCarte(){
        Carte_Pata_Tecktonik c1=Mockito.mock(Carte_Pata_Tecktonik.class);
        Mockito.when(c1.getNom()).thenReturn("test");
        ArrayList<Carte> list=new ArrayList<>();
        Champ champ=new Champ(1);
        Assert.assertNull(champ.derniereCarte());
        list.add(c1);
        Assert.assertEquals(champ.derniereCarte().getNom(),"test");
    }

    @Test
    public void TestCompareDerniereCarte(){
        Carte_Pata_Tecktonik c1=Mockito.mock(Carte_Pata_Tecktonik.class);
        Carte_Pata_Tecktonik c2=Mockito.mock(Carte_Pata_Tecktonik.class);
        Carte_Pata_Tentacule c3=Mockito.mock(Carte_Pata_Tentacule.class);
        Mockito.when(c1.isPataTecktonik()).thenReturn(true);
        Mockito.when(c2.isPataTecktonik()).thenReturn(true);
        Mockito.when(c3.isPataTecktonik()).thenReturn(false);
        ArrayList<Carte> list=new ArrayList<>();
        list.add(c1);
        Champ champ=new Champ(1,list);
        Assert.assertTrue(champ.CompareDerniereCarte(c2));
        Assert.assertFalse(champ.CompareDerniereCarte(c3));
    }

    @Test
    public void TestPlanter(){

    }


}
