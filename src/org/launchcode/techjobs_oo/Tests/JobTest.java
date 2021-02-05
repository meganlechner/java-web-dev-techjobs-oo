package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class JobTest {

    Job newJob1;
    Job newJob2;

    @Before
    public void createJobObjects() {
        newJob1 = new Job();
        newJob2 = new Job();
    }

    @Test
    public void testSettingJobId(){
        assertEquals((newJob1.getId()+1), newJob2.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(newJob.getName(), "Product tester");
        assertEquals(newJob.getEmployer().toString(), "ACME");
        assertEquals(newJob.getLocation().toString(), "Desert");
        assertEquals(newJob.getPositionType().toString(), "Quality control");
        assertEquals(newJob.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        newJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(newJob1.equals(newJob2));
    }

    @Test
    public void testTheString(){
        newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(newJob1.toString(), "*****" + "\nid: " + newJob1.getId() +
                "\nname: " + newJob1.getName() +
                "\nemployer: " + newJob1.getEmployer() +
                "\nlocation: " + newJob1.getLocation() +
                "\npositionType: " + newJob1.getPositionType() +
                "\ncoreCompetency: " + newJob1.getCoreCompetency() +
                "\n*****");
    }

    @Test
    public void testToStringConditionalName(){
        newJob1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("*****" + "\nid: " + newJob1.getId() +
                "\nname: Data not available" +
                "\nemployer: " + newJob1.getEmployer() +
                "\nlocation: " + newJob1.getLocation() +
                "\npositionType: " + newJob1.getPositionType() +
                "\ncoreCompetency: " + newJob1.getCoreCompetency() +
                "\n*****", newJob1.toString());
    }

    @Test
    public void testToStringConditionalEmployer(){
        newJob1 = new Job("Product Tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("*****" + "\nid: " + newJob1.getId() +
                "\nname: " + newJob1.getName() +
                "\nemployer: Data not available" + newJob1.getEmployer() +
                "\nlocation: " + newJob1.getLocation() +
                "\npositionType: " + newJob1.getPositionType() +
                "\ncoreCompetency: " + newJob1.getCoreCompetency() +
                "\n*****", newJob1.toString());
    }

    @Test
    public void testToStringConditionalLocation(){
        newJob1 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("*****" + "\nid: " + newJob1.getId() +
                "\nname: " + newJob1.getName() +
                "\nemployer: " + newJob1.getEmployer() +
                "\nlocation: Data not available" +
                "\npositionType: " + newJob1.getPositionType() +
                "\ncoreCompetency: " + newJob1.getCoreCompetency() +
                "\n*****", newJob1.toString());
    }

    @Test
    public void testToStringConditionalPositionType(){
        newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        assertEquals("*****" + "\nid: " + newJob1.getId() +
                "\nname: " + newJob1.getName() +
                "\nemployer: " + newJob1.getEmployer() +
                "\nlocation: " + newJob1.getLocation() +
                "\npositionType: Data not available" +
                "\ncoreCompetency: " + newJob1.getCoreCompetency() +
                "\n*****", newJob1.toString());
    }

    @Test
    public void testToStringConditionalCoreCompetency(){
        newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals("*****" + "\nid: " + newJob1.getId() +
                "\nname: " + newJob1.getName() +
                "\nemployer: " + newJob1.getEmployer() +
                "\nlocation: " + newJob1.getLocation() +
                "\npositionType: " + newJob1.getPositionType() +
                "\ncoreCompetency: Data not available" +
                "\n*****",newJob1.toString());
    }

    @Test
    public void testToStringConditionalNoJob(){
        newJob1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("Oopsie whoopsie, this job doesn't seem to exist!",newJob1.toString());
    }



}
