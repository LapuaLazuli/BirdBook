package com.e.birdbook;

public class UI_List_Item {
    private int birdImage;
    private String birdName;

    public UI_List_Item(int birdImage, String birdName){
        this.birdImage = birdImage;
        this.birdName = birdName;
    }

    public int getBirdImage() {
        return birdImage;
    }

    public String getBirdName() {
        return birdName;
    }
}
