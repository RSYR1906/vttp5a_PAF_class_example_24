USE money;

CREATE TABLE Book (
    id INT NOT NULL auto_increment,
    title VARCHAR(255) NOT NULL,
    quantity INT DEFAULT 1,

    CONSTRAINT pk_book_id PRIMARY KEY (id)
);

CREATE TABLE Reservation (
    id INT NOT NULL auto_increment,
    fullName VARCHAR(255) NOT NULL,
    bookingDate DATE,

    CONSTRAINT pk_reservation_id PRIMARY KEY (id)
);


CREATE TABLE ReservationDetails (
    id INT NOT NULL auto_increment,
    book_id INT,
    reservation_id INT,

    CONSTRAINT pk_reservationdetails_id PRIMARY KEY (id),
    CONSTRAINT fk_rd_book_id FOREIGN KEY (book_id) REFERENCES Book(id),
    CONSTRAINT fk_rd_reservation_id FOREIGN KEY (reservation_id) REFERENCES Reservation(id)

);

