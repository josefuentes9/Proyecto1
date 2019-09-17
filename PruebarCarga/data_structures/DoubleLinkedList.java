package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de objetos genericos.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class DoubleLinkedList<T> implements IDoubleLinkedList<T>
{
	/**
	 * Cabeza de la lista encadenada
	 */
	private Node<T> primero;

	/**
	 * �ltimo elemento de la lista encadenada
	 */
	private Node<T> ultimo;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int num;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public DoubleLinkedList( )
	{
		primero = null;
		ultimo = null;
	}

	public void agregar( T o )
	{
		Node<T> act= new Node<T>(o);
		if( primero == null )
		{
			primero = act;
			ultimo = act;
		}
		else
		{
			primero.insertarDespues(act);
			ultimo=act;
		}
		num++;
	}
	
	public int size() 
	{
		return num;
	}
	private class DoubleLinkedListIterator implements Iterator<T>{

		Node<T> a =null;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			boolean bool;
			if(a==null)
			{
				a=primero;
			}
			else 
			{
				a=a.darSiguiente();
			}
			if(a==null)
			{
				bool=false;
			}
			else
			{
				bool=true;
			}
			return bool;
		}
		
		@Override
		public T next() {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			if(a!=null)
			{
				return a.darObjeto();
			}
			else
			{
				throw new NoSuchElementException();
			}

		}
	}



	@Override
	public void remove(int pos) {
		// TODO Auto-generated method stub
		    
		        T valor = null;
		        if( pos == 0 )
		        {
		            if( primero.equals( ultimo ) )
		            {
		                ultimo = null;
		            }
		            valor = primero.darElemento( );
		            primero = primero.desconectarPrimero( );
		            num--;
		        }
		        else
		        {

		            Node<T> p = primero.darSiguiente( );
		            for( int cont = 1; cont < pos; cont++ )
		            {
		                p = p.darSiguiente( );
		            }

		            if( p.equals( ultimo ) )
		            {
		                ultimo = p.darAnterior( );
		            }
		            valor = p.darElemento( );
		            p.desconectarNodo( );
		            num--;
		        
		    }
	}

	@Override
	public T get(int pos) {
	            Node<T> aux = primero;

	            for( int cont = 0; cont < pos; cont++ )
	            {
	                aux = aux.darSiguiente( );
	            }

	            return aux.darElemento( );
	        
	}

	@Override
	public boolean isEmpty() 
	{
		primero = null;
        ultimo = null;
        num = 0;
        return true;
	}
	
	@Override
	public Iterator<T> iterator() 
	{			
		return new DoubleLinkedListIterator();
	}

	
}
	

