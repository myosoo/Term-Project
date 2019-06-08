package application;

public class PlayGame {
	// 실행
	public boolean[] run(int nMal, int nDice, Player[] team, int play) {
		boolean[] confirm = { false, false }; // 0인데스 : 말 잡을 때, 1인덱스 : 우승 여부

		// 말의 이동
		if (team[play].move(nMal, nDice) == true)
			System.out.println("GOAL IN ~");

		// 말 잡기
		if (team[play].capture(team[play].getMal(nMal), play, team))
			confirm[0] = true;

		// 우승 여부
		if (team[play].win(play, team) == true)
			confirm[1] = true;

		return confirm;
	}

}
