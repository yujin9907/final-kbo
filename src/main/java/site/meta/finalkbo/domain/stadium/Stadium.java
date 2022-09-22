package site.meta.finalkbo.domain.stadium;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Stadium {
    private Integer id;
    private String name;
    private Timestamp createDate;
}
