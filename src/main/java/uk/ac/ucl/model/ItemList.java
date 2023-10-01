package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemList implements ItemListInterface
{

    private List<Item> items;

    private String listName;

    MotherList mainList;
    public ItemList(String listName)
    {
        this.listName = listName;
        items = new ArrayList<>();
    }


    public ArrayList<HashMap<String, Object>> viewAllItems()
    {
        ArrayList<HashMap<String, Object>> temp = new ArrayList<>();
        //temp.add(listName);
        for(Item item : items)
        {
            temp.add(item.viewItem());
        }
        return temp;
    }


    public void addItem(String showName, String description, String url, String path, String similarCategory)
    {
        Item item = new Item(showName, description, url, path, similarCategory);
        items.add(item);

    }

    public void removeItem(Item item)
    {
        items.remove(item);
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListName(){
        return listName;
    }

    public List<Item> getList()
    {
        return items;
    }

}
