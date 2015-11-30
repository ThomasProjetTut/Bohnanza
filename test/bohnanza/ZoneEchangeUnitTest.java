package bohnanza;

import bohnanza.Carte.Carte;
import bohnanza.Carte.Carte_Pata_Tecktonik;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Created by Maxime on 30/11/2015.
 */
public class ZoneEchangeUnitTest {

    @Test
    public void testZoneEchange(){
        Zone zone = new Zone();
    }

    @Test
    public void testAjouterCarte(){
        Zone zone=new Zone();
        Carte_Pata_Tecktonik c1= Mockito.mock(Carte_Pata_Tecktonik.class);
        zone.ajouterCarte(c1);
        Assert.assertEquals(c1,zone.getZone().get(0));
    }

    @Test
    public void testDonnerCarte(){
        Zone zone=new Zone();
        Carte_Pata_Tecktonik c1= Mockito.mock(Carte_Pata_Tecktonik.class);
        zone.ajouterCarte(c1);
        Carte don=zone.donnerCarte(c1);
        Assert.assertEquals(c1,don);
    }

}
