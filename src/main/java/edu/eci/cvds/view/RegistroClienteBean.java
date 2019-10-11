package edu.eci.cvds.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;

@ManagedBean(name="AlquilerItemsBean")
@SessionScoped
public class RegistroClienteBean extends BasePageBean{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private long documento,documentoA;
	private String telefono;
	private String direccion;
	private String email;
	private List<Cliente> listaClientes;
	private ServiciosAlquiler serviciosAlquiler;

	@PostConstruct
	public void init() {
		actionSetClientes();
	}
	
	
	public void actionBuscarCliente() {
		try {
			serviciosAlquiler.consultarCliente(this.documento);
		} 
		catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actionSetClientes() {
		try {
			setListaClientes(serviciosAlquiler.consultarClientes());
		} 
		catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actionGuardarCliente() {
		try {
			Cliente c=new Cliente(this.nombre,this.documento,this.telefono,this.direccion,this.email);
			this.documentoA=this.documento;
			serviciosAlquiler.registrarCliente(c);
			getListaClientes();
		} catch (ExcepcionServiciosAlquiler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void actionReiniciarValores() {
		this.nombre=null;this.documento=0;this.telefono=null;this.direccion=null;this.email=null;
	}
	
	private void organizarClientes(long documento) {
		actionSetClientes();
		int n=listaClientes.size();
		for(int i=0;i<n;i++) {
			Cliente cl=listaClientes.get(i);
			if(cl.getDocumento()==documento) {
				Cliente aux=listaClientes.get(0);
				listaClientes.set(0, cl);
				listaClientes.set(i, aux);
			}
		}
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setnNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public long getDocumento() {
		return this.documento;
	}

	public void setDocumento(long documento) {
		this.documento=documento;
	}
	
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String tel) {
		this.telefono=telefono;
	}
	
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String dir) {
		this.direccion=direccion;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public List<Cliente> getListaClientes() {
		organizarClientes(this.documentoA);
		actionReiniciarValores();

		return this.listaClientes;
	}
	
	public void setListaClientes(List<Cliente> c) {
		this.listaClientes=c;
	}
	
}