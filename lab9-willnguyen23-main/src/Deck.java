import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		Card newCard;
		Rank[] rank = Rank.values();
		Suit[] suit = Suit.values();
		
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 13; ++j) {
				newCard = new Card(rank[j], suit[i]);
				cards.add(newCard);
			}
			
		}
	}
	
	public int size() {
		
		return cards.size();
	}
	
	public String toString() {
		
		return cards.toString();
	}
	
	public Card draw() {
		if (cards.size() == 0) {
			return null;
		}
		Card card = cards.get(0);
		cards.remove(0);
		
		return card;
	}
	
	public List<Card> draw(int count) {
		List<Card> newDeck;
		if (count > cards.size()) {
			newDeck = new ArrayList<Card>(count);
			
			while (!(cards.size() == 0)) {
				newDeck.add(cards.get(0));
				cards.remove(0);
			}
			
			return newDeck;
		}
		else if (count < 0) {
			newDeck = new ArrayList<Card>(0);
			
			return newDeck;
		}
		else {
			newDeck = new ArrayList<Card>(count);
			
			for (int j = 0; j < count; ++j) {
				newDeck.add(cards.get(0));
				cards.remove(0);
			}
			
			return newDeck;
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);;
	}
	
	public List<Card> getCardsByRank(Rank rank) {
		List<Card> sortedDeck = new ArrayList<Card>();
		
		for (int i = 0; i < cards.size(); ++i) {
			if (cards.get(i).getRank().equals(rank)) {
				sortedDeck.add(cards.get(i));
			}
		}
		
		return sortedDeck;
	}
}
