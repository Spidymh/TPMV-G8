package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;


/**
 * Clase abstracta que representa una instruccion del programa de la que heredan
 * todas las dem�s clases que van a representar alg�n ByteCode.
 * @authors Pablo Martin Huertas y Jose M� Lopez
 */
public abstract class ByteCode {
	/**
	 * Permite ejecutar un Bytecode.
	 * @param cpu El objeto CPU en el que se realizar� la operaci�n.
	 * @return Devuelve cierto si se ha podido realizar la operaci�n
	 * o falso en otro caso.
	 */
	abstract public boolean execute(CPU cpu);
	/**
	 * 
	 * @param words El array de Strings que se va a parsear, en posici�n 0
	 * el c�digo del Bytecode y en la 1 el par�metro si es necesario.
	 * @return Devuelve el Bytecode parseado o null si no se reconoce ninguno.
	 */
	abstract public ByteCode parse(String[] words);
	//abstract public String toString();
}
