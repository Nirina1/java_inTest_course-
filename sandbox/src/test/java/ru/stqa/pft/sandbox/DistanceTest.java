package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {
    @Test
    public void testArea() {
       Point p1 = new Point(1.0, 1.0);
       Point p2 = new Point(3.0, 1.0);
       Assert.assertEquals( p1.calculateDistance(p2), 2.0);
    }
}
