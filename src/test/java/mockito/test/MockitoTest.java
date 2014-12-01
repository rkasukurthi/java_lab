package mockito.test;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * This is the sample code from <a
 * href="http://docs.mockito.googlecode.com/hg/org/mockito/Mockito.html#1"
 * >mockito document</a> <li>{@link #testVerify()} <li>{@link #testStubbing()}
 * <li>{@link #testMatchers()}
 * 
 * @author zluo
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

	interface IMock {
		String call(String args);
	}

	@Mock
	List mList;
	@Mock
	IMock iMock;

	/**
	 * An example to demonstrate verify methods are run.
	 */
	@Test
	public void testVerify() {
		List mockedList = mock(List.class);
		mockedList.add("one");
		System.out.println(mockedList.size());
		mockedList.clear();
		System.out.println(mockedList.size());
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

	@Test
	public void testStubbing() {
		LinkedList mockedList = mock(LinkedList.class);
		when(mockedList.get(0)).thenReturn("first");
		System.out.println(mockedList.get(0));
		verify(mockedList).get(0);
	}

	@Test
	public void testMatchers() {
		LinkedList mockedList = mock(LinkedList.class);
		// stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		// stubbing using hamcrest (let's say isValid() returns your own
		// hamcrest matcher):
		// when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		// following prints "element"
		System.out.println(mockedList.get(999));

		// you can also verify using an argument matcher
		verify(mockedList).get(anyInt());
	}

	@Test
	public void testInvocationNumbers() {
		LinkedList mockedList = mock(LinkedList.class);
		// using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		// following two verifications work exactly the same - times(1) is used
		// by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		// verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("three times");
		verify(mockedList, atMost(5)).add("three times");

	}

	@Test
	public void verifyException() {
		try {
			LinkedList mockedList = mock(LinkedList.class);
			doThrow(new Exception()).when(mockedList).clear();
			mockedList.clear();
		} catch (Exception e) {
		}
	}

	@Test
	public void verifyInOrder() {
		List firstMock = mock(List.class);
		List secondMock = mock(List.class);

		// using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");

		// create inOrder object passing any mocks that need to be verified in
		// order
		InOrder inOrder = inOrder(firstMock, secondMock);

		// following will make sure that firstMock was called before secondMock
		inOrder.verify(firstMock).add("was called first");
		inOrder.verify(secondMock).add("was called second");
	}

	@Test
	public void neverHappen() {
		List mockOne = mock(List.class);
		List mock2 = mock(List.class);
		List mock3 = mock(List.class);
		mockOne.add("one");

		verify(mockOne).add("one");
		verifyZeroInteractions(mock2, mock3);
	}

	@Test
	public void findRedundant() {
		List mockList = mock(List.class);
		mockList.add("one");
		// mockList.add("two");
		verify(mockList).add("one");
		verifyNoMoreInteractions(mockList);
	}

	@Test
	public void testMockAnnotation() {
		mList.add("one");
		System.out.println(mList.size());
		mList.clear();
		System.out.println(mList.size());
		verify(mList).add("one");
		verify(mList).clear();
	}

	@Test
	public void testConsecutiveCalls() {
		when(mList.get(anyInt())).thenReturn("one", "two", "three");

		System.out.println(mList.get(0));
		System.out.println(mList.get(1));
		System.out.println(mList.get(2));
	}

	@Test
	public void testStubbingWithCallbacks() {

		when(iMock.call(anyString())).thenAnswer(new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Object mock = invocation.getMock();
				return "called with arguments" + args;
			}
		});
		// Following prints "called with arguments: foo"
		System.out.println(iMock.call("foo"));

	}
}
