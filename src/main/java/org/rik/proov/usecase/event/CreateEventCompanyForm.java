package org.rik.proov.usecase.event;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreateEventCompanyForm {

    @Nullable
    @Positive
    private Long id;

    @NotBlank
    @Size(min=1,max=64)
    private String name;



    private Integer registerCode;



    private Integer participantsSum;

    @NotBlank
    @Size(min=1,max=64)
    private String payment;

    @Nullable
    @Size(max=5000)
    private String info;

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
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

    @Nullable
    public String getInfo() {
        return info;
    }

    public void setInfo(@Nullable String info) {
        this.info = info;
    }
}
