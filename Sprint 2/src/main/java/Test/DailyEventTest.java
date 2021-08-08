package Test;

import static org.junit.Assert.*;

import java.util.Date;
import model.DailyEvent;

public class DailyEventTest {

  private DailyEvent test;
  private long id;
  private Date date;
  private String activity;
  private Integer step;
  private Integer calorie;
  private Double distance;
  private Double duration;


  @org.junit.Before
  public void setUp() throws Exception {
    id = 1;
    date = new Date(2021, 8, 7);
    activity = "walking";
    step = 51;
    calorie = 52;
    distance = 13.9415;
    duration = 55.4;
    test = new DailyEvent(id, date, activity, step, calorie, distance, duration);
  }

  @org.junit.Test
  public void getId() {
    assertEquals((long) test.getId(), id);
  }

  @org.junit.Test
  public void setId() {
    long testSetID = 2;
    test.setId(testSetID);
    assertEquals((long) test.getId(), testSetID);
  }

  @org.junit.Test
  public void getDate() {
    assertEquals(test.getDate(), date);
  }

  @org.junit.Test
  public void setDate() {
    Date testSetDate = new Date(2021, 9, 5);
    test.setDate(testSetDate);
    assertEquals(test.getDate(), testSetDate);
  }

  @org.junit.Test
  public void getStep() {
  }

  @org.junit.Test
  public void setStep() {
  }

  @org.junit.Test
  public void getActivity() {
  }

  @org.junit.Test
  public void setActivity() {
  }

  @org.junit.Test
  public void getCalorie() {
  }

  @org.junit.Test
  public void setCalorie() {
  }

  @org.junit.Test
  public void getDistance() {
  }

  @org.junit.Test
  public void setDistance() {
  }

  @org.junit.Test
  public void getDuration() {
  }

  @org.junit.Test
  public void setDuration() {
  }
}