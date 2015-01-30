package compare;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {
	
	
    Set<Space> set = new TreeSet<Space>(new Comparator<Space>(){

		public int compare(Space o1, Space o2) {
			int c1=-1,c2=-1;
			if (!o1.isOccupied) c1= o1.getWeight();
			if (!o2.isOccupied) c2= o2.getWeight();
			return c2-c1;
		}
    });

    
    
	public static class Space{
		int id;
		int weight;
		boolean isOccupied;
		Car car;
		
		public Space(int id, int weight) {
			super();
			this.id = id;
			this.weight = weight;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public boolean isOccupied() {
			if (car !=null) return true;
			return false;
		}
		
		public Car getCar() {
			return car;
		}
		public void setCar(Car car) {
			this.car = car;
		}
	}

	public static class Car{
		int id;
		public Car(int id) {
			super();
			this.id = id;
		}
	}

	@Test
	public void test(){
		Space space1=new Space(1, 1);
		Space space2=new Space(2, 2);
		Space space3=new Space(3, 2);
		Space space4=new Space(4, 3);
		Space space5=new Space(5, 0);
		set.add(space1);
		set.add(space2);
		set.add(space3);
		set.add(space4);
		set.add(space5);
		
		Iterator<Space> it = set.iterator();
		assertEquals(5, it.next().getId());

		space5.setCar(new Car(2));
		
		it = set.iterator();
		assertEquals(4, it.next().getId());
		
		space5.setCar(null);
		
		it = set.iterator();
		assertEquals(5, it.next().getId());
	}
	
	
}
