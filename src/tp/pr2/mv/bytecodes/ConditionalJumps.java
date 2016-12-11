package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

/**
 * Clase que representa los distintos Bytecodes que sirven para
 * hacer saltos condicionales. 
 * @author Pablo Mart�n Huertas y Jose M� L�pez.
 *
 */
public abstract class ConditionalJumps extends ByteCode{
	/**
	 * En caso de no cumplirse la condici�n la posici�n del programa 
	 * a la que se deber� saltar.
	 */
	protected int salto;
	
	/**
	 * Constructor por defector.
	 */
	public ConditionalJumps(){};
	/**
	 * Constructor que inicializa el valor de salto a num.
	 * @param num El valor de salto.
	 */
	public ConditionalJumps(int num){
		salto = num;
	}
	
	/**
	 * 
	 * @param op1
	 * @param op2
	 * @return
	 */
	
	/**
	 * Compara los distintos operandos.
	 * @param op1 Operando1
	 * @param op2 Operando2
	 * @return Devulve true si se cumple la condici�n o
	 * false en otro caso.
	 */
	abstract public boolean execute(int op1, int op2);
	
	/**
	 * Realiza las operaciones con la pila que tienen en com�n todas
	 * las instrucciones de salto condicional.
	 */
	public boolean execute(CPU cpu){
		int op1 = 0; int op2 = 0; Integer aux = null;
		aux= cpu.pop_back();
		if(aux==null)return false;
		op2 = aux;
		aux = cpu.pop_back();
		if(aux==null)return false;
		op1 = aux;
		if (execute(op1, op2)) {
			cpu.sigPC();
			return true;
		}
		else return cpu.SaltoPC(this.salto);
	}
	
	/**
	 * 
	 * @param word 
	 * @param salto
	 * @return Entero que indica la posici�n a la que se saltar�.
	 */
	abstract public ByteCode parseAux(String word, int salto);

	/**
	 * Parsea un array de Strings para obtener un Objeto Bytecode.
	 * words El array de String a parsear.
	 */
	@Override
	public ByteCode parse(String[] words) {
		if(words.length !=2) return null;
		else return this.parseAux(words[0], Integer.parseInt(words[1]));
		
	}

}
