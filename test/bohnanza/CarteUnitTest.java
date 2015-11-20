package bohnanza;

import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractCollection;

/**
 * Created by Maxime on 13/11/2015.
 */
public class CarteUnitTest {

    @Test
    public void testCarte(){
        Carte carte=new Carte("testcarte",1,2,3,4);
        Carte carte1=new Carte("test2",1,2,3,4);
        Assert.assertTrue(carte.compareInstance(carte1));
    }




}
