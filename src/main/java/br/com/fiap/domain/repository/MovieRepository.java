package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Movie;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MovieRepository implements Repository<Movie, Long>{
    private static final AtomicReference<MovieRepository> instance = new AtomicReference<>();

    private final EntityManager manager;

    private MovieRepository(EntityManager manager) {
        this.manager = manager;
    }

    public static MovieRepository build(EntityManager manager) {
        instance.compareAndSet(null, new MovieRepository(manager));
        return instance.get();
    }

    @Override
    public List<Movie> findAll() {
        return manager.createQuery("From Movie").getResultList();
    }

    @Override
    public Movie findById(Long id) {
        return manager.find(Movie.class, id);
    }

    @Override
    public Movie persist(Movie movie) {
        try {
            manager.getTransaction().begin();
            movie = manager.merge(movie);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException("Erro ao persistir filme", e);
        }
        return movie;
    }

}
