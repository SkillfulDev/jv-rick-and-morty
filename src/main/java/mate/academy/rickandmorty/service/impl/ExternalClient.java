package mate.academy.rickandmorty.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.ExternalCharacterResponseDto;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ExternalClient {
    private static final String URL = "https://rickandmortyapi.com/api/character";
    private final ObjectMapper objectMapper;

    public ExternalCharacterResponseDto getCharacters() {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(
                    httpRequest, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(
                    response.body(),
                    ExternalCharacterResponseDto.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Can't get response from source",e);
        }
    }
}
