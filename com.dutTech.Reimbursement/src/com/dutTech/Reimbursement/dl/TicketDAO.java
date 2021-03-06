package com.dutTech.Reimbursement.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dutTech.Reimbursement.enums.Reimbursement;
import com.dutTech.Reimbursement.enums.Status;
import com.dutTech.Reimbursement.models.Ticket;

public class TicketDAO implements DAO<Ticket,Integer>{
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	
	@Override
	public void add(Ticket newObject) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "insert into tickets"
									+ "(refund_amount,refund_status,refund_type,refund_description,refund_date)"
									+ "values(?,CAST(? AS statusType),?::refundType,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, ((int) newObject.getAmount()));
			pstmt.setString(2, newObject.getStatus().toString());
			pstmt.setString(3,newObject.getCategory().toString());
			pstmt.setString(4, newObject.getDescription());
			pstmt.setObject(5, newObject.getTicket_time().toLocalDate());
//			pstmt.setInt(6, newObject.getEmployee_id());
			
			pstmt.execute();
		
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Ticket --> add() is not working",e);
		}
		
	}
	
	
	@Override
	public ArrayList<Ticket> findAll() {

		ArrayList<Ticket> getAllTickets = new ArrayList<Ticket>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from tickets";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				getAllTickets.add(
							  new Ticket(
									  Status.valueOf(rs.getString("refund_status")),
									  rs.getDouble("refund_amount"),
									  Reimbursement.valueOf(rs.getString("refund_type")),
									  rs.getString("refund_description"),
									  rs.getTimestamp("refund_date").toLocalDateTime(),
									  rs.getInt("id")
//									  rs.getInt("employee_id"),
								)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Something's wrong",e);
		}
		return getAllTickets;
	}
	
	

	@Override
	public Ticket findById(Integer id) {
	
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from tickets where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Ticket(
						Status.valueOf(rs.getString("refund_status")),
						  rs.getDouble("refund_amount"),
						  Reimbursement.valueOf(rs.getString("refund_type")),
						  rs.getString("refund_description"),
						  rs.getTimestamp("refund_date").toLocalDateTime(),
						  rs.getInt("id")
//						  rs.getInt("employee_id"),
						  
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("findById method is not working", e);
		}
		
		return null;
	}

	
	@Override
	public void update(Ticket newObject) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "update tickets set refund_status = ?::statusType where id =?";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, newObject.getStatus().toString());
			pstmt.setInt(2, newObject.getId());
		
			pstmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Error ---> update()", e);
		}
	}
	
	
	

	@Override
	public ArrayList<Ticket> getTicketByEmployeeId(Integer employee_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ticket> filterStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
