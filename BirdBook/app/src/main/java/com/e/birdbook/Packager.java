package com.e.birdbook;

public class Packager {

    public static Package pack(Results bir, Package.TYPE t){

        Package resultPackage = null;
        switch(t)
        {
            case BIRD:
                resultPackage = new Package(bir, t);
                break;

            case INVALID:
            default:
                System.out.println("ERROR: unrecognized type");
                break;
        }

        return resultPackage;
    }
}
