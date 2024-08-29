import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
	private static Map<Rank, Integer> CARD_VALUES;
	private final static int MAX_VALUE = 21;
	private List<Card> cards;
	List<Card> cardsCopy;
	private int value = 0;
	private int numAcesAs11 = 0;

	
	private static Map<Rank, Integer> initializeMap() {
		Map<Rank, Integer> input = new HashMap<Rank, Integer>();
		input.put(Rank.TWO, 2);
		input.put(Rank.THREE, 3);
		input.put(Rank.FOUR, 4);
		input.put(Rank.FIVE, 5);
		input.put(Rank.SIX, 6);
		input.put(Rank.SEVEN, 7);
		input.put(Rank.EIGHT, 8);
		input.put(Rank.NINE, 9);
		input.put(Rank.TEN, 10);
		input.put(Rank.JACK, 10);
		input.put(Rank.QUEEN, 10);
		input.put(Rank.KING, 10);
		input.put(Rank.ACE, 11);
		
		return input;
	} 
	
	public BlackjackHand(Card c1, Card c2) {
		cards = new ArrayList<Card>();
		addCard(c1);
		addCard(c2);
		
		CARD_VALUES = initializeMap();
	}
	
	public void addCard(Card card) {
		if (card == null) {
			throw new NullPointerException();
		} 
		else if (getValue() < MAX_VALUE) {
			cards.add(card);
			value = getValue();
		}
	}
	
	public int size() {
		
		return cards.size();
	}
	
	public static Map<Rank, Integer> getCardValues() {
		CARD_VALUES = initializeMap();
		
		return CARD_VALUES;
	}
	
	public List<Card> getCards() throws NullPointerException {
		
		
		return new ArrayList<>(cards);
	}
	
	public int getValue() {
		int result = 0;
		int resultBeforeAces = 0;
		int acesAmount = 0;
	
		for (int i = 0; i < cards.size(); ++i) {
			if (cards.get(i).getRank().equals(Rank.ACE)) {
				acesAmount++;
			}
		}
		
		for (int j = 0; j < cards.size(); ++j) {
			if (cards.get(j).getRank().equals(Rank.ACE)) {
				result += 0;
				continue;
			}
			else {
				resultBeforeAces += CARD_VALUES.get(cards.get(j).getRank());
			}
			
		}
		
		numAcesAs11 = acesAmount;
		result = resultBeforeAces;
		
		while (numAcesAs11 >= 0) {
			result = resultBeforeAces;
			for (int k = 0; k < numAcesAs11; ++k) {
				result += 11;
			}
			
			for (int l = 0; l < acesAmount - numAcesAs11; ++l) {
				result++;
			}
			
			if (result <= MAX_VALUE) {
				break;
			}
			
			numAcesAs11--;
		}
		
		return result;
	}
	
	public String toString() {
		
		return cards.toString();
	}
}
