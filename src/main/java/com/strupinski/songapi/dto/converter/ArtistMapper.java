package com.strupinski.songapi.dto.converter;

import com.strupinski.songapi.dto.ArtistDTO;
import com.strupinski.songapi.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {

    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    Artist ArtistDTOToArtist(ArtistDTO artistDTO);

    ArtistDTO ArtistToArtistDTO(Artist artist);
}
