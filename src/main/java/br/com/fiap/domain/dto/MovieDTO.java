package br.com.fiap.domain.dto;

import br.com.fiap.Main;
import br.com.fiap.domain.entity.Genre;
import br.com.fiap.domain.entity.Movie;
import br.com.fiap.domain.service.GenreService;
import br.com.fiap.domain.service.MovieService;
import br.com.fiap.infra.security.dto.PessoaDTO;
import br.com.fiap.infra.security.service.PessoaFisicaService;
import br.com.fiap.infra.security.service.PessoaJuridicaService;

import java.util.Objects;
import java.util.Set;

public record MovieDTO(
        Long id,
        boolean adult,
        String backdropPath,
        Set<? extends Genre> genres,
        String originalLanguage,
        String originalTitle,
        String overview,
        Double popularity,
        String posterPath,
        String releaseDate,
        String title,
        boolean video,
        double voteAverage,
        Integer voteCount
) {

    private static MovieService service = MovieService.build(Main.PERSISTENCE_UNIT);
    private static GenreService genreService = GenreService.build(Main.PERSISTENCE_UNIT);


    public static Movie of(MovieDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("MovieDTO não pode ser nulo");
        }

        Movie movie = (dto.id != null) ? service.findById(dto.id) : new Movie();


        movie.setAdult(dto.adult);

        if (dto.backdropPath == null || dto.backdropPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo 'backdropPath' não pode ser nulo ou vazio");
        } else {
            movie.setBackdropPath(dto.backdropPath);
        }

        if (dto.genres != null) {
            dto.genres.forEach(genreDTO -> {
                Genre genre;
                if (genreDTO.getId() != null) {
                    genre = genreService.findById(genreDTO.getId());
                    if (genre == null) {
                        throw new IllegalArgumentException("Gênero com ID " + genreDTO.getId() + " não encontrado");
                    }
                } else {
                    genre = new Genre();
                    genre.setName(genreDTO.getName());
                }
                movie.addGenre(genre);
            });
        }

        if (dto.originalLanguage == null || dto.originalLanguage.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo 'originalLanguage' não pode ser nulo ou vazio");
        } else {
            movie.setOriginalLanguage(dto.originalLanguage);
        }

        if (dto.originalTitle == null || dto.originalTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo 'originalTitle' não pode ser nulo ou vazio");
        } else {
            movie.setOriginalTitle(dto.originalTitle);
        }

        if (dto.overview == null || dto.overview.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo 'overview' não pode ser nulo ou vazio");
        } else {
            movie.setOverview(dto.overview);
        }

        if (dto.popularity == null) {
            throw new IllegalArgumentException("Campo 'popularity' não pode ser nulo");
        } else {
            movie.setPopularity(dto.popularity);
        }

        if (dto.posterPath == null || dto.posterPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo 'posterPath' não pode ser nulo ou vazio");
        } else {
            movie.setPosterPath(dto.posterPath);
        }

        if (dto.releaseDate == null || dto.releaseDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo 'releaseDate' não pode ser nulo ou vazio");
        } else {
            movie.setReleaseDate(dto.releaseDate);
        }

        if (dto.title == null || dto.title.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo 'title' não pode ser nulo ou vazio");
        } else {
            movie.setTitle(dto.title);
        }

        movie.setVideo(dto.video);

        movie.setVoteAverage(dto.voteAverage);

        if (dto.voteCount == null) {
            throw new IllegalArgumentException("Campo 'voteCount' não pode ser nulo");
        } else {
            movie.setVoteCount(dto.voteCount);
        }

        return movie;
    }

    public static MovieDTO of(Movie m) {
        return new MovieDTO(m.getId(), m.isAdult(), m.getBackdropPath(), m.getGenres(), m.getOriginalLanguage(), m.getOriginalTitle(), m.getOverview(), m.getPopularity(), m.getPosterPath(), m.getReleaseDate(), m.getTitle(), m.isVideo(), m.getVoteAverage(), m.getVoteCount());
    }


}
