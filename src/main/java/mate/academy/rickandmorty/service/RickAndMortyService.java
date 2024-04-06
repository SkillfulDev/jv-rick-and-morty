package mate.academy.rickandmorty.service;

import mate.academy.rickandmorty.dto.internal.CharacterResponseDto;

import java.util.List;

public interface RickAndMortyService {
    CharacterResponseDto getRandomCharacter();

    List<CharacterResponseDto> findByNameLike(String params);
}
