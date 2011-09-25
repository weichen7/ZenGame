/**
 * @author 
 */
public class RainingNumbers {

	public static void main(String[] args) {
		int x=0, y=0, dx=0, dy=0, score = 0;
		String text = "";
		long startTime =System.currentTimeMillis();
		
		Zen.setFont("Courier-64");
		while (Zen.isRunning()) {

			if (text.length() == 0) {
				x = Zen.getZenWidth() / 2;
				y = 0;
				dx = 0;
				dy = 2;
				text = "" + (int) (Math.random() * 999);
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				score += 10000 / elapsed;
			}
			Zen.setColor(255, 255, 255);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(255, 0, 0);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Level: 1",10,30);
			Zen.drawText("Score: 0",10,60);
			
			x += dx;
			y += dy;
			
			String user = Zen.getEditText();
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == text.charAt(0))
					text = text.substring(1);
			}
			
			Zen.sleep(100);

		}
	}

}
