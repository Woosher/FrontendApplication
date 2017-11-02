package application.models;

public class SearchProduct {

    private int line_id, speech_number;
    private String play_name, line_number, speaker, text_entry;

    public SearchProduct(int line_id, int speech_number, String play_name, String line_number, String speaker, String text_entry) {
        this.line_id = line_id;
        this.speech_number = speech_number;
        this.play_name = play_name;
        this.line_number = line_number;
        this.speaker = speaker;
        this.text_entry = text_entry;
    }

    public int getLine_id() {
        return line_id;
    }

    public void setLine_id(int line_id) {
        this.line_id = line_id;
    }

    public int getSpeech_number() {
        return speech_number;
    }

    public void setSpeech_number(int speech_number) {
        this.speech_number = speech_number;
    }

    public String getPlay_name() {
        return play_name;
    }

    public void setPlay_name(String play_name) {
        this.play_name = play_name;
    }

    public String getLine_number() {
        return line_number;
    }

    public void setLine_number(String line_number) {
        this.line_number = line_number;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getText_entry() {
        return text_entry;
    }

    public void setText_entry(String text_entry) {
        this.text_entry = text_entry;
    }
}
