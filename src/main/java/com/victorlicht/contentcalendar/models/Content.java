package com.victorlicht.contentcalendar.models;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotNull
        String Title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String url
) {
}
