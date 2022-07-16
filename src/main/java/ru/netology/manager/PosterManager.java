package ru.netology.manager;
import lombok.Data;

import ru.netology.domain.PosterIem;

@Data
public class PosterManager {
    private PosterIem[] posters = new PosterIem[0];
    private int defaultMovieLength = 10;

    PosterManager() {
    }

    public PosterManager(int userLength) {
        if (userLength > 0) {
            defaultMovieLength = userLength;
        }

    }

    public void addMovie(PosterIem movie) {
        int length = posters.length + 1;
        PosterIem[] tmp = new PosterIem[length];
        System.arraycopy(posters, 0, tmp, 0, posters.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        posters=tmp;
    }

    public PosterIem[] getLastAdd() {
        int moviesLength = posters.length;
        int localMovieLength = defaultMovieLength;
        if (moviesLength < localMovieLength) {
            localMovieLength = moviesLength;
        }
        PosterIem[] result = new PosterIem[localMovieLength];

        for (int i = 0; i < result.length; i++) {
            int index = moviesLength - i - 1;
            result[i] = posters[index];
        }
        return result;


    }
}
