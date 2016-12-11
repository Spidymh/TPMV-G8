package tp.pr2.mv;


/**
 * Esta clase abstracta ser� de la que hereden las clases que representen
 * los distintos comandos.
 * @authors Pablo Mart�n Huertas y Jose M� L�pez
 *
 */
public abstract class Command {


	
	public Command (){}
	/**
	 * Ejecuta el comando.
	 * @param aplicacion El objeto engine en el que se ejecutara el comando.
	 * @return Devuelve cierto si se ejecuta con �xito y falso en otro caso.
	 */
	abstract public boolean execute(Engine aplicacion);
	/**
	 * Nos permite obtener un objeto comando de un String.
	 * @param linea Es un array de Strings que contiene en la posici�n 0 el
	 * codigo del comando y en la segunda el par�metro si deber�a haberlo.
	 * @return Devuelve el comando que se obtiene de linea.
	 */
	abstract public Command Parse(String[]linea);
	/**
	 * Sirve para que cada comando muestre para que sirve.
	 * @return Devuelve para que sirve el comando en cuestion.
	 */
	abstract public String textHelp();



}
