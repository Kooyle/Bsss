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
@Table(name = "invitation")
@JsonIgnoreProperties({"handler","hibernateLazyInitialize"})
@Component
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid")
    private Integer nid;

    private Integer cid;

    private Integer uid;

    private Integer rid;

    private String invitestate;

    private String invitemsg;

    private String inviteresult;
}
