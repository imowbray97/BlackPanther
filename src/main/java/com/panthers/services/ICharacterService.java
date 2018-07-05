package com.panthers.services;

import java.util.List;

import com.panthers.entity.BCharacter;


public interface ICharacterService {
    List<BCharacter> getAllCharacters();
    BCharacter getCharacterById(long characterId);
    boolean addCharacter(BCharacter character);
    void updateCharacter(BCharacter character);
    void deleteCharacter(BCharacter character);
} 