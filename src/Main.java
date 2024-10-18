import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            // Create JAXB context and unmarshaller
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal XML to Java object
            File xmlFile = new File("src/data.xml");
            Employees employees = (Employees) unmarshaller.unmarshal(xmlFile);

            // Print all employees
            for (Employee employee : employees.getEmployeeList()) {
                System.out.println(employee);
            }

            // Example: Injecting a new value into the second employee
            Employee secondEmployee = employees.getEmployeeList().get(1);
            secondEmployee.setName("Alice Johnson");

            System.out.println("After injection:");
            System.out.println(secondEmployee);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
