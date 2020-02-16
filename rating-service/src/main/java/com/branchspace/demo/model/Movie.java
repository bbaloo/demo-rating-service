package com.branchspace.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Value
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    String id;
    String title;
    MovieGenre genre;
    Long productionTimestamp;
    //in requirements state that I should keep List of ratings instead of just simple avg value, so it is
    List<Rating> rating;
}
