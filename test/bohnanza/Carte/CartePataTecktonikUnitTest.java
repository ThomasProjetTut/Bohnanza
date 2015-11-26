package bohnanza.Carte;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CartePataTecktonikUnitTest {

    @Test
    public void testCartePataTecktonik(){
        Carte_Pata_Tecktonik carte_pata_tecktonik = new Carte_Pata_Tecktonik();
        Map<Integer,Integer> testMap = new HashMap<>();
        testMap.put(2,2);
        testMap.put(3,3);

        Assert.assertEquals("Pata Tecktonik", carte_pata_tecktonik.getNom());
        Assert.assertEquals(6,carte_pata_tecktonik.getNbMax());
        Assert.assertEquals(testMap, carte_pata_tecktonik.getPatatometre());
    }

    @Test
    public void testIsPataTecktonik(){
        Carte_Pata_Tecktonik carte_pata_tecktonik = new Carte_Pata_Tecktonik();

        Assert.assertTrue(carte_pata_tecktonik.isPataTecktonik());
    }




}
