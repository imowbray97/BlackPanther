package com.panthers.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.panthers.entity.BCharacter;
import com.panthers.panthers_ws.AddCharacterRequest;
import com.panthers.panthers_ws.AddCharacterResponse;
import com.panthers.panthers_ws.CharacterInfo;
import com.panthers.panthers_ws.DeleteCharacterRequest;
import com.panthers.panthers_ws.DeleteCharacterResponse;
import com.panthers.panthers_ws.GetAllCharactersResponse;
import com.panthers.panthers_ws.GetCharacterByIdRequest;
import com.panthers.panthers_ws.GetCharacterByIdResponse;
import com.panthers.panthers_ws.ServiceStatus;
import com.panthers.panthers_ws.UpdateCharacterRequest;
import com.panthers.panthers_ws.UpdateCharacterResponse;
import com.panthers.services.ICharacterService;





@Endpoint
public class CharacterEndpoints {
	private static final String NAMESPACE_URI = "http://www.panthers.com/panthers-ws";

	@Autowired
	ICharacterService characterService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCharacterByIdRequest")
	@ResponsePayload
	public GetCharacterByIdResponse getCharacter(@RequestPayload GetCharacterByIdRequest request) {
		GetCharacterByIdResponse response = new GetCharacterByIdResponse();
		CharacterInfo characterInfo = new CharacterInfo();
		BeanUtils.copyProperties(characterService.getCharacterById(request.getCharacterId()), characterInfo);
		response.setCharacterInfo(characterInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCharactersRequest")
	@ResponsePayload
	public GetAllCharactersResponse getAllCharacters() {
		GetAllCharactersResponse response = new GetAllCharactersResponse();
		List<CharacterInfo> characterInfoList = new ArrayList<>();
		List<BCharacter> charactersList = characterService.getAllCharacters();
		for (int i = 0; i < charactersList.size(); i++) {
			CharacterInfo details = new CharacterInfo();
			BeanUtils.copyProperties(charactersList.get(i), details);
			characterInfoList.add(details);
		}
		response.getCharacterInfo().addAll(characterInfoList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCharacterRequest")
	@ResponsePayload
	public AddCharacterResponse addCharacter(@RequestPayload AddCharacterRequest request) {
		AddCharacterResponse response = new AddCharacterResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		BCharacter character = new BCharacter();
		character.setName(request.getName());
		character.setDescription(request.getDescription());
		boolean flag = characterService.addCharacter(character);
		if (flag == false) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Content Already Available");
			response.setServiceStatus(serviceStatus);
		} else {
			CharacterInfo characterInfo = new CharacterInfo();
			BeanUtils.copyProperties(character, characterInfo);
			response.setCharacterInfo(characterInfo);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Added Successfully");
			response.setServiceStatus(serviceStatus);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCharacterRequest")
	@ResponsePayload
	public UpdateCharacterResponse updateCharacter(@RequestPayload UpdateCharacterRequest request) {
		BCharacter character = new BCharacter();
		BeanUtils.copyProperties(request.getCharacterInfo(), character);
		characterService.updateCharacter(character);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateCharacterResponse response = new UpdateCharacterResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCharacterRequest")
	@ResponsePayload
	public DeleteCharacterResponse deleteArticle(@RequestPayload DeleteCharacterRequest request) {
		BCharacter character = characterService.getCharacterById(request.getCharacterId());
		ServiceStatus serviceStatus = new ServiceStatus();
		if (character == null) {
			serviceStatus.setStatusCode("FAIL");
			serviceStatus.setMessage("Content Not Available");
		} else {
			characterService.deleteCharacter(character);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Deleted Successfully");
		}
		DeleteCharacterResponse response = new DeleteCharacterResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

}
