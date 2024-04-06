package mate.academy.rickandmorty.mapper.impl;

import mate.academy.rickandmorty.dto.internal.CharacterResponseDto;
import mate.academy.rickandmorty.entity.Character;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapperImpl implements CharacterMapper {
    public CharacterMapperImpl() {
    }

    public CharacterResponseDto toDto(Character character) {
        if (character == null) {
            return null;
        } else {
            CharacterResponseDto characterResponseDto = new CharacterResponseDto();
            if (character.getId() != null) {
                characterResponseDto.setId(character.getId());
            }

            if (character.getExternalId() != null) {
                characterResponseDto.setExternalId(character.getExternalId());
            }

            if (character.getName() != null) {
                characterResponseDto.setName(character.getName());
            }

            if (character.getStatus() != null) {
                characterResponseDto.setStatus(character.getStatus());
            }

            if (character.getGender() != null) {
                characterResponseDto.setGender(character.getGender());
            }

            return characterResponseDto;
        }
    }
}
