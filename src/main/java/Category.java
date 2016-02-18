import java.util.ArrayList;

public class Category {
  private String mName;
  private int mId;
  private static ArrayList<Category> mAllCategories = new ArrayList<Category>();
  private ArrayList<Task> mTasks;

  public Category(String name){
    mName = name;
    mAllCategories.add(this);
    mId = mAllCategories.size();
    mTasks = new ArrayList<Task>();
  }

  public String getName(){
    return mName;
  }

  public int getId() {
    return mId;
  }

  public void addTask(Task newTask){
    mTasks.add(newTask);
  }

  public static Category find(int id) {
    try {
      return mAllCategories.get(id-1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public static ArrayList<Category> all(){
    return mAllCategories;
  }

  public ArrayList<Task> getTasks() {
    return mTasks;
  }

  public static void clear(){
    mAllCategories.clear();
  }

}
