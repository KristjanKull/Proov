package org.rik.proov.domain.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EventCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer registerCode;

    private Integer participantsSum;

    private String payment;

    private String info;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(Integer registerCode) {
        this.registerCode = registerCode;
    }

    public Integer getParticipantsSum() {
        return participantsSum;
    }

    public void setParticipantsSum(Integer participantsSum) {
        this.participantsSum = participantsSum;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
