package uk.ac.ucl.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model
{
    MotherList motherList = new MotherList();
    public boolean listExists(String listName)
    {
        if(getMotherList() != null)
        {
            for (ItemList lst : motherList.getMainList())
            {
                if(lst.getListName().equals(listName))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean itemExists(String showName)
    {
        for(ItemList lst : motherList.getMainList())
        {
            for(Item item : lst.getList())
            {
                if(item.getShowName().equals(showName))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void createList(String listName)
    {
        if(!listExists((listName)))
        {
            ItemList lst = new ItemList(listName);
            motherList.addList(lst);
        }
    }


    /*public List<ArrayList<String>> viewAllLists()
    {
        List<ArrayList<String>> temp = new ArrayList<>();
        for(ItemList lst: motherList.getMainList())
        {
            temp.add(lst.viewAllItems());
        }
        return temp;
    }*/

    public List<ArrayList<HashMap<String, Object>>> viewAllLists()
    {
        List<ArrayList<HashMap<String, Object>>> temp = new ArrayList<>();
        for(ItemList lst: motherList.getMainList())
        {
            temp.add(lst.viewAllItems());
        }
        return temp;
    }

    public ArrayList<String> allCategoryNames()
    {
        ArrayList<String> temp = new ArrayList<>();
        for(ItemList lst : motherList.getMainList())
        {
            temp.add(lst.getListName());
        }
        return temp;
    }

    public void addItemToList(String listName, String showName, String description, String url, String path, String similarCategory)
    {
        for(ItemList lst : motherList.getMainList())
        {
            if(lst.getListName().equals(listName))
            {
                if(!itemExists(showName))
                {
                    lst.addItem(showName, description, url, path, similarCategory);
                }
            }
        }
    }

    public Item searchItem(String showName)
    {
        for(ItemList lst : motherList.getMainList())
        {
            for(Item item : lst.getList())
            {
                if(item.getShowName().equals(showName))
                {
                    return item;
                }
            }
        }
        return null;
    }

    public void editItem(Item item, String showName, String description, String url, String path, String similarCategory)
    {
        item.setShowName(showName);
        item.setDescription(description);
        item.setUrl(url);
        item.setPath(path);
        item.setSimilarCategory(similarCategory);
    }

    public void editList(ItemList lst, String listName)
    {
        lst.setListName(listName);
    }

    public ArrayList<Item> getAllItems()
    {
        ArrayList<Item> temp = new ArrayList<>();
        for(ItemList lst : motherList.getMainList())
        {
            for(Item item : lst.getList())
            {
                temp.add(item);
            }
        }
        return temp;
    }
    //
    public void deleteItem(Item item)
    {
        for(ItemList lst : motherList.getMainList())
        {
            if(searchItem(item.getShowName()) != null)
            {
                lst.removeItem(item);
            }
        }
    }

    public void deleteList(ItemList itemList)
    {
        motherList.getMainList().remove(itemList);
    }

    public void writeToFile(Object object, String fileName) throws IOException
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert object to JSON string
        String jsonString = gson.toJson(object);
        // Write JSON string to file
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(jsonString);
        fileWriter.close();
    }
    public ArrayList<ItemList> readFile(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader(path);
        return gson.fromJson(reader, new TypeToken<ArrayList<ItemList>>(){}.getType());
    }

    public void initializeMotherListContents(ArrayList<ItemList> x)
    {
        motherList.initializeMainListContents(x);
    }

    public ArrayList<ItemList> getMotherList()
    {
        return motherList.getMainList();
    }

    public ItemList getListFromListName(String listName)
    {
        for(ItemList lst : motherList.getMainList())
        {
            if(lst.getListName().equals(listName))
            {
                return lst;
            }
        }
        return null;
    }

    public String readImage(String path)
    {
        ImageProcessing img = new ImageProcessing();
        String base64img = img.getImageAsBase64(path);
        return base64img;
    }

    public List<String> readAllImagesInList(String itemListName)
    {
        ItemList lst = getListFromListName(itemListName);
        if(lst != null)
        {
            List<String> imgPaths = new ArrayList<>();
            for(Item item : lst.getList())
            {
                String path = item.getPath();
                if(path.contains("jpg") || path.contains("png"))
                {
                    imgPaths.add(readImage(path));
                }
                else
                {
                    imgPaths.add(null);
                }
            }
            return imgPaths;
        }
        return null;

    }

    public List<String> readAllImages(List<HashMap<String, Object>> x)
    {
        List<String> imgPaths = new ArrayList<>();
        for(HashMap item : x)
            {
                String path = (String) item.get("path");
                if(path.contains("jpg") || path.contains("png"))
                {
                    imgPaths.add(readImage(path));
                }
                else
                {
                    imgPaths.add(null);
                }
            }
        return imgPaths;
    }

    public List<String> readImagesForViewAllList()
    {
        List<String> imgPaths = new ArrayList<>();
        for(ItemList lst : motherList.getMainList())
        {
            for (Item item : lst.getList())
            {
                String path = item.getPath();
                if(path.contains("jpg") || path.contains("png"))
                {
                    imgPaths.add(readImage(path));
                }
                else
                {
                    imgPaths.add(null);
                }
            }

        }
        return imgPaths;
    }

    public String getListNameFromItem(String showName)
    {
        for(ItemList lst : motherList.getMainList())
        {
            for(Item item : lst.getList())
            {
                if(item.getShowName().equals(showName))
                {
                    return lst.getListName();
                }
            }
        }
        return null;
    }
    public ArrayList<HashMap<String, Object>> viewItemsInList(ItemList lst)
    {
        ArrayList<HashMap<String, Object>> temp = new ArrayList<HashMap<String, Object>>();
        for(Item item : lst.getList())
        {
            temp.add(item.viewItem());
        }
        return temp;
    }

    public List<HashMap<String, Object>> search(String searchString) {
        List<HashMap<String, Object>> temp = new ArrayList<>();
        for(ItemList lst : motherList.getMainList()) {
            for(Item item : lst.getList()) {
                if(item.getShowName().toLowerCase().contains(searchString.toLowerCase())) {
                    temp.add(item.viewItem());
                }
            }
        }
        return temp;
    }

    public List<String> searchList(String searchString)
    {
        List<String> temp = new ArrayList<>();
        for(ItemList lst : motherList.getMainList())
        {
            if(lst.getListName().toLowerCase().contains(searchString.toLowerCase()))
            {
                temp.add(lst.getListName());
            }
        }
        return temp;
    }



}
