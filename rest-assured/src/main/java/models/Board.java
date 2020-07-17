package models;

import com.google.gson.annotations.SerializedName;

public class Board{

	@SerializedName("descData")
	private Object descData;

	@SerializedName("pinned")
	private boolean pinned;

	@SerializedName("labelNames")
	private LabelNames labelNames;

	@SerializedName("shortUrl")
	private String shortUrl;

	@SerializedName("url")
	private String url;

	@SerializedName("prefs")
	private Prefs prefs;

	@SerializedName("idEnterprise")
	private Object idEnterprise;

	@SerializedName("name")
	private String name;

	@SerializedName("idOrganization")
	private Object idOrganization;

	@SerializedName("closed")
	private boolean closed;

	@SerializedName("id")
	private String id;

	@SerializedName("limits")
	private Limits limits;

	@SerializedName("desc")
	private String desc;

	public Object getDescData(){
		return descData;
	}

	public boolean isPinned(){
		return pinned;
	}

	public LabelNames getLabelNames(){
		return labelNames;
	}

	public String getShortUrl(){
		return shortUrl;
	}

	public String getUrl(){
		return url;
	}

	public Prefs getPrefs(){
		return prefs;
	}

	public Object getIdEnterprise(){
		return idEnterprise;
	}

	public String getName(){
		return name;
	}

	public Object getIdOrganization(){
		return idOrganization;
	}

	public boolean isClosed(){
		return closed;
	}

	public String getId(){
		return id;
	}

	public Limits getLimits(){
		return limits;
	}

	public String getDesc(){
		return desc;
	}
}