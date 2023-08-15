package dao;

import java.util.List;

import model.*;


public interface TshirtDao {

	public void saveData(List<Tshirt> tshirtList);

	public List<Tshirt> getData(String color, String size, String gender, String outputPreference);

}