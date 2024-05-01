package Mining.List;

public interface ListADT<T>
{
  void add(int index, T element);
  void add(T element);
  void set(int index, T element);
  T get(int index);
  T remove(int index);
  T remove(T element);
  int indexOf(T element);
  boolean contains(T element);
  boolean isEmpty();
  boolean isFull();
  int size();
}
