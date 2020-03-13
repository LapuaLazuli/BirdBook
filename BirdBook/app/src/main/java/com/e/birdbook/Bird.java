package com.e.birdbook;

public class Bird {
    private String name, description, finding, habitat, diet, nest, behavior, conservation, size, shape;

    public Bird(){}

    public Bird(String name, String description, String finding, String habitat, String diet, String nest, String behavior, String conservation, String size, String shape){
        this.name = name;
        this.description = description;
        this.finding = finding;
        this.habitat = habitat;
        this.diet = diet;
        this.nest = nest;
        this.behavior = behavior;
        this.conservation = conservation;
        this.size = size;
        this.shape = shape;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescripton(String descripton) {
        this.description = descripton;
    }

    public void setFinding(String finding) {
        this.finding = finding;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setNest(String nest) {
        this.nest = nest;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public void setConservation(String conservation) {
        this.conservation = conservation;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFinding() {
        return finding;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    public String getNest() {
        return nest;
    }

    public String getBehavior() {
        return behavior;
    }

    public String getConservation() {
        return conservation;
    }

    public String getSize() {
        return size;
    }

    public String getShape() {
        return shape;
    }
}
