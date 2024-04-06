package mate.academy.rickandmorty.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharacterResponseDto;
import mate.academy.rickandmorty.entity.Character;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.repository.RickAndMortyRepository;
import mate.academy.rickandmorty.service.RickAndMortyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class RickAndMortyServiceImpl implements RickAndMortyService {
    private static final Random random = new Random();
    private final RickAndMortyRepository rickAndMortyRepository;
    private final CharacterMapper characterMapper;

    @Override
    public CharacterResponseDto getRandomCharacter() {
        long maxGeneratedNumber = rickAndMortyRepository.count() + 1;
        return characterMapper.toDto(rickAndMortyRepository.findById(
                        random.nextLong(1, maxGeneratedNumber)).orElseThrow(() ->
                        new RuntimeException("Can't find Character in DB")));
    }

    @Override
    public List<CharacterResponseDto> findByNameLike(String params) {
        List<Character> foundedCharactersFromDB =
                rickAndMortyRepository.findAllByNameContainsIgnoreCase(params);
        return foundedCharactersFromDB.stream()
                .map(characterMapper::toDto)
                .toList();
    }
}
