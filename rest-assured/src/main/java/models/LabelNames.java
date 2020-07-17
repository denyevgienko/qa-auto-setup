package models;

import com.google.gson.annotations.SerializedName;

public class LabelNames{

	@SerializedName("orange")
	private String orange;

	@SerializedName("red")
	private String red;

	@SerializedName("sky")
	private String sky;

	@SerializedName("pink")
	private String pink;

	@SerializedName("green")
	private String green;

	@SerializedName("blue")
	private String blue;

	@SerializedName("lime")
	private String lime;

	@SerializedName("yellow")
	private String yellow;

	@SerializedName("black")
	private String black;

	@SerializedName("purple")
	private String purple;

	public String getOrange(){
		return orange;
	}

	public String getRed(){
		return red;
	}

	public String getSky(){
		return sky;
	}

	public String getPink(){
		return pink;
	}

	public String getGreen(){
		return green;
	}

	public String getBlue(){
		return blue;
	}

	public String getLime(){
		return lime;
	}

	public String getYellow(){
		return yellow;
	}

	public String getBlack(){
		return black;
	}

	public String getPurple(){
		return purple;
	}
}