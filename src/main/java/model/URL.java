package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class URL {
    private String raw;
    private List<String> host;
    private List<String> path;

    public static URL urlBuilder(String url) {
        return URL.builder()
                .host(Collections.singletonList(url.split("/")[0]))
                .raw(url)
                .path(Arrays.stream(url.split("/"))
                        .map(i -> i.replaceAll("/", ""))
                        .skip(1)
                        .collect(Collectors.toList()))
                .build();
    }
}
