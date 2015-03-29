package arrays;

import java.lang.reflect.Array;

public class ArrayReflection {
	 /**
	  * While developing an application, it is reasonable that the developer
	  * needs to determine if an argument or object is an array. To perform this
	  * in Java, you must first retrieve the object’s Class object and simply
	  * ask it. The isArray() method of the Class class will tell you.
	  *
	  * Once you have determined you have an array, you can ask the
	  * getComponentType() method of Class what type of array you actually
	  * have. The getComponentType() method returns null if the isarray() method
	  * returned false. Otherwise, the Class type of the element is returned.
	  * You can recursively call isarray() if the array is multidimensional.
	  *
	  * You can use the getLength() method of the array class found in
	  * java.lang.reflect package to discover the length of the array.
	  *
	  */
	 public static void arrayReflection() {

	     System.out.println("               array REFLECTION                  ");
	     System.out.println("-------------------------------------------------");

	     String stringVariable = "Alex Hunter";
	     Class type0 = stringVariable.getClass();

	     if (type0.isArray()) {
	         Class elementType = type0.getComponentType();
	         System.out.println("    - array of  : " + elementType);
//	         System.out.println("    - Length of : " + array.getLength(stringVariable));
	     } else {
	         System.out.println("    - " + type0.getName() + " is not an array");
	     }


	     System.out.println();
	     System.out.println("  -----------------------");
	     System.out.println("  String array Reflection");
	     System.out.println("  -----------------------");
	     System.out.println();

	     String[] stringarray = {
	         "Sun Solaris", "HP-UX", "Linux", "MS Windows", "Macintosh"
	     };

	     Class type1 = stringarray.getClass();

	     if (type1.isArray()) {
	         Class elementType = type1.getComponentType();
	         System.out.println("    - array of  : " + elementType);
	         System.out.println("    - Length of : " + Array.getLength(stringarray));
	     } else {
	         System.out.print("    - " + type1.getName() + " is not an array");
	     }


	     System.out.println();
	     System.out.println("  --------------------------------");
	     System.out.println("  int (primitive) array Reflection");
	     System.out.println("  --------------------------------");
	     System.out.println();

	     int[] intarray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
	     Class type2 = intarray.getClass();

	     if (type2.isArray()) {
	         Class elementType = type2.getComponentType();
	         System.out.println("    - array of  : " + elementType);
	         System.out.println("    - Length of : " + Array.getLength(intarray));
	     } else {
	         System.out.print("    - " + type2.getName() + " is not an array");
	     }

	 }


	 /**
	  * Sole entry point to the class and application.
	  * @param args array of String arguments.
	  */
	 public static void main(String[] args) {

	     arrayReflection();
	 }
}
