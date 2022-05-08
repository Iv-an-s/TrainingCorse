package com.geekbrains.isemenov.trainingCorse.lesson2.task1;

import java.util.Collection;

public interface MyList<E> {
    E get(int index);

    boolean add(E e);

    E set(int index, E element);

    E remove(int index);

    boolean remove(Object o);

    int indexOf(Object o);

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    int lastIndexOf(Object o);

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    boolean removeAll(Collection<?> c);

    Object[] toArray();
}
