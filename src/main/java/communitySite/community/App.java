package communitySite.community;

import java.io.Console;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.nadav.persistance.entities.Rating;
import com.nadav.persistance.entities.User;
import com.nadav.persistance.dao.RatingDao;
import com.nadav.persistance.dao.UserDao;
import com.nadav.persistance.dao.impl.RatingDaoImpl;
import com.nadav.persistance.dao.impl.UserDaoImpl;


import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		DateTime dt = new DateTime("2004-12-13T21:39");
		Timestamp timeStamp = new Timestamp(dt.getMillis());

		Date date = new Date(100, 3, 2); // (year-1900,month,day)

//		 User user = new User();
//		 user.setFirstName("Test");
//		 user.setLastName("User");
//		 user.setUsername("gum");
//		 user.setEmail("test@mail.com");
//		 user.setPassword("1234");
//		 
//		 List<User> UserList = new ArrayList<User>();
//		 UserDao dao = new UserDaoImpl();
//		 
		 //dao.insertUser(user);
		
//		 dao.deleteUserStatus(3);
		 		 
//		 user = dao.getUserStatusById(1); 		 
//
//		 user.setIsPartner(true);
//		 dao.updateUserStatus(user);
		 
//		 UserList = dao.getAllUsers();
//		 		 
//		 System.out.println("user: " + user);
//		 System.out.println("UserList: " + UserList);


		 
		 Rating Rating = new Rating();
		 Rating.setUserId(1);
		 Rating.setTargetType("Rating");
		 Rating.setValue(1);
		 
		 List<Rating> RatingList = new ArrayList<Rating>();
		 RatingDao dao = new RatingDaoImpl();
		 
		 //dao.insertRating(Rating);
		
//		 dao.deleteRatingStatus(3);
		 		 
//		 Rating = dao.getRatingStatusById(1); 		 
//
//		 Rating.setIsPartner(true);
//		 dao.updateRatingStatus(Rating);
		 
		 RatingList = dao.getAllRatings();
//		 		 
//		 System.out.println("Rating: " + Rating);
		 System.out.println("RatingList: " + RatingList);

	}
	// public void insertUserStatusInGroup(UserStatusInGroup UserStatusInGroup);
	//
	// public void deleteUserStatusInGroup(int UserStatusInGroupId);
	//
	// public UserStatusInGroup getUserStatusInGroupById(int UserStatusInGroupId);
	//
	// public void updateUserStatusInGroup(UserStatusInGroup UserStatusInGroup);

}
