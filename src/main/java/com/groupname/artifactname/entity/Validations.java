package com.groupname.artifactname.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Validations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @Max(value = 100, message = "max value is 100")
    private int maNum;

    @Min(value = 5)
    private int minNum;

    @Size(max = 5)
    private String size;

    @JsonProperty
    @AssertFalse
    private boolean bFalse;

    @JsonProperty
    @AssertTrue
    private boolean bTrue;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;
}
