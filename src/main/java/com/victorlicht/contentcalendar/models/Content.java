package com.victorlicht.contentcalendar.models;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String Title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String url
) {
}
