package line.enumdmo;

public enum LibraryType {
	DYYHHHLZH("东营银行黄河路支行"),JXYEY("井下幼儿园");
	
	private String context;
	
	private LibraryType(String name){
		this.context=name;
	}

	public String getName() {
		return context;
	}
}
