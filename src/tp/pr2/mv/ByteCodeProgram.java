package tp.pr2.mv;

import tp.pr2.mv.bytecodes.ByteCode;


/**
 * Esta clase nos permite representar un programa en la m�quina virtual.
 * @authors Pablo Mart�n Huertas y Jose M� L�pez.
 *
 */

public class ByteCodeProgram {
	/**
	 * Constante que indica el tama�o m�ximo del programa.
	 */
	private final int MAX = 100;
	/**
	 * Es un array de ByteCodes que representa una lista de instrucciones.
	 */
	private ByteCode[] program;
	/**
	 * Numero de ByteCodes que tiene program.
	 */
	private int numInst;
	
	/**
	 * Constructor de ByteCodeProgram que nos permite crear un objeto de este tipo,
	 * con su atributo program vacio y por ello numInst = 0.
	 */
	public ByteCodeProgram(){
		this.program = new ByteCode[MAX];
		this.numInst = 0;
	}
	/**
	 * 
	 * @param inst Es el ByteCode que le concatenaremos a program despu�s de a �ltima posici�n ocupada.
	 * @return Devolver� cierto si caben mas instrucciones en program y falso en otro caso.
	 */
	public boolean push_back(ByteCode inst){
		if(numInst<program.length){
			program[numInst]=inst; 
			numInst++;
			return true;
			}
		else return false;
	}
	/**
	 * Nos permite acceder al atributo numInst del objeto.
	 * @return Devuelve el valor de numInst.
	 */
	public int getnumInst(){
		return numInst;
	}
	
	/**
	 * Nos permite acceder a un ByteCode de los que tiene almacenado el objeto en program.
	 * @param pos Posici�n del array a la que queremos acceder.
	 * @return Devolver� el ByteCode almacenado en la posici�n que se le ha pasado.
	 */
	public ByteCode getInstr(int pos){
		return program[pos];
	}
	
	/**
	 * Sustituye un ByteCode de program por otro.
	 * @param inst El ByteCode que queremos a�adir.
	 * @param pos La posici�n del ByteCode que va a ser sustituido.
	 * @return Devuelve cierto si se ha podido realizar la operaci�n y falso en otro caso.
	 */
	public boolean replace(ByteCode inst, int pos){
		if (pos >= numInst||pos<0) return false;
		else {
			program[pos] = inst;
			return true;
		}
	}
	
	/**
	 * Devuelve el ByteCode almacenado en cierta posici�n de program.
	 * @param i La posici�n a la que queremos acceder.
	 * @return Devolver� null si no se puede acceder a esa posici�n y el ByteCode en otro caso.
	 * 
	 */
	public ByteCode devolver(int i){
		if(i<numInst)return program[i];
		else return null;
	}
	
	/**
	 * Redefinimos el toString de ByteCodeProgram para que sea capaz de mostrarnos el estado del programa.
	 */
	public String toString(){
		StringBuilder cadena =  new StringBuilder();
		cadena.append("Programa almacenado:\n");
		for (int i = 0; i < numInst; ++i){
			cadena.append(i);
			cadena.append(": ");
			cadena.append(program[i].toString());
			cadena.append('\n');
		}
		if(numInst == 0) cadena.append("<vacio>\n");
		return cadena.toString();
	}
	
}
