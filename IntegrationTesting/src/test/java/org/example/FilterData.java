package org.example;

import java.util.List;

public class FilterData{
	@Override
	public String toString() {
		return "FilterData{" +
				"mLangs=" + mLangs +
				", topSellingAvailable=" + topSellingAvailable +
				", genres=" + genres +
				", scnFrmts=" + scnFrmts +
				'}';
	}

	private List<String> mLangs;
	private boolean topSellingAvailable;
	private List<String> genres;
	private List<String> scnFrmts;

	public List<String> getMLangs(){
		return mLangs;
	}

	public boolean isTopSellingAvailable(){
		return topSellingAvailable;
	}

	public List<String> getGenres(){
		return genres;
	}

	public List<String> getScnFrmts(){
		return scnFrmts;
	}
}