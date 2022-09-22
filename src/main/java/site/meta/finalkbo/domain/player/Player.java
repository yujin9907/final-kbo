package site.meta.finalkbo.domain.player;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Player {
    private Integer id;
    private String name;
    private Integer teamId;
    private String position;
    private Timestamp createDate;
}
