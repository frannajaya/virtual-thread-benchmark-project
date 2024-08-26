package com.fran.na.jaya.virtual.thread.benchmark.project.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "dog")
public class Dog implements Serializable {

  @Serial
  private static final long serialVersionUID = -2762703214153591942L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private ZonedDateTime deletedAt;
  private String racial;
  private String color;

  @PrePersist
  protected void prePersist() {
    if (createdAt == null) {
      createdAt = ZonedDateTime.now();
    }
    if (updatedAt == null) {
      updatedAt = ZonedDateTime.now();
    }
  }

  @PreUpdate
  protected void preUpdate() {
    if (updatedAt == null) {
      updatedAt = ZonedDateTime.now();
    }
  }
}
