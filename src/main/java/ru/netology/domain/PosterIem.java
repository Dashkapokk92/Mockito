package ru.netology.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class PosterIem {
    private int id;
    private String imageUrl;
    private String name;
    private String genre;
}


