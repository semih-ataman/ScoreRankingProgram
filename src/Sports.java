import java.util.Comparator;

/**
 * @author Semih Ataman
 * @since 17-April-2021
 */
/**
 * @author Semih
 *
 */
public class Sports implements Comparable<Object> {

	private String name;
	private int totalScoredAgainstTeam;
	private int totalScoredItself;
	private int totalPoint;
	private int numberOfWonMatches;
	private int numberOfTiedMatches;
	private int numberOfLossMatches;

	public Sports(String name, int scoredAgainstTeam, int scoredItself) {
		this.name = name;
		addTotalScoredAgainstTeam(scoredAgainstTeam);
		addTotalScoredItself(scoredItself);
	}

	public String getName() {
		return name;
	}

	public int getTotalScoredAgainstTeam() {
		return totalScoredAgainstTeam;
	}

	public int getTotalScoredItself() {
		return totalScoredItself;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void addTotalScoredAgainstTeam(int scoredAgainstTeam) {
		totalScoredAgainstTeam += scoredAgainstTeam;
	}

	public void addTotalScoredItself(int scoredItself) {
		totalScoredItself += scoredItself;
	}

	public int getNumberOfWonMatches() {
		return numberOfWonMatches;
	}

	public int getNumberOfTiedMatches() {
		return numberOfTiedMatches;
	}

	public int getNumberOfLossMatches() {
		return numberOfLossMatches;
	}

	public int getNumberOfAllMatches() {
		return getNumberOfWonMatches() + getNumberOfTiedMatches() + getNumberOfLossMatches();
	}

	public boolean isWon(int scoredAgainstTeam, int scoredItself) {
		if (scoredAgainstTeam > scoredItself) {
			numberOfWonMatches++;
			return true;
		}
		return false;
	}

	public boolean isLoss(int scoredAgainstTeam, int scoredItself) {
		if (scoredAgainstTeam < scoredItself) {
			numberOfLossMatches++;
			return true;
		}
		return false;
	}

	public boolean isTied(int scoredAgainstTeam, int scoredItself) {
		if (scoredAgainstTeam == scoredItself) {
			numberOfTiedMatches++;
			return true;
		}
		return false;
	}

	public void addTotalPoint(int scoredAgainstTeam, int scoredItself) {

	}

	public void addTotalPoint(int point) {
		totalPoint += point;
	}

	@Override
	public int compareTo(Object o) {

		Sports otherSport = (Sports) o;

		if (this.totalPoint < otherSport.totalPoint) {
			return 1;
		}

		else if (this.totalPoint == otherSport.totalPoint) {

			return 0;
		}

		else {
			return -1;
		}
	}

	public static Comparator<Object> SportsComparator = new Comparator<>() {

		@Override
		public int compare(Object o1, Object o2) {

			Sports sport1 = (Sports) o1;
			Sports sport2 = (Sports) o2;

			int comparison = Integer.valueOf(sport1.getTotalPoint()).compareTo(Integer.valueOf(sport2.getTotalPoint()));

			if (comparison == 0) {

				comparison = (Integer.valueOf(sport1.getTotalScoredAgainstTeam() - sport1.getTotalScoredItself()))
						.compareTo(Integer.valueOf(sport2.getTotalScoredAgainstTeam() - sport2.getTotalScoredItself()));

			}

			return comparison;

		}
	};
}
