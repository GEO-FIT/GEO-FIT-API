package com.geofit.geofit._common.client.dto.response;

import java.util.ArrayList;
import java.util.List;

public record TestResponse(
    String type,
    String content,
    List<Integer> Ids
) {

    public static TestResponse from() {
        List<Integer> ids = new ArrayList<>();
        ids.add(51);
        ids.add(52);
        ids.add(53);
        return new TestResponse("RESULT", "채팅내용", ids);
    }
}
