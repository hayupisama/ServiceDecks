package com.mstradingcards.ServiceDecks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mstradingcards.ServiceDecks.dto.DeckDTO;
import com.mstradingcards.ServiceDecks.services.DeckService;

@RestController
@RequestMapping("/api/decks")
public class DeckController {

	@Autowired
	private DeckService deckService;

	@GetMapping("/getAllDecks/{playerId}")
	public List<DeckDTO> getAllDecks(@PathVariable Long playerId) {
		return deckService.getAllDecks(playerId);
	}

	

	@GetMapping("/getDeckById/{id}")
	public DeckDTO getDeckById(@PathVariable Long id) {
		return deckService.getDeckById(id);
	}

	@PostMapping("/createDeck/{playerId}")
	public DeckDTO createDeck(@RequestBody DeckDTO deckDTO, @PathVariable Long playerId) {
		return deckService.createDeck(deckDTO, playerId);
	}

	@PutMapping("/updateDeck/{playerId}")
	public DeckDTO updateDeck(@RequestBody DeckDTO deckDTO, @PathVariable Long playerId) {
		return deckService.updateDeck(deckDTO, playerId);
	}
	@DeleteMapping("/deleteDeck/{name}/{playerId}")
	public void deleteDeck(@PathVariable String name, @PathVariable Long playerId) {
		deckService.deleteDeck(name, playerId);
	}
}
