package org.solent.com504.factoryandfacade.model;

import java.util.ArrayList;
import java.util.List;

public class FarmFacadeImpl implements FarmFacade {
    List<Animal> allAnimals = new ArrayList<Animal>();
    @Override
    public List<Animal> getAllAnimals() {
        for (Animal animalList : allAnimals){
            System.out.println(animalList.getName());
        }
        return allAnimals;
    }

    @Override
    public void addDog(String name) {
        Dog newDog = new Dog();
        newDog.setName(name);
        allAnimals.add(newDog);

    }

    @Override
    public void addCat(String name) {
        Cat newCat = new Cat();
        newCat.setName(name);
        allAnimals.add(newCat);
    }

    @Override
    public void addCow(String name) {
        Cow newCow = new Cow();
        newCow.setName(name);
        allAnimals.add(newCow);
    }
}
