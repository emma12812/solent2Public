package org.solent.com504.factoryandfacade.model;

import java.util.LinkedHashMap;
import java.util.List;

public interface FarmFacade {

    public List<Animal> getAllAnimals();

    public boolean addAnimal(String animalID, String animalType, String name, String address);

    public List<Animal> getAnimalsOfType(String animalID);
    
    public Animal getAnimal(String name);
    
    public boolean removeAnimal(String animalID);
}
