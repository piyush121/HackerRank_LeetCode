package hackerRank;

import java.util.*;

class Movie implements Comparable<Movie>
{
	int rating;
	String Genre;
	public Movie(int r,String g)
	{
		this.rating=r;
		this.Genre=g;
	}

	@Override
	public int compareTo(Movie o2) {
		// TODO Auto-generated method stub
		if(this.rating==o2.rating)
			return 0;
		if(this.rating>o2.rating)
				return 1;
		return -1;
	}
}

public class MovieRating {
	
	List<Movie> movies=new LinkedList<>();
	public void showMovie()
	{
		movies.add(new Movie(9,"Horror"));
		movies.add(new Movie(8,"Horror"));
		movies.add(new Movie(10,"Horror"));
		movies.sort(null);

}

}