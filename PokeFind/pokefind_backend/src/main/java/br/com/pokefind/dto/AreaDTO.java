package br.com.pokefind.dto;

import br.com.pokefind.model.Area;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AreaDTO {
    private Long id;
    private String name;

    private String url;

    public AreaDTO(Area area){
        this.id = area.getId();
        this.name = area.getName();
        this.url = area.getUrl();
    }
}
