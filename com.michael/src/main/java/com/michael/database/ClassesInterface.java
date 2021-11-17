package com.michael.database;

import java.util.List;

import com.michael.models.Classes;

public interface ClassesInterface 
{
	public Classes selectClassID(Integer id);
	public boolean createClass(Integer id, Integer fk_account, String classname, String classdate, String timestart, String category, String description, String notes);
	public List<Classes> selectAll();
	public int findMaxInt();
}
