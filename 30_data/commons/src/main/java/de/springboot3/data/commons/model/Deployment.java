package de.springboot3.data.commons.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "deployment")
public class Deployment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String jobName;

    @Column(nullable = false)
    private String hostName;

    @Column(nullable = false)
    @CreationTimestamp
    private ZonedDateTime creationDate;

    public Long getId() {
        return id;
    }

    public Deployment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getJobName() {
        return jobName;
    }

    public Deployment setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public String getHostName() {
        return hostName;
    }

    public Deployment setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Deployment setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deployment that = (Deployment) o;
        return Objects.equals(id, that.id) && Objects.equals(jobName, that.jobName) && Objects.equals(hostName, that.hostName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobName, hostName, creationDate);
    }
}
