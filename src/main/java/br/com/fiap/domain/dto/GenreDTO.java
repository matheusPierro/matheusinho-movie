package br.com.fiap.domain.dto;

import br.com.fiap.Main;
import br.com.fiap.domain.entity.Genre;
import br.com.fiap.domain.service.GenreService;
import br.com.fiap.domain.service.MovieService;
import br.com.fiap.infra.security.service.PessoaFisicaService;

import java.util.Objects;

public record GenreDTO(
        Long id,
        String name
) {
    private static GenreService service = GenreService.build(Main.PERSISTENCE_UNIT);
    private static MovieService movieService = MovieService.build(Main.PERSISTENCE_UNIT);

    public static Genre of(GenreDTO dto) {

        if (Objects.isNull(dto)) return null;

        Genre p = new Genre();

        if (Objects.nonNull(dto.id)) {
            p = service.findById(dto.id);
        }

        if (Objects.nonNull(dto.name)) {
            p.setName(dto.name);
        }

        return p;
    }

    public static GenreDTO of(Genre g) {
        return new GenreDTO(g.getId(), g.getName());
    }
}
