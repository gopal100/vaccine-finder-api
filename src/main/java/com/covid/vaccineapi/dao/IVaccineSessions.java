package com.covid.vaccineapi.dao;

import com.covid.vaccineapi.pojo.Session__1;
import org.springframework.data.repository.CrudRepository;

public interface IVaccineSessions extends CrudRepository<Session__1, Integer> {
}
