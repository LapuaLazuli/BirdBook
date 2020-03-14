package com.e.birdbook;

import java.util.Dictionary;

public class Package {
    enum TYPE{INVALID, BIRD}
    private String name, description, finding, habitat, diet, nest, behavior, conservation, size, shape;
    private TYPE type;

    public Package(){type = TYPE.INVALID;}

    public Package(BirdInfoResults bir, TYPE t){
        Dictionary d = bir.getResults();
        setName((String) d.get("name"));
        setDescripton((String) d.get("description"));
        setFinding((String) d.get("finding"));
        setHabitat((String) d.get("habitat"));
        setDiet((String) d.get("diet"));
        setNest((String) d.get("nest"));
        setBehavior((String) d.get("behavior"));
        setConservation((String) d.get("conservation"));
        setShape((String) d.get("shape"));
        setSize((String) d.get("size"));
        this.type = t;
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