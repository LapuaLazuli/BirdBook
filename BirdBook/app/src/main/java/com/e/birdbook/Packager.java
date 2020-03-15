package com.e.birdbook;

public class Packager {

    public static BirdPackage pack(Results bir){

        BirdPackage resultPackage = null;
        switch(bir.getType())
        {
            case BIRD:
                resultPackage = new BirdPackage(bir);
                break;

            case BIRDLIST:
                resultPackage = new BirdListPackage(bir);
                break;

            case INVALID:
            default:
                System.out.println("ERROR: unrecognized type");
                break;
        }

        return resultPackage;
    }
}
