package org.solent.com504.  factoryandfacade.impl;

import java.util.*;

import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.FarmFacade;
import org.solent.com504.factoryandfacade.model.FarmObjectFactory;

public class FarmFacadeImpl implements FarmFacade {

    List<Animal> animals = new ArrayList<Animal>();

    FarmObjectFactory farmObjectFactory = null;

    public void setFarmObjectFactory(FarmObjectFactory farmObjectFactory) {
        this.farmObjectFactory = farmObjectFactory;
    }

    @Override
    public boolean addAnimal(String animalID, String animalType, String name, String address) {
        // check if animal with this name already exists. if yes return false
        if (getAnimal(name) != null) {
            return false;
        }

        // if animal doesnt exist add animal to farm
        Animal animal = farmObjectFactory.createAnimal(animalType);
        animal.setName(name);
        animal.setAddress(address);
        animal.setID(animalID);
        animals.add(animal);
        return true;
    }

    @Override
    public List<Animal> getAllAnimals() {

        // return a copy of the list in case it is changed and to avoid it being changed
        return new ArrayList<Animal>(animals);
    }

    @Override
    public List<Animal> getAnimalsOfType(String animalType) {

        List<Animal> animalList = new ArrayList<Animal>();

        for (Animal animal : animals) {
            if (animal.getAnimalType().equals(animalType)) {
                animalList.add(animal);
            }
        }

        return animalList;
    }

    @Override
    public Animal getAnimal(String name) {
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean removeAnimal(String animalID) {
        // iterate through animal list and remove entry corresponding to name
        ListIterator<Animal> animalIterator = animals.listIterator();
        while (animalIterator.hasNext()) {
            Animal animal = animalIterator.next();
            if (animalID.equals(animal.getAnimalID())) {
                animalIterator.remove();
                return true;
            }
        }
        return false;
    }
}
