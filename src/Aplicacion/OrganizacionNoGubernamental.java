package Aplicacion;

public class OrganizacionNoGubernamental {
	private Ubicacion ubicacion;
	private String tipoDeOrganizacion;
	private Integer cantidadDeTrabajadores;
	//constructor
	public OrganizacionNoGubernamental(Ubicacion ubicacion, String tipoDeOrganizacion, Integer cantidadDeTrabajadores) {
		this.ubicacion= ubicacion;
		this.tipoDeOrganizacion= tipoDeOrganizacion;
		this.cantidadDeTrabajadores= cantidadDeTrabajadores;
	}
	//Geters
	public Ubicacion getUbicacion() {
		return(this.ubicacion);
	}
	
	public String getTipoDeOrganizacion(){
		return(this.tipoDeOrganizacion);
	}
	
	public Integer getcantidadDeTrabajadores(){
		return cantidadDeTrabajadores;
	}
}
