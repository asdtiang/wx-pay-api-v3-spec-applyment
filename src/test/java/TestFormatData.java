import org.junit.Test;

/**
 * @author abel lee
 * @create 2020-06-04 23:47
 **/
public class TestFormatData {

  @Test
  public void test() {
    String str = "--boundaryContent-Disposition: form-data; " +
      "name=\"meta\"Content-Type: application/json; charset=UTF-8Content-Transfer-Encoding: 8bit{\"filename\":\"logo.png\",\"sha256\":\"ae1aed08b7af0cc8c150caa27f9b768d8b63a7efcfc5c09ab09b8fe0a31a2c7f\"}--boundaryContent-";
    String[] strings = str.split("--boundary");
    for (int i = 0; i < strings.length; i++) {
      System.out.println(strings[i]);
    }
    String firstSplit = strings[1];
    System.out.println("firstSplit" + firstSplit);

    int indexStart = firstSplit.indexOf("{\"filename\":");
    System.out.println(indexStart);
    System.out.println(firstSplit.substring(indexStart));
  }


}
