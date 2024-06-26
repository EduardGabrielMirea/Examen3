package examen3.controller;

import examen3.entity.Cliente;
import examen3.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ClienteController {


    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public void crearCliente() {
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente:");
        cliente.setNombre(scanner.nextLine());
        clienteRepository.save(cliente);
        System.out.println("Cliente creado exitosamente.");
    }

    public void modificarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del cliente que desea modificar:");
        long id = Long.parseLong(scanner.nextLine());
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            System.out.println("Ingrese el nuevo nombre del cliente:");
            cliente.setNombre(scanner.nextLine());
            clienteRepository.save(cliente);
            System.out.println("Cliente modificado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void borrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del cliente que desea borrar:");
        long id = Long.parseLong(scanner.nextLine());
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            clienteRepository.delete(cliente);
            System.out.println("Cliente borrado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void listarClientes() {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre());
            }
        }
    }

}
