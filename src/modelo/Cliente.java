package modelo;

import java.awt.Toolkit;

public class Cliente {

	private String RespuestaDNI;
	private String RespuestaNombre;
	private String RespuestaApellido;
	private String RespuestaSexo;
	private String RespuestaContrasena;
	
	public Cliente(String dni, String nombre, String apellido, String sexo, String contrasena) {
		this.RespuestaDNI = dni;
		this.RespuestaNombre = nombre;
		this.RespuestaApellido = apellido;
		this.RespuestaSexo = sexo;
		this.RespuestaContrasena = contrasena;
	}

	public Cliente() {
		
	}

	public String getDni() {
		return RespuestaDNI;
	}

	public void setDni(String dni) {
		this.RespuestaDNI = dni;
	}

	public String getNombre() {
		return RespuestaNombre;
	}

	public void setNombre(String nombre) {
		this.RespuestaNombre = nombre;
	}

	public String getApellido() {
		return RespuestaApellido;
	}

	public void setApellido(String apellido) {
		this.RespuestaApellido = apellido;
	}

	public String getSexo() {
		return RespuestaSexo;
	}

	public void setSexo(String String) {
		this.RespuestaSexo = String;
	}

	public String getContraseña() {
		return RespuestaContrasena;
	}

	public void setContrasena(String contrasena) {
		this.RespuestaContrasena = contrasena;
	}

	public void setRespuestaSexo(Toolkit toolkit) {
		this.RespuestaSexo = RespuestaSexo;
		
	}

	public String getRespuestaDNI() {
		return RespuestaDNI;
	}

	public void setRespuestaDNI(String respuestaDNI) {
		RespuestaDNI = respuestaDNI;
	}

	public String getRespuestaNombre() {
		return RespuestaNombre;
	}

	public void setRespuestaNombre(String respuestaNombre) {
		RespuestaNombre = respuestaNombre;
	}

	public String getRespuestaApellido() {
		return RespuestaApellido;
	}

	public void setRespuestaApellido(String respuestaApellido) {
		RespuestaApellido = respuestaApellido;
	}

	public String getRespuestaSexo() {
		return RespuestaSexo;
	}

	public void setRespuestaSexo(String respuestaSexo) {
		RespuestaSexo = respuestaSexo;
	}

	public String getRespuestaContrasena() {
		return RespuestaContrasena;
	}

	public void setRespuestaContrasena(String respuestaContrasena) {
		RespuestaContrasena = respuestaContrasena;
	}

	
	

	
	
	//*****************************************************************//
	
	
	
	
	
	
}
