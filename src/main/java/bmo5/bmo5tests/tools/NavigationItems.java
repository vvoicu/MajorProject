package bmo5.bmo5tests.tools;

public enum NavigationItems {

	Previous("icon-c-angle-left"),First("icon-c-angle-double-left"),Next("icon-c-angle-right"),Last("icon-c-angle-double-right"), 
	One("1"), Two("2"), Three("3"), Four("4"), Five("5"), ninetyfour("94");
	
	private String code;

	private NavigationItems(String c) {
	code = c;
	}

	public String getCode() {
	return code;
	}
	
	
}
