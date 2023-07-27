package UI;

public class Sammary {
	private String location;
	private int noMartary;
	private int numF;
	private int numM;
	private int numSingel;
	private int numMareed;
	private int avgAge;

	public Sammary() {
		super();
	}

	public Sammary(String location, int noMartary, int numF, int numM, int numSingel, int numMareed, int age) {
		super();
		this.location = location;
		this.noMartary = noMartary;
		this.numF = numF;
		this.numM = numM;
		this.numSingel = numSingel;
		this.numMareed = numMareed;
		this.avgAge = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoMartary() {
		return noMartary;
	}

	public void setNoMartary(int noMartary) {
		this.noMartary = noMartary;
	}

	public int getNumF() {
		return numF;
	}

	public void setNumF(int numF) {
		this.numF = numF;
	}

	public int getNumM() {
		return numM;
	}

	public void setNumM(int numM) {
		this.numM = numM;
	}

	public int getNumSingel() {
		return numSingel;
	}

	public void setNumSingel(int numSingel) {
		this.numSingel = numSingel;
	}

	public int getNumMareed() {
		return numMareed;
	}

	public void setNumMareed(int numMareed) {
		this.numMareed = numMareed;
	}

	public int getAvgAge() {
		return avgAge;
	}

	public void setAvgAge(int age) {
		this.avgAge = age;
	}
}