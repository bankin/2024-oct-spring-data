package org.nltworkshop.service.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.modelmapper.ModelMapper;
import org.nltworkshop.data.entities.Company;
import org.nltworkshop.data.entities.Project;
import org.nltworkshop.data.repositories.CompanyRepository;
import org.nltworkshop.data.repositories.ProjectRepository;
import org.nltworkshop.service.ProjectService;
import org.nltworkshop.service.model.imports.ProjectImportModel;
import org.nltworkshop.service.model.imports.ProjectRootImportModel;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {


    private static final String FILE_PATH = "src/main/resources/files/xmls/projects.xml";


    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isImported() {
        return this.projectRepository.count() > 0;
    }


    @Override
    public void seedData() throws JAXBException, IOException {
        XmlMapper xmlMapper = new XmlMapper();
        ProjectRootImportModel projectRootImportModel = xmlMapper.readValue(readFile(), ProjectRootImportModel.class);

        projectRootImportModel.getProjectImportModels()
                .forEach(this::saveToDB);
    }

    private String saveToDB(ProjectImportModel project) {
        Project forDB = this.modelMapper.map(project, Project.class);
//        forDB.setStartDate(LocalDate.parse(project.getStartDate()));

        Optional<Company> company =
            this.companyRepository.findByName(forDB.getCompany().getName());

        if (company.isEmpty()) {
            return "Invalid project. Company not found.";
        }

        forDB.setCompany(company.get());
        this.projectRepository.save(forDB);

        return "Successfully imported project";
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String getFinishedProjects() {
        List<Project> all = this.projectRepository.findByIsFinishedTrue();

        return all
            .stream()
            .map(Object::toString)
            .collect(Collectors.joining("\n"));
    }
}
