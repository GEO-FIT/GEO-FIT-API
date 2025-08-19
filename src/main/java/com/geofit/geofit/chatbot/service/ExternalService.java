package com.geofit.geofit.chatbot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geofit.geofit.chatbot.dto.request.BizRequest;
import com.geofit.geofit.chatbot.dto.response.BizResponse;

@Service
@Transactional(readOnly = true)
public class ExternalService {

    public BizResponse callBiz(BizRequest request) {
        // TODO 소상공인 외부 API 연결하고 거기서 얻어온 pdf 응답값의 링크 반환
        return new BizResponse(
            request.province() +
            request.city() +
            request.district() +
            request.category() + "PDF결과물링크"
        );
    }
}
