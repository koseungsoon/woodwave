package com.woodwave.member.vo;

import org.springframework.stereotype.Component;

import java.sql.Date;
@Component

public class MemberVO {

    private String member_id;
    private String member_pwd;
    private String member_name;
    private String member_email;
    private String member_phone;
    private String member_zipcode;
    private String member_address;
    private String member_subaddress;
    private Date member_joindate;
//    private String member_del_yn;

    public MemberVO() {
    }

    public MemberVO(String member_id, String member_pwd, String member_name, String member_email, String member_phone, String member_zipcode, String member_address, String member_subaddress, Date member_joindate, String member_del_yn) {
        this.member_id = member_id;
        this.member_pwd = member_pwd;
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_phone = member_phone;
        this.member_zipcode = member_zipcode;
        this.member_address = member_address;
        this.member_subaddress = member_subaddress;
        this.member_joindate = member_joindate;
//        this.member_del_yn = member_del_yn;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pwd() {
        return member_pwd;
    }

    public void setMember_pwd(String member_pwd) {
        this.member_pwd = member_pwd;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public String getMember_zipcode() {
        return member_zipcode;
    }

    public void setMember_zipcode(String member_zipcode) {
        this.member_zipcode = member_zipcode;
    }

    public String getMember_address() {
        return member_address;
    }

    public void setMember_address(String member_address) {
        this.member_address = member_address;
    }

    public String getMember_subaddress() {
        return member_subaddress;
    }

    public void setMember_subaddress(String member_subaddress) {
        this.member_subaddress = member_subaddress;
    }

    public Date getMember_joindate() {
        return member_joindate;
    }

    public void setMember_joindate(Date member_joindate) {
        this.member_joindate = member_joindate;
    }

   /* public String getMember_del_yn() {
        return member_del_yn;
    }

    public void setMember_del_yn(String member_del_yn) {
        this.member_del_yn = member_del_yn;
    }*/
}
