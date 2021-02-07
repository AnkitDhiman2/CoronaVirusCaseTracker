package com.practice.coronacases.model;


public class VirusStats {


    private String country;
    private String reportedCases;
    private String reportedDeaths;

    public VirusStats(String country, String reportedCases, String reportedDeaths) {
        this.country = country;
        this.reportedCases = reportedCases;
        this.reportedDeaths = reportedDeaths;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReportedCases() {
        return reportedCases;
    }

    public void setReportedCases(String reportedCases) {
        this.reportedCases = reportedCases;
    }

    public String getReportedDeaths() {
        return reportedDeaths;
    }

    public void setReportedDeaths(String reportedDeaths) {
        this.reportedDeaths = reportedDeaths;
    }
}
