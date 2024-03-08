package de.springbootbuch.data.commons.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Data
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

}
