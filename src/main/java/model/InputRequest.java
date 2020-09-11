package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class InputRequest {
    private String url;
    private String method;
    private List<InputParam> params;
}
