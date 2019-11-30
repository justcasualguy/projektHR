package services.generators;

import models.Address;

import java.util.Random;

public class AddressGenerator {
    public static String generateZipCode(){
        String zipcode= "";
        Random rand = new Random();

        for(int i=0;i<6;i++){
            if(i==2)
                zipcode+='-';
            else
                zipcode+=Integer.toString(rand.nextInt(9));
        }
        return zipcode;
    }
    public Address generateAddress(){
        return null;
    }
}
