package MiningAndGems;

import Mining.List.MyArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

  // Testing add(int index, T element)

  // Testing ability to add item to a list, with an index and an element, sunny case scenario
  @Test
  public void addedElementIsInList() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    list.add(0, 1);

    // assert
    assertEquals(1, list.get(0));
  }

  // Testing ability to add multiple items to list with index and element
  @Test
  public void addMultipleElementsToList() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // assert
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  // Testing size of list after adding 5 elements
  @Test
  public void sizeIs5AfterAdding5Elements() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);
    list.add(3, 4);
    list.add(4, 5);

    // assert
    assertEquals(5, list.size());
  }

  // Testing ability to add null element to list
  // Test failed because of IllegalArgumentException was not thrown
  @Test public void nullArgumentResultsInIllegalStateException2() {
    // arrange
    MyArrayList<String> list = new MyArrayList<>();

    // act, assert
    assertThrows(IllegalArgumentException.class, () -> list.add(0, null));
  }

  // Testing ability to add element to list with index out of bounds
  @Test public void indexOutOfBoundsResultsInIndexOutOfBoundsException2() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act, assert
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 1));
  }



  // Test add(T element)

  // Testing ability to add item to list with no index, sunny case scenario
  @Test public void addItemsNoIndex() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    list.add(1);

    // assert
    assertEquals(1, list.get(0));
  }

  // Testing ability to add multiple items to list with no index
  @Test public void addMultipleItemsWithNoIndex() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    list.add(1);
    list.add(2);
    list.add(3);

    // assert
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  // Testing size of list after adding 5 elements with no index
  // test failed because illegalArgumentException was not thrown
  @Test public void nullArgumentResultsInIllegalStateException() {
    // arrange
    MyArrayList<String> list = new MyArrayList<>();

    // act, assert
    assertThrows(IllegalArgumentException.class, () -> list.add(null));
  }


  // Test set(int index, T element)

  // Testing ability to set elements in list, by adding elements and after that, setting them, sunny case scenario
  @Test public void setElementWorks() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    list.set(1, 4);

    // assert
    assertEquals(4, list.get(1));
  }

  // Testing ability to set element in an empty arrayList
  @Test public void setElementInEmptyArray() {
    MyArrayList<Integer> list = new MyArrayList<>();

    assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, 1));
  }

  // Testing ability to set element with an index out of bounds of the arrayList
  @Test public void setElementOutOfBounds() {
    MyArrayList<Integer> list = new MyArrayList<>();

    assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 1));
  }


  // Test get(int index)

  // Testing ability to get items within a list - sunny case scenario
  @Test public void getElementAtValidIndex() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    int element = list.get(1);

    // assert
    assertEquals(2, element, "should return element at index 1");
  }

  // Testing ability to get item in an empty arrayList
  @Test public void getElementInEmptyArray() {
    MyArrayList<Integer> list = new MyArrayList<>();

    Exception e = assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    assertTrue(e.getMessage().contains("index:0"), " should throw exception with message containing 'index:0'");
  }

  // Testing ability to get item in an empty arrayList out of bounds for initial list
  @Test public void getElementAtBoundaryIndexes() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);

    // act and assert
    assertAll("Testing boundary indexes",
        () -> assertEquals(10, list.get(0), "should return first elements"),
        () -> assertEquals(30, list.get(2), "should return last element")
    );
  }

  // Testing ability to get element with an index out of bounds of the arrayList
  @Test public void getElementOutOfBoundsNegativeIndex() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act and assert
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
  }

  // Testing ability to get element with an index out of bounds of the arrayList
  @Test public void getElementOutOfBoundsPositiveIndex() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    list.add(2);

    // act and assert
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
  }

  // Testing ability to get element after it has been removed
  @Test
  public void getElementAfterRemoval() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.remove(1); // Remove the element at index 1 (20)
    assertAll(
        () -> assertEquals(10, list.get(0), "Index 0 should still return the first element"),
        () -> assertEquals(30, list.get(1), "Index 1 should now return what was at index 2")
    );
  }


  // Test removeElement(int index)

  // Testing ability to remove items from list
  @Test public void removeElementWorks() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    list.remove(1);

    // assert
    assertEquals(1, list.get(0));
    assertEquals(3, list.get(1));
  }

  // Testing ability to remove items from list, where index is out of bounds: boundary test
  @Test public void removeElementWorks2() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);

    // assert
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
  }



  // Test removeElement(T element)

  // Testing ability to remove single item from list
  @Test public void removeElementFromListWithNoIndex() {
    // arrange
    MyArrayList<String> list = new MyArrayList<>();
    list.add("A");

    // act
    list.remove("A");

    // assert
    assertEquals(0, list.size());
  }

  // Testing ability to remove item from list, where item is not on list, testing boundaries
  @Test public void removeElementNotInList() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);

    // act and assert
    assertThrows(IllegalStateException.class, () -> list.remove(null));
  }

  // Testing ability to remove item from list, where item is not on list, testing boundaries
  @Test public void removeElementNotInList2() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);

    // act and assert
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
  }

  // Testing ability to remove item from list, where item is not on list, testing boundaries
  @Test public void removeElementNotInList3() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);

    // act and assert
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
  }


  // Test indexOf(T element)

  // Testing ability to get index of an element in a list
  @Test public void indexOfWorks() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    int index = list.indexOf(2);

    // assert
    assertEquals(1, index);
  }

  // Testing ability to get index of an element in a list, where element is not in list
  @Test public void indexOfElementNotInList() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    int index = list.indexOf(4);

    // assert
    assertEquals(-1, index);
  }


  // Test contains(T element)
  // Testing ability to check if element is in list
  @Test public void containsWorks() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    boolean contains = list.contains(2);

    // assert
    assertTrue(contains);
  }

  // Testing ability to check if element is in list, where element is not in list
  @Test public void containsElementNotInList() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    boolean contains = list.contains(4);

    // assert
    assertFalse(contains);
  }

  // Testing ability to check if element is in list, where list is empty
  @Test public void containsElementInEmptyList() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    boolean contains = list.contains(1);

    // assert
    assertFalse(contains);
  }

  // Testing ability to check if element is in list, where element is null
  // Failed because IllegalArgument was not thrown
  @Test public void containsNullElement() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    boolean contains = list.contains(null);

    // assert
    assertFalse(contains);
  }

  // Testing ability to check if element is in list, where list is empty and element is null
  @Test public void containsNullElementInEmptyList() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    boolean contains = list.contains(null);

    // assert
    assertFalse(contains);
  }

  // Testing ability to check if element is in list, where element is null and list has null element
  @Test public void containsNullElementInList() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, null);
    list.add(1, 2);
    list.add(2, 3);

    // act
    boolean contains = list.contains(null);

    // assert
    assertTrue(contains);
  }


  // Test isEmpty()
  // Testing ability to check if list is empty

  // Testing ability to check if list is empty, where list is empty
  @Test public void isEmptyWorks() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    boolean isEmpty = list.isEmpty();

    // assert
    assertTrue(isEmpty);
  }

  // Testing ability to check if list is empty, where list is not empty
  @Test public void isEmptyWorks2() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);

    // act
    boolean isEmpty = list.isEmpty();

    // assert
    assertFalse(isEmpty);
  }

  // Testing ability to check if list is empty, where list is empty and element is null
  @Test public void isEmptyWorks3() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, null);

    // act
    boolean isEmpty = list.isEmpty();

    // assert
    assertFalse(isEmpty);
  }

  // Testing ability to check if list is empty, where list is not empty and element is null
  @Test public void isEmptyWorks4() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, null);

    // act
    boolean isEmpty = list.isEmpty();

    // assert
    assertFalse(isEmpty);
  }



  // Test isFull()
  // Testing ability to check if list is full where list has items
  // failed because even if the list is full, it is unbounded the method always return false
  @Test public void isFullWorks2() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    boolean isFull = list.isFull();

    // assert
    assertFalse(isFull);
  }

  // Testing ability to check if list is full, where list is empty
  // failed because even if the list is full, it is unbounded the method always return false
  @Test public void isFullWorks() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    boolean isFull = list.isFull();

    // assert
    assertFalse(isFull);
  }

  // Testing ability to check if list is full, where list is empty and element is null
  // failed because even if the list is full, it is unbounded the method always return false
  @Test public void isFullWorks3() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, null);

    // act
    boolean isFull = list.isFull();

    // assert
    assertFalse(isFull);
  }

  // Testing ability to check if list is full, where list is not empty and element is null
  // failed because even if the list is full, it is unbounded the method always return false
  @Test public void isFullWorks4() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, null);

    // act
    boolean isFull = list.isFull();

    // assert
    assertFalse(isFull);
  }

  // Test size()
  // Testing ability to get size of list
  @Test public void sizeWorks() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);

    // act
    int size = list.size();

    // assert
    assertEquals(3, size);
  }

  // Testing ability to get size of list, where list is empty
  @Test public void sizeWorks2() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    int size = list.size();

    // assert
    assertEquals(0, size);
  }

  // Testing ability to get size of list, where list is empty and element is null
  @Test public void sizeWorks3() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, null);

    // act
    int size = list.size();

    // assert
    assertEquals(1, size);
  }

  // Testing ability to get size of list, where list is not empty and element is null
  @Test public void sizeWorks4() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, null);

    // act
    int size = list.size();

    // assert
    assertEquals(2, size);
  }

  // Testing ability to get size of list where item is added and removed
  @Test public void sizeWorks5() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);
    list.remove(1);

    // act and assert
    assertEquals(2, list.size());
  }




  // Testing ToString()

  // Testing ability to get string representation of empty list
  @Test
  public void toStringOnEmptyList() {
    MyArrayList<Integer> list = new MyArrayList<>();
    assertEquals("{}", list.toString(), "String representation of an empty list should be {}");
  }

  // Testing ability to get string representation of list with one element
  @Test
  public void toStringWithSingleElement() {
    MyArrayList<String> list = new MyArrayList<>();
    list.add("Hello");
    assertEquals("{Hello}", list.toString(), "String representation should contain only one element without a trailing comma");
  }

  // Testing ability to get string representation of list with multiple elements
  @Test
  public void toStringWithMultipleElements() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals("{1, 2, 3}", list.toString(), "String representation should match the elements in the list");
  }

  // Testing ability to get string representation of list with multiple elements, where elements are null
  @Test
  public void toStringWithNullElements() {
    MyArrayList<String> list = new MyArrayList<>();
    list.add("Hello");
    list.add(null);
    list.add("World");
    assertEquals("{Hello, null, World}", list.toString(), "String representation should correctly display null elements");
  }

  // Testing ability to get string representation of list after element removal
  @Test
  public void toStringAfterElementRemoval() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.remove(1); // Remove element '2'
    assertEquals("{1, 3}", list.toString(), "String representation should reflect list after removal");
  }









  // Test expandCapacity()
  // Testing ability to expand capacity of list
  @Test public void expandingCapacityWorks() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    for (int i = 0; i < 101; i++) {
      list.add(i);
    }

    // assert
    assertEquals(101, list.size());
  }

  // Testing ability to expand capacity of list, where list is empty
  @Test public void expandingCapacityWorks2() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();

    // act
    for (int i = 0; i < 101; i++) {
      list.add(i);
    }

    // assert
    assertEquals(101, list.size());
  }

  // Testing ability to expand capacity of list, where list is empty and element is null
  @Test public void expandingCapacityWorks3() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, null);

    // act
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }

    // assert
    assertEquals(101, list.size());
  }

  // Testing ability to expand capacity of list, where list is not empty and element is null
  @Test public void expandingCapacityWorks4() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(0, 1);
    list.add(1, null);

    // act
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }

    // assert
    assertEquals(102, list.size());
  }

  // Testing ability to expand capacity of list, where list is full
  @Test public void expandingCapacityWorks5() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }

    // act
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }

    // assert
    assertEquals(200, list.size());
  }

  // Testing ability to expand capacity of list, where list is full and element is null
  @Test public void expandingCapacityWorks6() {
    // arrange
    MyArrayList<Integer> list = new MyArrayList<>();
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }

    // act
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }

    // assert
    assertEquals(200, list.size());
  }

}