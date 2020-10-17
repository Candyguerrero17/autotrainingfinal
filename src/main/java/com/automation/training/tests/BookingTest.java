package com.automation.training.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.training.pages.BookingHome;
import com.automation.training.pages.HotelFoundPage;
import com.automation.training.pages.HotelReservationPage;
import com.automation.training.pages.LastStepsPage;
import com.automation.training.pages.WriteData;
import com.automation.training.utils.modals.RervationModel;

public class BookingTest extends BaseTests {
	BookingHome booking;
	HotelFoundPage hotelFound;
	WriteData data;

	HotelReservationPage hotelResevation;
	LastStepsPage lastPage;

	@Test
	public void selectHotel() {
		booking = getBookingHomePage();
		hotelFound = booking.searchHotel();
		hotelFound.filter();
		assertTrue(hotelFound.isVisibleNameHotel());
//		assertTrue(hotelFound.isVisibleScore());
//		assertTrue(hotelFound.isVisiblePrice());
		RervationModel value = hotelFound.setData();
		hotelResevation = hotelFound.doReservation();
		assertTrue(hotelResevation.isVisibleameHotel(value.getNameHotel()));
		assertTrue(hotelResevation.isVisibleDescription());
		assertTrue(hotelResevation.isVisiblePrice(value.getPriceHotel()));
		data = hotelResevation.yourRoom();
		lastPage = data.addDate();
		lastPage.enterPhone();
		assertTrue(lastPage.isVisibleMessageAlmost());
		assertTrue(lastPage.isVisibleFullName());
		assertTrue(lastPage.isVisibleMessageAlmost());
	}

}
