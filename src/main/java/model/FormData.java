package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FormData {
    private String key;
    private String value;
    private String type;

    public static List<FormData> headerBuilder() {
        FormData formData1 = new FormData();
        formData1.setKey("access-token");
        formData1.setValue("{{access-token}}");
        formData1.setType("text");

        FormData formData2 = new FormData();
        formData2.setKey("accessKey");
        formData2.setValue("{{accessKey}}");
        formData2.setType("text");
        return Arrays.asList(formData1, formData2);
    }
}
