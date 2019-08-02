package ru.shpi0.resttest.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @Column(name = "dt_created")
    private LocalDateTime dtCreated;

    @Column(name = "product_name")
    private String productName;

    public Application(LocalDateTime dtCreated, String productName) {
        this.dtCreated = dtCreated;
        this.productName = productName;
    }

    public Application() {
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public LocalDateTime getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(LocalDateTime dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(applicationId, that.applicationId) &&
                Objects.equals(dtCreated, that.dtCreated) &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, dtCreated, productName);
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", dtCreated=" + dtCreated +
                ", productName='" + productName + '\'' +
                '}';
    }
}
