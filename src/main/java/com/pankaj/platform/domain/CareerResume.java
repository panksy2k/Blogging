package com.pankaj.platform.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankajpardasani on 24/09/2016.
 */
@Document
public class CareerResume {
    @Id
    private String id;
    private String candidateName;
    private List<String> skills = new ArrayList<>(1);
    private String emailAddress;
    private Address homeAddress;

    private ProfessionalSummary summary = new ProfessionalSummary();
    private List<ProjectSpecification> experience = new ArrayList<>(1);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProfessionalSummary getSummary() {
        return summary;
    }

    public void setSummary(ProfessionalSummary summary) {
        this.summary = summary;
    }

    public List<ProjectSpecification> getExperience() {
        return experience;
    }

    public void setExperience(List<ProjectSpecification> experience) {
        this.experience = experience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public static class ProfessionalSummary {
        private List<String> summaryInfo = new ArrayList<>(1);

        public List<String> getSummaryInfo() {
            return summaryInfo;
        }

        public void setSummaryInfo(List<String> summaryInfo) {
            this.summaryInfo = summaryInfo;
        }
    }

    public static class Address {
        private String doorStreet;
        private String postCode;
        private String area;
        private String county;
        private String country;

        public String getDoorStreet() {
            return doorStreet;
        }

        public void setDoorStreet(String doorStreet) {
            this.doorStreet = doorStreet;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    public static class ProjectSpecification {
        private LocalDate startDate, endDate;
        private String projectName, projectDescription;
        private String organisation;
        private String jobTitle;
        private String techEnvironment;
        private String contributions[];

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getProjectDescription() {
            return projectDescription;
        }

        public void setProjectDescription(String projectDescription) {
            this.projectDescription = projectDescription;
        }

        public String getOrganisation() {
            return organisation;
        }

        public void setOrganisation(String organisation) {
            this.organisation = organisation;
        }

        public String getTechEnvironment() {
            return techEnvironment;
        }

        public void setTechEnvironment(String techEnvironment) {
            this.techEnvironment = techEnvironment;
        }

        public String[] getContributions() {
            return contributions;
        }

        public void setContributions(String[] contributions) {
            this.contributions = contributions;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }
    }
}

