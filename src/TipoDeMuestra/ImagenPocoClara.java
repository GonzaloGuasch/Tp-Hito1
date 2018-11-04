package TipoDeMuestra;
import java.util.List;
import Muestra.Verificacion;

public class ImagenPocoClara extends TipoDeMuestra {
	
	@Override
	public boolean hacerseCargo(List<Verificacion> verificaciones) {
	
		return this.todosVerificanron("ImagenPocoClara", verificaciones) || (
				   this.usuarioDeMayorNivelObservo("ImagenPocoClara", verificaciones) &&
				   this.noHayDosUsuariosDeAltoNivelQueDiscrepan("ImagenPocoClara" , verificaciones));
	}
	@Override
	public String decirTipo() {
		return "ImagenPocoClara";
	}
}
