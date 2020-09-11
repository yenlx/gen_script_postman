package process.interpreter;

import common.ValidateType;
import model.InputParam;
import model.Item;
import model.Request;

import java.util.Collections;
import java.util.List;

import static model.Event.eventTestBuild;

public class ValidateBuilderContext {

    protected Item getValidateRequired(List<InputParam> params, InputParam param, String url, String method) {
        Item item = new Item();
        item.setName(param.getName() + " " + ValidateType.REQUIRED);
        item.setEvent(Collections.singletonList(eventTestBuild(param, ValidateType.REQUIRED)));
        item.setRequest(Request.requestBuilder(params, param, url, method, ValidateType.REQUIRED));
        return item;
    }

    protected Item getValidateOverLength(List<InputParam> params, InputParam param, String url, String method) {
        Item item = new Item();
        item.setName(param.getName() + " " + ValidateType.OVER_LENGTH);
        item.setEvent(Collections.singletonList(eventTestBuild(param, ValidateType.OVER_LENGTH)));
        item.setRequest(Request.requestBuilder(params, param, url, method, ValidateType.OVER_LENGTH));
        return item;
    }

    protected Item getValidateInvalidFormat(List<InputParam> params, InputParam param, String url, String method) {
        Item item = new Item();
        item.setName(param.getName() + " " + ValidateType.OVER_LENGTH);
        item.setEvent(Collections.singletonList(eventTestBuild(param, ValidateType.OVER_LENGTH)));
        item.setRequest(Request.requestBuilder(params, param, url, method, ValidateType.OVER_LENGTH));
        return item;
    }

}
