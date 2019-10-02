package org.solent.com504.factoryandfacade.model;

public class Duck implements Animal {

    private String name;

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSound() {
        return "Quack";
    }

}
