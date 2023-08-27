package org.example.com.vti.entity;

public class Answer {
    private int answerID;
    private String content;
    private int questionID;
    private boolean isCorrect;

    // Getter methods
    public int getAnswerID() {
        return answerID;
    }

    public String getContent() {
        return content;
    }

    public int getQuestionID() {
        return questionID;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    // Setter methods
    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Answer(int answerID, String content, int questionID, boolean isCorrect) {
        this.answerID = answerID;
        this.content = content;
        this.questionID = questionID;
        this.isCorrect = isCorrect;
    }

}
