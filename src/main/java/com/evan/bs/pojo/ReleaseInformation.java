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
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@EntityListeners(AuditingEntityListener.class)//Jpa自动设置创建时间


@Table(name = "releaseinformation")
@JsonIgnoreProperties({"handler","hibernateLazyInitialize"})
@Component
public class ReleaseInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")

    private Integer rid;

/*
    @ManyToOne
    @JoinColumn(name = "cid")//外键
    private Comusermsg comusermsg;
*/

    private Integer cid;

    @Column(name = "createdate")
    @CreatedDate//Jpa自动设置创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//出参时往前端传回一段格式化好的时间字符串
    private Date createdate;

    private String job;

    private String comsalary;

    private String comexperience;

    private String comeducation;

    private String comnatureofwork;

    private String details;

    private String workrequire;




}
