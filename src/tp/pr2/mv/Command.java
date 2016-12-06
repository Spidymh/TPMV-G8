package tp.pr2.mv;


/**
 * Esta clase permite representar los comandos que ejecuta engine.
 * @authors Pablo Mart�n Huertas y Jose M� L�pez
 *
 */
public abstract class Command {



	public Command (){}
	
	abstract public boolean execute(Engine aplicacion);
	abstract public Command Parse(String[]linea);
	abstract public String textHelp();



}
