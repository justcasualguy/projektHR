package services.generators;

import models.Employee;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DocumentGenerator {
    public static void generateEmploymentContract(Employee employee,String templatePath,String documentName, String parametersDecriberPath){
        HashMap<String, String> parameters; //name, surname,address, pesel,jobposition,salary ,working since
        String nameParameter = "imiePracownika";
        String surnameParameter = "nazwiskoPracownika";
        String addressParameter = "adresPracownika";
        String personalIdentityNumberParamater = "peselPracownika";
        String jobPositionParameter = "stanowiskoPracownika";
        String salaryParameter  = "wynagrodzeniePracownika";
        String workingSinceParameter = "dzienRozpoczeciaPracy";

        Jc justification = new Jc();
        justification.setVal(JcEnumeration.CENTER);

        WordprocessingMLPackage template=null;
        try {
            template = WordprocessingMLPackage.load(new FileInputStream(new File(templatePath)));
        }
        catch (Exception e){

        }
        List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);
        for( Object o : texts)
        {
            Text t = (Text)o;
            if(((Text)o).getValue().equals(nameParameter))
                ((Text) o).setValue(employee.getName());

           else if(((Text)o).getValue().equals(surnameParameter)) {
                ((Text) o).setValue(employee.getSurname());
                ((P) ((R) ((Text) o).getParent()).getParent()).getPPr().setJc(justification);
            }
            else if(((Text)o).getValue().equals(addressParameter)) {
                ((Text) o).setValue(employee.getAddress().toString());
                   ((P) ((R) ((Text) o).getParent()).getParent()).getPPr().setJc(justification);
               }

            else if(((Text)o).getValue().equals(personalIdentityNumberParamater)) {
                ((Text) o).setValue(employee.getPersonalIdentityNumber());
                ((P) ((R) ((Text) o).getParent()).getParent()).getPPr().setJc(justification);
            }

            else  if(((Text)o).getValue().equals(jobPositionParameter))
                ((Text) o).setValue(employee.getJobPosition().getPositionName());

            else  if(((Text)o).getValue().equals(salaryParameter))
                ((Text) o).setValue(employee.getSalary());

            else if(((Text)o).getValue().equals(workingSinceParameter))
                ((Text) o).setValue(employee.getEmployedSince());

        }
        try {
            writeDocxToStream(template, "C:\\Users\\kubac\\Desktop\\Generowanie dokumentow\\testtt2.docx");
        }
        catch(Exception e){}
    }



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


}
