package com.panthers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.panthers.entity.BCharacter;



public interface CharacterRepository extends CrudRepository<BCharacter, Long>  {
	BCharacter findByCharacterId(long characterId);
    List<BCharacter> findByNameAndDescription(String name, String description);
} 