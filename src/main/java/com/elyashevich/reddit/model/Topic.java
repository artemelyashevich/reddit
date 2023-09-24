package com.elyashevich.reddit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topic {
    @Id
    private String id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, message = "Minimum title length is 2 characters")
    @TextIndexed
    @Indexed(unique = true)
    private String title;

    @NotEmpty(message = "Body should not be empty")
    @Size(min = 2, message = "Minimum body length is 2 characters")
    @TextIndexed
    private String body;

    @NotEmpty(message = "Description should not be empty")
    @Size(min = 2, message = "Minimum description length is 2 characters")
    @TextIndexed
    private String description;

    @TextIndexed
    private String image;

    @TextIndexed
    private String creatorId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @CreatedDate
    private LocalDateTime created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updated;
}
