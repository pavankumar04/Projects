
# High level requirements	

You are required to build a Hotel Management application. This is an application where

## Guest can,

*	View Hotel and Room details
  * Show hotel details like hotel_id, hotel_name, address, phone, no_of_rooms and description
  * Show room details like room_no, room_type, room_cost
* View the Personal and Wallet details 
  * Show guest details like guest_id, guest_name, address, phone_no, email, username, password and            wallet_amt
* Book a room
  * Checking Room availability
    * Check the room availability based on check-in and check-out date. If available show the total amt to pay and get the confirmation from the guest otherwise throw the error message "Rooms are not available on these dates"
  * Room Confirmation
    * Check the wallet balance after the confirmation. Book the room if guest has sufficient balance, deduct and store the required details to the tables, otherwise throw the error message "wallet balance is not sufficient"
* View the booking details
  * Check the current booking details of the guest

## Admin can,

* View booking details 
  * Check the booking details of all guest
* Update the room status 
  * Updating the room status based on the check-in and check-out date.

Note: 
  * In this application all rooms are single room type and only one room can be allocated to each guestid.

## Must-Have
  *	All High level requirements above 
  *	Check-in date must not be in the past
  *	Check-out date should be equal to or greater than the start date

## Nice-To-Have
  *	Booking more than one room 
  *	Cancellation of room booked by guest 	
  *	Feedback ratings for the hotel rooms
  *	Adding money to wallet 
  	
## Great-To-Have
  * Confirmation alerts through SMS and Mail.
  * Sorting options on all tables
  * 'Quick filter' options on all tables.
  * Supporting different types of room- single/double, Ac/nonAc, deluxe rooms etc.
  
## Fantastic-To-Have
  * Types of payment mode like Net Banking/Credit/Debit cards etc.
  * Mobile UI
  * Conversational Interface
     * ChatBot
     * VoiceBot
  


