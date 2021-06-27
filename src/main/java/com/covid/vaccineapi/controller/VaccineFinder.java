package com.covid.vaccineapi.controller;

import com.covid.vaccineapi.pojo.Subscriber;
import com.covid.vaccineapi.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VaccineFinder {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IVaccineService vaccineService;
    static List<String> list = new ArrayList<>();

    @GetMapping("/registerToken/{pincode}/{mobNo}")
    public String addPeople(@PathVariable String pincode, @PathVariable String mobNo){
        list.add(pincode);
        Subscriber subscriber = new Subscriber(mobNo, pincode);
        vaccineService.saveSubscriber(subscriber);
        return subscriber.getId().toString();
    }
}
