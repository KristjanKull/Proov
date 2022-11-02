package org.rik.proov.usecase.event;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

public class CreateEventForm {

    @Nullable
    @Positive
    private Long id;

    @NotBlank
    @Size(min=1,max=64)
    private String name;

    @Nullable
    @Size(max=1000)
    private String info;

    @NotBlank
    @Size(min=1,max=64)
    private String place;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    @FutureOrPresent
    private Date timestamp;

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

    @Nullable
    public String getInfo() {
        return info;
    }

    public void setInfo(@Nullable String info) {
        this.info = info;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }



}
