package mate.academy.rickandmorty.repository;

import mate.academy.rickandmorty.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RickAndMortyRepository extends JpaRepository<Character,Long> {
    List<Character> findAllByNameContainsIgnoreCase(String params);
}
