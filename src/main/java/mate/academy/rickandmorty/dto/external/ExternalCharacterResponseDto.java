package mate.academy.rickandmorty.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import mate.academy.rickandmorty.entity.Character;

import java.util.List;

@Data
public class ExternalCharacterResponseDto {
    @JsonProperty("results")
    private List<Character> characters;
}
