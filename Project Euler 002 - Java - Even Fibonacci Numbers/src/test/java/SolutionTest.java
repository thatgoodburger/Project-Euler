import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;

/**
 * Created by aaugsbur on 8/3/16.
 */
public class SolutionTest {

    private static final ArrayList<Integer> fibNumsThroughOne;
    private static final ArrayList<Integer> fibNumsThroughTwo;
    private static final ArrayList<Integer> fibNumsThroughTen;

    // initialize static vars
    static {

        fibNumsThroughOne = new ArrayList<Integer>() {{
            add(1);
        }};

        fibNumsThroughTwo = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};

        fibNumsThroughTen = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(5);
            add(8);
            add(13);
            add(21);
            add(34);
            add(55);
            add(89);
        }};
    }

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testSolution() throws Exception {
        Solution solution = new Solution();
    }

    @Test
    public void testGetFibNumsNoFilter() throws Exception {
        Assert.assertEquals(Solution.getFibNums(1), fibNumsThroughOne);
        Assert.assertEquals(Solution.getFibNums(2), fibNumsThroughTwo);
        Assert.assertEquals(Solution.getFibNums(10), fibNumsThroughTen);
    }
}