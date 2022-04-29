package com.hotel.project.hotelproject;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotel.project.hotelproject.book.Book;
import com.hotel.project.hotelproject.book.BookRepository;
import com.hotel.project.hotelproject.booking.Booking;
import com.hotel.project.hotelproject.booking.BookingRepository;
import com.hotel.project.hotelproject.bookingRoom.BookingRoom;
import com.hotel.project.hotelproject.bookingRoom.BookingRoomRepository;
import com.hotel.project.hotelproject.cancelBooking.CancelBooking;
import com.hotel.project.hotelproject.cancelBooking.CancelBookingRepository;
import com.hotel.project.hotelproject.customer.Customer;
import com.hotel.project.hotelproject.customer.CustomerRepository;
import com.hotel.project.hotelproject.hosted.Hosted;
import com.hotel.project.hotelproject.hosted.HostedRepository;
import com.hotel.project.hotelproject.occupiedRoom.OccupiedRoom;
import com.hotel.project.hotelproject.occupiedRoom.OccupiedRoomRepository;
import com.hotel.project.hotelproject.room.Room;
import com.hotel.project.hotelproject.room.RoomRepository;
import com.hotel.project.hotelproject.roomType.RoomType;
import com.hotel.project.hotelproject.roomType.RoomTypeRepository;
import com.hotel.project.hotelproject.staff.Staff;
import com.hotel.project.hotelproject.staff.StaffRepository;
import com.hotel.project.hotelproject.user.Role;
import com.hotel.project.hotelproject.user.RoleRepository;
import com.hotel.project.hotelproject.user.User;
import com.hotel.project.hotelproject.user.UserRepository;

@Configuration
public class HotelConfig {
	
	
	// I need to put all this in separate methods
	
	
	
	List<Room> roomsList = new ArrayList();
	List<Customer> customersList = new ArrayList();
	List<Staff> staffList = new ArrayList();
	List<Booking> bookingList = new ArrayList<>();
	List<RoomType> roomTypesList = new ArrayList();
	List<BookingRoom> bookingRoomList = new ArrayList();
	List<OccupiedRoom> occupiedRoomList = new ArrayList();
	List<Hosted> hostedList = new ArrayList();
	List<CancelBooking> cancelBookingList = new ArrayList();
	List<Book> booksList = new ArrayList();
	List<Role> rolesList = new ArrayList();
	
	@Bean
	CommandLineRunner commandLineRunner( 
			RoomRepository repository,
			CustomerRepository customerRepository,
			StaffRepository staffRepository,
			BookingRepository bookingRepository,
			RoomTypeRepository roomTypeRepository,
			BookingRoomRepository bookingRoomRepository,
			OccupiedRoomRepository occupiedRoomRepository,
			HostedRepository hostedRepository,
			CancelBookingRepository cancelBookingRepository,
			BookRepository bookRepository,
			RoleRepository roleRepository,
			UserRepository userRepository) {
    return args -> {
    	
    	Resource.class.getResource("/com/company/resources/graphics/image.jpg");
    	
			
    	Room room1 =  new Room ( "Ro.1", 50,"Standard Single Room",1,"./image");
    	roomsList.add( room1 );
    	
    	//Room room2 =  new Room ( "Ro.2","family","room TV and Internet", 70 );
    	//Room room2 =  new Room ( "Ro.2",2,"confirmed",70,"Family Room",3, "./image");
    	Room room2 =  new Room ( "Ro.2",70,"Family Room",3, "./image");
    	roomsList.add( room1 );
    	roomsList.add( room2 );
			
    	repository.saveAll( roomsList );
    	
    	
    	
    	Customer hosni =  new Customer ( "Hosni","Eltom",
    			"5 wood st", "Manchester","United Kingdom","hoselg@yahoo.com",
    			0744433331);
    	Customer zeze =  new Customer ( "Zeze","Hamed",
    			"9 old mot st", "Bolton", "United Kingdom" ,"zezelg@yahoo.com",
    			0777731435);
    	/*
    	  Customer zeze =  new Customer ( "Zeze","Hamed","zeze123D",
    			"5 columbine st","zezelg@yahoo.com",
    			0777731, LocalDate.of(1995, 06, 20));
    	 */
    	customersList.add( hosni );
    	customersList.add( zeze );
			
    	customerRepository.saveAll( customersList );
    	
    	Staff peter = new Staff ( "Peter","Pual","peter@gamil.com","peter123" );
    	Staff adam = new Staff ( "Adam","Ahmed","adam@gamil.com", "adam123");
    	staffList.add( peter );
    	staffList.add( adam );
    	staffRepository.saveAll( staffList );
    	
    	/*
    	Booking booking1 = new Booking(
				"BN1","Ro.1",LocalDate.of(2021, 12, 9), LocalDate.of(2021, 12, 20) );
		Booking booking2 = new Booking(
				"BN2","Ro.2",LocalDate.of(2021, 12, 12), LocalDate.of(2021, 12, 18) );
		*/
    	Booking booking1 = new Booking(
				LocalDate.of(2021, 12, 9), LocalDate.of(2021, 12, 20),2,3);
    	
    	Booking booking2 = new Booking( LocalDate.of(2021, 12, 12), LocalDate.of(2021, 12, 18),1,2 );
		bookingList.add( booking1 );
		bookingList.add( booking2 );
		
		bookingRepository.saveAll( bookingList );
		
		RoomType roomType1 =  new RoomType ("standard",1);
		RoomType roomType2 =  new RoomType ("family",3);
		roomTypesList.add(roomType1);
		roomTypesList.add(roomType2);
		
		roomTypeRepository.saveAll( roomTypesList);
		
		BookingRoom bookingRoom1 = new BookingRoom(1L,3,"confirmed",1,1);
		BookingRoom bookingRoom2 = new BookingRoom(2L,1,"confirmed",2,2);
		
		bookingRoomList.add(bookingRoom1);
		bookingRoomList.add(bookingRoom2);
		
		bookingRoomRepository.saveAll( bookingRoomList );
		
		
		// occupied room
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(stamp.getTime());
		
		Timestamp stamp2 = new Timestamp(System.currentTimeMillis());
		Date date2 = new Date(stamp2.getTime());
		
		OccupiedRoom occupiedRoom1 = new OccupiedRoom(1l, stamp,stamp2,1l,1l);
		OccupiedRoom occupiedRoom2 = new OccupiedRoom(2l, stamp,stamp2,2l,2l);
		
		occupiedRoomList.add( occupiedRoom1 );
		occupiedRoomList.add( occupiedRoom2 );
		
		occupiedRoomRepository.saveAll( occupiedRoomList );
		
		Hosted host1 = new Hosted(1l,1l,1l);
		Hosted host2 = new Hosted(2l,2l,2l);
		
		hostedList.add(host1);
		hostedList.add(host2);
		
		hostedRepository.saveAll( hostedList );
		
		CancelBooking cancelBooking1 = new CancelBooking(1l,1l,LocalDate.of(2021, 12, 31),"my business meeting was cancelled");
		CancelBooking cancelBooking2 = new CancelBooking(2l,2l,LocalDate.of(2021, 12, 30),"I missed my fly");
		
		cancelBookingList.add( cancelBooking1 ); 
		cancelBookingList.add( cancelBooking2 ); 
		
		cancelBookingRepository.saveAll( cancelBookingList );
		
		Book book1 = new Book(1l,0123l,1500,"Jo Peter","Happy life","second shelf");
		Book book2 = new Book(2l,0124l,1540,"Adam Wood","The moon","first shelf");
		
		booksList.add( book1 );	
		booksList.add( book2 );
		
		bookRepository.saveAll( booksList );
		
		
		Role user = new Role("User");
		Role admin = new Role("Admin");
		
		rolesList.add(user);
		rolesList.add(admin);
		
		roleRepository.saveAll(rolesList);
		//Role user2 = new Role();
		
		// add normal user
		User user1 = new User("Test3","Test33","test3@gmail.com","hello");
				
	    Role roleUser = roleRepository.findByName("User");
	    user1.addRole(roleUser);		
		
	    userRepository.save(user1);
	    
	    // add admin user
	    User adminUser = new User("Test4","Test44", "test4@gmail.com","$2a$10$umABm98M7aft7J20A.aWhOA5G.Q/OCca4/N/ikttMnVEUl35zsrMO");
	    Role roleAdmin = roleRepository.findByName("Admin");
	    adminUser.addRole( roleAdmin );
	    
	    userRepository.save( adminUser );

;			//customerRepository.save(null);
			
		};	
		
	}

}
