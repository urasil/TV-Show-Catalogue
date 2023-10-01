package uk.ac.ucl.model;

import java.util.HashMap;
import java.util.List;

public class Item implements ItemInterface
{
    private String showName;
    private String description;
    private String url;
    private String path;
    private String similarCategory;

    public Item(String showName, String description, String url, String path, String similarCategory)
    {
        this.showName = showName;
        this.description = description;
        this.url = url;
        this.path = path;
        this.similarCategory = similarCategory;
    }

    public String getShowName()
    {
        return showName;
    }

    public void setShowName(String showName)
    {
        this.showName = showName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getSimilarCategory()
    {
        return similarCategory;
    }

    public void setSimilarCategory(String similarCategory) {
        this.similarCategory = similarCategory;}

    public HashMap viewItem()
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("showName", showName);
        map.put("description", description);
        map.put("url", url);
        map.put("path", path);
        map.put("similarCategory", similarCategory);
        return map;
    }


}
