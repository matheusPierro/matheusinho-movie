package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "TB_MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MOVIE")
    @SequenceGenerator(name = "SQ_MOVIE", sequenceName = "SQ_MOVIE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_MOVIE")
    private Long id;

    @Column(name = "ADULT_MOVIE")
    private boolean adult;

    @Column(name = "BDP_MOVIE")
    private String backdropPath;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_MOVIE_GENRE",
            joinColumns = {
                    @JoinColumn(
                            name = "MOVIE",
                            referencedColumnName = "ID_MOVIE",
                            foreignKey = @ForeignKey(name = "FK_TB_MOVIE_MOVIE")
                    )
            },
            inverseJoinColumns = {

                    @JoinColumn(
                            name = "GENRE",
                            referencedColumnName = "ID_GENRE",
                            foreignKey = @ForeignKey(name = "FK_TB_MOVIE_GENRE")
                    )
            }
    )
    private Set<Genre> genres = new LinkedHashSet<>();

    @Column(name = "OR_LANG_MOVIE")
    private String originalLanguage;

    @Column(name = "OR_TITLE_MOVIE")
    private String originalTitle;

    @Column(name = "OVERVIEW_MOVIE")
    private String overview;

    @Column(name = "POPULARITY_MOVIE")
    private Double popularity;

    @Column(name = "POSTER_PATH_MOVIE")
    private String posterPath;

    @Column(name = "RELEASE_DATE_MOVIE")
    private String releaseDate;

    @Column(name = "TITLE_MOVIE")
    private String title;

    @Column(name = "VIDEO_MOVIE")
    private boolean video;

    @Column(name = "VT_AVRG_MOVIE")
    private double voteAverage;

    @Column(name = "VOTE_COUNT_MOVIE")
    private Integer voteCount;

    public Movie() {
    }

    public Movie(Long id, boolean adult, String backdropPath, Set<Genre> genres, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, String releaseDate, String title, boolean video, double voteAverage, Integer voteCount) {
        this.id = id;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.genres = genres;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Movie addGenre(Genre g) {
        genres.add(g);
        return this;
    }


    public Movie removeGenre(Genre g) {
        genres.remove(g);
        return this;
    }

    public Long getId() {
        return id;
    }

    public Movie setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isAdult() {
        return adult;
    }

    public Movie setAdult(boolean adult) {
        this.adult = adult;
        return this;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Movie setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public Movie setGenres(Set<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public Movie setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public Movie setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public Movie setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Movie setPopularity(Double popularity) {
        this.popularity = popularity;
        return this;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Movie setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Movie setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isVideo() {
        return video;
    }

    public Movie setVideo(boolean video) {
        this.video = video;
        return this;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public Movie setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Movie setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", adult=" + adult +
                ", backdropPath='" + backdropPath + '\'' +
                ", genres=" + genres +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}