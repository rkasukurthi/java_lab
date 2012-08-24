package example.delegate

/**
 * Java doesn't provide any built-in delegation mechanism, and so far Groovy didn't either. 
 * But with the @Delegate transformation, a class field or property can be annotated and become 
 * an object to which method calls are delegated. In the following example, an Event class has 
 * a date delegate, and the compiler will delegate all of Date's methods invoked on the Event 
 * class to the Date delegate. As shown in the latest assert, the Event class has got a 
 * before(Date) method, and all of Date's methods.
 * 
 * @author zluo
 *
 */

class Photo {
	int width
	int height
}

class PhotoSelection {
	@Delegate Photo photo

	String title
	String caption
}

def photo = new Photo(width: 640, height: 480)
def selection = new PhotoSelection(title: "Groovy", caption: "Groovy", photo: photo)

assert selection.title == "Groovy"
assert selection.caption == "Groovy"

assert selection.width == 640
assert selection.height == 480

