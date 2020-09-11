package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OutputPostMan {
    private Info info;
    private List<Item> item;
    private ProtocolProfileBehavior protocolProfileBehavior;
}
