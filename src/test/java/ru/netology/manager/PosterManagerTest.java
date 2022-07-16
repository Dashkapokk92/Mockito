package ru.netology.manager;

import ru.netology.domain.PosterIem;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    private final PosterIem first = new PosterIem(1, "http://", "Spider-Man: No Way Home", "Adventure");
    private final PosterIem second = new PosterIem(2, "http://", "No Time To Die", "Thriller");
    private final PosterIem third = new PosterIem(3, "http://", "Shang-Chi And The Legend Of The Ten Rings", "Fantasy");
    private final PosterIem fourth = new PosterIem(4, "http://", "The Father", "Drama");
    private final PosterIem fifth = new PosterIem(5, "http://", "Dune", "Adventure");
    private final PosterIem sixth = new PosterIem(6, "http://", "ШеA Quiet Place: Part II", "Thriller");
    private final PosterIem seventh = new PosterIem(7, "http://", "Palm Springs", "Mystery");
    private final PosterIem eighth = new PosterIem(8, "http://", "The Suicide Squad", "Adventure");
    private final PosterIem ninth = new PosterIem(9, "http://", "Free Guy", "Comedy");
    private final PosterIem tenth = new PosterIem(10, "http://", "Cruella", "Crime");

   PosterIem[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

    @Test
    void shouldShowLast10Movies() {
        PosterManager manger = new PosterManager(10);
        manger.addMovie(first);
        manger.addMovie(second);
        manger.addMovie(third);
        manger.addMovie(fourth);
        manger.addMovie(fifth);
        manger.addMovie(sixth);
        manger.addMovie(seventh);
        manger.addMovie(eighth);
        manger.addMovie(ninth);
        manger.addMovie(tenth);
       PosterIem[] actual = manger.getLastAdd();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowCustomMovieLength() {
      PosterManager manger = new PosterManager(5);
        manger.addMovie(first);
        manger.addMovie(second);
        manger.addMovie(third);
        manger.addMovie(fourth);
        manger.addMovie(fifth);
       PosterIem[] expected = {fifth, fourth, third, second, first};
        PosterIem[] actual = manger.getLastAdd();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNothing() {
        PosterManager manger = new PosterManager();
        PosterIem[] actual = manger.getLastAdd();
        PosterIem[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowValid() {
        PosterManager manager = new PosterManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        PosterIem movieToAdd = new PosterIem(11, "Minari", "http://", "Drama");
        manager.addMovie(movieToAdd);
        PosterIem[] actual = manager.getLastAdd();
        PosterIem[] expected = {new PosterIem(11, "Minari", "http://", "Drama"), tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);

    }

    @Test
    void mustShowOverMax() {
        PosterManager manager = new PosterManager(11);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        PosterIem[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

    }

}