package site.meta.finalkbo.web.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TeamViewDto {
    private Integer id;
    private String name;
    private Timestamp createDate;
    private String stadiumName;
    private Integer stadiumId;
}
