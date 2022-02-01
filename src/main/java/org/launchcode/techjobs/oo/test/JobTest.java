package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job test_job1;
    Job test_job2;

    @Before
    public void createJobObject() {
        test_job1 = new Job();
        test_job2 = new Job();
    }
    //Test that ID's are being properly assigned and that sequential jobs's IDs differ by 1
    @Test
    public void testSettingJobId() {
        assertEquals(test_job1.getId() + 1, test_job2.getId());
    }

    //Test that ensures all fields are properly assigned with constructor
    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job3 instanceof Job);

        assertTrue(test_job3.getName() instanceof String);
        assertEquals("Product tester", test_job3.getName());

        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertEquals("ACME", test_job3.getEmployer().toString());

        assertTrue(test_job3.getLocation() instanceof Location);
        assertEquals("Desert", test_job3.getLocation().toString());


        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertEquals("Quality control", test_job3.getPositionType().toString());

        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", test_job3.getCoreCompetency().toString());

    }

    @Test
    public void testJobForEquality() {
        Job test_job4 = new Job("Name", new Employer("Apple"), new Location("Beach"), new PositionType("Product Development"), new CoreCompetency("Communication"));
        Job test_job5 = new Job("Name", new Employer("Apple"), new Location("Beach"), new PositionType("Product Development"), new CoreCompetency("Communication"));

        assertFalse(test_job4.getId() == test_job5.getId());
    }

    @Test
    public void returnsStringWhenJobPassed() {
        Job test_job6 = new Job("Name", new Employer("Apple"), new Location("Beach"), new PositionType("Product Development"), new CoreCompetency("Communication"));
        String[] arrayString = test_job6.toString().split("\n");
        //System.out.println(arrayString.length);
        int linesOfSpace = 0;
        for (String line : arrayString) {
            if(line.length() == 1) {
                linesOfSpace++;
                //System.out.println(linesOfSpace);
            }
        }
        //System.out.println(test_job6.toString());
        assertEquals(2, linesOfSpace);
    }

    @Test
    public void stringContainsLabelAndData() {
        Job test_job7 = new Job("Name", new Employer("Apple"), new Location("Beach"), new PositionType("Product Development"), new CoreCompetency("Communication"));
        String finalString = test_job7.toString();
        assertTrue(finalString.contains("Name: Name"));
        assertTrue(finalString.contains("Employer: Apple"));
        assertTrue(finalString.contains("Location: Beach"));
        assertTrue(finalString.contains("Position Type: Product Development"));
        assertTrue(finalString.contains("Core Competency: Communication"));
    }

    @Test
    public void emptyFieldReturnsSetString() {
        PositionType testPosition = new PositionType("Product Development");
        test_job1.setPositionType(testPosition);
        String finalString = test_job1.toString();
        assertTrue(finalString.contains("Name: Data not available"));
        assertTrue(finalString.contains("Employer: Data not available"));

    }

    @Test
    public void returnsStringIfOnlyIdHasValue() {
        String finalString = test_job1.toString();
        assertEquals("OOPS! This job does not seem to exist.", finalString);
    }
}
