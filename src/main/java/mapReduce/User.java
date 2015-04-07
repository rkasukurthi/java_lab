package mapReduce;

public class User {
    String name;
    int age;
    int color;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public User(String name, int i) {
	super();
	this.name = name;
	this.age = i;
    }
    
    
}
