package mate.academy.rickandmorty.dto.external;

import lombok.Data;

@Data
public class PageInfo {
    private String next;
    private String prev;
    private int pages;
    private int count;
}
