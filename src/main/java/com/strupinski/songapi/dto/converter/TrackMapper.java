package com.strupinski.songapi.dto.converter;// TrackMapper.java
import com.strupinski.songapi.dto.TrackDTO;
import com.strupinski.songapi.entity.Track;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AlbumMapper.class)
public interface TrackMapper {

    TrackMapper INSTANCE = Mappers.getMapper(TrackMapper.class);

    Track trackDTOtoTrack(TrackDTO trackDTO);

    TrackDTO trackToTrackDTO(Track track);

}

