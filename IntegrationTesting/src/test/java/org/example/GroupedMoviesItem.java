package org.example;

import java.util.List;

public class GroupedMoviesItem{
	private List<String> grn;
	private String edgeBanner;
	private String releaseDate;
	private String appImgPath;
	private int contentId;
	private String label;
	private int duration;
	private String appCvrPath;
	private List<String> scrnFmt;
	private String cvrPath;
	private int totalSessionCount;
	private String imgPath;
	private Rnr rnr;
	private List<LanguageFormatGroupsItem> languageFormatGroups;
	private String censor;
	private List<Object> sndFmt;
	private String bookingStatus;
	private int popularityRank;

	public List<String> getGrn(){
		return grn;
	}

	public String getEdgeBanner(){
		return edgeBanner;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getAppImgPath(){
		return appImgPath;
	}

	public int getContentId(){
		return contentId;
	}

	public String getLabel(){
		return label;
	}

	public int getDuration(){
		return duration;
	}

	public String getAppCvrPath(){
		return appCvrPath;
	}

	public List<String> getScrnFmt(){
		return scrnFmt;
	}

	public String getCvrPath(){
		return cvrPath;
	}

	public int getTotalSessionCount(){
		return totalSessionCount;
	}

	public String getImgPath(){
		return imgPath;
	}

	public Rnr getRnr(){
		return rnr;
	}

	public List<LanguageFormatGroupsItem> getLanguageFormatGroups(){
		return languageFormatGroups;
	}

	public String getCensor(){
		return censor;
	}

	public List<Object> getSndFmt(){
		return sndFmt;
	}

	public String getBookingStatus(){
		return bookingStatus;
	}

	public int getPopularityRank(){
		return popularityRank;
	}
}