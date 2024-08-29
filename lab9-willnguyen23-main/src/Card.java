import java.util.Objects;

interface Comparable {
	public int compareTo(Card o);
}

public class Card implements Comparable {
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		if (rank == null || suit == null) {
			throw new NullPointerException();
		}
		this.rank = rank;
		this.suit = suit;
	}

	public int compareTo(Card o) {
		int rankComparison = this.rank.compareTo(o.getRank());
		int suitComparison = this.suit.compareTo(o.getSuit());
		
		if (suitComparison == 0) {
			if (rankComparison == 0) {
				return 0;
			}
			else {
				return rankComparison;
			}
			
		}
		else {
			return suitComparison;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			Card newObj = (Card) obj;
			
			if (newObj.getRank() == this.rank && newObj.getSuit() == this.suit) {
				return true;
			}
			else {
				return false;
			}
		}	
		else {
			return false;
		}

	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	@Override
	public int hashCode() {
		int result = Objects.hash(this.rank, this.suit);
		
		return result;
	}
	
	public String toString() {
		
		return this.rank + "" + this.suit;
	}

	
}
