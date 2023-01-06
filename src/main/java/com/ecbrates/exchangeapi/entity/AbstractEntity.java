package com.ecbrates.exchangeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
@MappedSuperclass
public class AbstractEntity {

    @Id
    @ReadOnlyProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    @Column(name = "created")
    private Date createdDate;
    @LastModifiedDate
    @Column(name = "updated")
    private Date updatedDate;

    public AbstractEntity() {
        createdDate = new Date();
        updatedDate = new Date();
    }

}
