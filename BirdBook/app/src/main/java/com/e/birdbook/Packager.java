package com.e.birdbook;

public class Packager {

    public static Package pack(Results bir, Package.TYPE t){

        switch(t)
        {
            case BIRD:
                return new Package(bir, t);
                break;

            case INVALID:
            default:
                System.out.println("ERROR: unrecognized type");
                break;
        }

    }
}
