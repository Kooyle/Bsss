package com.evan.bs.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "companywork")
@JsonIgnoreProperties({"handler","hibernateLazyInitialize"})
public class Companywork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")

    private Integer cid;

    private String username;

    private String comname;

    private Date comdate;

    private String comemail;

    private String comphone;

    private String finance;

    private String industry;

    private String scale;

    private String comadress;

    private String introduction;
    private java.util.Date createdate;

    private String job;

    private String comsalary;

    private String comexperience;

    private String comeducation;

    private String comnatureofwork;

    private String details;

    private String workrequire;



}
