package bohnanza.Carte;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CartePataTerroristeUnitTest {

    @Test
    public void testCartePataTerroriste(){
        Carte_Pata_Terroriste carte_pata_terroriste = new Carte_Pata_Terroriste();
        Map<Integer,Integer> testMap = new HashMap<>();
        testMap.put(2, 1);
        testMap.put(3, 2);
        testMap.put(4, 3);
        testMap.put(5, 4);

        Assert.assertEquals("Pata Terroriste", carte_pata_terroriste.getNom());
        Assert.assertEquals(8, carte_pata_terroriste.getNbMax());
        Assert.assertEquals(testMap, carte_pata_terroriste.getPatatometre());
    }

    @Test
    public void testIsPataTerroriste(){
        Carte_Pata_Terroriste carte_pata_terroriste = new Carte_Pata_Terroriste();

        Assert.assertTrue(carte_pata_terroriste.isPataTerroriste());
    }




}
