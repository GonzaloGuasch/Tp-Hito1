package NivelesDeVerificacion;

import Muestra.Muestra;

public abstract class NivelDeVerificacion {
	public abstract boolean hacerseCargo(Muestra muestra);
	public abstract void cambiarEstado(Muestra muestra);
}
