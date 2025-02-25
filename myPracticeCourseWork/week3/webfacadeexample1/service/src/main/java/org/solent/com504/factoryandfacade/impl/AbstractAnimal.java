package org.solent.com504.factoryandfacade.impl;

import org.solent.com504.factoryandfacade.model.Animal;

public abstract class AbstractAnimal implements Animal {
    
    String name = null;
    String address = null;
    String animalID = null;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getAddress(){
        return address;
    }
    @Override
    public void setAddress(String address){
        this.address = address;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setID(String animalID){
        this.animalID = animalID;
    }
    @Override
    public String getAnimalID(){return  animalID;}
    // Abstract methods
    
    @Override
    public abstract String getSound();
    
    @Override
    public abstract String getAnimalType();

    @Override
    public String toString() {
        return "AbstractAnimal{" + "name=" + name 
                + " type="+getAnimalType()
                + " sound="+getSound()
                + "}";
    }

    
 
    
}
