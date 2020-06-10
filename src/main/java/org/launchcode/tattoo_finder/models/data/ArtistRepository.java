package org.launchcode.tattoo_finder.models.data;

import org.launchcode.tattoo_finder.models.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
