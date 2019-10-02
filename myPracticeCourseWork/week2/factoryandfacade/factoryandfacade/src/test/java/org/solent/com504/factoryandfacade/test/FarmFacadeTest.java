package org.solent.com504.factoryandfacade.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author cgallen
 */
public class FarmFacadeTest {

    @Test
    public void FarmFacadeTest() {

        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        assertNotNull(farmFacade);

    }
    @Test
    public void addingDog(){
        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        farmFacade.addDog("tom");

    }

    @Test
    public void addingCat(){
        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        farmFacade.addCat("jess");
    }
    @Test
    public void addingCow(){
        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        farmFacade.addCow("jack");
    }
    @Test
    public void listingAnimals(){
        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        farmFacade.addCow("moo");
        farmFacade.getAllAnimals();
    }
}
