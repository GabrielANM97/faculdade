package interfaces;

import java.util.Iterator;
import exceptions.InvalidPositionException;


public interface Tree<E> extends Iterable<E> {

	public int size();

	public boolean isEmpty();

	public Iterator<E> iterator();

	public Iterable<Position<E>> positions();

	public E replace(Position<E> v, E e) throws InvalidPositionException;	

	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;

	public boolean isInternal(Position<E> v) throws InvalidPositionException;

	public boolean isExternal(Position<E> v) throws InvalidPositionException;

	public boolean isRoot(Position<E> v) throws InvalidPositionException;

}
