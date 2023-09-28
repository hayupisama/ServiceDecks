package com.mstradingcards.ServiceDecks.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mstradingcards.ServiceDecks.dto.DeckDTO;
import com.mstradingcards.ServiceDecks.models.Deck;
import com.mstradingcards.ServiceDecks.repository.DeckRepository;

@Service
public class DeckService {

	@Autowired
	private DeckRepository decksRepository;

	public List<DeckDTO> getAllDecks(Long playerId) {
		List<Deck> decks = decksRepository.findByPlayerId(playerId);
		return decks.stream().map(this::mapToDeckDTO).collect(Collectors.toList());
	}

	public DeckDTO getDeckById(Long id) {
		return decksRepository.findById(id).map(this::mapToDeckDTO).orElse(null);
	}

	public DeckDTO createDeck(DeckDTO deckDTO, Long playerId) {
		Deck deck = mapToDeckEntity(deckDTO, playerId);
		Deck savedDeck = decksRepository.save(deck);
		return mapToDeckDTO(savedDeck);
	}

	public DeckDTO updateDeck(DeckDTO deckDTO, Long playerId) {
		Deck existingDeck = decksRepository.findByNameAndPlayerId(deckDTO.getName(), playerId).orElse(null);
		if (existingDeck != null) {
			Deck updatedDeck = mapToDeckEntity(deckDTO, playerId);
			updatedDeck.setId(existingDeck.getId());
			return mapToDeckDTO(decksRepository.save(updatedDeck));
		}
		return null;
	}

	public void deleteDeck(String name, Long playerId) {
		Deck existingDeck = decksRepository.findByNameAndPlayerId(name, playerId).orElse(null);
		if (existingDeck != null)
			decksRepository.delete(existingDeck);
	}

	private DeckDTO mapToDeckDTO(Deck deck) {
		DeckDTO deckDTO = new DeckDTO();
		deckDTO.setName(deck.getName());
		deckDTO.setCards(deck.getCards());
		return deckDTO;
	}

	private Deck mapToDeckEntity(DeckDTO deckDTO, Long playerId) {
		Deck deck = new Deck();
		deck.setName(deckDTO.getName());
		deck.setCards(deckDTO.getCards());
		deck.setPlayerId(playerId); // TODO GET PLAYER ID FROM JWT TOKEN
		return deck;
	}
}
