package com.francoarmando.AppHotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class AppHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppHotelApplication.class, args);

		Connection connection = null;
		try {
			// Paso 1: Cargar el driver JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Paso 2: Establecer la conexión con la base de datos
			String url = "jdbc:mysql://localhost:3306/RegistroHotel";
			String usuario = "root";
			String contraseña = "root";
			connection = DriverManager.getConnection(url, usuario, contraseña);

			System.out.println("Conexión exitosa a la base de datos MySQL");


		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Paso 3: Cerrar la conexión
			try {
				if (connection != null) {
					connection.close();
					System.out.println("Conexión cerrada correctamente");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

