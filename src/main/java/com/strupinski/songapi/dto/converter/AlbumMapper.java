package com.strupinski.songapi.dto.converter;

import com.strupinski.songapi.dto.AlbumDTO;
import com.strupinski.songapi.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper {

    AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);

    AlbumDTO AlbumtoAlbumDTO(Album album);

    Album AlbumDTOtoAlbum(AlbumDTO albumDTO);
}
