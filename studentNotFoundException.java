package customeException;

public class studentNotFoundException extends RuntimeException {
	
	private String message;
	
	public studentNotFoundException(String message) {
		
		this.message=message;
	}
 @Override
 public String getMessage() {
	 
	 return message;
	 
 }
}
