package com.evan.bs.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "usermsg")
@JsonIgnoreProperties({"handler","hibernateLazyInitialize"})
public class Usermsg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")

   private int uid;
    private Date date1;
    private String name;
    private String sex;
    private String email;
    private String phone;
    private String education;
    private String school;
    private String natureofwork;
    private String salary;
    private String experience;
    private String credentials;
    private String  adress;
    private String advantage;
    private String workexp1;
    private String workexp2;
    private String workexp3;


   public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNatureofwork() {
        return natureofwork;
    }

    public void setNatureofwork(String natureofwork) {
        this.natureofwork = natureofwork;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getWorkexp1() {
        return workexp1;
    }

    public void setWorkexp1(String workexp1) {
        this.workexp1 = workexp1;
    }

    public String getWorkexp2() {
        return workexp2;
    }

    public void setWorkexp2(String workexp2) {
        this.workexp2 = workexp2;
    }

    public String getWorkexp3() {
        return workexp3;
    }

    public void setWorkexp3(String workexp3) {
        this.workexp3 = workexp3;
    }
}
