package com.covid.vaccineapi.service;

import com.covid.vaccineapi.dao.IVaccineDAO;
import com.covid.vaccineapi.dao.IVaccineSessions;
import com.covid.vaccineapi.pojo.Session;
import com.covid.vaccineapi.pojo.Session__1;
import com.covid.vaccineapi.pojo.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements IVaccineService {

    @Autowired
    private IVaccineDAO vaccineDAO;
    @Autowired
    private IVaccineSessions vaccineSessions;

    @Override
    public int saveSubscriber(Subscriber subscriber) {
        return vaccineDAO.save(subscriber).getId();
    }

    @Override
    public int saveSchedule(List<Session__1> sessions) {
          vaccineSessions.saveAll(sessions);
          return 1;
    }
}
