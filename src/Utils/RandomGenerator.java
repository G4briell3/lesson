package Utils;

public class RandomGenerator 
{
	public static String stringValue(int count) {
		String CHARACTER_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*CHARACTER_STRING.length());
			builder.append(CHARACTER_STRING.charAt(character));
				}
		return builder.toString();
	}
	
	public static String mixedValue(int count)
	{
		String CHARACTER_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*CHARACTER_STRING.length());
			builder.append(CHARACTER_STRING.charAt(character));
				}
		return builder.toString();	
	}
	
	public static String numbers(int count)
	{
		String CHARACTER_STRING = "01234567890123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*CHARACTER_STRING.length());
			builder.append(CHARACTER_STRING.charAt(character));
				}
		return builder.toString();
	}
}
