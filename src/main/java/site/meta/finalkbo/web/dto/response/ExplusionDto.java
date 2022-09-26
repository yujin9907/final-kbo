package site.meta.finalkbo.web.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
// 삭제할거
@Getter
@Setter
public class ExplusionDto {
    private Integer id;
    private String teamName;
    private String position;
    private String playerName;
    private String reason;
    private Timestamp createDate;
}
