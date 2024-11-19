package org.nltworkshop.service.model.imports;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Set;

@JacksonXmlRootElement(localName = "employees")
public class EmployeeRootImportModel {

    @JacksonXmlProperty(localName = "employee")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Set<EmployeeImportModel> employees;

    public EmployeeRootImportModel() {}

    public Set<EmployeeImportModel> getEmployees() {
        return employees;
    }
}
