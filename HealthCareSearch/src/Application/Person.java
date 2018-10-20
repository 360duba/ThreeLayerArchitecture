package Application;

public class Person {
	private String MetalLevel;
	private String PlanID;
	private String PlanMarketName;
	public Person(String MetalLevel,String PlanID,String PlanMarketName) {
		this.MetalLevel=MetalLevel;
		this.PlanID=PlanID;
		this.PlanMarketName=PlanMarketName;
	}
	public String getML() {
		return MetalLevel;
	}
	public String getPID() {
		return PlanID;
	}
	public String getPMN() {
		return PlanMarketName;
	}
}