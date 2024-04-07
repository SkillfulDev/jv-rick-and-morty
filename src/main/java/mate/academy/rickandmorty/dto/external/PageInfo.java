package mate.academy.rickandmorty.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PageInfo {
    @JsonProperty("next")
    private String next;
    @JsonProperty("prev")
    private String prev;
    @JsonProperty("pages")
    private int pages;
    @JsonProperty("count")
    private int count;
}
