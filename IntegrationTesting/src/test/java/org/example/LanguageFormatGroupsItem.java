package org.example;

import java.util.List;

public class LanguageFormatGroupsItem{
	private int totalSessionCount;
	private List<ScreenFormatsItem> screenFormats;
	private String lang;
	private String fmtGrpId;

	public int getTotalSessionCount(){
		return totalSessionCount;
	}

	public List<ScreenFormatsItem> getScreenFormats(){
		return screenFormats;
	}

	public String getLang(){
		return lang;
	}

	public String getFmtGrpId(){
		return fmtGrpId;
	}
}