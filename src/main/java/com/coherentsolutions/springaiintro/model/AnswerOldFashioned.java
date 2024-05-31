package com.coherentsolutions.springaiintro.model;

import java.util.Objects;

public class AnswerOldFashioned {
    private final String answer;

    //Constructor
    public AnswerOldFashioned(String answer) {
        this.answer = answer;
    }

    //Getter
    public String getAnswer() {
        return answer;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerOldFashioned answer1 = (AnswerOldFashioned) o;
        return Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(answer);
    }

    //toString

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                '}';
    }
}
