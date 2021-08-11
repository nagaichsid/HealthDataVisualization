package test;

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
    assertEquals(test.getStep(), step);
  }

  @org.junit.Test
  public void setStep() {
    int testStep = 1;
    test.setStep(1);
    assertEquals((int) test.getStep(), testStep);
  }

  @org.junit.Test
  public void getActivity() {
    assertEquals(test.getActivity(), "walking");
  }

  @org.junit.Test
  public void setActivity() {
    test.setActivity("running");
    assertEquals(test.getActivity(), "running");
  }

  @org.junit.Test
  public void getCalorie() {
    assertEquals(test.getCalorie(), calorie);
  }

  @org.junit.Test
  public void setCalorie() {
    test.setCalorie(20);
    assertEquals((int) test.getCalorie(), 20);
  }

  @org.junit.Test
  public void getDistance() {
    assertEquals(test.getDistance(), distance);
  }

  @org.junit.Test
  public void setDistance() {
    test.setDistance(21.00);
    assertEquals(test.getDistance(), 21.00, 0.001);
  }

  @org.junit.Test
  public void getDuration() {
    assertEquals(test.getDuration(), duration, 0.001);
  }

  @org.junit.Test
  public void setDuration() {
    test.setDuration(22.01);
    assertEquals(test.getDuration(), 22.01, 0.001);
  }
}