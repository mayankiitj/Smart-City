package com.mmt.flyfish.constant;


public class SQLConstants {
	
	public static String AUTHENTICATE = "Select * from UserTable where UserName =? AND Password = ? ";
	
	public static String TREATMENT_LIST_QRY = "Select C.disease, C.treatment_date, D.doctorFirstName, D.doctorLastName, D.doctorRating, C.consultationId   from Consultations C left join Doctors D on C.doctorId = D.doctorId where C.patientId = ? ";
	
	public static String TREATMENT_DETAIL = "Select C.disease, C.treatment_date, D.doctorFirstName,D.doctorLastName, D.doctorRating, C.consultationId,  C.description from Consultations C left join Doctors D on C.doctorId = D.doctorId left join Medication M on M.key = C.medicationKey where C.consultationId = ? ";
	
	public static String MEDICATION_DETAIL = "Select M.medicationId, M.Name, M.Composition from Medication where M.consultationId = ? ";
	
	public static final String SEARCH_SLOTS_QRY = "Select latitude, longitude, price, address, name,SQRT( POW(69.1 * (latitude - ?), 2) + POW(69.1 * (? - longitude) * COS ( latitude / 57.3 ), 2)) AS distance from ParkingLot where userId is NULL AND distance < 25 ORDER BY distance";

	public static final String UPDATE_QRY = "Update ParkingLot Set userId = ? where latitude = ? AND longitude = ? ";
	
	public static final String DELETE_QRY = "Update ParkingLot Set userId = NULL where latitude = ? AND longitude = ? ";
	
	public static final String STATUS_QRY = "Select bookingTime from Parking Lot where latitude = ? AND longitude = ?";


}
