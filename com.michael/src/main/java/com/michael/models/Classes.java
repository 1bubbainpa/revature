package com.michael.models;

import java.sql.Date;
import java.sql.Time;
/**
 * Baseline reference for the classes table in database
 * @author Michael Ord
 *
 */
public class Classes 
{
	private int classid;
	private int fk_account;
	private String classname;
	private Date classdate;
	private Time timestart;
	private String category;
	private String description;
	private String notes;
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classes(int classid, int fk_account, String classname, Date classdate, Time timestart, String category,
			String description, String notes) 
	{
		super();
		this.classid = classid;
		this.fk_account = fk_account;
		this.classname = classname;
		this.classdate = classdate;
		this.timestart = timestart;
		this.category = category;
		this.description = description;
		this.notes = notes;
	}

	@Override
	public String toString() 
	{
		return "Classes [classid=" + classid + ", fk_account=" + fk_account + ", classname=" + classname
				+ ", classdate=" + classdate + ", timestart=" + timestart + ", category=" + category + ", description="
				+ description + ", notes=" + notes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((classdate == null) ? 0 : classdate.hashCode());
		result = prime * result + classid;
		result = prime * result + ((classname == null) ? 0 : classname.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + fk_account;
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((timestart == null) ? 0 : timestart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classes other = (Classes) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (classdate == null) {
			if (other.classdate != null)
				return false;
		} else if (!classdate.equals(other.classdate))
			return false;
		if (classid != other.classid)
			return false;
		if (classname == null) {
			if (other.classname != null)
				return false;
		} else if (!classname.equals(other.classname))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fk_account != other.fk_account)
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (timestart == null) {
			if (other.timestart != null)
				return false;
		} else if (!timestart.equals(other.timestart))
			return false;
		return true;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public int getFk_account() {
		return fk_account;
	}

	public void setFk_account(int fk_account) {
		this.fk_account = fk_account;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Date getClassdate() {
		return classdate;
	}

	public void setClassdate(Date classdate) {
		this.classdate = classdate;
	}

	public Time getTimestart() {
		return timestart;
	}

	public void setTimestart(Time timestart) {
		this.timestart = timestart;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
