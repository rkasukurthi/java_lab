package mapReduce;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import org.junit.Test;

public class MapReduceTest {
    
    List<User> createUsers(){
	List<User> users= new ArrayList<User>();
	for (int i=0; i<10000000; i++){
	  User user = new User("x", i); 
	  user.color=i/2;
	  users.add(user);   
	}
	return users;
	
    }
    
    @Test
    public void testUsers(){
	List<User> users = createUsers();
	
	long start = System.currentTimeMillis();
	long sum=0;
	for(User user : users){
	    if (user.getName().equals("x") && user.color==0){
		sum += user.getAge();
	    }
	}
	long end = System.currentTimeMillis();
	System.out.println ("Normal way took : " + (end-start) + " ms.");
	
	long sum1 =0;
	start = System.currentTimeMillis();
	sum1 = users.parallelStream().filter(user->user.getName().equals("x") && user.color==0).mapToLong(u -> u.age).sum();
	end = System.currentTimeMillis();
	System.out.println ("Parallel Stream took : " + (end-start) + " ms.");
	
        assertEquals(sum, sum1);
    }
    
    
}
