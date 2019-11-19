package exercises.polindrome;

public class Polindrome {
	private String text;
	private boolean isValid;
	
	public Polindrome() {
	}
	
	public Polindrome(String text) {
		setText(text);
		isValid = check();
	}
	
	public void setText(String arg) {
		text = arg;
		
		if (text == null) {
			return;
		}
		
		text = text.trim();
	}
	
	public String getText() {
		return text;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	private boolean check() {
		if (text == null || text.length() == 0) {
			
		}
		for (int i = 0, j = text.length() - 1; i != j; i++, j--) {
			if (i > j) {
				break;
			}
			
			if (text.charAt(i) != text.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
}
