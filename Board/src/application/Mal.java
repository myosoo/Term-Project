package application;

import javafx.scene.control.Button;

public class Mal {
	private int x, y; // 7x7 행렬 좌표
	Button malname;
	private boolean isStart; // 출발지과 도착지의 구분
	private boolean isFinish;

	public Mal() {
		this.x = 550;
		this.y = 550;
		isFinish = false;
		isStart = false;
	}

	// 이동
	public boolean move(int n) {
		// 빽도
		if (n == -1) {
			if (isStart == false) {
				x = 550;
				y = 550;
				isStart = true;
			} else if (x == 550 && y != 550) {
				y += 100;
			} else if (y == 550 && x != 50) {
				x -= 100;
			} else if (x == 50 && y != 50) {
				y -= 100;
			} else if (y == 50 && x != 550) {
				x += 100;
			} else if (x == y) {
				x -= 80;
				y -= 80;

				if (x == 390 || x == 300) {
					x -= 10;
					y -= 10;
				}
			} else if (x + y == 600) {
				x += 80;
				y -= 80;

				if (x == 300 || x == 210) {
					x += 10;
					y -= 10;
				}
			}
		}
		// 왼쪽 대각선
		else if (x == y && isStart == true) {
			for (int i = 0; i < n; i++) {
				x += 80;
				y += 80;

				if (x == 210 || x == 300) {
					x += 10;
					y += 10;
				}

				// 골인
				if (x == 550) {
					x = 1100;
					y = 1100;
					isFinish = true;
					return true;
				}
			}
		}
		// 오른쪽 대각선
		else if (x + y == 600 && x != 50) {
			if(x==300 && y==300) {
				if(n==1) {
					x=390;
					y=390;
				}
				else if(n==2) {
					x=470;
					y=470;
				}
				else if(n==3) {
					x=550;
					y=550;
				}
				else if(n>=4) {
					// 골인
					if (x > 550 && x < 720) {
						x = 1100;
						y = 1100;
						isFinish = true;
						return true;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (y == 550) {
					x += 100;
				} 
				else {
					x -= 80;
					y += 80;
					if (x == 390 || x == 300) {
						x -= 10;
						y += 10;
					}
				}
			}

		}
		// 사각형 테두리
		else {
			for (int i = 0; i < n; i++) {
				if (x == 550) {
					if (y == 550 && isStart == true)
						x += 100;
					else if (y == 50)
						x -= 100;
					else
						y -= 100;
				} else if (y == 50) {
					if (x == 50)
						y += 100;
					else
						x -= 100;
				} else if (x == 50) {
					if (y == 550)
						x += 100;
					else
						y += 100;
				} else if (y == 550) {
					x += 100;
				} 
				
				// 잡힌 말이 다시 시작 할 경우
				else if (x >= 720 && y >= 450 && isStart == false) { 
					if (n == -1) {
						x = 550;
						y = 550;
					} else if (n == 1) {
						x = 550;
						y = 450;
					} else if (n == 2) {
						x = 550;
						y = 350;
					} else if (n == 3) {
						x = 550;
						y = 250;
					} else if (n == 4) {
						x = 550;
						y = 150;
					} else if (n == 5) {
						x = 550;
						y = 50;
					}
					break;
				}

				// 골인
				if (x > 550 && x < 720) {
					x = 1100;
					y = 1100;
					isFinish = true;
					return true;
				}
			}
		}
		isStart = true;
		return false;
	}

	// 시작점에서 다시시작
	public void setReady(int player, int malnum) {
		x = 720;
		y = 450;
		if (player == 0) {
			x = x + 40 * malnum;
		} else if (player == 1) {
			y = 500;
			x = x + 40 * malnum;
		} else if (player == 2) {
			y = 550;
			x = x + 40 * malnum;
		} else if (player == 3) {
			y = 600;
			x = x + 40 * malnum;
		}
		isStart = false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getIsStart() {
		return isStart;
	}

	public boolean getIsFinish() {
		return isFinish;
	}

}
