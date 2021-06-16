package com.oyid.jianyi.dto;

/**
 * Created by Administrator on 2018/2/7.
 */
public class UserOrder extends Order {
    private String collUserName;
    private String collMobilePhone;
    private String collAddress;
    private String collTelphone;
    private String collCompanyName;

    private String mailingUserName;
    private String mailingMobilePhone;
    private String mailingAddress;
    private String mailingTelphone;
    private String mailingCompanyName;

    public String getCollUserName() {
        return collUserName;
    }

    public void setCollUserName(String collUserName) {
        this.collUserName = collUserName;
    }

    public String getCollMobilePhone() {
        return collMobilePhone;
    }

    public void setCollMobilePhone(String collMobilePhone) {
        this.collMobilePhone = collMobilePhone;
    }

    public String getCollAddress() {
        return collAddress;
    }

    public void setCollAddress(String collAddress) {
        this.collAddress = collAddress;
    }

    public String getCollTelphone() {
        return collTelphone;
    }

    public void setCollTelphone(String collTelphone) {
        this.collTelphone = collTelphone;
    }

    public String getCollCompanyName() {
        return collCompanyName;
    }

    public void setCollCompanyName(String collCompanyName) {
        this.collCompanyName = collCompanyName;
    }

    public String getMailingUserName() {
        return mailingUserName;
    }

    public void setMailingUserName(String mailingUserName) {
        this.mailingUserName = mailingUserName;
    }

    public String getMailingMobilePhone() {
        return mailingMobilePhone;
    }

    public void setMailingMobilePhone(String mailingMobilePhone) {
        this.mailingMobilePhone = mailingMobilePhone;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getMailingTelphone() {
        return mailingTelphone;
    }

    public void setMailingTelphone(String mailingTelphone) {
        this.mailingTelphone = mailingTelphone;
    }

    public String getMailingCompanyName() {
        return mailingCompanyName;
    }

    public void setMailingCompanyName(String mailingCompanyName) {
        this.mailingCompanyName = mailingCompanyName;
    }
}
