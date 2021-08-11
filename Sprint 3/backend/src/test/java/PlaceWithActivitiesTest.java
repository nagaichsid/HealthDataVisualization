import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.Date;
import model.PlaceLog;
import model.PlaceWithActivities;
import model.WalkingActivity;
import org.junit.Before;
import org.junit.Test;

public class PlaceWithActivitiesTest {
  private PlaceWithActivities test;
  private PlaceLog testPlaceLog;
  private Long placeLogID;
  private Long walkingActivityID;
  private Integer placeId;
  private String placeName;
  private Double longitude;
  private Double latitude;
  private LocalTime startTime;
  private LocalTime endTime;
  private Date date;
  private WalkingActivity testWalkingActivity;
  private Double duration;
  private Double distance;
  private Integer step;
  private Integer calorie;

  @Before
  public void setUp() throws Exception {
    placeLogID = (long) 1;
    walkingActivityID = (long) 2;
    placeId = 22;
    placeName = "home";
    longitude = 47.25;
    latitude = 122.44;
    startTime = LocalTime.of(14, 10, 0);
    endTime = LocalTime.of(16, 10, 0);
    date = new Date(2021, 8, 7);
    testPlaceLog = new PlaceLog(placeLogID, placeId, placeName, longitude, latitude, startTime, endTime, date);
    duration = 100.00;
    distance = 50.00;
    step = 2000;
    calorie = 200;
    testWalkingActivity = new WalkingActivity(walkingActivityID, placeLogID, duration, distance, step, calorie);
    test = new PlaceWithActivities(testPlaceLog, testWalkingActivity);
  }

  @Test
  public void setPlaceLog() {
    test.setPlaceLog(null);
    assertNull(test.getPlaceLog());
  }

  @Test
  public void getPlaceLog() {
    assertEquals(testPlaceLog, test.getPlaceLog());
  }

  @Test
  public void getWalkingActivity() {
    assertEquals(testWalkingActivity, test.getWalkingActivity());
  }

  @Test
  public void setWalkingActivity() {
    test.setWalkingActivity(null);
    assertNull(test.getWalkingActivity());
  }

  @Test
  public void updatePlaceLogWithActivities() {
    test.updatePlaceLogWithActivities(testPlaceLog, testWalkingActivity);
    assertEquals(test.getWalkingActivity().getDuration(), duration * 2, 0.001);
    assertEquals(test.getWalkingActivity().getDistance(), distance * 2, 0.001);
    assertEquals(test.getWalkingActivity().getStep(), step * 2, 0.001);
    assertEquals(test.getWalkingActivity().getCalorie(), calorie * 2, 0.001);
    assertEquals(test.getPlaceLog().getTimeSpent(), 14400.00, 0.001);
  }
}