package model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private String name;
    private List<Event> event;
    private Request request;
    private List<Object> response;
}
