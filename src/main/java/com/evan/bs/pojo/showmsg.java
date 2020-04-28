package com.evan.bs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
public class showmsg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")

    private Integer rid;

    private Integer cid;

    private Date createdate;

    private String job;

    private String comsalary;

    private String comexperience;

    private String comeducation;

    private String comnatureofwork;

    private String details;

    private String workrequire;

    private String username;

    private String comname;

    private java.sql.Date comdate;

    private String comemail;

    private String comphone;

    private String finance;

    private String industry;

    private String scale;

    private String comadress;

    private String introduction;

}
