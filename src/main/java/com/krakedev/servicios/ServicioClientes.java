package com.krakedev.servicios;

import java.util.ArrayList;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakeDevException;
import com.krakedev.persistencia.ClientesBDD;

@Path("customers")
public class ServicioClientes {
	@Path("m1")
	@GET
	public String saludar() {
		return "Hola mundo REST Wweb Servicies";
	}
	
	@Path("mbuscar")
	@GET // se utiliza para las solicitudes de lectura
	@Produces(MediaType.APPLICATION_JSON) //sirve para transforma a formato json, produce datos
	public Cliente buscar(){
		Cliente cliente = new Cliente("1756308010", "Naty",2);
		
		return cliente;
	}
	
	@Path("insertar")
	@POST// para las solicitudes de creación
	@Consumes(MediaType.APPLICATION_JSON)//acepta esto datos
	public Response insertar(Cliente cliente) {//response devolver error
		System.out.println(">>>>>>"+cliente);
		ClientesBDD cli=new ClientesBDD();
		try {
			cli.insertar(cliente);
			return Response.ok().build();
		} catch (KrakeDevException e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("act")
	@PUT //para las solicitudes de actualización.
	@Consumes(MediaType.APPLICATION_JSON)//acepta esto datos
	public Response actualizar(Cliente cliente) {
		System.out.println("ACTUALIZANDO CLIENTE>>>>>>"+cliente);
		ClientesBDD cli=new ClientesBDD();
		try {
			cli.actualizara(cliente);
			return Response.ok().build();
		} catch (KrakeDevException e) {

			e.printStackTrace();
			return Response.serverError().build();
		}
		
		
	}
	
	@Path("all")
	@GET // se utiliza para las solicitudes de lectura
	@Produces(MediaType.APPLICATION_JSON) //sirve para transforma a formato json, produce datos
	
	public Response obtenerClientes(){
		
		ClientesBDD cli=new ClientesBDD();
		ArrayList<Cliente>clientes=null;
		try {
			clientes=cli.recuperarTodos();
			return Response.ok(clientes).build();
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	
	}
	
	@Path("/buscarPorCedula/{cedulaClienteParam}")//buscar por / la  cedula
	@GET // se utiliza para las solicitudes de lectura
	@Produces(MediaType.APPLICATION_JSON) //sirve para transforma a formato json, produce datos
	
	public Response buscarPorCedula(@PathParam("cedulaClienteParam") String cedula){
		
		ClientesBDD cli=new ClientesBDD();
		Cliente cliente=null;
		
		System.out.println("Ingresa>>>>"+cedula);
		try {
			cliente=cli.buscarPorPK(cedula);
			return Response.ok(cliente).build();
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			
			return Response.serverError().build();
		}
	
	}
	
	@Path("buscarNumeroHijos/{numeroHijos}")
	@GET // se utiliza para las solicitudes de lectura
	@Produces(MediaType.APPLICATION_JSON) //sirve para transforma a formato json, produce datos
	
	public Response obtenerNumHijos(@PathParam("numeroHijos") int numHijos){
		
		ClientesBDD cli=new ClientesBDD();
		ArrayList<Cliente>clientes=null;
		try {
			if (numHijos>=0) {
				clientes=cli.recuperarNumHijos(numHijos);
				System.out.println("obtener numero de hijos: "+clientes);
				return Response.ok(clientes).build();
			}
			
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return null;
	
	}
}
