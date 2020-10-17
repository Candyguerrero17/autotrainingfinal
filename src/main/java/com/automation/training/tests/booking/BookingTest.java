package com.automation.training.tests.booking;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.automation.training.pages.booking.BookingHome;
import com.automation.training.pages.booking.HotelFoundPage;
import com.automation.training.pages.booking.HotelReservationPage;
import com.automation.training.pages.booking.LastStepsPage;
import com.automation.training.pages.booking.WriteData;
import com.automation.training.utils.BaseTests;
import com.automation.training.utils.modals.RervationModel;

public class BookingTest extends BaseTests {
	private BookingHome booking;
	private HotelFoundPage hotelFound;
	private WriteData data;
	private HotelReservationPage hotelResevation;
	private LastStepsPage lastPage;

	@Test
	public void verifyReservationOfHotel() {
		booking = getBookingHomePage();
		hotelFound = booking.searchHotel();
		hotelFound.filter();
		assertTrue(hotelFound.isVisibleNameHotel());
		assertTrue(hotelFound.isVisibleScore());
		assertTrue(hotelFound.isVisiblePrice());
		RervationModel value = hotelFound.setData();
		hotelResevation = hotelFound.doReservation();
		assertTrue(hotelResevation.isVisibleameHotel(value.getNameHotel()));
		assertTrue(hotelResevation.isVisibleDescription());
		assertTrue(hotelResevation.isVisiblePrice(value.getPriceHotel()));
		data = hotelResevation.yourRoom();
		lastPage = data.addDate();
		lastPage.enterNumberPhone();
		assertTrue(lastPage.isVisibleMessagePhoneHelp());
		assertTrue(lastPage.isVisibleMessageRequestedFields());
		assertTrue(lastPage.isVisibleFullName());
		assertTrue(lastPage.isVisibleEmail());
		lastPage.enterInformacionToPay();
		assertTrue(lastPage.isVisibleMessageNumberCard());
		
	}

}
