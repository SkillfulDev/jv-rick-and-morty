package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.dto.internal.CharacterResponseDto;
import mate.academy.rickandmorty.entity.Character;

public interface CharacterMapper {
    CharacterResponseDto toDto(Character character);
}
