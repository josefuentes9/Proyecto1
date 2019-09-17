package model.data_structures;

import java.util.Iterator;

public interface IDoubleLinkedList <T> extends  Iterable <T>
{

	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param dato nuevo elemento
	 */
	public void agregar( T dato );
	public void remove (int pos);
	public T get (int pos);
	public boolean isEmpty();
	Iterator<T> iterator();

}
