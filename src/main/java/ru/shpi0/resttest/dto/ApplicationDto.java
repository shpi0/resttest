package ru.shpi0.resttest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import ru.shpi0.resttest.config.LocalDateTimeAdapter;
import ru.shpi0.resttest.model.Application;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name = "APPLICATION")
@ApiModel(value = "APPLICATION")
public class ApplicationDto {

    private Long CONTACT_ID;

    private Long APPLICATION_ID;

    private LocalDateTime DT_CREATED;

    private String PRODUCT_NAME;

    public ApplicationDto() {
    }

    public ApplicationDto(Long CONTACT_ID, Long APPLICATION_ID, LocalDateTime DT_CREATED, String PRODUCT_NAME) {
        this.CONTACT_ID = CONTACT_ID;
        this.APPLICATION_ID = APPLICATION_ID;
        this.DT_CREATED = DT_CREATED;
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public ApplicationDto(Long CONTACT_ID, Application application) {
        this.CONTACT_ID = CONTACT_ID;
        this.APPLICATION_ID = application.getApplicationId();
        this.DT_CREATED = application.getDtCreated();
        this.PRODUCT_NAME = application.getProductName();
    }

    @JsonProperty("CONTACT_ID")
    public Long getCONTACT_ID() {
        return CONTACT_ID;
    }

    public void setCONTACT_ID(Long CONTACT_ID) {
        this.CONTACT_ID = CONTACT_ID;
    }

    @JsonProperty("APPLICATION_ID")
    public Long getAPPLICATION_ID() {
        return APPLICATION_ID;
    }

    public void setAPPLICATION_ID(Long APPLICATION_ID) {
        this.APPLICATION_ID = APPLICATION_ID;
    }

    @JsonProperty("DT_CREATED")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy hh:mm:ss")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getDT_CREATED() {
        return DT_CREATED;
    }

    public void setDT_CREATED(LocalDateTime DT_CREATED) {
        this.DT_CREATED = DT_CREATED;
    }

    @JsonProperty("PRODUCT_NAME")
    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    @Override
    public String toString() {
        return "ApplicationDto{" +
                "CONTACT_ID=" + CONTACT_ID +
                ", APPLICATION_ID=" + APPLICATION_ID +
                ", DT_CREATED=" + DT_CREATED +
                ", PRODUCT_NAME='" + PRODUCT_NAME + '\'' +
                '}';
    }
}
