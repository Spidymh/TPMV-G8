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
	public CPU(){
		halt=false;
		pilaop=new OperandStack();
		memoria=new Memory();
	}
	
	/**
	 * Permite la extraccion de halt para saber cuando parar la maquina.
	 */
	
	public boolean getHalt(){
		return halt;
	}
	
	/**
	 * Este m�todo nos permite ejecutar instrucciones de tipo ByteCode.
	 * @param instr El ByteCode que se ejecutar�.
	 * @return Devolver� cierto si se se ha podido ejecutar la instrucci�n y falso en otro caso.
	 */
	public boolean execute(ByteCode instr){
		switch(instr.getOp()){
		case PUSH:{ 
			if(!this.pilaop.push_back(instr.getPar()))return false;
			break;
		}
		case STORE: {
			if(pilaop.getNumInt()==0)return false;
			memoria.write(instr.getPar(), pilaop.pop_back());
			break;
		}
		case LOAD:{
			if(memoria.read(instr.getPar())==null)return false;
			pilaop.push_back(memoria.read(instr.getPar()));
			break;
		}
		case ADD:{
			if(pilaop.getNumInt()<2)return false;
			int sol=0;
			sol+=pilaop.pop_back();
			sol+=pilaop.pop_back();
			pilaop.push_back(sol);
			
			break;
		}
		case SUB:{
			if(pilaop.getNumInt()<2)return false;
			int sol=0;
			sol-=pilaop.pop_back();
			sol+=pilaop.pop_back();
			pilaop.push_back(sol);
			break;
		}
		case MUL:{
			if(pilaop.getNumInt()<2)return false;
			int sol=0;
			sol=pilaop.pop_back();
			sol*=pilaop.pop_back();
			pilaop.push_back(sol);
			break;
		}
		case DIV:{
			if(pilaop.getNumInt()<2)return false;
			int sol=0;
			int aux=pilaop.pop_back();
			if(aux==0)return false;
			sol=(pilaop.pop_back()/aux);
			pilaop.push_back(sol);
			break;
		}
		case OUT:{
			System.out.println(pilaop.getValor());
			break;
		}
		case HALT:{
			halt=true;
			break;
		}
		}
	
	
		return true;
	}
	
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
