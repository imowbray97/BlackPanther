package com.panthers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panthers.entity.BCharacter;
import com.panthers.repository.CharacterRepository;


@Service
public class CharacterService implements ICharacterService{

	@Autowired
	CharacterRepository characterRepository;

	public List<BCharacter> getAllCharacters() {
		List<BCharacter> list = new ArrayList<>();
		characterRepository.findAll().forEach(c -> list.add(c));
		return list;
	}

	public BCharacter getCharacterById(long characterId) {
		BCharacter character = characterRepository.findByCharacterId(characterId);
		return character;
	}

	public boolean addCharacter(BCharacter character) {
		 List<BCharacter> list = characterRepository.findByNameAndDescription(character.getName(), character.getDescription()); 	
         if (list.size() > 0) {
	           return false;
         } else {
	           character = characterRepository.save(character);
	           return true;
         }
	}

	public void updateCharacter(BCharacter character) {
		characterRepository.save(character);		
	}

	public void deleteCharacter(BCharacter character) {
		characterRepository.delete(character);		
	}

}
