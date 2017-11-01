package com.appcook.user.letscookapp.Model;

public class AuthenticUser extends User{

    private String password;
    private Profile profile;
    private FAQs faqs;
    private Info cookInf;
    private Info appInf;
    //private Favorite favor;


    public AuthenticUser() {
        this.password = "";
        this.profile = new Profile();
        this.faqs = new FAQs();
        this.cookInf = new CookerInfo();
        this.appInf = new AppInfo();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public FAQs getFaqs() {
        return faqs;
    }

    public void setFaqs(FAQs faqs) {
        this.faqs = faqs;
    }

    public Info getCookInf() {
        return cookInf;
    }

    public void setCookInf(CookerInfo cookInf) {
        this.cookInf = cookInf;
    }

    public Info getAppInf() {
        return appInf;
    }

    public void setAppInf(AppInfo appInf) {
        this.appInf = appInf;
    }

    @Override
    public String toString() {
         String s = super.toString() +" \n "+"AuthenticUser{" +
                "password='" + password + '\'' +
                ", profile=" + profile +
                ", faqs=" + faqs +
                ", cookInf=" + cookInf +
                ", appInf=" + appInf +
                '}';

        return s;
    }
}
