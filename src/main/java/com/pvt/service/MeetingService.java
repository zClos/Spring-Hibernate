package com.pvt.service;

import com.pvt.dao.MeetingDao;
import com.pvt.pojos.Meeting;

public class MeetingService {

    private MeetingDao meetingDao;

    public MeetingService() {
    }

    public MeetingService(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    public void saveMeeting(Meeting meeting) {
        meetingDao.add(meeting);
    }

    public Meeting getMeeting(Integer id) {
        return meetingDao.get(Meeting.class, id);
    }

    public void deleteMeeting(Meeting meeting) {
        meetingDao.delete(meeting);
    }
}
