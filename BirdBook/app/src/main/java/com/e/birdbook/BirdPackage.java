package com.e.birdbook;

import java.util.Dictionary;

public class BirdPackage implements Package
{

    private String name, description, finding, habitat, diet, nest,
                    behavior, conservation, size, shape, imageURL, color;
    private Request.TYPE type;

    public BirdPackage(){type = Request.TYPE.INVALID;}

    public BirdPackage(Results bir){
        Dictionary<String, String> d = bir.getResults();
        setName(d.get("name"));
        setDescripton(d.get("description"));
        setFinding(d.get("finding"));
        setHabitat(d.get("habitat"));
        setDiet(d.get("diet"));
        setNest(d.get("nest"));
        setBehavior(d.get("behavior"));
        setConservation(d.get("conservation"));
        setShape(d.get("shape"));
        setSize(d.get("size"));
        setImageURL(d.get("image"));
        setColor(d.get("color"));
        this.type = Request.TYPE.BIRD;
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

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    public void setColor(String color) {
        this.color = color;
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

    public String getImageURL() { return this.imageURL; }

    public String getColor() {
        return color;
    }

    public Request.TYPE getType(){
        return type;
    }
}
