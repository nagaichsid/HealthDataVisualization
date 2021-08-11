package test;

import static org.junit.Assert.*;

import model.WalkingActivity;
import org.junit.Before;
import org.junit.Test;

public class WalkingActivityTest {
  private WalkingActivity test;
  private Long id;
  private Long placeLogId;
  private Double duration;
  private Double distance;
  private Integer step;
  private Integer calorie;

  @Before
  public void setUp() throws Exception {
    id = (long) 1;
    placeLogId = (long) 2;
    duration = 100.00;
    distance = 50.00;
    step = 2000;
    calorie = 200;
    test = new WalkingActivity(id, placeLogId, duration, distance, step, calorie);
  }

  @Test
  public void getId() {
    assertEquals(id, test.getId(), 0.001);
  }

  @Test
  public void setId() {
    test.setId((long) 2);
    assertEquals(2, test.getId(), 0.001);
  }

  @Test
  public void getPlaceLogId() {
    assertEquals(placeLogId, test.getPlaceLogId(), 0.001);
  }

  @Test
  public void setPlaceLogId() {
    test.setPlaceLogId((long) 1);
    assertEquals(1, test.getPlaceLogId(), 0.001);
  }

  @Test
  public void getDuration() {
    assertEquals(duration, test.getDuration());
  }

  @Test
  public void setDuration() {
    test.setDuration(30.01);
    assertEquals(30.01, test.getDuration(), 0.001);
  }

  @Test
  public void getDistance() {
    assertEquals(distance, test.getDistance(), 0.001);
  }

  @Test
  public void setDistance() {
    test.setDistance(30.02);
    assertEquals(30.02, test.getDistance(), 0.001);
  }

  @Test
  public void getStep() {
    assertEquals(step, test.getStep());
  }

  @Test
  public void setStep() {
    test.setStep(35);
    assertEquals(35, (int) test.getStep());
  }

  @Test
  public void getCalorie() {
    assertEquals(calorie, test.getCalorie());
  }

  @Test
  public void setCalorie() {
    test.setCalorie(15);
    assertEquals(15, (int) test.getCalorie());
  }

  @Test
  public void addDuration() {
    test.addDuration(10.00);
    assertEquals(duration + 10.00, test.getDuration(), 0.001);
  }

  @Test
  public void addDistance() {
    test.addDistance(10.00);
    assertEquals(distance + 10.00, test.getDistance(), 0.001);
  }

  @Test
  public void addStep() {
    test.addStep(10);
    assertEquals(step + 10, (int) test.getStep());
  }

  @Test
  public void addCalorie() {
    test.addCalorie(10);
    assertEquals(calorie + 10, (int) test.getCalorie());
  }
}