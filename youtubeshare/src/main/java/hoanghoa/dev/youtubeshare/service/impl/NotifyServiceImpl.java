package hoanghoa.dev.youtubeshare.service.impl;

import hoanghoa.dev.youtubeshare.service.INotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotifyServiceImpl implements INotifyService {

    @Autowired
    private SimpMessagingTemplate template;
    public void processMsg(String msg) {
        // pushing the data to websocket
        this.template.convertAndSend("/topic/server-notification", msg);
    }
}
