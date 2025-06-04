CREATE TABLE IF NOT EXISTS Student (
    studentId bigint NOT NULL AUTO_INCREMENT,
    studentName varchar(255) NOT NULL,
    fatherName varchar(255) NOT NULL,
    dateOfBirth DATE NOT NULL,
    rollNumber varchar(255) NOT NULL,
    totalMark bigint NOT NULL,
    status BOOL NOT NULL,
    createdAt timestamp,
    modifiedDate timestamp,
    PRIMARY KEY (studentId)
);