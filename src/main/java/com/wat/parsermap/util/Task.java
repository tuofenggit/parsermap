package com.wat.parsermap.util;

public class Task {
	
	public static final String SIMULATION = "simulation";
	
	public static final String MESHING = "meshing";
    
    private String name;
    
    private String title;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    /**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
