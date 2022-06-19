package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dtos.FavAddressDto;
import com.ssafy.happyhouse.model.dtos.FavoriteDto;

@Mapper
public interface IFavoriteMapper {
	int deleteFavorite(FavoriteDto favoriteDto);

	int insertFavorite(FavAddressDto favAddressDto);
	
	List<FavAddressDto> selectFavoriteAll(String userId);
	
	FavoriteDto selectFavoriteByUserId(FavAddressDto favAddressDto);
}
