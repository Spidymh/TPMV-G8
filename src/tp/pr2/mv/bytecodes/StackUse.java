package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;
/**
 * Clase que representa las operaciones que manipulan la pila.
 * @author Pablo Mart�n Huertas y Jose M� L�pez.
 *
 */
public abstract class StackUse extends ByteCode{
	/**
	 * El parametro que manipula el ByteCode
	 */
	protected int parametro;
	/**
	 * Constructor por defecto.
	 */
	public StackUse(){	}
	/**
	 * Constructor que adem�s inicializa el atributo parametro a par.
	 * @param par
	 */
	public StackUse(int par){
		this.parametro=par;
	}
	
	/**
	 * Ejecuta el Bytecode concreto.
	 * @cpu El objeto CPU en el que se ejecutar� el Bytecode.
	 */
	abstract public boolean execute(CPU cpu);
	
	/**
	 * Nos permite obtener un ByteCode a partir de un c�digo
	 * y del par�metro.
	 * @param word El c�digo del Bytecode
	 * @param par El valor del par�metro.
	 * @return
	 */
	abstract public ByteCode parseAux(String word, int par);
	@Override
	/**
	 * Obtiene un objeto Bytecode a partir de un array de Strings.
	 * @words El array de Strings que se va a parsear.
	 */
	public ByteCode parse(String[] words) {
		if(words.length!=2)return null;
		else return this.parseAux(words[0], Integer.parseInt(words[1]));
	}

}
