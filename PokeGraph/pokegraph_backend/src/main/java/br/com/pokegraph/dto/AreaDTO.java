package br.com.pokegraph.dto;

import br.com.pokegraph.model.Area;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AreaDTO {
    private Long id;
    private String name;

    public AreaDTO(Area area){
        this.id = area.getId();
        this.name = area.getName();
    }
}
