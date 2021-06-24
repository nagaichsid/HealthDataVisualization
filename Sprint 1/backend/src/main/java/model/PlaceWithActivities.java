package model;

public class PlaceWithActivities {
  private PlaceLog placeLog;
  private WalkingActivity walkingActivity;

  public PlaceWithActivities(PlaceLog placeLog,
      WalkingActivity walkingActivity) {
    this.placeLog = placeLog;
    this.walkingActivity = walkingActivity;
  }

  public PlaceLog getPlaceLog() {
    return placeLog;
  }

  public void setPlaceLog(PlaceLog placeLog) {
    this.placeLog = placeLog;
  }

  public WalkingActivity getWalkingActivity() {
    return walkingActivity;
  }

  public void setWalkingActivities(WalkingActivity walkingActivities) {
    this.walkingActivity = walkingActivity;
  }
}
