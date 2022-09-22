package site.meta.finalkbo.domain.team;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Team {
    private Integer id;
    private Integer stadiumId;
    private String name;
    private Timestamp createDate;
}
