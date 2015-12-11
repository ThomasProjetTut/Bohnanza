package model.Carte;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CartePataTetenucleaireUnitTest {

    @Test
    public void testCartePataTetenucleaire(){
        Carte_Pata_Tetenucleaire carte_pata_tetenucleaire = new Carte_Pata_Tetenucleaire();
        Map<Integer,Integer> testMap = new HashMap<>();
        testMap.put(2, 1);
        testMap.put(4, 2);
        testMap.put(6, 3);
        testMap.put(7, 4);

        Assert.assertEquals("Pata Tetenucleaire", carte_pata_tetenucleaire.getNom());
        Assert.assertEquals(12, carte_pata_tetenucleaire.getNbMax());
        Assert.assertEquals(testMap, carte_pata_tetenucleaire.getPatatometre());
    }

    @Test
    public void testIsPataTetenucleaire(){
        Carte_Pata_Tetenucleaire carte_pata_tetenucleaire = new Carte_Pata_Tetenucleaire();

        Assert.assertTrue(carte_pata_tetenucleaire.isPataTetenucleaire());
    }




}
