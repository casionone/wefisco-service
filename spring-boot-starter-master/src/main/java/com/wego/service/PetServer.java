package com.wego.service;

import com.wego.entity.Pet;
import com.wego.model.ResultModel;

import java.util.HashMap;
import java.util.List;

public interface PetServer {
    ResultModel<HashMap<String,List<Pet>>> showMarketPet();
}
