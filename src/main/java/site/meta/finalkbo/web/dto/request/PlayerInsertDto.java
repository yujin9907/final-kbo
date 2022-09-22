package site.meta.finalkbo.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerInsertDto {
    private String name;
    private Integer teamId;
    private String position;
}
