package application;

public class PlayGame {
	// ����
	public boolean[] run(int nMal, int nDice, Team[] team, int play) {
		boolean[] confirm = { false, false }; // 0�ε��� : �� ���� ��, 1�ε��� : ��� ����

		// ���� �̵�
		if (team[play].move(nMal, nDice) == true)
			System.out.println("GOAL IN ~");

		// �� ���
		if (capture(team[play].getMal(nMal), play, team))
			confirm[0] = true;

		// ��� ����
		if (win(play, team) == true)
			confirm[1] = true;

		return confirm;
	}

	// ��� ����
	public boolean win(int i, Team[] team) {
		for (int j = 0; j <= team[i].numOfmal(); j++) {
			if (team[i].numOfmal() == j) {
				return true;
			} else if (team[i].getIsFinish(j) == false)
				break;
		}
		return false;
	}

	// �ٸ� �� �� ���
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

							// ���� ���� �ʱ�ȭ
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
