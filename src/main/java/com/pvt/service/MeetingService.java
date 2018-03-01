package com.pvt.service;

import com.pvt.dao.MeetingDao;
import com.pvt.pojos.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MeetingService {

    @Autowired
    private MeetingDao meetingDao;

    public MeetingService() {
    }

    public MeetingService(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void saveMeeting(Meeting meeting) {
        meetingDao.save(meeting);
    }

    @Transactional(readOnly = true)
    public Meeting getMeeting(Integer id) {
        return meetingDao.findOne(id);
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteMeeting(Meeting meeting) {
        meetingDao.delete(meetingDao.findOne(meeting.getId()));
        System.out.println("The Meeting successfully deleted\n");
    }
}
