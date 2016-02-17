import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {
  String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;

  public Task(String description) {
    mDescription = description;
    mCompleted = false;
  }

  public String getDescription() {
    return mDescription;
  }

  public boolean isCompleted(){
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    mCreatedAt = LocalDateTime.now();
    return mCreatedAt;
  }
}
