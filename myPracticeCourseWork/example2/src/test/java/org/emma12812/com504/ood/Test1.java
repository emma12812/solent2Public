package org.emma12812.com504.ood;

import org.emma12812.com504.ood.MyTestClassLog4j;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Test1 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testofLog()
    {
         MyTestClassLog4j myTestClassLog4j = new MyTestClassLog4j();
       myTestClassLog4j.writeAboutMe();
    }
}
