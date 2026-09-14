package br.com.fiap.entities;

public class Meeting {
    private int meetingId;
    private int employeeId;
    private String title;
    private String meetingDate;
    private String status;

    public Meeting(int employeeId, String title, String meetingDate, String status) {
        this.employeeId = employeeId;
        this.title = title;
        this.meetingDate = meetingDate;
        this.status = status;
    }

    public Meeting(int meetingId, int employeeId, String title, String meetingDate, String status) {
        this.meetingId = meetingId;
        this.employeeId = employeeId;
        this.title = title;
        this.meetingDate = meetingDate;
        this.status = status;
    }

    public boolean validateTitle() {
        return title != null && !title.isBlank();
    }

    public boolean validateDate() {
        if (meetingDate == null) {
            return false;
        }

        if (meetingDate.length() != 10) {
            return false;
        }

        if (meetingDate.charAt(2) != '/' || meetingDate.charAt(5) != '/') {
            return false;
        }

        return true;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
