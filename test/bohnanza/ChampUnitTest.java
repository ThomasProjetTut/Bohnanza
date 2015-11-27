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
    public void TestDerniereCarte(){
        Carte_Pata_Tecktonik c1=Mockito.mock(Carte_Pata_Tecktonik.class);
        Mockito.when(c1.getNom()).thenReturn("test");
        Champ champ=new Champ(1);
        Assert.assertNull(champ.derniereCarte());

        ArrayList<Carte> list=new ArrayList<>();
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
        ArrayList<Carte> list=new ArrayList<>();
        list.add(c1);
        Champ champ=new Champ(1,list);
        Assert.assertTrue(champ.CompareDerniereCarte(c2));
        Assert.assertFalse(champ.CompareDerniereCarte(c3));
    }

    @Test
    public void TestPlanter(){
        Champ champ=new Champ(1);
        Carte_Pata_Tecktonik c1=new Carte_Pata_Tecktonik();
        int a=champ.planter(c1);
        Assert.assertEquals(a,0);
        Assert.assertEquals(champ.derniereCarte(),c1);

    }


}
