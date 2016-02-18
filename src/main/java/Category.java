import java.util.ArrayList;

public class Category {
  private String mName;
  private int mId;
  private static ArrayList<Category> mAllCategories = new ArrayList<Category>();

  public Category(String name){
    mName = name;
    mAllCategories.add(this);
    mId = mAllCategories.size();
  }

  public String getName(){
    return mName;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Category> all(){
    return mAllCategories;
  }

}
