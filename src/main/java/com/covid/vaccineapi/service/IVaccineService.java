package com.covid.vaccineapi.service;

import com.covid.vaccineapi.pojo.Session__1;
import com.covid.vaccineapi.pojo.Subscriber;

import java.util.List;

public interface IVaccineService {
    int saveSubscriber(Subscriber subscriber);
    int saveSchedule(List<Session__1> sessions);
}
