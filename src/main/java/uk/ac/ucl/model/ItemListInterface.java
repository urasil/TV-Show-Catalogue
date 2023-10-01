package uk.ac.ucl.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ItemListInterface {

    public ArrayList<HashMap<String, Object>> viewAllItems();

    public void addItem(String showName, String description, String url, String path, String similarCategory);

    public void removeItem(Item item);

    public void setListName(String listName);

    public String getListName();

    public List<Item> getList();
}
