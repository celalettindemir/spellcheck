package com.yenibiris.textcorrection.DTO;

public class Content {
    private String text;

    Content() {}

    Content(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
