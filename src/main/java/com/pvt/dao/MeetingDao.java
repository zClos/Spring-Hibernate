package com.pvt.dao;

import com.pvt.pojos.Meeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingDao extends CrudRepository<Meeting, Integer> {
}
