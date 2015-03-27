package stack;
/**
 * http://stackoverflow.com/questions/685060/design-a-stack-such-that-getminimum-should-be-o1
 * @author zluo
 *
 */
public class StackWithMin {
    int min;
    int size;
    int[] data = new int[1024];

    public void push ( int val ) {
        if ( size == 0 ) {
            data[size] = val;
            min = val;
        } else if ( val < min) {
            data[size] = 2 * val - min;
            min = val;

            assert (data[size] < min); 
        } else {
            data[size] = val;
        }

        ++size;

        // check size and grow array
    }

    public int getMin () {
        return min;
    }

    public int pop () {
        --size;

        int val = data[size];

        if ( ( size > 0 ) && ( val < min ) ) {
            int prevMin = min;
            min += min - val;
            return prevMin;
        } else {
            return val;
        }
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public static void main (String...args) {
        StackWithMin stack = new StackWithMin();

        for ( String arg: args ) 
            stack.push( Integer.parseInt( arg ) );

        while ( ! stack.isEmpty() ) {
            int min = stack.getMin();
            int val = stack.pop();

            System.out.println( val + " " + min );
        }

        System.out.println();
    }

}