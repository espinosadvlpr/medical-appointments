create database quileia;
use quileia;

show tables;
select * from patient;
INSERT INTO `quileia`.`patient` 
(`id`, `birthdate`, `eps`, `full_name`, `history`, `identification`, `identification_type`) 
VALUES ('1', '2000-12-31', 'Compensar EPS', 'Paciente Prueba', 'Estado de salud de prueba', '123456789', 'CC');

select * from doctor;
INSERT INTO `quileia`.`doctor` 
(`id`, `end_hour`, `experience`, `full_name`, `identification`, `identification_type`, `professional_card`, `specialty`, `start_hour`) 
VALUES ('1', '19:00', '3.5', 'Medico Prueba', '987328129', 'CC', '87w44d89f7', 'Ortopedia', '07:00');

select * from appointment;
INSERT INTO `quileia`.`appointment` 
(`id`, `appointment_day`, `appointment_hour`, `doctor_id`, `patient_id`) 
VALUES ('1', 'Lunes', '09:00', '1', '1');
