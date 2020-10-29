/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kind.time.cal;

import java.util.Calendar;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael J. Lee
 */
public class DayOfWeekTest {

   @Test
   public void testMondayIsWeekday(){
       assertTrue(DayOfWeek.MONDAY.isWeekday());
       assertFalse(DayOfWeek.MONDAY.isWeekend());
       assertTrue(DayOfWeek.isWeekday(Calendar.MONDAY));
       assertFalse(DayOfWeek.isWeekend(Calendar.MONDAY));
   }
   
   @Test
   public void testTuesdayIsWeekday(){
       assertTrue(DayOfWeek.TUESDAY.isWeekday());
       assertFalse(DayOfWeek.TUESDAY.isWeekend());
       assertTrue(DayOfWeek.isWeekday(Calendar.TUESDAY));
       assertFalse(DayOfWeek.isWeekend(Calendar.TUESDAY));
   }
   
   
   @Test
   public void testWednesdayIsWeekday(){
       assertTrue(DayOfWeek.WEDNESDAY.isWeekday());
       assertFalse(DayOfWeek.WEDNESDAY.isWeekend());
       assertTrue(DayOfWeek.isWeekday(Calendar.WEDNESDAY));
       assertFalse(DayOfWeek.isWeekend(Calendar.WEDNESDAY));
   }
   
   @Test
   public void testThursdayIsWeekday(){
       assertTrue(DayOfWeek.THURSDAY.isWeekday());
       assertFalse(DayOfWeek.THURSDAY.isWeekend());
       assertTrue(DayOfWeek.isWeekday(Calendar.THURSDAY));
       assertFalse(DayOfWeek.isWeekend(Calendar.THURSDAY));
   }
   
   @Test
   public void testFridayIsWeekday(){
       assertTrue(DayOfWeek.FRIDAY.isWeekday());
       assertFalse(DayOfWeek.FRIDAY.isWeekend());
       assertTrue(DayOfWeek.isWeekday(Calendar.FRIDAY));
       assertFalse(DayOfWeek.isWeekend(Calendar.FRIDAY));
   }

   @Test
   public void testSaturdayIsWeekend(){
       assertTrue(DayOfWeek.SATURDAY.isWeekend());
       assertFalse(DayOfWeek.SATURDAY.isWeekday());
       assertFalse(DayOfWeek.isWeekday(Calendar.SATURDAY));
       assertTrue(DayOfWeek.isWeekend(Calendar.SATURDAY));
   }

      @Test
   public void testSundayIsWeekend(){
       assertTrue(DayOfWeek.SUNDAY.isWeekend());
       assertFalse(DayOfWeek.SUNDAY.isWeekday());
       assertFalse(DayOfWeek.isWeekday(Calendar.SUNDAY));
       assertTrue(DayOfWeek.isWeekend(Calendar.SUNDAY));
   }
   
    @Test
    public void testGetISOValueForMonday(){
        assertEquals(1, DayOfWeek.MONDAY.getISOValue());
    }
    
    @Test
    public void testGetISOValueForTuesday(){
        assertEquals(2, DayOfWeek.TUESDAY.getISOValue());
    }
    
    @Test
    public void testGetISOValueForWednesday(){
        assertEquals(3, DayOfWeek.WEDNESDAY.getISOValue());
    }
    
    @Test
    public void testGetISOValueForThursday(){
        assertEquals(4, DayOfWeek.THURSDAY.getISOValue());
    }
    
    @Test
    public void testGetISOValueForFriday(){
        assertEquals(5, DayOfWeek.FRIDAY.getISOValue());
    }
    
    @Test
    public void testGetISOValueForSaturday(){
        assertEquals(6, DayOfWeek.SATURDAY.getISOValue());
    }
    
    @Test
    public void testGetISOValueForSunday(){
        assertEquals(7, DayOfWeek.SUNDAY.getISOValue());
    }


 
}
