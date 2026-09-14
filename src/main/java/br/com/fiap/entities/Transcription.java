package br.com.fiap.entities;

public class Transcription {
    private int transcriptionId;
    private int meetingId;
    private String content;

    public Transcription(int meetingId, String content) {
        this.meetingId = meetingId;
        this.content = content;
    }

    public Transcription(int transcriptionId, int meetingId, String content) {
        this.transcriptionId = transcriptionId;
        this.meetingId = meetingId;
        this.content = content;
    }

    public boolean validateContent() {
        return content != null && !content.isBlank();
    }

    public int getTranscriptionId() {
        return transcriptionId;
    }

    public void setTranscriptionId(int transcriptionId) {
        this.transcriptionId = transcriptionId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
