package com.geofit.geofit.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geofit.geofit.chatbot.dto.response.MessageResponse;

@Service
@Transactional(readOnly = true)
public class DemoService {

    public MessageResponse getOne() {
        return new MessageResponse(
            "COLLECT",
            "창업 공간 추천을 위해 임대료, 면적, 층수와 같은 정보를 추가로 입력해주시면 좋아요",
            new ArrayList<>()
        );
    }

    public MessageResponse getTwo() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(183);
        ids.add(11);
        ids.add(53);
        return new MessageResponse(
            "RESPONSE",
            "매물을 추천해드릴게요",
            ids
        );
    }

    public MessageResponse getThree() {
        return new MessageResponse(
            "POLICY",
            "당신에게 맞는 정책엔 A, B, C가 있어요",
            new ArrayList<>()
        );
    }

    public MessageResponse getFour() {
        return new MessageResponse(
            "EVALUATION",
            "응답이 어떠셨나요? 별점으로 평가해주세요",
            new ArrayList<>()
        );
    }

    public List<MessageResponse> getAllResponses() {
        List<MessageResponse> responses = new ArrayList<>();
        responses.add(getOne());
        responses.add(getTwo());
        responses.add(getThree());
        responses.add(getFour());
        return responses;
    }
}
