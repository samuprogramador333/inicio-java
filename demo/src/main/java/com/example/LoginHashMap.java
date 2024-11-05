package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginHashMap {
    private static Map<String, String> baseDeDatos = new HashMap<>();
    private static Map<String, Map<String, Map<String, String>>> horarios = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 4) {
            try {
                System.out.println("1. Registrarte");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Registrar horarios");
                System.out.println("4. Salir");
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
                        registrarHorario(scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Error, intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        scanner.close();
    }

    private static void registrarUsuario(Scanner scanner) {
        try {
            System.out.print("Ingrese el nombre que quiere de usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la contraseña que quiere: ");
            String contrasena = scanner.nextLine();

            if (baseDeDatos.containsKey(nombre)) {
                System.out.println("Usuario existente. Intente otro nombre.");
            } else {
                baseDeDatos.put(nombre, contrasena);
                horarios.put(nombre, new HashMap<>()); // Inicializar un nuevo mapa para horarios
                System.out.println("Usuario registrado exitosamente.");
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
                System.out.println("Inicio de sesión exitoso");
            } else {
                System.out.println("El Usuario o la contraseña son incorrectos.");
            }
        } catch (Exception e) {
            System.out.println("Error durante el inicio de sesión: " + e.getMessage());
        }
    }

    private static void registrarHorario(Scanner scanner) {
        try {
            System.out.print("Ingrese su usuario: ");
            String nombre = scanner.nextLine();

            if (!baseDeDatos.containsKey(nombre)) {
                System.out.println("Usuario no encontrado. Iniciar sesión primero.");
                return;
            }

            System.out.print("Ingrese la etiqueta del horario: ");
            String etiqueta = scanner.nextLine();
            System.out.print("Ingrese la fecha (formato AÑO-MES-DIA): ");
            String fecha = scanner.nextLine();
            System.out.print("Ingrese el día de la semana: ");
            String dia = scanner.nextLine();
            System.out.print("Ingrese el horario (formato HH:mm): ");
            String horario = scanner.nextLine();

            Map<String, String> detalleHorario = new HashMap<>();
            detalleHorario.put("Fecha", fecha);
            detalleHorario.put("Dia", dia);
            detalleHorario.put("Hora", horario);

            horarios.get(nombre).put(etiqueta, detalleHorario);
            System.out.println("Horario registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar el horario: " + e.getMessage());
        }
    }
}
