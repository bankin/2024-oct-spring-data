package bg.softuni;

import bg.softuni.entities.dtos.EmployeeDTO;
import bg.softuni.services.EmployeeService;
import bg.softuni.services.ManagerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final ManagerService managerService;

    public Main(EmployeeService employeeService, ManagerService managerService) {
        this.employeeService = employeeService;
        this.managerService = managerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int bornBefore = Integer.parseInt(scanner.nextLine());

//        List<EmployeeDTO> result = employeeService.findEmployeesBornBefore(bornBefore);
//        List<EmployeeDTO> result = employeeService.findAllWithManager();

        List<EmployeeDTO> result = managerService.findAllManagers();

//        CreateEmployeeDTO
//        employeeService.create()

        System.out.println(result);
    }
}
