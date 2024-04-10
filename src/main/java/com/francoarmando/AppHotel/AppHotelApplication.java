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
			//Carga el driver JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Establecer la conexión con la base de datos
			String url = "jdbc:mysql://localhost:3306/RegistroHotel";
			String usuario = "root";
			String contrasena = "root";
			connection = DriverManager.getConnection(url, usuario, contrasena);

			System.out.println("Conexión exitosa a la base de datos MySQL");


		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//Cerrar la conexión
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

