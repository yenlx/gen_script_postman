package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static common.Const.SCHEMA;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class PostManOutputData {
    private InputCollection inputCollection;
    private List<Item> items;

    public OutputPostMan outputPostMan() {
        OutputPostMan out = new OutputPostMan();
        out.setInfo(Info.builder().postmanID(UUID.randomUUID()).name(getInputCollection().getName()).schema(SCHEMA).build());
        out.setItem(items);
        return out;
    }

    public void addAllItem(List<Item> items) {
        if (this.items == null) this.items = new ArrayList<>();
        this.items.addAll(items);
    }
}
