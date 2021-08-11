import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.Date;
import model.PlaceLog;
import org.junit.Before;
import org.junit.Test;

public class PlaceLogTest {
  private PlaceLog test;
  private Long id;
  private Integer placeId;
  private String placeName;
  private Double longitude;
  private Double latitude;
  private LocalTime startTime;
  private LocalTime endTime;
  private Date date;

  @Before
  public void setUp() throws Exception {
    id = (long) 1;
    placeId = 22;
    placeName = "home";
    longitude = 47.25;
    latitude = 122.44;
    startTime = LocalTime.of(14, 10, 0);
    endTime = LocalTime.of(16, 10, 0);
    date = new Date(2021, 8, 7);
    test = new PlaceLog(id, placeId, placeName, longitude, latitude, startTime, endTime, date);
  }

  @Test
  public void getId() {
    assertEquals(id, test.getId());
  }

  @Test
  public void setId() {
    test.setId((long) 2);
    assertEquals(2, test.getId(), 0.001);
  }

  @Test
  public void getPlaceId() {
    assertEquals(placeId, test.getPlaceId());
  }

  @Test
  public void setPlaceId() {
    test.setPlaceId(3);
    assertEquals(3, test.getPlaceId(), 0.001);
  }

  @Test
  public void getPlaceName() {
    assertEquals(placeName, test.getPlaceName());
  }

  @Test
  public void setPlaceName() {
    test.setPlaceName("not home");
    assertEquals("not home", test.getPlaceName());
  }

  @Test
  public void getLongitude() {
    assertEquals(longitude, test.getLongitude());
  }

  @Test
  public void setLongitude() {
    test.setLongitude(47.11);
    assertEquals(47.11, test.getLongitude(), 0.001);
  }

  @Test
  public void getLatitude() {
    assertEquals(latitude, test.getLatitude());
  }

  @Test
  public void setLatitude() {
    test.setLatitude(122.06);
    assertEquals(122.06, test.getLatitude(), 0.001);
  }

  @Test
  public void getStartTime() {
    assertEquals(startTime, test.getStartTime());
  }

  @Test
  public void setStartTime() {
    LocalTime testTime = LocalTime.of(12, 0, 0);
    test.setStartTime(testTime);
    assertEquals(testTime, test.getStartTime());
  }

  @Test
  public void getEndTime() {
    assertEquals(endTime, test.getEndTime());
  }

  @Test
  public void setEndTime() {
    LocalTime testTime = LocalTime.of(12, 0, 0);
    test.setEndTime(testTime);
    assertEquals(testTime, test.getEndTime());
  }

  @Test
  public void getDate() {
    assertEquals(date, test.getDate());
  }

  @Test
  public void setDate() {
    Date testDate = new Date(2021, 9, 5);
    test.setDate(testDate);
    assertEquals(testDate, test.getDate());
  }

  @Test
  public void getTimeSpent() {
    assertEquals(7200.0, test.getTimeSpent(), 0.001);
  }

  @Test
  public void setTimeSpent() {
    test.setTimeSpent((long) 100);
    assertEquals(100, test.getTimeSpent(), 0.001);
  }

  @Test
  public void addTimeSpent() {
    test.addTimeSpent((long) 1);
    assertEquals(7201.0, test.getTimeSpent(), 0.001);
  }
}