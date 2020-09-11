package process.interpreter;

import model.InputCollection;
import model.InputParam;
import model.InputRequest;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ValidateInvalidFormat implements ValidateInterpreter {
    private InputCollection inputCollection;

    public ValidateInvalidFormat(InputCollection inputCollection) {
        this.inputCollection = inputCollection;
    }

    @Override
    public List<Item> interpret(ValidateBuilderContext context) {
        List<Item> items = new ArrayList<>();
        for (InputRequest request : inputCollection.getRequests()) {
            for (InputParam param : request.getParams()) {
                Item item = context.getValidateInvalidFormat(request.getParams(), param, request.getUrl(), request.getMethod());
                items.add(item);
            }
        }
        return items;
    }
}
