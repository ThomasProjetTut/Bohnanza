package bohnanza.Carte;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CartePataTentaculeUnitTest {

    @Test
    public void testCartePataTentacule(){
        Carte_Pata_Tentacule carte_pata_tentacule = new Carte_Pata_Tentacule();
        Map<Integer,Integer> testMap = new HashMap<>();
        testMap.put(3, 1);
        testMap.put(6, 2);
        testMap.put(8, 3);
        testMap.put(9, 4);

        Assert.assertEquals("Pata Tentacule", carte_pata_tentacule.getNom());
        Assert.assertEquals(18, carte_pata_tentacule.getNbMax());
        Assert.assertEquals(testMap, carte_pata_tentacule.getPatatometre());
    }

    @Test
    public void testIsPataTentacule(){
        Carte_Pata_Tentacule carte_pata_tentacule = new Carte_Pata_Tentacule();

        Assert.assertTrue(carte_pata_tentacule.isPataTentacule());
    }




}
