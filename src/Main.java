import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Semih Ataman
 * @since 17-April-2021
 */

// Polymorphism wasn't used efficiently in the commented lines.
public class Main {

	static ArrayList<Sports> sports = new ArrayList<>();

	public static void main(String[] args) {

		readFile(args[0]);
		// writeToFile("handball.txt", "icehokey.txt");
		writeToFile();
	}

	public static void readFile(String path) {

		File file = new File(path);
		Scanner input;

		try {

			input = new Scanner(file);

			while (input.hasNext()) {

				String[] line = input.nextLine().split("\t");
				String[] scores = line[3].split(":");
				int homeScore = Integer.parseInt(scores[0]);
				int awayScore = Integer.parseInt(scores[1]);
				Sports home = findSport(line[1]);
				Sports away = findSport(line[2]);

				if (line[0].equals("I")) {

					if (home == null) {
						sports.add(new IceHokey(line[1], homeScore, awayScore));

					}

					else {
						appendExistingHomeSport(home, homeScore, awayScore);
					}

					if (away == null) {
						sports.add(new IceHokey(line[2], awayScore, homeScore));
					}

					else {
						appendExistingAwaySport(away, homeScore, awayScore);
					}
				}

				else if (line[0].equals("H")) {

					if (home == null) {
						sports.add(new Handball(line[1], homeScore, awayScore));
					}

					else {
						appendExistingHomeSport(home, homeScore, awayScore);
					}

					if (away == null) {
						sports.add(new Handball(line[2], awayScore, homeScore));
					}

					else {
						appendExistingAwaySport(away, homeScore, awayScore);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void appendExistingHomeSport(Sports home, int homeScore, int awayScore) { // This method is called
		                                                                                // when
		                                                                                // there is specified home
		                                                                                // sport object in the
		                                                                                // system which means
		                                                                                // (home != null)
		home.addTotalScoredAgainstTeam(homeScore);
		home.addTotalScoredItself(awayScore);
		home.addTotalPoint(homeScore, awayScore);
	}

	public static void appendExistingAwaySport(Sports away, int homeScore, int awayScore) { // This method is called
		                                                                                // when
		                                                                                // there is specified away
		                                                                                // sport object in the
		                                                                                // system which means
		                                                                                // (away != null)
		away.addTotalScoredAgainstTeam(awayScore);
		away.addTotalScoredItself(homeScore);
		away.addTotalPoint(awayScore, homeScore);
	}

	public static Sports findSport(String name) {
		for (Sports sport : sports) {
			if (name.equals(sport.getName())) {
				return sport;
			}
		}
		return null;
	}

	// This method is using polymorphism efficiently. This method doesn't depend on
	// the subclasses of sports. This method works for all type of sports.
	public static void writeToFile() {

		Collections.sort(sports);

		File directory = new File("output"); // Output files will reside in output directory, for example -->
												// output\\ıcehokey.txt etc.
		directory.mkdir();

		for (Sports sport : sports) {

			File file = new File("output\\" + sport.getClass().getSimpleName().toLowerCase() + ".txt");

			try {

				FileWriter fw = new FileWriter(file, true);
				int lineNumber = getNumberOfLine(file);

				fw.write(lineNumber + ".\t" + sport.getName() + "\t" + sport.getNumberOfAllMatches() + "\t"
						+ sport.getNumberOfWonMatches() + "\t" + sport.getNumberOfTiedMatches() + "\t"
						+ sport.getNumberOfLossMatches() + "\t" + sport.getTotalScoredAgainstTeam() + ":"
						+ sport.getTotalScoredItself() + "\t" + sport.getTotalPoint() + "\n");

				fw.close();
			}

			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int getNumberOfLine(File file) {

		int lineCounter = 1;

		try {

			Scanner input = new Scanner(file);

			while (input.hasNext()) {
				input.nextLine();
				lineCounter++;
			}

			input.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lineCounter;
	}
	/*
	 * public static void writeToFile(String firstPath, String secondPath) {
	 * 
	 * File file = new File(); PrintWriter pw = new PrintWriter();
	 * 
	 * File firstFile = new File(firstPath); File secondFile = new File(secondPath);
	 * 
	 * 
	 * ArrayList<Handball> allHandballs = findSortedHandballs(); ArrayList<IceHokey>
	 * allIceHokeys = findSortedIceHokeys();
	 * 
	 * try {
	 * 
	 * PrintWriter pw1 = new PrintWriter(firstFile); int i = 1;
	 * 
	 * for (Handball handball : allHandballs) { pw1.write(i + ".\t" +
	 * handball.getName() + "\t" + handball.getNumberOfAllMatches() + "\t" +
	 * handball.getNumberOfWonMatches() + "\t" + handball.getNumberOfTiedMatches() +
	 * "\t" + handball.getNumberOfLossMatches() + "\t" +
	 * handball.getTotalScoredAgainstTeam() + ":" + handball.getTotalScoredItself()
	 * + "\t" + handball.getTotalPoint() + "\n"); i++; }
	 * 
	 * pw1.close();
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); }
	 * 
	 * try {
	 * 
	 * PrintWriter pw2 = new PrintWriter(secondFile); int i = 1;
	 * 
	 * for (IceHokey icehokey : allIceHokeys) { pw2.write(i + ".\t" +
	 * icehokey.getName() + "\t" + icehokey.getNumberOfAllMatches() + "\t" +
	 * icehokey.getNumberOfWonMatches() + "\t" + icehokey.getNumberOfTiedMatches() +
	 * "\t" + icehokey.getNumberOfLossMatches() + "\t" +
	 * icehokey.getTotalScoredAgainstTeam() + ":" + icehokey.getTotalScoredItself()
	 * + "\t" + icehokey.getTotalPoint() + "\n"); i++; }
	 * 
	 * pw2.close(); } catch (FileNotFoundException e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	/*
	 * public static ArrayList<IceHokey> findSortedIceHokeys() {
	 * 
	 * ArrayList<IceHokey> allIceHokeys = new ArrayList<>();
	 * 
	 * for (Sports sport : sports) { if (sport instanceof IceHokey) {
	 * allIceHokeys.add((IceHokey) sport); } }
	 * 
	 * Collections.sort(allIceHokeys); return allIceHokeys; }
	 * 
	 * public static ArrayList<Handball> findSortedHandballs() {
	 * 
	 * ArrayList<Handball> allHandballs = new ArrayList<>();
	 * 
	 * for (Sports sport : sports) { if (sport instanceof Handball) {
	 * allHandballs.add((Handball) sport); } }
	 * 
	 * Collections.sort(allHandballs); return allHandballs;
	 * 
	 * }
	 */
}
