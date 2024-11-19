package org.nltworkshop.service.model.imports;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.math.BigDecimal;


public class ProjectImportModel {

    @JacksonXmlProperty
    private String name;
    @JacksonXmlProperty
    private String description;
    @JacksonXmlProperty(localName = "start-date")
    private String startDate;
    @JacksonXmlProperty(localName = "is-finished")
    private boolean isFinished;
    @JacksonXmlProperty
    private BigDecimal payment;
    @JacksonXmlProperty(localName = "company")
    private CompanyImportModel companyName;

    public ProjectImportModel() {
    }

    public ProjectImportModel(String name, String description, String startDate, boolean isFinished, BigDecimal payment, CompanyImportModel companyName) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.isFinished = isFinished;
        this.payment = payment;
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public CompanyImportModel getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyImportModel companyName) {
        this.companyName = companyName;
    }

    /*
    /    <project>
        <name>Robocop</name>
        <description>AI robots</description>
        <start-date>2019-05-31</start-date>
        <is-finished>false</is-finished>
        <payment>99999.00</payment>
        <company name="MavenLtd"/>
    </project>
     */
}
