package site.meta.finalkbo.domain.expulsion;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter

public class Expulsion {
    private Integer id;
    private String reason;
    private Integer playerId;
    private Timestamp createDate;
}
