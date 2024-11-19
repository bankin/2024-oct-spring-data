package org.nltworkshop.web.controllers;

import ch.qos.logback.classic.Logger;
import org.nltworkshop.service.CompanyService;
import org.nltworkshop.service.EmployeeService;
import org.nltworkshop.service.ProjectService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    private final ProjectService projectService;
    private final CompanyService companyService;
    private final EmployeeService employeeService;

    public HomeController(ProjectService projectService, CompanyService companyService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.companyService = companyService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        boolean isAllDataImported =
            this.projectService.isImported() &&
            this.companyService.isImported() &&
            this.employeeService.isImported();

        model.addAttribute("areImported", isAllDataImported);

        logger.debug("My first debug");

        return "home";
    }

    // Request Path -> HTTP Method -> Controller::method

}
