package org.launchcode.tattoo_finder.models.data;

import org.launchcode.tattoo_finder.models.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
