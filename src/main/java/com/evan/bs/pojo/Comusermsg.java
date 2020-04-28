package com.evan.bs.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "comusermsg")
@JsonIgnoreProperties({"handler","hibernateLazyInitialize"})
public class Comusermsg {
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


/*
    public Comusermsg (Integer cid,String username,String comname,Date comdate, String comemail,String comphone,String finance,String industry,String scale,String comadress,String introduction) {

        this.cid = cid;
        this.username = username;
        this.comname = comname;
        this.comdate = comdate;
        this.comemail = comemail;
        this.comphone = comphone;
        this.finance = finance;
        this.industry = industry;
        this.scale = scale;
        this.comadress = comadress;
        this.introduction = introduction;
    }

    public Comusermsg(){

    }*/

/*
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "comusermag")
    private Set<ReleaseInformation> shops = new HashSet<ReleaseInformation>();
*/

}
