package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(newJob.getName(),"Product tester");
        assertEquals(newJob.getEmployer().getValue(),"ACME");
        assertEquals(newJob.getLocation().getValue(),"Desert");
        assertEquals(newJob.getPositionType().getValue(),"Quality control");
        assertEquals(newJob.getCoreCompetency().getValue(),"Persistence");

        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(newJob.getName() instanceof String);

    }
    @Test
    public void testJobsForEquality(){
        Job jobA = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job jobB = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertNotEquals(jobA, jobB);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobA = new Job("Data Base", new Employer("Citi"),
                new Location("Kentucky"),
                new PositionType("Data Analyst"),
                new CoreCompetency("Persistence"));
        assertEquals(jobA.toString().startsWith(System.lineSeparator()),true);
        assertEquals(jobA.toString().endsWith(System.lineSeparator()),true);

    }

    private String newLine = System.lineSeparator();

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency(""));
        assertEquals( newLine +
                "ID: " + testJob.getId()  + newLine +
                "Name: Product tester" + newLine +
                "Employer: ACME" + newLine +
                "Location: Data not available" + newLine +
                "Position Type: Quality control" + newLine +
                "Core Competency: Data not available" +
                newLine, testJob.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency(""));

        assertEquals( newLine +
                "ID: " + testJob.getId() + newLine +
                "Name: Product tester" + newLine +
                "Employer: ACME" + newLine +
                "Location: Data not available" + newLine +
                "Position Type: Quality control" + newLine +
                "Core Competency: Data not available" +
                newLine, testJob.toString());
    }

}






