package site.meta.finalkbo.domain.player;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Player {
    private Integer id;
    private String name;
    private Integer teamId;
    private String position;
    private Timestamp createDate;

    // 엔티티 아님
    private String teamName;

    // ??
    public Player(String name, Integer teamId, String position) {
        this.name = name;
        this.teamId = teamId;
        this.position = position;
    }
}
