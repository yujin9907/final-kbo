package site.meta.finalkbo.domain.stadium;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
public class Stadium {
    private Integer id;
    private String name;
    private Timestamp createDate;

    public Stadium(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
