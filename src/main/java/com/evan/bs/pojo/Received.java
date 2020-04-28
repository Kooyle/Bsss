package com.evan.bs.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "received")
@JsonIgnoreProperties({"handler","hibernateLazyInitialize"})
@Component
public class Received {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reid")

    private Integer reid;

    private Integer cid;

    private Integer uid;

    private Integer rid;

    private String result;

    private String msg;

    private String state;

    private String resultstate;
}
