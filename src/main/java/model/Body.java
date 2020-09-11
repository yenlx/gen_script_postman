package model;

import common.Const;
import common.ModeType;
import common.ParamType;
import common.ValidateType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static common.Const.LOREM;
import static common.Utils.genInvalidValueParams;

@Getter
@Setter
@NoArgsConstructor
public class Body {
    private String mode;
    private String raw;
    private Options options;
    private List<FormData> urlencoded;

    public static Body bodyWithUrlEncodeBuilder(InputParam inputParam, List<InputParam> inputParams, ValidateType type) {
        Body body = new Body();
        body.setMode(ModeType.URLENCODED.getIndex());
        body.setUrlencoded(buildUrlEncode(inputParam, inputParams, type));
        return body;
    }

    static List<FormData> buildUrlEncode(InputParam inputParam, List<InputParam> inputParams, ValidateType type) {
        List<FormData> data = new ArrayList<>();
        for (InputParam param : inputParams) {
            FormData f = new FormData();
            f.setKey(param.getName());
            f.setType(param.getType().getValue());
            if (inputParam.equals(param)) {
                f.setValue(genInvalidValueParams(type, inputParam.getLength() == null ? 0 : Integer.parseInt(inputParam.getLength()), param.getName()));
            } else {
                f.setValue(param.getType() == ParamType.ENUM ? String.valueOf(Const.ENUM) : LOREM.substring(0, inputParam.getLength() == null ? 0 : Integer.parseInt(inputParam.getLength())));
            }
            data.add(f);
        }
        return data;
    }
}
