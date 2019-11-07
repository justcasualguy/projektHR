package generators;

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

    public static Employee generateEmployee(){
        File file1 = new File("");
        String path = file1.getAbsolutePath()+"\\src\\main\\java\\generators\\data\\";
        file1 = new File(path+"maleNames.txt");
        File file2 = new File(path+"lastNames.txt");

        return  new Employee(generateValueFromTextFile(file1.getAbsolutePath()),generateValueFromTextFile(file2.getAbsolutePath()),generateBirthDate());
    }



}
