package services.generators;

import models.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;

public class EmployeeGenerator {
    private Employee employee;

    public static int countLines(String filePath){
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static String generateValueFromTextFile(String dataFilePath){
        String value="";
        Random rand = new Random();

        int i=0;
        try {
            FileReader fileReader = new FileReader(dataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int random = rand.nextInt(countLines(dataFilePath));
            while(i<=random) {
                try {
                    value = bufferedReader.readLine();
                } catch (IOException e) {
                    System.out.println(e);
                    return "Generation error";
                }
                i++;
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
            return "No such file";
        }
    return value;
    }


    public static LocalDate  generateBirthDate(){
        int day;
        int month;
        int year;
        Random rand = new Random();

        year = rand.nextInt(52)+1949;
        month = rand.nextInt(11)+1;

        if(month==2)
            day = rand.nextInt(27)+1;
        else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
             day = rand.nextInt(30)+1;
        else
            day = rand.nextInt(29)+1;

        return LocalDate.of(year,month,day);
}


    public static Employee generateManEmployee(){
        File names = new File("");
        String path = names.getAbsolutePath()+"\\src\\main\\java\\services.generators\\data\\";
        names = new File(path+"maleNames.txt");
        File surnames = new File(path+"lastNames.txt");

        return  new Employee(
                generateValueFromTextFile(names.getAbsolutePath()),
                generateValueFromTextFile(surnames.getAbsolutePath()),
                generateBirthDate()
        );
    }

    public static Employee generateWomanEmployee(){
        File names = new File("");
        String path = names.getAbsolutePath()+"\\src\\main\\java\\services.generators\\data\\";
        names = new File(path+"femaleNames.txt");
        File surnames = new File(path+"lastNames.txt");

        String surname = generateValueFromTextFile(surnames.getAbsolutePath());

        StringBuilder builder = new StringBuilder(surname);

        if(surname.charAt(surname.length()-1)=='i')
            builder.setCharAt(builder.length()-1,'a');

        return  new Employee(
                generateValueFromTextFile(names.getAbsolutePath()),
                builder.toString(),
                generateBirthDate()
        );
    }



    public static String generateWomanPersonalIdentityNumber() {
        String pesel="";
        Random generator = new Random();
        for(int i=0;i<12;i++) {
            //rok
            if(i==0) {
                pesel+=String.valueOf(generator.nextInt(7)+2);
            }
            else if(i==1) {
                if(pesel.charAt(0)!='2')
                    pesel+=String.valueOf(generator.nextInt(7)+2);
                else
                    pesel+=String.valueOf(generator.nextInt(9));
            }
            //msc

            else if(i==2)
                pesel+=String.valueOf(generator.nextInt(1));
            else if(i==3) {
                if(pesel.charAt(2)=='1')
                    pesel+=String.valueOf(generator.nextInt(2));
                else
                    pesel+=String.valueOf(generator.nextInt(9)+1);
            }
            //dzien
            else if(i==4) {
                if(pesel.charAt(3)=='2')
                    pesel+=String.valueOf(generator.nextInt(2));
                else
                    pesel+=String.valueOf(generator.nextInt(3));
            }
            else if(i==5) {
                if(pesel.charAt(3)=='2')
                    pesel+=String.valueOf(generator.nextInt(8));
                else if(pesel.charAt(4)=='3'&&(pesel.charAt(3)=='1'||pesel.charAt(3)=='3'||pesel.charAt(3)=='5'
                        ||pesel.charAt(3)=='7'||pesel.charAt(3)=='8'||pesel.charAt(3)=='0'||(pesel.charAt(3)=='2'&&pesel.charAt(2)=='1')))
                    pesel+=String.valueOf(generator.nextInt(1));
                else if(pesel.charAt(4)=='3')
                    pesel+='0';
                else
                    pesel+=String.valueOf(generator.nextInt(9));


            }
            else if(i==10) {
                int x;
                do {
                    x=generator.nextInt(9);
                }while(x%2!=0);
                pesel+=String.valueOf(x);


            }
            else {
                pesel+=String.valueOf(generator.nextInt(9));
            }
        }

        return pesel;
    }

    public static String generateManPersonalIdentityNumber() {
        String pesel="";
        Random generator = new Random();
        for(int i=0;i<12;i++) {
            //rok
            if(i==0) {
                pesel+=String.valueOf(generator.nextInt(7)+2);
            }
            else if(i==1) {
                if(pesel.charAt(0)!='2')
                    pesel+=String.valueOf(generator.nextInt(7)+2);
                else
                    pesel+=String.valueOf(generator.nextInt(9));
            }
            //msc

            else if(i==2)
                pesel+=String.valueOf(generator.nextInt(1));
            else if(i==3) {
                if(pesel.charAt(2)=='1')
                    pesel+=String.valueOf(generator.nextInt(2));
                else
                    pesel+=String.valueOf(generator.nextInt(9)+1);
            }
            //dzien
            else if(i==4) {
                if(pesel.charAt(3)=='2')
                    pesel+=String.valueOf(generator.nextInt(2));
                else
                    pesel+=String.valueOf(generator.nextInt(3));
            }
            else if(i==5) {
                if(pesel.charAt(3)=='2')
                    pesel+=String.valueOf(generator.nextInt(8));
                else if(pesel.charAt(4)=='3'&&(pesel.charAt(3)=='1'||pesel.charAt(3)=='3'||pesel.charAt(3)=='5'
                        ||pesel.charAt(3)=='7'||pesel.charAt(3)=='8'||pesel.charAt(3)=='0'||(pesel.charAt(3)=='2'&&pesel.charAt(2)=='1')))
                    pesel+=String.valueOf(generator.nextInt(1));
                else if(pesel.charAt(4)=='3')
                    pesel+='0';
                else
                    pesel+=String.valueOf(generator.nextInt(9));


            }
            else if(i==10) {
                int x;
                do {
                    x=generator.nextInt(9);
                }while(x%2==0);
                pesel+=String.valueOf(x);


            }
            else {
                pesel+=String.valueOf(generator.nextInt(9));
            }
        }

        return pesel;
    }


}
