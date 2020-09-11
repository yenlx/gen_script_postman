package model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Info {
    private UUID postmanID;
    private String name;
    private String schema;
}
