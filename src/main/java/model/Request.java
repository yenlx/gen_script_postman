package model;

import common.ValidateType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static model.FormData.headerBuilder;
import static model.URL.urlBuilder;

@Getter
@Setter
@NoArgsConstructor
public class Request {
    private String method;
    private List<FormData> header;
    private Body body;
    private URL url;

    public static Request requestBuilder(List<InputParam> inputParams, InputParam inputParam, String url, String method, ValidateType type) {
        Request request = new Request();
        request.setMethod(method);
        request.setHeader(headerBuilder());
        request.setUrl(urlBuilder(url));
        request.setBody(Body.bodyWithUrlEncodeBuilder(inputParam, inputParams, type));
        return request;
    }


}
