package hackerRank;
enum Suits{Spade,diamond,heart,club};
enum Ranks{one,two,three,four,manymore};
class Card
{
	Suits suit;
	int Rank;
	Card(Suits s,int rank)
	{
		this.suit=s;
		this.Rank=rank;
	}
}

public class deckOfCards {
	
	Card[] card;
	
	public deckOfCards() {
		// TODO Auto-generated constructor stub
			this.card=new Card[52];
			for(int i=0;i<52;i++)
				{
					this.card[i]=new Card(Suits.club,i%13);
				}
	}
	

}
