package com.practice.coronacases.services;

import com.practice.coronacases.model.VirusStats;
import jdk.jfr.Timestamp;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


@Service
public class CoronaAppService {

    private static  String APP_DATA = "https://covid19.who.int/WHO-COVID-19-global-table-data.csv";


    private ArrayList<VirusStats> stats = new ArrayList<>();

    public ArrayList<VirusStats> getStats() {
        return stats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void getData() throws IOException, InterruptedException {
        HttpClient client =  HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(URI.create(APP_DATA)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        ArrayList<VirusStats> tempStats = new ArrayList<>();

        StringReader in = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            String country = record.get("\uFEFFName");
            String newlyReportedCases = record.get("Cases - newly reported in last 24 hours");
            String deathsReported = record.get("Cases - newly reported in last 24 hours");

            tempStats.add(new VirusStats(country,newlyReportedCases,deathsReported));
        }
        stats = tempStats;
    }
}
