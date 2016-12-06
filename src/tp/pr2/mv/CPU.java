package tp.pr2.mv;

import tp.pr2.mv.bytecodes.ByteCode;


/**
 * Representa la unidad de procesamiento de la m�quina virtual.
 * @authors Pablo Martin Huertas y Jose M� Lopez
 *
 */
public class CPU {
	ByteCodeProgram programa;
	private int PC;
	/**
	 * boolean que indica si indica si se ha ejecutado la instrucci�n HALT.
	 */
	private boolean halt;
	/**
	 * Representa la pila de operandos(una pila de enteros).
	 */
	private OperandStack pilaop;
	/**
	 * Representa la memoria de la m�quina virtual.
	 */
	private Memory memoria;
	
	/**
	 * Constructor que nos permite crear un objeto de tipo CPU, inicializando halt a false e invocando
	 * a los constructores de las clases OperandStack y Memory.
	 */
	public CPU(ByteCodeProgram program){
		halt=false;
		pilaop=new OperandStack();
		memoria=new Memory();
		programa=program;
	}
	
	/**
	 * Permite la extraccion de halt para saber cuando parar la maquina.
	 */
	
	public boolean getHalt(){
		return halt;
	}
	
	public boolean exeload(int par){
		if(this.memoria.read(par)==null)this.memoria.write(par, 0);
		this.pilaop.push_back(this.memoria.read(par));
		return true;
	}
	public boolean exepush(int par){
		return this.pilaop.push_back(par);
	}
	public boolean exestore(int par){
		this.memoria.write(par, this.pilaop.pop_back());
		return true;
	}
	
	public boolean run(){
		for(int ctrl=0;ctrl<this.programa.getnumInst();ctrl++){
			if(!this.programa.getInstr(ctrl).execute(this))return false;
		}
		return true;
	}
	
	public int pop_back(){
		return pilaop.pop_back();
	}
	
	public boolean push_back(int num){
		return pilaop.push_back(num);
	}
	
	public boolean SaltoPC(int num){
		if (num <0) return false;
		else PC = num;
		return true;
	}
	
	/**
	 * Este m�todo nos permite ejecutar instrucciones de tipo ByteCode.
	 * @param instr El ByteCode que se ejecutar�.
	 * @return Devolver� cierto si se se ha podido ejecutar la instrucci�n y falso en otro caso.
	 */
	
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("Estado de la CPU:\n  ");
		cadena.append(memoria.toString());
		cadena.append("\n  ");
		cadena.append(pilaop.toString());
		cadena.append('\n');
		return cadena.toString();
	}
	
	
}
