package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class JobTest {

    @Before
    public void createJobObjects() {
        Job newJob1 = new Job();
        Job newJob2 = new Job();
    }

//    @Test
//    public void testSettingJobId(){
//        assertEquals((newJob1.getId()+1), newJob2.getId(), .001);
//    }

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
        Job newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(newJob1.equals(newJob2));
    }

}
