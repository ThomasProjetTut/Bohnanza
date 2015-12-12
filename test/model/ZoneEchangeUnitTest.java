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

}
