/**
 * @author ymeng7, weichen7
 */
public class RainingNumbers {

	public static void main(String[] args) {
		int x = 0, y = 0, dx = 0, dy = 0, score = 0;
		String text = "";
		int life = 3; //added "life" count
		long startTime = System.currentTimeMillis();
		Zen.setFont("Calibri-20");
		
		while (Zen.isRunning() && life > 0) {
			y = 0;// fix question 0
			boolean solved=false;
			while (y <= Zen.getZenHeight()) {
				if (text.length() == 0) {
					x = (int) (((Zen.getZenWidth() / 2) * Math.random()) + 150);
					y = 20;
					dx = 0;
					dy =  (1 + (int)(score / 100)); //added speed
					text = "" + (int) (Math.random() * 999);

					long elapsed = System.currentTimeMillis() - startTime;
					if (elapsed != 0 && solved) {
						score += elapsed/10;
						solved = false;
					}
				}
				Zen.setColor(0, 0, 0);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

				Zen.setColor(20, 150, 20);
				Zen.drawText(text, x, y);

				Zen.drawText("Level: " + (1 + (int)(score / 100)), 10,
						Zen.getZenHeight() - 20);
				Zen.drawText("Score: " + (score), 10, 60);
				Zen.drawText("Life: " + life, 10, 180);
				Zen.fillRect(150, 20, 5, 450);

				// Text Line

				Zen.flipBuffer();
				x += dx;
				y += dy;

				String user = Zen.getEditText();
				Zen.setEditText("");
				if (y == Zen.getZenHeight())
					life--;
				for (int i = 0; i < user.length(); i++) {
					char c = user.charAt(i);
					if (c == text.charAt(0))
						text = text.substring(1);
				}
				solved = true;
				startTime = System.currentTimeMillis();
				Zen.sleep(100);

			}
		}

	}
}