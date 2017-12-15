package cn.xiaowenjie.listviewdemo;

/**
 * item数据类，根据实际情况自己修改
 *  
 * @author xiaowenjie
 * @date 2015-12-24
 */
public class Item
{

    private String title, detail;

    private int imageId;

    public Item(String title, String detail, int imageId)
    {
        super();
        this.title = title;
        this.detail = detail;
        this.imageId = imageId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

}
