package site.meta.finalkbo.domain.stadium;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Stadium {
    private Integer id;
    private String name;
    private Timestamp createDate;
}
