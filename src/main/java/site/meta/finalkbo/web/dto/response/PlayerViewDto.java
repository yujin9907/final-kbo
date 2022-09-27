package site.meta.finalkbo.web.dto.response;

import lombok.Getter;
import lombok.Setter;
import site.meta.finalkbo.domain.expulsion.Expulsion;

import java.sql.Timestamp;

@Getter
@Setter
public class PlayerViewDto {
    private Integer id;
    private String name;
    private Integer teamId;
    private String position;
    private Timestamp createDate;
    private String teamName;
}
