package mate.academy.rickandmorty.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.ExternalCharacterResponseDto;
import mate.academy.rickandmorty.entity.Character;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ExternalClient {
    private static final String URL = "https://rickandmortyapi.com/api/character";
    private final ObjectMapper objectMapper;

    public List<Character> getAllCharacters() {
        List<Character> allCharacters = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        String nextUrl = URL;

        while (nextUrl != null && !nextUrl.isEmpty()) {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(nextUrl))
                    .build();
            try {
                HttpResponse<String> response = httpClient.send(
                        httpRequest,
                        HttpResponse.BodyHandlers.ofString()
                );
                ExternalCharacterResponseDto pageData = objectMapper.readValue(
                        response.body(),
                        ExternalCharacterResponseDto.class
                );

                allCharacters.addAll(pageData.getCharacters());
                nextUrl = pageData.getInfo().getNext();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Can't get response from source", e);
            }
        }
        return allCharacters;
    }
}
