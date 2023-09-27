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

	@GetMapping("/getAllDecks")
	public List<DeckDTO> getAllDecks() {
		// TODO GET PLAYER ID FROM JWT TOKEN
		Long playerId = -1L;
		return deckService.getAllDecks(playerId);
	}

	@PutMapping("/updateDeck/{id}")
	public DeckDTO updateDeck(@PathVariable Long id, @RequestBody DeckDTO deckDTO) {
		// TODO GET PLAYER ID FROM JWT TOKEN
		Long playerId = -1L;
		return deckService.updateDeck(id, deckDTO, playerId);
	}

	@GetMapping("/getDeckById/{id}")
	public DeckDTO getDeckById(@PathVariable Long id) {
		return deckService.getDeckById(id);
	}

	@PostMapping("/createDeck")
	public DeckDTO createDeck(@RequestBody DeckDTO deckDTO) {
		// TODO GET PLAYER ID FROM JWT TOKEN
		Long playerId = -1L;
		return deckService.createDeck(deckDTO, playerId);
	}

	@DeleteMapping("/deleteDeck/{id}")
	public void deleteDeck(@PathVariable Long id) {
		deckService.deleteDeck(id);
	}
}
