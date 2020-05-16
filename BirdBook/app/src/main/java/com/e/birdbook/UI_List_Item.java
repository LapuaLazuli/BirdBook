package com.e.birdbook;

import android.os.Parcel;
import android.os.Parcelable;

public class UI_List_Item //implements Parcelable
{
    private String birdImage;
    private String birdName;

    public UI_List_Item(String birdImage, String birdName){
        this.birdImage = birdImage;
        this.birdName = birdName;
    }

    public String getBirdImage() {
        return birdImage;
    }

    public String getBirdName() {
        return birdName;
    }


}
