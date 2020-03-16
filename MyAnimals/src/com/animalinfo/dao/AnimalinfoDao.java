package com.animalinfo.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AnimalinfoDao {
	public Map<String, Integer> selectLoactionAll();
	public Map<String, Integer> selectLocation(String sido);
	public Map<String, Integer> selectKindAll();
	public Map<String, Integer> selectKindAnimal(String kind);
	public Map<String, Integer> selectState();
	
}
