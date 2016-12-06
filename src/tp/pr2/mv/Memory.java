package tp.pr2.mv;


/**
 * Representa la memoria de la m�quina.
 * @authors Pablo Martin Huertas y Jose M� Lopez
 *
 */
public class Memory {
	/**
	 * Tama�o inicial de la memoria.
	 */
	private final int MAX = 100;
	/**
	 * Atributo que contiene los datos almacenados en la memoria. 
	 */
	private Integer[]memory;
	
	/**
	 * Redefinimos el constructor del objeto para que cree un objeto Memory con 
	 * su atributo memoria inicializado a un vector vac�o del tama�o m�ximo indicado.
	 */
	public Memory(){
		this.memory=new Integer[MAX];
	}

	/**
	 * Nos permite cambiar el tama�o de memory
	 * @param n Valor que se tendr� en cuenta a la hora de cambiar el tama�o (ser� el valor 
	 * que hay que pasar si no estamos seguros de que una posici�n se va a salir del rango de la
	 * memoria).
	 */
	public void redimensionar(int n){
		Integer []aux=new Integer[n+1];
		for(int ctrl=0;ctrl<this.memory.length;ctrl++){
			aux[ctrl]=memory[ctrl];
		}
		memory=aux;
		
	}
	
	/**
	 * Nos permite escribir en cierta posici�n de memory.
	 * @param pos La posici�n en la que queremos escribir.
	 * @param valor El entero que queremos escribir en memory.
	 * @return Devuelve falso si la posici�n introducida no es v�lida y cierto en otro caso.
	 */
	public boolean write(int pos, int valor){
		if(pos<0)return false;
		if(pos>=this.memory.length){
			redimensionar(pos);
			}
		memory[pos]=valor;
		return true;
	}
	
	/**
	 * Nos permite acceder al valor almacenado en cierta posici�n de memory.
	 * @param pos La posici�n de memory a la que queremos aceceder.
	 * @return Devuelve el valor almacenado en esa posici�n, y  si no hay nada.
	 */
	public Integer read(int pos){
		if(pos<0)return null;
		if(memory[pos] != null) return memory[pos];
		else return null;
	}
	
	/**
	 * Redefinimos el m�todo toString de Memory, para que nos muestre informaci�n sobre el estado de la memoria.
	 */
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("Memoria: ");
		boolean vacia = true;
		for (int i = 0; i < memory.length; ++i){
			if(memory[i] != null){ 
			cadena.append('[');
			cadena.append(i);
			cadena.append("]:");
			cadena.append(memory[i]);
			cadena.append(' ');
			vacia = false;
			}
		}
		if(vacia) cadena.append("<vacia>");
		
		return cadena.toString();
	}
}
