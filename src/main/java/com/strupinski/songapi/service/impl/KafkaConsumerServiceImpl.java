package com.strupinski.songapi.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.strupinski.songapi.dto.TrackDTO;
import com.strupinski.songapi.dto.converter.TrackMapper;
import com.strupinski.songapi.repository.SongRepository;
import com.strupinski.songapi.service.KafkaConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final SongRepository songRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void listenFromReceivingTopic(String message) {
        log.info("Message received: ");
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = objectMapper.readTree(message);
            TrackDTO trackDTO = objectMapper.treeToValue(rootNode.findValue("tracks")
                            .findValue("items")
                            .get(0),
                    TrackDTO.class);

            log.info("Track parsed successfully");
            log.info(String.valueOf(trackDTO));
            songRepository.save(TrackMapper.INSTANCE.trackDTOtoTrack(trackDTO));
        } catch (Exception e) {
            log.error("Error while file processing");
            log.error(e.getMessage());
        }
    }
}
