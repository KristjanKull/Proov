package org.rik.proov.domain.event;



import javax.persistence.*;
import java.math.BigInteger;


@Entity
public class EventPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;

    private String lastName;

    private BigInteger ssn;

    private String payment;

    private String info;

    /**@ManyToOne(fetch = FetchType.LAZY)
    private Event event;**/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /**public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }**/
}
