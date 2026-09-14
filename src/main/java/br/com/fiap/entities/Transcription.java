package br.com.fiap.entities;

public class Transcription {
    private int transcriptionId;
    private int meetingId;
    private String content;
    private String processingStatus;

    public Transcription(int meetingId, String content, String processingStatus) {
        this.meetingId = meetingId;
        this.content = content;
        this.processingStatus = processingStatus;
    }

    public Transcription(int transcriptionId, int meetingId, String content, String processingStatus) {
        this.transcriptionId = transcriptionId;
        this.meetingId = meetingId;
        this.content = content;
        this.processingStatus = processingStatus;
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

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }
}
