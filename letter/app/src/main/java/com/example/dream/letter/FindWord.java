package com.example.dream.letter;

public class FindWord {
    private String  name;
    private String meaning;

    public FindWord(String name, String meaning) {
        this.name = name;
        this.meaning = meaning;
    }

    public FindWord(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
