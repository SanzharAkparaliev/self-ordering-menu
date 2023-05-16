package com.selforderingmenu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;
    LocalDateTime removedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedAt = LocalDateTime.now();
    }

    @PreRemove
    public void preRemove() {
        removedAt = LocalDateTime.now();
    }
}
