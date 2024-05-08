package utilz;

public class Constants {

	public static class PlayerConstants{
		public static final int RUNNING = 0;
		public static final int IDLE = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int HIT = 4;
		public static final int ATTACK_1 = 5;
		public static final int ATTACK_2 = 6;
		public static final int DEATH = 7;
		
		public static int GetSpriteAmount(int player_action) {
			
			switch(player_action) {
			
				case RUNNING:
				case ATTACK_1:
				case ATTACK_2:
					return 8;
				case DEATH:
					return 7;
				case IDLE:
					return 6;
				case HIT:
					return 4;
				case JUMP:
				case FALLING:
					return 2;
				default:
					return 1;
			
					
			} 
			
			
			//return how many sprites there is
		
			
		}
		//method that returns the amount of sprites per animation we ask for
		//to avoid out of bounds error
	}
}
