package mate.academy.rickandmorty.config;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.ExternalCharacterResponseDto;
import mate.academy.rickandmorty.repository.RickAndMortyRepository;
import mate.academy.rickandmorty.service.impl.ExternalClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializationData implements CommandLineRunner {
    private final ExternalClient externalClient;
    private final RickAndMortyRepository rickAndMortyRepository;

    @Override
    public void run(String... args) throws Exception {
        ExternalCharacterResponseDto characters = externalClient.getCharacters();
        rickAndMortyRepository.saveAll(characters.getCharacters());
    }
}
