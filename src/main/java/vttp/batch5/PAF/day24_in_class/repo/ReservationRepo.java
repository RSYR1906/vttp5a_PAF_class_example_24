package vttp.batch5.PAF.day24_in_class.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vttp.batch5.PAF.day24_in_class.model.Reservation;
import vttp.batch5.PAF.day24_in_class.model.ReservationDetail;
import vttp.batch5.PAF.day24_in_class.utils.Queries;

@Repository
public class ReservationRepo {

    @Autowired
    private JdbcTemplate template;

    public int createReservation(Reservation reservation) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(Queries.insertReservation, new String[] { "id" });
                ps.setString(1, reservation.getFullName());
                ps.setDate(2, reservation.getBookingDate());

                return ps;
            }

        };

        template.update(psc, keyHolder);

        // return the primary stored in the reference variable KeyHolder of the
        // parameter template.update
        int iReservationId = keyHolder.getKey().intValue();

        return iReservationId;
    }

    public Boolean createReservationDetails(ReservationDetail reservationDetail) {

        int iUpdated = template.update(Queries.insertReservationDetail, reservationDetail.getBook().getId(),
                reservationDetail.getReservation().getId());

        if (iUpdated > 0)
            return true;
        return false;

    }

}
