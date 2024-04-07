package mate.academy.rickandmorty.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import mate.academy.rickandmorty.entity.Character;

@Data
public class ExternalCharacterResponseDto {
    @JsonProperty("results")
    private List<Character> characters;
    @JsonProperty("info")
    private PageInfo info;
}
