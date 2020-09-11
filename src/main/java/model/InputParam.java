package model;

import common.ParamType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class InputParam {
    private String name;
    private ParamType type;
    private String length;
    private String format;

}
