package model.Carte;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CartePataTestosteroneUnitTest {

    @Test
    public void testCartePataTestosterone(){
        Carte_Pata_Testosterone carte_pata_testosterone = new Carte_Pata_Testosterone();
        Map<Integer,Integer> testMap = new HashMap<>();
        testMap.put(3, 1);
        testMap.put(5, 2);
        testMap.put(6, 3);
        testMap.put(7, 4);

        Assert.assertEquals("Pata Testosterone", carte_pata_testosterone.getNom());
        Assert.assertEquals(14, carte_pata_testosterone.getNbMax());
        Assert.assertEquals(testMap, carte_pata_testosterone.getPatatometre());
    }

    @Test
    public void testIsPataTestosterone(){
        Carte_Pata_Testosterone carte_pata_testosterone = new Carte_Pata_Testosterone();

        Assert.assertTrue(carte_pata_testosterone.isPataTestosterone());
    }




}
