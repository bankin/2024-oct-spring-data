package org.nltworkshop.service.model.imports;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Set;

@JacksonXmlRootElement(localName = "companies")
public class CompanyRootImportModel {

    @JacksonXmlProperty(localName = "company")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Set<CompanyImportModel> companyImportModels;

    public CompanyRootImportModel() {
    }

    public Set<CompanyImportModel> getCompanyImportModels() {
        return companyImportModels;
    }
}
