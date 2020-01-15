import models.Address;
import models.Employee;
import models.JobPosition;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import services.generators.DocumentGenerator;

import javax.xml.bind.JAXBElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Test {


    private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
        List<Object> result = new ArrayList<Object>();
        if (obj instanceof JAXBElement) obj = ((JAXBElement<?>) obj).getValue();

        if (obj.getClass().equals(toSearch))
            result.add(obj);
        else if (obj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) obj).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }

        }
        return result;
    }

    private static void writeDocxToStream(WordprocessingMLPackage template, String target) throws IOException, Docx4JException {
        File f = new File(target);
        template.save(f);
    }

    public static void main(String[] args) {

        Employee employee = new Employee("Jan", "Kowalski", "nieistotne", "12-12-2018"
                , new JobPosition("12-12-2018", "12-12-2018", "sprzątacz", "czystości"),
                new Address("Polska", "Warszawa", "Przeworska", "3", "21-530"),
                null, null, null);
        String templatePath = "C:\\Users\\kubac\\Desktop\\Generowanie dokumentow\\test.docx";
        String documentName = "test2.docx";


        DocumentGenerator.generateEmploymentContract(employee, templatePath, documentName, null);


    }
}