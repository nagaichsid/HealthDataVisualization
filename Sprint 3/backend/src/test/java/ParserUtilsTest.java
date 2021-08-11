import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import db_dump.ParserUtils;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import model.DailyEvent;
import model.PlaceLog;
import model.WalkingActivity;
import org.junit.Before;
import org.junit.Test;

public class ParserUtilsTest {
  String testDate;
  Date expectedDate;
  String testLocalTime;
  LocalTime expectedTime;
  long testPlaceID;
  String dailyEventTest1;
  String dailyEventTest2;
  String placeLogTest1;
  String placeLogTest2;


  @Before
  public void setUp() throws Exception {
    testDate = "20210807";
    expectedDate = java.util.Date.from(LocalDate.of( 2021, 8, 7)
        .atStartOfDay(ZoneId.of("America/Los_Angeles")).toInstant());
    testLocalTime = "20130209T132707-0800";
    expectedTime = LocalTime.of(13, 27, 07);
    testPlaceID = 1;
    dailyEventTest1 = "{\n"
        + "    \"activity\" : \"walking\",\n"
        + "    \"group\" : \"walking\",\n"
        + "    \"duration\" : 1845.0,\n"
        + "    \"distance\" : 1562.0,\n"
        + "    \"steps\" : 2254,\n"
        + "    \"calories\" : 78\n"
        + "  }";
    dailyEventTest2 = "{\n"
        + "      \"activity\" : \"transport\",\n"
        + "      \"group\" : \"transport\",\n"
        + "      \"manual\" : false,\n"
        + "      \"startTime\" : \"20130209T183724-0800\",\n"
        + "      \"endTime\" : \"20130209T185022-0800\",\n"
        + "      \"duration\" : 778.0,\n"
        + "      \"distance\" : 5961.0,\n"
        + "      \"trackPoints\" : [ ]\n"
        + "    }";
    placeLogTest1 = "{\n"
        + "    \"type\" : \"place\",\n"
        + "    \"startTime\" : \"20130209T063407-0800\",\n"
        + "    \"endTime\" : \"20130209T132707-0800\",\n"
        + "    \"place\" : {\n"
        + "      \"id\" : 6552482,\n"
        + "      \"name\" : \"Home\",\n"
        + "      \"type\" : \"home\",\n"
        + "      \"location\" : {\n"
        + "        \"lat\" : 47.67645,\n"
        + "        \"lon\" : -122.32305\n"
        + "      }\n"
        + "    },\n"
        + "    \"lastUpdate\" : \"20140801T025223Z\"\n"
        + "  }";
    placeLogTest2 = "{\n"
        + "    \"type\" : \"place\",\n"
        + "    \"startTime\" : \"20130209T063407-0800\",\n"
        + "    \"endTime\" : \"20130209T132707-0800\",\n"
        + "    \"place\" : {\n"
        + "      \"id\" : 6552482,\n"
        + "      \"type\" : \"home\",\n"
        + "      \"location\" : {\n"
        + "        \"lat\" : 47.67645,\n"
        + "        \"lon\" : -122.32305\n"
        + "      }\n"
        + "    },\n"
        + "    \"lastUpdate\" : \"20140801T025223Z\"\n"
        + "  }";
  }

  @Test
  public void getDate() throws ParseException {
    assertEquals(expectedDate, ParserUtils.getDate("20210807"));
  }

  @Test
  public void getLocalTime() {
    assertEquals(expectedTime, ParserUtils.getLocalTime(testLocalTime));
  }

  @Test
  public void getDailyEventFromJson() {
    JsonObject parsedEvent = new Gson().fromJson(dailyEventTest1, JsonObject.class);
    DailyEvent dailyEvent = ParserUtils.getDailyEventFromJson(parsedEvent, expectedDate);
    assertEquals(dailyEvent.getStep(), 2254, 0.001);

    JsonObject parsedEvent2 = new Gson().fromJson(dailyEventTest2, JsonObject.class);
    DailyEvent dailyEvent2 = ParserUtils.getDailyEventFromJson(parsedEvent2, expectedDate);
    assertEquals(dailyEvent2.getDistance(), 5961, 0.001);
  }

  @Test
  public void getPlaceLogFromJson() {
    JsonObject parsedLog = new Gson().fromJson(placeLogTest1, JsonObject.class);
    PlaceLog placeLog = ParserUtils.getPlaceLogFromJson(parsedLog, expectedDate);
    assertEquals(placeLog.getLatitude(), 47.67645, 0.001);

    JsonObject parsedLog2 = new Gson().fromJson(placeLogTest2, JsonObject.class);
    PlaceLog placeLog2 = ParserUtils.getPlaceLogFromJson(parsedLog2, expectedDate);
    assertNull(placeLog2);
  }

  @Test
  public void getWalkingActivityFromJson() {
    JsonObject parsedActivity = new Gson().fromJson(dailyEventTest1, JsonObject.class);
    WalkingActivity walkingActivity = ParserUtils.getWalkingActivityFromJson(parsedActivity, testPlaceID);
    assertEquals(walkingActivity.getStep(), 2254, 0.001);
  }
}