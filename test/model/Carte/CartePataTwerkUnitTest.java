package model.Carte;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CartePataTwerkUnitTest {

    @Test
    public void testCartePataTwerk(){
        Carte_Pata_Twerk carte_pata_twerk = new Carte_Pata_Twerk();
        Map<Integer,Integer> testMap = new HashMap<>();
        testMap.put(4, 1);
        testMap.put(6, 2);
        testMap.put(8, 3);
        testMap.put(10, 4);

        Assert.assertEquals("Pata Twerk", carte_pata_twerk.getNom());
        Assert.assertEquals(20, carte_pata_twerk.getNbMax());
        Assert.assertEquals(testMap, carte_pata_twerk.getPatatometre());
    }

    @Test
    public void testIsPataTwerk(){
        Carte_Pata_Twerk carte_pata_twerk = new Carte_Pata_Twerk();

        Assert.assertTrue(carte_pata_twerk.isPataTwerk());
    }




}
