package model;

import model.Carte.Carte;
import org.junit.Assert;
import org.junit.Test;

public class PiocheUnitTest {

    @Test
    public void testInitPioche() {
        Pioche pioche = new Pioche();

        Assert.assertEquals(pioche.getTaillePioche(), 104);
    }

    @Test
    public void testGiveNextCarte() {
        Pioche pioche = new Pioche();

        Carte carte = pioche.getPioche().get(pioche.getTaillePioche()-1);
        Carte carte2 = pioche.giveNextCarte();

        Assert.assertEquals(carte, carte2);
        Assert.assertNotEquals(carte, pioche.giveNextCarte());
    }

    @Test
    public void testVerifTourDePioche() {
        Pioche pioche = new Pioche();



    }
}
