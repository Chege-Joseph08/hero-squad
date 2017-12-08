import java.util.List;
import java.util.ArrayList;

public class Squad {
// defining private variables
  private String mName;
  private String mReason;
  
//constructor that accepts name, ability and weakness as input
  public Squad(String name, String reason) {
    mName = name;
    mReason = reason;

  }
  //Return The Name
  public String getName() {
    return mName;
  }

  //Return The Reason
  public String getReason() {
    return mReason;
  }

    

}