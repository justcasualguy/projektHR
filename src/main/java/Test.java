import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import generators.AddressGenerator;
import generators.EmployeeGenerator;
import models.Employee;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) {
       for(int i=0;i<5;i++) //ten for cos robi
        System.out.println(AddressGenerator.generateZipCode());
    }


}
