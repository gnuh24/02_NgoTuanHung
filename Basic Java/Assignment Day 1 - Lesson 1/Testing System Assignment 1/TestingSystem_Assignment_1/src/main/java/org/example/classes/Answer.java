package org.example.classes;

public class Answer {
    public int answerID;
    public String content;
    public int questionID;
    public boolean isCorrect;

    public Answer(int answerID, String content, int questionID, boolean isCorrect) {
        this.answerID = answerID;
        this.content = content;
        this.questionID = questionID;
        this.isCorrect = isCorrect;
    }

}
