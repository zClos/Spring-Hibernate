package com.pvt.service;

import com.pvt.dao.MeetingDao;
import com.pvt.pojos.Meeting;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class MeetingService {

    private MeetingDao meetingDao;

    public MeetingService() {
    }

    public MeetingService(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void saveMeeting(Meeting meeting) {
        meetingDao.add(meeting);
    }

    @Transactional(readOnly = true)
    public Meeting getMeeting(Integer id) {
        return meetingDao.get(Meeting.class, id);
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteMeeting(Meeting meeting) {
        meetingDao.delete(Meeting.class, meeting.getMeetingId());
        System.out.println("The Meeting successfully deleted\n");
    }
}
