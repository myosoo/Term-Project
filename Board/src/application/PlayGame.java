package application;

public class PlayGame {
	// 실행
	public boolean[] run(int nMal, int nDice, Team[] team, int play) {
		boolean[] confirm = { false, false }; // 0인데스 : 말 잡을 때, 1인덱스 : 우승 여부

		// 말의 이동
		if (team[play].move(nMal, nDice) == true)
			System.out.println("GOAL IN ~");

		// 말 잡기
		if (capture(team[play].getMal(nMal), play, team))
			confirm[0] = true;

		// 우승 여부
		if (win(play, team) == true)
			confirm[1] = true;

		return confirm;
	}

	// 우승 여부
	public boolean win(int i, Team[] team) {
		for (int j = 0; j <= team[i].numOfmal(); j++) {
			if (team[i].numOfmal() == j) {
				return true;
			} else if (team[i].getIsFinish(j) == false)
				break;
		}
		return false;
	}

	// 다른 팀 말 잡기
	public boolean capture(Mal mal, int nTeam, Team[] team) {
		Boardgame btn = new Boardgame();
		for (int k = 0; k < team.length; k++) {
			if (k != nTeam) {
				for (int i = 0; i < team[k].numOfmal(); i++) {
					int x = team[k].getX(i);
					int y = team[k].getY(i);
					if (mal.getX() == x && mal.getY() == y) {
						if (team[k].getIsStart(i) == true && team[k].getIsFinish(i) == false) {
							team[k].setReady(k, i);
							btn.malposition(k, i, team);

							// 업은 말들 초기화
							for (int j = 0; j < team[k].numOfmal(); j++) {
								team[k].setArr(i, j, false);
							}
							team[k].setArr(i, i, true);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
