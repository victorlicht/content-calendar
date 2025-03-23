package com.victorlicht.contentcalendar.repository;

import com.victorlicht.contentcalendar.models.Content;
import com.victorlicht.contentcalendar.models.Status;
import com.victorlicht.contentcalendar.models.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {}

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content example = new Content(
                1,
                "Example 01",
                "Example 1",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                null);
        contentList.add(example);
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean notExistsById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).count() != 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
