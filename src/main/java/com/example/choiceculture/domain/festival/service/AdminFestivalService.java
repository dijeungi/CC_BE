package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.*;

import java.util.List;

public interface AdminFestivalService {

    List<FestivalInfoDTO> getProducts();

//    void addProduct(FestivalInfoDTO infoDTO);
//
//    void editProduct(FestivalInfoDTO infoDTO);

    void deleteProduct(Integer festivalId);

    List<FestivalResponseDTO> getIdList();

    List<FestivalInfoDTO> findProducts(String keyword);

}
