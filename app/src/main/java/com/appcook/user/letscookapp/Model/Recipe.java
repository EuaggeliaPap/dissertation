package com.appcook.user.letscookapp.Model;

public class Recipe {

    private int rid;
    private String rtitle;
    private String rimpath;
    private String mdesc;//i auto tha meinei lista kai tha ginei k to katw i kanena mallon to 2
    private String steps;

    public Recipe() {
        this.rid= 0;
        this.rtitle = "";
        this.rimpath = "";
        this.mdesc = "";
        this.steps = "";
    }

    public int getRid() { return rid; }

    public void setRid(int rid) { this.rid = rid; }

    public String getRtitle() {
        return rtitle;
    }

    public void setRtitle(String rtitle) {
        this.rtitle = rtitle;
    }

    public String getRimpath() {
        return rimpath;
    }

    public void setRimpath(String rimpath) {
        this.rimpath = rimpath;
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "rid='" + rid + '\'' +
                "rtitle='" + rtitle + '\'' +
                ", rimpath='" + rimpath + '\'' +
                ", mdesc=" + mdesc +
                ", steps='" + steps + '\'' +
                '}';
    }
}
