package bohnanza;

import org.junit.Assert;
import org.junit.Test;

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
    public void TestPlanter(){
        Champ champ=new Champ(1);
        Carte c=new Carte("test",1,2,3,4);
        champ.planter(c);
        Assert.assertEquals("test", champ.haricots.get(0).getNom());
    }

    @Test
    public void TestVerifCarteDuDessous(){
        Carte c1=new Carte("test1",1,2,3,4);
        Carte c2=new Carte("test2",1,2,3,4);
        Carte c3=new Carte("test3",1,2,3,4);
        Carte c4=new Carte("test4",1,2,3,4);
        ArrayList<Carte> list=new ArrayList<Carte>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        Carte c5=new Carte("Test",1,2,3,4);
        Champ champ=new Champ(1,list);
        Assert.assertTrue(champ.CompareDerniereCarte(c5));
    }


}
