package site.meta.finalkbo.domain.expulsion;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Expulsion {
    private Integer id;
    private String reason;
    private Integer playerId;
    private Timestamp createDate;
}
