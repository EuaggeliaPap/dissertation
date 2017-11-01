package com.appcook.user.letscookapp.Model;

public class FAQs {

    private  int qid;
    private String qtitle;
    private String answer;

    public FAQs() {
        this.qid = 0;
        this.qtitle = "";
        this.answer = "";
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQtitle() {
        return qtitle;
    }

    public void setQtitle(String qtitle) {
        this.qtitle = qtitle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "FAQs{" +
                "qid=" + qid +
                ", qtitle='" + qtitle + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
