package com.ssafy.happyhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dtos.FavoriteDto;
import com.ssafy.happyhouse.model.dtos.FavAddressDto;
import com.ssafy.happyhouse.model.mapper.IFavoriteMapper;

@Service
public class FavoriteService {
	private final IFavoriteMapper favoriteMapper;

	@Autowired
	public FavoriteService(IFavoriteMapper favoriteMapper) {
		this.favoriteMapper = favoriteMapper;
	}

	public boolean registerFavorite(FavAddressDto favAddressDto) throws Exception {
		if (favAddressDto.getSido().equals("") || favAddressDto.getGugun().equals("")
				|| favAddressDto.getDong().equals(""))
			return false;
		if (favoriteMapper.selectFavoriteByUserId(favAddressDto) != null)
			return false;
		return favoriteMapper.insertFavorite(favAddressDto) == 1;
	}

	public List<FavAddressDto> listFavorite(String userId) throws Exception {
		return favoriteMapper.selectFavoriteAll(userId);
	}

	public boolean deleteFavorite(FavoriteDto favoriteDto) {
		return favoriteMapper.deleteFavorite(favoriteDto) == 1;
	}
}