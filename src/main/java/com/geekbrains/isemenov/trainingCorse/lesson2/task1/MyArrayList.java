package com.geekbrains.isemenov.trainingCorse.lesson2.task1;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(Object[] array) {
        elementData = new Object[array.length + (array.length >> 1)];
        System.arraycopy(array, 0, elementData, 0, array.length);
        size = array.length;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Incorrect initial capacity: " + initialCapacity);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Incorrect index: " + index);
        }
        return (E) elementData[index];
    }

    public boolean add(E e) {
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size] = e;
        size++;
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        int cSize = c.size();
        if (cSize == 0)
            return false;

        Object[] a = c.toArray();
        int oldSize = size;

        while ((size + cSize) < elementData.length) {
            grow();
        }

        System.arraycopy(a, 0, elementData, oldSize, cSize);
        size = size + cSize;

        return true;
    }

    private Object[] grow() {
        return elementData = Arrays.copyOf(elementData, newCapacity(size + 1));
    }

    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);


        if (newCapacity - minCapacity <= 0) {
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : MAX_ARRAY_SIZE;
    }

    public E set(int index, E element) {

        if (index < 0 || index >= size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Max index is: " + (size - 1));
        }
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    public E remove(int index) {
        if (index < 0 || index >= size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Max index is: " + (size - 1));
        }
        E oldValue = (E) elementData[index];
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        } else {
            elementData[newSize] = null;
        }
        size = newSize;
        return oldValue;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0) {
            return false;
        }
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        } else {
            elementData[newSize] = null;
        }
        size = newSize;
        return true;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            if (!remove(o)) {
                return false;
            }
        }
        return true;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
}





