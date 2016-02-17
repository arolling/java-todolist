import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {
  private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private int mID;
  private static ArrayList<Task> mAllTasks = new ArrayList<Task>();

  public Task(String description) {
    mDescription = description;
    mCreatedAt = LocalDateTime.now();
    mCompleted = false;
    mAllTasks.add(this);
    mID = mAllTasks.size();
  }

  public String getDescription() {
    return mDescription;
  }

  public boolean isCompleted(){
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static ArrayList<Task> all(){
    return mAllTasks;
  }

  public int getId() {
    return mID;
  }

  public static Task find(int id){
    for (Task task : mAllTasks) {
      if (task.getId() == id) {
        return task;
      }
    }
    return null;
  }

  public static void clear(){
    mAllTasks.clear();
  }

}
