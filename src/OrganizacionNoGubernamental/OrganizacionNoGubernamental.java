package OrganizacionNoGubernamental;

import Aplicacion.Ubicacion;

public class OrganizacionNoGubernamental {
	private Ubicacion ubicacion;
	private String tipoDeOrganizacion;
	private Integer cantidadDeTrabajadores;
	
	public OrganizacionNoGubernamental(Ubicacion ubicacion, String tipoDeOrganizacion, Integer cantidadDeTrabajadores) {
		this.ubicacion= ubicacion;
		this.tipoDeOrganizacion= tipoDeOrganizacion;
		this.cantidadDeTrabajadores= cantidadDeTrabajadores;
	}
	
	public Ubicacion getUbicacion() {
		return(this.ubicacion);
	}
	
	public String getTipoDeOrganizacion(){
		return(this.tipoDeOrganizacion);
	}
	
	public Integer cantidadDeTrabajadores(){
		return(this.cantidadDeTrabajadores);
	}
}
