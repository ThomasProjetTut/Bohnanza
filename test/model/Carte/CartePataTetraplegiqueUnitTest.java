package model.Carte;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CartePataTetraplegiqueUnitTest {

    @Test
    public void testCartePataTetraplegique(){
        Carte_Pata_Tetraplegique carte_pata_tetraplegique = new Carte_Pata_Tetraplegique();
        Map<Integer,Integer> testMap = new HashMap<>();
        testMap.put(2, 1);
        testMap.put(4, 2);
        testMap.put(5, 3);
        testMap.put(6, 4);

        Assert.assertEquals("Pata Tetraplegique", carte_pata_tetraplegique.getNom());
        Assert.assertEquals(10, carte_pata_tetraplegique.getNbMax());
        Assert.assertEquals(testMap, carte_pata_tetraplegique.getPatatometre());
    }

    @Test
    public void testIsPataTetraplegique(){
        Carte_Pata_Tetraplegique carte_pata_tetraplegique = new Carte_Pata_Tetraplegique();

        Assert.assertTrue(carte_pata_tetraplegique.isPataTetraplegique());
    }




}
