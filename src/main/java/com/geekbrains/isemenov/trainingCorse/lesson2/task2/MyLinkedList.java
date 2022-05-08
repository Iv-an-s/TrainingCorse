package com.geekbrains.isemenov.trainingCorse.lesson2.task2;

import com.geekbrains.isemenov.trainingCorse.lesson2.task1.MyList;

import java.util.Collection;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    int size;
    Node<E> first;
    Node<E> last;

    public MyLinkedList() {
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }

    private void linkLast(E element) {
        final MyLinkedList.Node<E> oldLastNode = last;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(oldLastNode, element, null);
        last = newNode;
        if (oldLastNode == null)
            first = newNode;
        else
            oldLastNode.next = newNode;
        size++;
        //modCount++;
    }

    private E unlinkLast(MyLinkedList.Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final MyLinkedList.Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        //modCount++;
        return element;
    }

    private void linkFirst(E element) {
        final MyLinkedList.Node<E> oldFirstNode = first;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(null, element, oldFirstNode);
        first = newNode;
        if (oldFirstNode == null)
            last = newNode;
        else
            oldFirstNode.prev = newNode;
        size++;
        //modCount++;
    }

    private E unlinkFirst(MyLinkedList.Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final MyLinkedList.Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        //modCount++;
        return element;
    }

    E unlink(MyLinkedList.Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final MyLinkedList.Node<E> next = x.next;
        final MyLinkedList.Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        //modCount++;
        return element;
    }

    public E removeFirst() {
        final MyLinkedList.Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    public E removeLast() {
        final MyLinkedList.Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    public E getFirst() {
        final MyLinkedList.Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public E getLast() {
        final MyLinkedList.Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public E remove(int index) {
        if (index >= 0 && index < size) {
            return unlink(node(index));
        }
        throw new IndexOutOfBoundsException("Incorrect index: " + index);
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            return node(index).item;
        }
        throw new IndexOutOfBoundsException("Incorrect index: " + index);
    }

    private MyLinkedList.Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }


    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Incorrect index: " + index);
        }
        if (index == 0) {
            addFirst(element);
        }
        if (index == size - 1) {
            addLast(element);
        }
        MyLinkedList.Node<E> node = node(index);
        MyLinkedList.Node<E> previousNode = node.prev;
        MyLinkedList.Node<E> nextNode = node;
        MyLinkedList.Node<E> insertedNode = new Node<E>(previousNode, element, nextNode);
        previousNode.next = insertedNode;
        nextNode.prev = insertedNode;
        size++;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return (indexOf(o) >= 0);
    }

    public int lastIndexOf(Object o) {
        int index = size - 1;
        MyLinkedList.Node<E> lastNode = last;
        while (index >= 0) {
            E lastElement = lastNode.item;
            if (lastElement.equals(o)) {
                return index;
            }
            lastNode = lastNode.prev;
            index--;
        }
        return -1;
    }


    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Incorrect index: " + index);
        }

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        MyLinkedList.Node<E> predecessor, successor;
        if (index == size) {
            successor = null;
            predecessor = last;
        } else {
            successor = node(index);
            predecessor = successor.prev;
        }

        for (Object o : a) {
            E e = (E) o;
            MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(predecessor, e, null);
            if (predecessor == null)
                first = newNode;
            else
                predecessor.next = newNode;
            predecessor = newNode;
        }

        if (successor == null) {
            last = predecessor;
        } else {
            predecessor.next = successor;
            successor.prev = predecessor;
        }

        size += numNew;
        //modCount++;
        return true;
    }

    public boolean removeAll(Collection c) {
        for (Object o : c) {
            if (!remove(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyLinkedList.Node<E> node = first;
        result[0] = node.item;
        for (int i = 1; i < size; i++) {
            node = node.next;
            result[i] = node.item;
        }
        return result;
    }

    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
