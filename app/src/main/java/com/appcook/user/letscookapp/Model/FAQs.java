package com.appcook.user.letscookapp.Model;

public class FAQs {

    private  int qid;
    private String qtitle;
    private String qanswer;

    public FAQs() {
        this.qid = 0;
        this.qtitle = "";
        this.qanswer = "";
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

    public String getQanswer() {
        return qanswer;
    }

    public void setQanswer(String qanswer) {
        this.qanswer = qanswer;
    }

    @Override
    public String toString() {
        return "FAQs{" +
                "qid=" + qid +
                ", qtitle='" + qtitle + '\'' +
                ", qanswer='" + qanswer + '\'' +
                '}';
    }
}
