package models;

import com.google.gson.annotations.SerializedName;

public class Prefs{

	@SerializedName("backgroundBrightness")
	private String backgroundBrightness;

	@SerializedName("backgroundColor")
	private String backgroundColor;

	@SerializedName("comments")
	private String comments;

	@SerializedName("backgroundTopColor")
	private String backgroundTopColor;

	@SerializedName("canBeEnterprise")
	private boolean canBeEnterprise;

	@SerializedName("hideVotes")
	private boolean hideVotes;

	@SerializedName("backgroundImage")
	private Object backgroundImage;

	@SerializedName("canBeOrg")
	private boolean canBeOrg;

	@SerializedName("backgroundBottomColor")
	private String backgroundBottomColor;

	@SerializedName("voting")
	private String voting;

	@SerializedName("calendarFeedEnabled")
	private boolean calendarFeedEnabled;

	@SerializedName("backgroundTile")
	private boolean backgroundTile;

	@SerializedName("canBePublic")
	private boolean canBePublic;

	@SerializedName("canBePrivate")
	private boolean canBePrivate;

	@SerializedName("backgroundImageScaled")
	private Object backgroundImageScaled;

	@SerializedName("permissionLevel")
	private String permissionLevel;

	@SerializedName("cardAging")
	private String cardAging;

	@SerializedName("canInvite")
	private boolean canInvite;

	@SerializedName("invitations")
	private String invitations;

	@SerializedName("isTemplate")
	private boolean isTemplate;

	@SerializedName("background")
	private String background;

	@SerializedName("cardCovers")
	private boolean cardCovers;

	@SerializedName("selfJoin")
	private boolean selfJoin;

	public String getBackgroundBrightness(){
		return backgroundBrightness;
	}

	public String getBackgroundColor(){
		return backgroundColor;
	}

	public String getComments(){
		return comments;
	}

	public String getBackgroundTopColor(){
		return backgroundTopColor;
	}

	public boolean isCanBeEnterprise(){
		return canBeEnterprise;
	}

	public boolean isHideVotes(){
		return hideVotes;
	}

	public Object getBackgroundImage(){
		return backgroundImage;
	}

	public boolean isCanBeOrg(){
		return canBeOrg;
	}

	public String getBackgroundBottomColor(){
		return backgroundBottomColor;
	}

	public String getVoting(){
		return voting;
	}

	public boolean isCalendarFeedEnabled(){
		return calendarFeedEnabled;
	}

	public boolean isBackgroundTile(){
		return backgroundTile;
	}

	public boolean isCanBePublic(){
		return canBePublic;
	}

	public boolean isCanBePrivate(){
		return canBePrivate;
	}

	public Object getBackgroundImageScaled(){
		return backgroundImageScaled;
	}

	public String getPermissionLevel(){
		return permissionLevel;
	}

	public String getCardAging(){
		return cardAging;
	}

	public boolean isCanInvite(){
		return canInvite;
	}

	public String getInvitations(){
		return invitations;
	}

	public boolean isIsTemplate(){
		return isTemplate;
	}

	public String getBackground(){
		return background;
	}

	public boolean isCardCovers(){
		return cardCovers;
	}

	public boolean isSelfJoin(){
		return selfJoin;
	}
}