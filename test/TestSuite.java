import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import task1_2.GlebListTest;
import task1_3_1.CopyOnWriteListTest;
import task1_4_1.WeirdListTest;
import task1_5.SortUtilTest;
import task2_1.ListAsSetTest;


@SuiteClasses( { GlebListTest.class, 
	CopyOnWriteListTest.class ,
	WeirdListTest.class, SortUtilTest.class,
	ListAsSetTest.class})
@RunWith(Suite.class)
public class TestSuite {

}
