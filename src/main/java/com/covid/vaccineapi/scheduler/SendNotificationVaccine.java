package com.covid.vaccineapi.scheduler;

import com.covid.vaccineapi.pojo.Center;
import com.covid.vaccineapi.pojo.Root;
import com.covid.vaccineapi.pojo.Session;
import com.covid.vaccineapi.pojo.VaccineFee;
import com.covid.vaccineapi.utility.SendTelegramNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@EnableScheduling
public class SendNotificationVaccine {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private SendTelegramNotification sendTelegramNotification;

    @Scheduled(fixedRate = 60000)
    public void callHomePage() {
        String str = restTemplate.getForObject("https://vaccine-alert-wb.herokuapp.com/", String.class);
        System.out.println("called app > " + str);
    }

    @Scheduled(fixedRate = 15000)
    public void sendMessage() {
        System.out.println(" scheduler ");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.set("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.56");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        //todayKolkata = todayKolkata.plusDays(1);
        System.out.println("Current Date in IST=" + todayKolkata);
        String formattedDate = todayKolkata.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Current date formatted: " + formattedDate);

        String url = null;
        ResponseEntity<Root> respEntity = null;

        try {
            url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=725&date=" + formattedDate;
            System.out.println("url > " + url);
            respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Root.class);
            System.out.println("size of data Kolkata> " + respEntity.getBody().getCenters().size());
            final List<Center> centers = respEntity.getBody().getCenters();
            sendNotification(centers);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=730&date=" + formattedDate;
            System.out.println("url > " + url);
            respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Root.class);
            System.out.println("size of data North 24 Pargana> " + respEntity.getBody().getCenters().size());
            final List<Center> centers = respEntity.getBody().getCenters();
            sendNotification(centers);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=720&date=" + formattedDate;
            System.out.println("url > " + url);
            respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Root.class);
            System.out.println("size of data Hooghly> " + respEntity.getBody().getCenters().size());
            final List<Center> centers = respEntity.getBody().getCenters();
            sendNotification(centers);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private void sendNotification(List<Center> centers) {
        for (Center center : centers) {
            final List<Session> sessions = center.getSessions();
            for (Session session: sessions) {
                if (session.getMin_age_limit() >= 18 && session.getMin_age_limit() <= 44 ) {
                    if (session.getAvailable_capacity_dose1() > 1 || session.getAvailable_capacity_dose2() > 1) {
                        String centerName = center.getName();
                        int pin = center.getPincode();
                        String vaxName = session.getVaccine();
                        int avaiDose1 = session.getAvailable_capacity_dose1();
                        int avaiDose2 = session.getAvailable_capacity_dose2();
                        int avaiCapacity = session.getAvailable_capacity();
                        String date = session.getDate();
                        String feeType = center.getFee_type();
                        List<VaccineFee> vaccineFee = center.getVaccine_fees();
                        String vaccinePrice = vaccineFee != null && vaccineFee.size() > 0 ?
                                vaccineFee.stream().map(fee -> "Name - " + fee.getVaccine() + "Price - " + fee.getFee()).collect(Collectors.joining(", "))
                                : " ";
                        String msg = "Available > \n :: Center Name : " + centerName
                                + "\n :: Pin : " + pin
                                + "\n :: Vaccine name : " + vaxName
                                + "\n :: Available Dose 1 : " + avaiDose1
                                + "\n :: Available Dose 2 : " + avaiDose2
                                + "\n :: Avaiable Capacity : " + avaiCapacity
                                + "\n :: Minimum age limit : " + session.getMin_age_limit()
                                + "\n :: Date : " + date
                                + "\n :: Fee type : " + feeType
                                + "\n :: Vaccine Price : " + vaccinePrice;
                        sendTelegramNotification.sendTelegramMsg(msg, true);
                    }
                }else if(session.getMin_age_limit() >= 45 && session.getAvailable_capacity_dose1() > 1 ) {
                    String centerName = center.getName();
                    int pin = center.getPincode();
                    String vaxName = session.getVaccine();
                    int avaiDose1 = session.getAvailable_capacity_dose1();
                    int avaiDose2 = session.getAvailable_capacity_dose2();
                    int avaiCapacity = session.getAvailable_capacity();
                    String date = session.getDate();
                    String feeType = center.getFee_type();
                    List<VaccineFee> vaccineFee = center.getVaccine_fees();
                    String vaccinePrice = vaccineFee != null && vaccineFee.size() > 0 ?
                            vaccineFee.stream().map(fee -> "Name - " + fee.getVaccine() + "Price - " + fee.getFee()).collect(Collectors.joining(", "))
                            : " ";
                    String msg = "Available > \n :: Center Name : " + centerName
                            + "\n :: Pin : " + pin
                            + "\n :: Vaccine name : " + vaxName
                            + "\n :: Available Dose 1 : " + avaiDose1
                            + "\n :: Available Dose 2 : " + avaiDose2
                            + "\n :: Avaiable Capacity : " + avaiCapacity
                            + "\n :: Minimum age limit : " + session.getMin_age_limit()
                            + "\n :: Date : " + date
                            + "\n :: Fee type : " + feeType
                            + "\n :: Vaccine Price : " + vaccinePrice;
                    sendTelegramNotification.sendTelegramMsg(msg, false);
                }
            }
            /*sessions.stream().filter(session -> {

                return false;
            }).count();*/
        }
    }
}
