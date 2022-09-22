package site.meta.finalkbo.domain.team;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Team {
    private Integer id;
    private Integer stadiumId;
    private String name;
    private Timestamp createDate;
}
