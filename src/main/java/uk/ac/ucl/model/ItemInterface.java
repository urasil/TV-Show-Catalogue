package uk.ac.ucl.model;

import java.util.HashMap;
import java.util.List;

public interface ItemInterface {
    public String getShowName();
    public void setShowName(String showName);
    public String getDescription();
    public void setDescription(String description);
    public String getUrl();
    public void setUrl(String url);
    public String getPath();
    public void setPath(String path);
    public HashMap<String, Object> viewItem();
}
