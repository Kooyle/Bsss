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
@Table(name = "msglist")
@JsonIgnoreProperties({"handler","hibernateLazyInitialize"})
@Component
public class Msglist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid")

    private Integer mid;

    private String tittle;

    private String article;

    private String link;
}
