package com.e.birdbook;

public class Packager {

    public static Package pack(BirdInfoResults bir, Package.TYPE t){

        return new Package(bir, t);
    }
}
