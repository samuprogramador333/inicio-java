package com.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginHashMap {
    private static Map<String,String>baseDeDatos=new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 3) {
            try {
                System.out.println("1. Registrarte");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Salir");
                System.out.print("Seleccionar una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        registrarUsuario(scanner);
                        break;
                    case 2:
                        iniciarSesion(scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Error intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        scanner.close();
    }

    private static void registrarUsuario(Scanner scanner) {
        try {
            System.out.print("Ingrese el  nombre deseado de usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la contraseña deseada contraseña: ");
            String contrasena = scanner.nextLine();

            if (baseDeDatos.containsKey(nombre)) {
                System.out.println("El ya es existente. Intente otro nombre.");
            } else {
                baseDeDatos.put(nombre, contrasena);
                System.out.println("Usario registrado exitosamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
        }
    }

    private static void iniciarSesion(Scanner scanner) {
        try {
            System.out.print("Ingrese su usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            if (baseDeDatos.containsKey(nombre) && baseDeDatos.get(nombre).equals(contrasena)) {
                System.out.println("¡Inicio de sesión exitoso!");
            } else {
                System.out.println("Usuario o contraseña son incorrectos.");
            }
        } catch (Exception e) {
            System.out.println("Error durante el inicio de sesión: " + e.getMessage());
        }
    }
}
