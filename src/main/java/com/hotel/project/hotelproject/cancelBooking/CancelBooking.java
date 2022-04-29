package com.hotel.project.hotelproject.cancelBooking;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class CancelBooking {
	
	@Id
	@SequenceGenerator(
			name = "cancel_booking_sequence",
			sequenceName = "cancel_booking_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "cancel_booking_sequence" )
	
	private long id;
	private long bookingId;
	private LocalDate cancellationDate;
	private String reasonForCancellation;
	
	public CancelBooking() {
	
	}

	public CancelBooking(long id, long bookingId, LocalDate cancellationDate, String reasonForCancellation) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.cancellationDate = cancellationDate;
		this.reasonForCancellation = reasonForCancellation;
	}

	public CancelBooking(long bookingId, LocalDate cancellationDate, String reasonForCancellation) {
		super();
		this.bookingId = bookingId;
		this.cancellationDate = cancellationDate;
		this.reasonForCancellation = reasonForCancellation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(LocalDate cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public String getReasonForCancellation() {
		return reasonForCancellation;
	}

	public void setReasonForCancellation(String reasonForCancellation) {
		this.reasonForCancellation = reasonForCancellation;
	}

	@Override
	public String toString() {
		return "CancelBooking [id=" + id + ", bookingId=" + bookingId + ", cancellationDate=" + cancellationDate
				+ ", reasonForCancellation=" + reasonForCancellation + "]";
	}
	
	
}
