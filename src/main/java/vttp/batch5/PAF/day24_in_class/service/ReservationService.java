package vttp.batch5.PAF.day24_in_class.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp.batch5.PAF.day24_in_class.model.Reservation;
import vttp.batch5.PAF.day24_in_class.model.ReservationDetail;
import vttp.batch5.PAF.day24_in_class.repo.ReservationRepo;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo;

    @Transactional
    public boolean createReservationRecord(Reservation reservation, ReservationDetail reservationDetail) {

        Boolean bCreated = false;
        // start transaction
        // already in transaction based on the @Transactional annotation.

        // create the reservation record
        int iReservationId = reservationRepo.createReservation(reservation);

        // uncomment to simulate error
        // throw new IllegalArgumentException("Simulate error after creating
        // Reservation...");

        // created the reservation detail record
        reservationDetail.getReservation().setId(iReservationId);
        reservationRepo.createReservationDetails(reservationDetail);

        // uncomment to simulate error
        // throw new IllegalArgumentException("Simulate error after creating
        // ReservationDetails...");

        // commit transaction
        // auto because already annotated
        bCreated = true;

        return bCreated;
    }

}
