package org.rik.proov.usecase.event;

import org.springframework.lang.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class CreateEventPersonForm {

    @Nullable
    @Positive
    private Long id;

    @NotBlank
    @Size(min=1,max=64)
    private String firstName;

    @NotBlank
    @Size(min=1,max=64)
    private String lastName;


    private BigInteger ssn;

    @NotBlank
    @Size(min=1,max=64)
    private String payment;

    @Nullable
    @Size(max=1500)
    private String info;

    @Positive
    private Long eventId;

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigInteger getSsn() {
        return ssn;
    }

    public void setSsn(BigInteger ssn) {
        this.ssn = ssn;
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
