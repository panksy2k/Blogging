package com.pankaj.platform.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pankajpardasani on 24/09/2016.
 */
@Document
public class CareerResume {
    @Id
    private String id;
    private String candidateName;
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

    public static class ProfessionalSummary {
        private List<String> summaryInfo = new ArrayList<>(1);

        public List<String> getSummaryInfo() {
            return summaryInfo;
        }

        public void setSummaryInfo(List<String> summaryInfo) {
            this.summaryInfo = summaryInfo;
        }
    }

    public static class ProjectSpecification {
        private LocalDate startDate, endDate;
        private String projectName, projectDescription;
        private String organisation;
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
    }
}

