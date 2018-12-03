package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Actor;
import es.salesianos.model.Peliculas;



public class Repository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Actor search(Actor actorFormulario) {
		Actor actorInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OWNER WHERE codOwner = ?");
			prepareStatement.setInt(1, actorFormulario.getCodActor());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				actorInDatabase = new Actor();
				actorInDatabase.setCodActor(resultSet.getInt(1));
				actorInDatabase.setName(resultSet.getString(2));
				actorInDatabase.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
			
		}
		manager.close(conn);
		return actorInDatabase;
	}

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void insert(Actor actorFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ACTOR (name,surname)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, actorFormulario.getName());
			preparedStatement.setString(2, actorFormulario.getSurname());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}
		
		
		manager.close(conn);
	}

	public void update(Actor ownerFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE OWNER SET name = ?,surname = ? WHERE codOwner = ?");
			preparedStatement.setString(1, ownerFormulario.getName());
			preparedStatement.setString(2, ownerFormulario.getSurname());
			preparedStatement.setInt(3, ownerFormulario.getCodActor());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void delete(Integer codActor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			
			preparedStatement = deletePetsFor(codActor, conn);
			
			preparedStatement = deleteActor(codActor, conn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	private PreparedStatement deleteActor(Integer codActor, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM ACTOR WHERE codActor = ?");
		preparedStatement.setInt(1, codActor);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement deletePetsFor(Integer codOwner, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM PET WHERE codOwner = ?");
		preparedStatement.setInt(1, codOwner);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	public List<Actor> searchAll() {
		List<Actor> listOwners = new ArrayList<Actor>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			/*
			prepareStatement = conn.prepareStatement("
			SELECT * FROM OWNER o, PET p INNER JOIN WHERE o.codOwner = p.codOwner");
			while (resultSet.next()) {
				Owner ownerInDatabase = new Owner();
				ownerInDatabase.setCodOwner(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
				Pet pet = new Pet();
				pet.setName(resultSet.getString(4)) 
				pet.setCodOwner(resultSet.getString(5)) 
				ownerInDatabase.getMascotas().add(pet)
				listOwners.add(ownerInDatabase);
			}
			 */
			
			prepareStatement = conn.prepareStatement("SELECT * FROM OWNER");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Actor ownerInDatabase = new Actor();
				
				ownerInDatabase.setCodActor(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2)); 
				ownerInDatabase.setSurname(resultSet.getString(3));
				
				listOwners.add(ownerInDatabase);
			}

			for (Actor owner : listOwners) {
				
				prepareStatement = conn.prepareStatement(
						"SELECT * FROM PET where codOwner="+owner.getCodActor());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Peliculas pet = new Peliculas();
					pet.setName(resultSet.getString(1));
					pet.setCodOwner(resultSet.getInt(2));
					owner.getMascotas().add(pet);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listOwners;
	}
	
	public Actor searchByCodOwner(Integer codActor) {
		Actor ownerInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ACTOR WHERE codOwner = ?");
			prepareStatement.setInt(1, codActor);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				ownerInDatabase = new Actor();
				ownerInDatabase.setCodActor(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
				ownerInDatabase.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	public void insertPet(Peliculas pet) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO PET (petName,codOwner)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, pet.getName());
			preparedStatement.setInt(2, pet.getCodOwner());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}
		
		
		manager.close(conn);
		
	}
	
	public List<Peliculas> searchAllPets() {
		List<Peliculas> listPets = new ArrayList<Peliculas>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM PET WHERE codOwner=?");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Peliculas petInDatabase = new Peliculas();
				
				petInDatabase.setName(resultSet.getString(1));
				petInDatabase.setCodOwner(resultSet.getInt(2));
				

				listPets.add(petInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listPets;
	}

}
