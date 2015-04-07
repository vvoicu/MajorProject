package bmo5.bmo5tests.tools;

public enum NavigationEnum {

	Next("next"),Last("last"),Previous("prev"),First("first"), One("1"), Two("2");
	
	private String code;

	private NavigationEnum(String c) {
	code = c;
	}

	public String getCode() {
	return code;
	}
	
	
}
