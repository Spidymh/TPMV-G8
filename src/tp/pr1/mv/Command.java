package tp.pr1.mv;


/**
 * Esta clase permite representar los comandos que ejecuta engine.
 * @authors Pablo Mart�n Huertas y Jose M� L�pez
 *
 */
public class Command {
	
	/**
	 * Tipo enumerado que representa uno de los comandos implementados.
	 */
	private ENUM_COMMAND command;
	/**
	 * En caso de que el comando lleve asociado un ByteCode, este atributo ser� el que lo represente.
	 */
	private ByteCode instruccion;
	/**
	 * Es un entero que nos es �til para la ejecuci�n del comando REPLACE. Es Integer para detectar errores.
	 */
	private Integer replace;
	
	/**
	 * Constructor por defecto del objeto.
	 */
	public Command (){}
	/**
	 * Constructor que nos permite crear un objeto de tipo Command con un comando asociado.
	 * @param comando El comando que se le asociar� al objeto creado.
	 */
	public Command (ENUM_COMMAND comando){
		command=comando;
	}
	/**
	 * Constructor que nos permite crear un objeto de tipo Command con un comando y un ByteCode asociado
	 * @param comando El comando que se le asociar� al objeto creado.
	 * @param inst El ByteCode que se le asociar� al objeto creado.
	 */
	public Command (ENUM_COMMAND comando, ByteCode inst){
		command = comando;
		instruccion = inst;
	}
	/**
	 * Constructor que nos permite crear un objeto de tipo Command con un comando y un valor de replace asociados.
	 * @param comando El comando que se le asociar� al objeto creado.
	 * @param n El valor de replace que se le asignar� al obejto creado.
	 */
	public Command (ENUM_COMMAND comando, int n){
		command = comando;
		replace = n;
	}
	
	
	
	
	/**
	 * Nos permite modificar el atributo command del objeto.
	 * @param comando El nuevo valor de command.
	 */
	public void setCommand(ENUM_COMMAND comando){
		command = comando;
	}

	/**
	 * Nos permite modificar el atributo instruccion del objeto.
	 * @param comando El nuevo valor de instruccion.
	 */
	public void setInstruccion(ByteCode inst){
		instruccion = inst;
	}
	
	/**
	 * Nos permite acceder al atributo command del objeto.
	 * @return Devuelve el atributo commmand.
	 */
	public ENUM_COMMAND getCommand(){
		return command;
	}
	
	public Integer getReplace(){
		return replace;
	}
	
	/**
	 * Es el m�todo encargado de la ejecuci�n de los comandos. Adem�s de ir informando del estado de la ejecuci�n.
	 * @param aplicacion Ser� necesario pasarle un objeto de tipo Engine con su lista de ByteCodes.
	 * @return Devolver� cierto si se ha podido finalizar la ejecuci�n del comando y falso en otro caso.
	 */
	public boolean execute(Engine aplicacion){
		switch (this.command){
		case QUIT:
			aplicacion.quit();
			break;
		case HELP:
			aplicacion.help();
			break;
		case NEWINST:
			if(!aplicacion.newinst(this.instruccion)) return false;
			break;
		case RESET:
			aplicacion.reset();
			break;
		case REPLACE:
			if(!aplicacion.replace(this)) return false;
			break;
		case RUN:
			if(!aplicacion.run()) return false;
			break;
		}
		
		
		return true;
	}


}
