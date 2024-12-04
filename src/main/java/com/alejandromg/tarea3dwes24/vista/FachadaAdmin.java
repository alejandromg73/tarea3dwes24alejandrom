package com.alejandromg.tarea3dwes24.vista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.alejandromg.tarea3dwes24.modelo.Credenciales;
import com.alejandromg.tarea3dwes24.modelo.Ejemplar;
import com.alejandromg.tarea3dwes24.modelo.Mensaje;
import com.alejandromg.tarea3dwes24.modelo.Persona;
import com.alejandromg.tarea3dwes24.modelo.Planta;
import com.alejandromg.tarea3dwes24.servicios.Controlador;
import com.alejandromg.tarea3dwes24.servicios.ServiciosCredenciales;
import com.alejandromg.tarea3dwes24.servicios.ServiciosEjemplar;
import com.alejandromg.tarea3dwes24.servicios.ServiciosMensaje;
import com.alejandromg.tarea3dwes24.servicios.ServiciosPersona;
import com.alejandromg.tarea3dwes24.servicios.ServiciosPlanta;

@Component
public class FachadaAdmin {

    @Autowired
    private ServiciosPlanta servPlanta;

    @Autowired
    private ServiciosEjemplar servEjemplar;

    @Autowired
    private ServiciosMensaje servMensaje;

    @Autowired
    private ServiciosPersona servPersona;

    @Autowired
    private ServiciosCredenciales servCredenciales;

    @Autowired
    @Lazy
    private Controlador controlador;

    @Autowired
    @Lazy
    private FachadaInvitado fachadaInvitado;

    @Autowired
    @Lazy
    private FachadaPersonal fachadaPersonal;

    private Scanner in = new Scanner(System.in);

    public void menuAdmin() {
        int opcion = 0;
        do {
            System.out.println("------MENÚ DE ADMINISTRADOR------");
            System.out.println("───────────────────────────────");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Gestión de plantas");
            System.out.println("2. Gestión de ejemplares");
            System.out.println("3. Gestión de mensajes");
            System.out.println("4. Gestión de personas");
            System.out.println("5. CERRAR SESIÓN.");
            System.out.println("───────────────────────────────");
            try {
                opcion = in.nextInt();
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Opción incorrecta");
                    continue;
                }
                switch (opcion) {
                    case 1:
                        menuAdminPlantas();
                        break;
                    case 2:
                        menuAdminEjemplares();
                        break;
                    case 3:
                        menuAdminMensajes();
                        break;
                    case 4:
                        menuAdminPersonas();
                        break;
                    case 5:
                        controlador.cerrarSesion();
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                in.nextLine();
                opcion = 0;
            }
        } while (opcion != 5);
    }

    public void menuAdminPlantas() {
        int opcion = 0;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("  ───────────────────────────────");
            System.out.println("1. Ver plantas");
            System.out.println("2. Crear nueva planta");
            System.out.println("3. Modificar datos de una planta");
            System.out.println("4. Volver al menú principal");
            System.out.println("  ───────────────────────────────");
            try {
                opcion = in.nextInt();
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción incorrecta");
                    continue;
                }
                switch (opcion) {
                    case 1:
                        fachadaInvitado.verTodasPlantas();
                        break;
                    case 2:
                        nuevaPlanta();
                        break;
                    case 3:
                        menuAdminModificarPlantas();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un númer.");
                in.nextLine();
                opcion = 0;
            }
        } while (opcion != 4);
    }

    public void menuAdminModificarPlantas() {
        int opcion = 0;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("  ───────────────────────────────");
            System.out.println("1. Modificar nombre común");
            System.out.println("2. Modificar nombre científico");
            System.out.println("3. Volver al menú de plantas");
            System.out.println("  ───────────────────────────────");
            try {
                opcion = in.nextInt();
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Opción incorrecta");
                    continue;
                }
                switch (opcion) {
                    case 1:
                        modificarNombreComun();
                        break;
                    case 2:
                        modificarNombreCientifico();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                in.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);
    }

    public void menuAdminEjemplares() {
        int opcion = 0;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("  ───────────────────────────────");
            System.out.println("1. Registrar nuevo ejemplar");
            System.out.println("2. Filtrar ejemplares por tipo de planta");
            System.out.println("3. Ver mensajes de un ejemplar");
            System.out.println("4. Volver al menú principal");
            System.out.println("  ───────────────────────────────");
            try {
                opcion = in.nextInt();
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción incorrecta");
                    continue;
                }
                switch (opcion) {
                    case 1:
                        nuevoEjemplar();
                        break;
                    case 2:
                        fachadaPersonal.filtrarEjemplaresPorCodigoPlanta();
                        break;
                    case 3:
                        verMensajesEjemplar();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                in.nextLine();
                opcion = 0;
            }
        } while (opcion != 4);
    }
    public void menuAdminPersonas() {
		int opcion = 0;
		do {
			System.out.println("Selecciona una opción:");
			System.out.println("  ───────────────────────────────");
			System.out.println("1. Registrar nueva persona");
			System.out.println("2. Ver todas las personas");
			System.out.println("3. Volver al menú principal");
			System.out.println("  ───────────────────────────────");
			try {
				opcion = in.nextInt();
				if (opcion < 1 || opcion > 3) {
					System.out.println("Opción incorrecta");
					continue;
				}
				switch (opcion) {
				case 1:
					nuevaPersona();
					break;
				case 2:
					verTodasPersonas();
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un número");
				in.nextLine();
				opcion = 0;
			}
		} while (opcion != 3);
	}

    public void menuAdminMensajes() {
        int opcion = 0;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("  ───────────────────────────────");
            System.out.println("1. Nuevo mensaje");
            System.out.println("2. Ver mensajes");
            System.out.println("3. Volver al menú principal");
            System.out.println("  ───────────────────────────────");
            try {
                opcion = in.nextInt();
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Opción incorrecta");
                    continue;
                }
                switch (opcion) {
                    case 1:
                        fachadaPersonal.nuevoMensaje();
                        break;
                    case 2:
                        menuAdminVerMensajes();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                in.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);
    }

    public void menuAdminVerMensajes() {
        int opcion = 0;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("  ───────────────────────────────");
            System.out.println("1. Ver todos los mensajes");
            System.out.println("2. Ver mensajes por persona");
            System.out.println("3. Ver mensajes por rango de fechas");
            System.out.println("4. Ver mensajes por tipo de planta");
            System.out.println("5. Volver al menú de mensajes");
            System.out.println("  ───────────────────────────────");
            try {
                opcion = in.nextInt();
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Opción incorrecta");
                    continue;
                }
                switch (opcion) {
                    case 1:
                        verTodosMensajes();
                        break;
                    case 2:
                        fachadaPersonal.verMensajesPersona();
                        break;
                    case 3:
                        fachadaPersonal.verMensajeFechas();
                        break;
                    case 4:
                        fachadaPersonal.verMensajeTipoPlanta();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                in.nextLine();
                opcion = 0;
            }
        } while (opcion != 5);
    }


    /**
	 * Método para crear una nueva planta, con sus validaciones y controlando las
	 * excepciones que pueden surgir
	 * 
	 */
	public Planta nuevaPlanta() {
		in.nextLine();
		Planta p;
		boolean datosPlantaCorrectos = false;
		do {
			p = new Planta();
			System.out.print("Código: ");
			try {
				String codigo = in.nextLine().trim().toUpperCase();
				boolean correcto = servPlanta.validarCodigo(codigo);
				boolean existe = servPlanta.codigoExistente(codigo);
				if (!correcto) {
					System.out.println("El formato del código no es correcto");
					continue;
				}
				if (existe) {
					System.out.println("El código ya existe para una planta");
					continue;
				}
				p.setCodigo(codigo);
				System.out.print("Nombre común: ");
				String nombreComun = in.nextLine().trim();
				p.setNombreComun(nombreComun);
				System.out.print("Nombre científico: ");
				String nombreCientifico = in.nextLine().trim();
				p.setNombreCientifico(nombreCientifico);
				datosPlantaCorrectos = servPlanta.validarPlanta(p);
				if (!datosPlantaCorrectos) {
					System.out.println("Los datos que has introducido no son correctos");
				}
			} catch (Exception ex) {
				System.out.println("Error durante la entrada de datos: " + ex.getMessage());
				datosPlantaCorrectos = false;
			}
		} while (!datosPlantaCorrectos);
		try {
	        servPlanta.insertar(p);
	        System.out.println("Planta insertada");
	    } catch (Exception ex) {
	        System.out.println("Error al insertar la planta: " + ex.getMessage());
	    }

		return p;
	}

	public Ejemplar nuevoEjemplar() {
	    in.nextLine();
	    Ejemplar e = null;
	    Mensaje m = null;
	    boolean correcto = false;
	    do {
	        try {
	            System.out.print("Código de la planta del ejemplar: ");
	            String codigoPlanta = in.nextLine().trim().toUpperCase();
	            boolean codigoValido = servPlanta.validarCodigo(codigoPlanta);
	            boolean plantaExiste = servPlanta.codigoExistente(codigoPlanta);
	            if (!codigoValido) {
	                System.out.println("El formato del código no es correcto");
	                continue;
	            }
	            if (!plantaExiste) {
	                System.out.println("No existe una planta con ese codigo");
	                continue;
	            }
	            Planta p = servPlanta.buscarPorCodigo(codigoPlanta);
	            e = new Ejemplar();
	            e.setPlanta(p);
	            e.setNombre(codigoPlanta);
	            servEjemplar.insertar(e);
	            e.setNombre(e.getPlanta().getCodigo() + "_" + e.getId());
	            servEjemplar.cambiarNombre(e.getId(), e.getNombre());
	            System.out.println("Ejemplar insertado con ID: " + e.getId());
	            String mensajeTexto = "Añadido el ejemplar " + e.getNombre();
	            LocalDateTime fechaHora = LocalDateTime.now();
	            String usuarioAutenticado = controlador.getUsuarioAutenticado();
	            Persona persona = servPersona.buscarPorNombre(usuarioAutenticado);
	            if (persona == null) {
	                System.out.println("Error: No se ha encontrado la persona autenticada");
	            } else {
	                m = new Mensaje(fechaHora, mensajeTexto, persona, e);
	                servMensaje.insertar(m);
	                System.out.println("Mensaje de creación del ejemplar añadido");
	            }
	            correcto = true;
	        } catch (Exception ex) {
	            System.out.println("Error durante la creación del ejemplar: " + ex.getMessage());
	            correcto = false;
	        }
	    } while (!correcto);
	    return e;
	}


	/**
	 * Método para crear una nueva planta, con sus validaciones y controlando las
	 * excepciones que pueden surgir
	 * 
	 */
	public Persona nuevaPersona() {
		in.nextLine();
		Persona pers;
		Credenciales c;
		boolean correcto = false;
		boolean emailValido = false;
		boolean usuarioValido = false;
		boolean contraseñaValida = false;
		String usuario = "";
		String contraseña = "";
		do {
			emailValido = false;
			usuarioValido = false;
			contraseñaValida = false;
			pers = new Persona();
			c = new Credenciales();
			System.out.print("Nombre: ");
			String nombre = in.nextLine().trim();
			pers.setNombre(nombre);
			String email = "";
			do {
				System.out.print("Email: ");
				email = in.nextLine().trim();
				pers.setEmail(email);
				if (servPersona.emailExistente(email)) {
					System.out.println("El email que has introducido ya está registrado");
				} else {
					emailValido = true;
				}
			} while (!emailValido);
			do {
				System.out.print("Usuario: ");
				usuario = in.nextLine().trim();
				if (usuario.equalsIgnoreCase("ADMIN")) {
					System.out.println("El usuario 'admin' ya está ocupado.");
				} else if (servCredenciales.usuarioExistente(usuario) || usuario.length() < 3) {
					System.out.println(
							"El usuario que has introducido ya está registrado o no cumple con los requisitos mínimos");
				} else {
					usuarioValido = true;
					c.setUsuario(usuario);
				}
			} while (!usuarioValido);
			do {
				System.out.print("Contraseña: ");
				contraseña = in.nextLine().trim();
				// Una pequeña medida de seguridad para las credenciales que he decidido
				// introducir
				if (servCredenciales.validarContraseña(contraseña) == false) {
					System.out.println(
							"La contraseña debe tener al menos 8 caracteres e incluir al menos un carácter especial como un punto o una coma");
				} else {
					contraseñaValida = true;
					c.setPassword(contraseña);
				}
			} while (!contraseñaValida);
			correcto = servPersona.validarPersona(pers);
			if (!correcto) {
				System.out.println("Los datos que has introducido no son correctos.");
			}
		} while (!correcto);
		try {
			servPersona.insertar(pers);
			System.out.println("Persona insertada");
		} catch (Exception ex) {
			System.out.println("Error al insertar la persona nueva: " + ex.getMessage());
		}
		return pers;
	}

	public void verTodasPersonas() {
		ArrayList<Persona> personas = (ArrayList<Persona>) servPersona.verTodos();
		if (personas == null || personas.isEmpty()) {
			System.out.println("Lo siento, no hay personas para mostrar en la base de datos");
			return;
		}
		System.out.println("Todo el personal: ");
		System.out.println();
		for (Persona pers : personas) {
			System.out.println(pers);
			System.out.println();
		}
	}

	public void verTodosMensajes() {
		ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) servMensaje.verTodos();
		if (mensajes == null || mensajes.isEmpty()) {
			System.out.println("Lo siento, no hay mensajes para mostrar en la base de datos");
			return;
		}
		System.out.println("Todos los mensajes: ");
		System.out.println();
		for (Mensaje m : mensajes) {
			System.out.println(m);
			System.out.println();
		}
	}

	public void modificarNombreComun() {
	    in.nextLine();
	    String codigo = "";
	    boolean valido = false;
	    do {
	        System.out.print("Introduce el código de la planta de la que quieres modificar el nombre común: ");
	        codigo = in.nextLine().trim().toUpperCase();
	        valido = servPlanta.validarCodigo(codigo);
	        if (!valido) {
	            System.out.println("El código de la planta que has introducido no es válido");
	        }
	    } while (!valido);
	    boolean existe = servPlanta.codigoExistente(codigo);
	    if (!existe) {
	        System.out.println("El código de la planta que has introducido no existe en la base de datos");
	        return;
	    }
	    System.out.print("Introduce el nuevo nombre común de la planta: ");
	    String nuevoNombreComun = in.nextLine().trim().toUpperCase();
	    try {
	        boolean actualizado = servPlanta.actualizarNombreComun(codigo, nuevoNombreComun);
	        if (actualizado) {
	            System.out.println("El nombre común de la planta con código " + codigo
	                    + " ha sido actualizado, ahora el nombre es: " + nuevoNombreComun);
	        } else {
	            System.out.println("Error al intentar actualizar el nombre común");
	        }
	    } catch (Exception ex) {
	        System.out.println("Error al actualizar el nombre común: " + ex.getMessage());
	    }
	}


	public void modificarNombreCientifico() {
	    in.nextLine();
	    String codigo = "";
	    boolean valido = false;
	    do {
	        System.out.print("Introduce el código de la planta de la que quieres modificar el nombre científico: ");
	        codigo = in.nextLine().trim().toUpperCase();
	        valido = servPlanta.validarCodigo(codigo);
	        if (!valido) {
	            System.out.println("El código de la planta que has introducido no es válido");
	        }
	    } while (!valido);
	    boolean existe = servPlanta.codigoExistente(codigo);
	    if (!existe) {
	        System.out.println("El código de la planta que has introducido no existe en la base de datos");
	        return; 
	    }
	    System.out.print("Introduce el nuevo nombre científico de la planta: ");
	    String nuevoNombreCientifico = in.nextLine().trim();
	    try {
	        boolean actualizado = servPlanta.actualizarNombreCientifico(codigo, nuevoNombreCientifico);
	        if (actualizado) {
	            System.out.println("El nombre científico de la planta con código " + codigo
	                    + " ha sido actualizado, ahora el nombre es: " + nuevoNombreCientifico);
	        } else {
	            System.out.println("Error al intentar actualizar el nombre científico");
	        }
	    } catch (Exception ex) {
	        System.out.println("Error al actualizar el nombre científico: " + ex.getMessage());
	    }
	}


	public void verMensajesEjemplar() {
		System.out.print("Introduce el id de un ejemplar para ver sus mensajes: ");
		try {
			long idEjemplar = in.nextLong();
			if (idEjemplar < 1 || idEjemplar > servEjemplar.contarEjemplares()) {
				System.out.println("Debes introducir un número entre el 1 y "
						+ servEjemplar.contarEjemplares());
				return;
			}
			ArrayList<Mensaje> mensajes = servMensaje.verMensajesPorEjemplar(idEjemplar);
			if (mensajes.isEmpty()) {
				System.out.println("No se encontraron mensajes para el ejemplar");
			} else {
				System.out.println("Mensajes del ejemplar con ID: " + idEjemplar + ":");
				System.out.println();
				for (Mensaje m : mensajes) {
					System.out.println(m);
					System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println("Error al intentar obtener los mensajes del ejemplar: " + e.getMessage());
		}
	}
}