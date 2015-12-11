package model.Carte;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CartePataTequillaUnitTest {

    @Test
    public void testCartePataTequilla(){
        Carte_Pata_Tequilla carte_pata_tequilla = new Carte_Pata_Tequilla();
        Map<Integer,Integer> testMap = new HashMap<Integer,Integer>();
        testMap.put(3, 1);
        testMap.put(5, 2);
        testMap.put(7, 3);
        testMap.put(8, 4);

        Assert.assertEquals("Pata Tequilla", carte_pata_tequilla.getNom());
        Assert.assertEquals(16, carte_pata_tequilla.getNbMax());
        Assert.assertEquals(testMap, carte_pata_tequilla.getPatatometre());
    }

    @Test
    public void testIsPataTequilla(){
        Carte_Pata_Tequilla carte_pata_tequilla = new Carte_Pata_Tequilla();

        Assert.assertTrue(carte_pata_tequilla.isPataTequilla());
    }




}
