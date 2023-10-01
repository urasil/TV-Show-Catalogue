package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class MotherList
{
    private ArrayList<ItemList> mainList = new ArrayList<ItemList>();
    public MotherList()
    {

    }
    public ArrayList<ItemList> getMainList()
    {
        return mainList;
    }

    public void addList(ItemList list)
    {
        mainList.add(list);
    }
    public void initializeMainListContents(ArrayList<ItemList> x)
    {
        mainList = x;
    }


}
