package com.github.kubesys.devfrk.spring.rda.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "question_picture")
public class QuestionPicture {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "seq")
    private Integer seq;

    @Size(max = 255)
    @Column(name = "url")
    private String url;

    @Size(max = 50)
    @NotNull
    @Column(name = "create_name", nullable = false, length = 50)
    private String createName;

    @Size(max = 50)
    @Column(name = "update_name", length = 50)
    private String updateName;

    @NotNull
    @Column(name = "create_time", nullable = false)
    private OffsetDateTime createTime;

    @NotNull
    @Column(name = "update_time", nullable = false)
    private OffsetDateTime updateTime;

    @NotNull
    @Column(name = "is_valid", nullable = false)
    private Boolean isValid = false;

    @NotNull
    @Column(name = "question_id", nullable = false)
    private Long questionId;

}