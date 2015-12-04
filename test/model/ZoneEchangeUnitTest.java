package model;

import model.Carte.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


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
        Zone zone1=new Zone();
        Carte_Pata_Tecktonik c1= Mockito.mock(Carte_Pata_Tecktonik.class);
        zone.ajouterCarte(c1);
        zone.donnerCarte(c1,zone1);
        Assert.assertEquals(c1,zone1.getZone().get(0));
    }

    @Test
    public void testEchangerCarte(){
        Zone zone=new Zone();
        Zone zone1=new Zone();
        Carte_Pata_Tecktonik c1= Mockito.mock(Carte_Pata_Tecktonik.class);
        Carte_Pata_Tecktonik c2= Mockito.mock(Carte_Pata_Tecktonik.class);
        zone.ajouterCarte(c1);
        zone1.ajouterCarte(c2);
        zone.echangerCarte(c1,zone1,c2);
        Assert.assertEquals(c1, zone1.getZone().get(0));
        Assert.assertEquals(c2,zone.getZone().get(0));


    }

}
