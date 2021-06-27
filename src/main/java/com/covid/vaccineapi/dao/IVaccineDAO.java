package com.covid.vaccineapi.dao;

import com.covid.vaccineapi.pojo.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineDAO extends CrudRepository<Subscriber, Integer> {
}
