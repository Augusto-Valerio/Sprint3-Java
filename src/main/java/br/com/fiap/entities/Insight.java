package br.com.fiap.entities;

public class Insight {
    private int insightId;
    private int transcriptionId;
    private String type;
    private String description;
    private String sentiment;
    private String actionSuggestion;

    public Insight(int transcriptionId, String type, String description, String sentiment, String actionSuggestion) {
        this.transcriptionId = transcriptionId;
        this.type = type;
        this.description = description;
        this.sentiment = sentiment;
        this.actionSuggestion = actionSuggestion;
    }

    public Insight(int insightId, int transcriptionId, String type, String description, String sentiment, String actionSuggestion) {
        this.insightId = insightId;
        this.transcriptionId = transcriptionId;
        this.type = type;
        this.description = description;
        this.sentiment = sentiment;
        this.actionSuggestion = actionSuggestion;
    }

    public boolean validateDescription() {
        return description != null && !description.isBlank();
    }

    public int getInsightId() {
        return insightId;
    }

    public void setInsightId(int insightId) {
        this.insightId = insightId;
    }

    public int getTranscriptionId() {
        return transcriptionId;
    }

    public void setTranscriptionId(int transcriptionId) {
        this.transcriptionId = transcriptionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getActionSuggestion() {
        return actionSuggestion;
    }

    public void setActionSuggestion(String actionSuggestion) {
        this.actionSuggestion = actionSuggestion;
    }
}
