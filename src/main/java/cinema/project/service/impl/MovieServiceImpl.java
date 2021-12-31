package cinema.project.service.impl;

import cinema.project.dao.MovieDao;
import cinema.project.lib.Inject;
import cinema.project.lib.Service;
import cinema.project.model.Movie;
import cinema.project.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
