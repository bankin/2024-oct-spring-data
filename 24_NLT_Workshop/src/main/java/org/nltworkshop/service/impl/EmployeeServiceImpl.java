package org.nltworkshop.service.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.modelmapper.ModelMapper;
import org.nltworkshop.data.entities.Employee;
import org.nltworkshop.data.entities.Project;
import org.nltworkshop.data.repositories.EmployeeRepository;
import org.nltworkshop.data.repositories.ProjectRepository;
import org.nltworkshop.service.EmployeeService;
import org.nltworkshop.service.model.imports.EmployeeImportModel;
import org.nltworkshop.service.model.imports.EmployeeRootImportModel;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String FILE_PATH = "src/main/resources/files/xmls/employees.xml";

    private final ModelMapper modelMapper;
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(ModelMapper modelMapper, ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean isImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public void seedData() throws JAXBException, IOException {
        XmlMapper xmlMapper = new XmlMapper();

        EmployeeRootImportModel employeeRootImportModel =
            xmlMapper.readValue(readFile(), EmployeeRootImportModel.class);

        employeeRootImportModel.getEmployees().forEach(this::saveToDB);
    }

    private String saveToDB(EmployeeImportModel employeeImportModel) {
        Employee forDB = this.modelMapper.map(employeeImportModel, Employee.class);

        Optional<Project> project =
                this.projectRepository.findByName(employeeImportModel.getProject().getName());

        if (project.isEmpty()) {
            return "Invalid Employee. Project not found";
        }

        forDB.setProject(project.get());
        this.employeeRepository.save(forDB);

        return "Successfully inserted Employee";
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String getEmployeesAbove25() {
        List<Employee> byAgeGreaterThan = this.employeeRepository.findByAgeGreaterThan(25);

        return byAgeGreaterThan
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
    }
}
