/**
 * @author Semih Ataman
 * @since 17-April-2021
 */
public class IceHokey extends Sports {

	public IceHokey(String name, int scoredAgainstTeam, int scoredItself) {
		super(name, scoredAgainstTeam, scoredItself);
		addTotalPoint(scoredAgainstTeam, scoredItself);
	}

	public void addTotalPoint(int scoredAgainstTeam, int scoredItself) {

		if (isWon(scoredAgainstTeam, scoredItself)) {
			addTotalPoint(3);
		}

		else if (isTied(scoredAgainstTeam, scoredItself)) {
			addTotalPoint(1);
		}

		else if (isLoss(scoredAgainstTeam, scoredItself)) {
			addTotalPoint(0);
		}
	}
}
