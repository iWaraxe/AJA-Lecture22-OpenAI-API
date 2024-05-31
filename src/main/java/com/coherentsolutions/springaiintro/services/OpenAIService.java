package com.coherentsolutions.springaiintro.services;

import com.coherentsolutions.springaiintro.model.Answer;
import com.coherentsolutions.springaiintro.model.Question;

public interface OpenAIService {
    Answer getAnswer(Question question);

    String getAnswer(String question);
}
