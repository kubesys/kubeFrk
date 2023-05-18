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
@Table(name = "homework_amend_response")
public class HomeworkAmendResponse {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "seq", nullable = false)
    private Short seq;

    @Size(max = 255)
    @Column(name = "url")
    private String url;

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
    @Column(name = "amend_single_record_id", nullable = false)
    private Long amendSingleRecordId;

}