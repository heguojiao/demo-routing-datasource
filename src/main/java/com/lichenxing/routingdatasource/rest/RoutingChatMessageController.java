package com.lichenxing.routingdatasource.rest;

import com.lichenxing.routingdatasource.domain.ChatMessage;
import com.lichenxing.routingdatasource.jpa.ChatMessageRepository;
import com.lichenxing.routingdatasource.routing.domain.RoutingChatMessage;
import com.lichenxing.routingdatasource.routing.jpa.RoutingChatMessageRepository;
import com.lichenxing.routingdatasource.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * RoutingChatMessageController
 *
 * @author Chenxing Li
 * @date 19/07/2017 00:22
 */
@Slf4j
@RestController
public class RoutingChatMessageController {

    @Autowired
    private RoutingChatMessageRepository routingChatMessageRepository;

    @RequestMapping(value = "/v5/{tenantId}/routing-messages", method = RequestMethod.GET)
    public Object getMessages(@PathVariable("tenantId") Integer tenantId) {
        log.info("GET /v5/{}/routing-messages", tenantId);
        return routingChatMessageRepository.findByTenantIdOrderByCreatedAtDesc(tenantId);
    }

    @RequestMapping(value = "/v5/{tenantId}/routing-messages", method = RequestMethod.POST)
    public Object saveMessages(@PathVariable("tenantId") Integer tenantId, @RequestBody RoutingChatMessage chatMessage) {
        log.info("POST /v5/{}/routing-messages body:{}", tenantId, JSONUtil.mapToJsonString(chatMessage));
        chatMessage.setMsgId(UUID.randomUUID().toString());
        chatMessage.setTenantId(tenantId);
        chatMessage.setCreatedAt(new Date());
        chatMessage.setUpdatedAt(new Date());
        routingChatMessageRepository.save(chatMessage);
        return chatMessage;
    }

}
