package com.mstradingcards.ServiceDecks.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstradingcards.ServiceDecks.models.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {

    // Query to find a deck by its name
    Optional<Deck> findByName(String name);

    // Query to find all decks belonging to a specific player
    List<Deck> findByPlayerId(Long playerId);

    // Query to find all decks containing a specific card
    List<Deck> findByCardsContaining(String card);

}

