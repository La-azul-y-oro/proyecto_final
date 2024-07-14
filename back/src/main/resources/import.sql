insert into payment_type (name, category, is_deleted) values ('Visa', 'DEBIT_CARD', false);
insert into payment_type (name, category, is_deleted) values ('Visa', 'CREDIT_CARD', false);
insert into payment_type (name, category, is_deleted) values ('Mastercard', 'DEBIT_CARD', false);
insert into payment_type (name, category, is_deleted) values ('Mastercard', 'CREDIT_CARD', false);
insert into payment_type (name, category, is_deleted) values ('American Express', 'CREDIT_CARD', false);
insert into payment_type (name, category, is_deleted) values ('Efectivo', 'OTHER', false);
insert into payment_type (name, category, is_deleted) values ('Transferencia', 'OTHER', false);

insert into brand (name, category, is_deleted) values ('Toyota', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Ford', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Honda', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Chevrolet', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Nissan', 'CAR', false);
insert into brand (name, category, is_deleted) values ('BMW', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Mercedes-Benz', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Volkswagen', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Audi', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Renault', 'CAR', false);
insert into brand (name, category, is_deleted) values ('Citroen', 'CAR', false);

insert into brand (name, category, is_deleted) values ('Bosch', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('Denso', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('ACDelco', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('Magna International', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('Delphi', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('Valeo', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('Continental', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('Brembo', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('TRW Automotive', 'SPAREPART', false);
insert into brand (name, category, is_deleted) values ('SKF', 'SPAREPART', false);

insert into brand (name, category, is_deleted) values ('CSP1', 'CAR_AND_SPAREPART', false);
insert into brand (name, category, is_deleted) values ('CSP2', 'CAR_AND_SPAREPART', false);
insert into brand (name, category, is_deleted) values ('CSP3', 'CAR_AND_SPAREPART', false);
insert into brand (name, category, is_deleted) values ('CSP4', 'CAR_AND_SPAREPART', false);
insert into brand (name, category, is_deleted) values ('CSP5', 'CAR_AND_SPAREPART', false);

insert into supplier (name, phone, email, street, number, is_deleted) values ('Accesorios Autocentro S.R.L.', '3414474715', 'autocentrosrl@gmail.com', 'Corrientes', 579, false);
insert into supplier (name, phone, email, street, number, is_deleted) values ('Tedini Repuestos', '3416708513', 'tedinirepuestos@gmail.com', 'La Paz', 1071, false);
insert into supplier (name, phone, email, street, number, is_deleted) values ('Brachetta Baterías', '3412984499', 'brachettabaterias@gmail.com', 'Blvd. 27 de Febrero', 2427, false);
insert into supplier (name, phone, email, street, number, is_deleted) values ('Suspensión Norte', '3416126448', 'suspensionnorte@gmail.com', 'Bv. Avellaneda', 2028, false);
insert into supplier (name, phone, email, street, number, is_deleted) values ('Auto Luxe', '3415023395', 'autoluxerosario@gmail.com', 'Av. Francia', 955, false);

INSERT INTO type_service(name, description, is_deleted) VALUES ('Cambio de aceite', 'Sustitución del aceite del motor y del filtro para mantener el motor limpio y lubricado.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Alineación y balanceo', 'Ajuste de los ángulos de las ruedas para asegurar una conducción recta y uniforme.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Revisión de frenos', 'Inspección y mantenimiento del sistema de frenos, incluyendo pastillas, discos y líquido de frenos.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Cambio de llantas', 'Reemplazo de llantas desgastadas o dañadas para garantizar una conducción segura.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Reparación de motor', 'Diagnóstico y reparación de problemas mecánicos en el motor del vehículo.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Diagnóstico de motor', 'Uso de herramientas de diagnóstico para identificar problemas en el motor y otros sistemas del vehículo.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Cambio de filtros', 'Reemplazo de filtros de aire, aceite y combustible para mantener la eficiencia del motor.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Mantenimiento de aire acondicionado', 'Revisión y reparación del sistema de aire acondicionado para asegurar su correcto funcionamiento.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Revisión de suspensión', 'Inspección y reparación de los componentes de la suspensión para una conducción cómoda y segura.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Reparación de transmisión', 'Mantenimiento y reparación del sistema de transmisión del vehículo.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Reemplazo de baterías', 'Sustitución de baterías viejas o defectuosas para asegurar un arranque fiable del motor.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Reparación de sistemas eléctricos', 'Diagnóstico y reparación de problemas en el sistema eléctrico del vehículo.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Reparación de escapes', 'Reparación o reemplazo de componentes del sistema de escape para reducir emisiones y ruido.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Inspección de seguridad', 'Revisión completa del vehículo para asegurar que cumple con los estándares de seguridad.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Mantenimiento preventivo', 'Servicios regulares para prevenir problemas mayores, incluyendo cambios de aceite, revisiones y ajustes.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Servicio de emergencia en carretera', 'Asistencia inmediata en caso de averías o emergencias mientras se está en carretera.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Revisión de luces', 'Inspección y reemplazo de bombillas y componentes del sistema de iluminación.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Diagnóstico computarizado', 'Uso de herramientas y software avanzados para identificar y solucionar problemas del vehículo.', false);
INSERT INTO type_service(name, description, is_deleted) VALUES ('Reparación de sistemas de dirección', 'Reparación y mantenimiento del sistema de dirección para asegurar un control preciso del vehículo.', false);

insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Matías', 'Rodriguez', 'DNI', 20123456, 'niconicodinolfo@gmail.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Joaquin', 'Fernandez', 'DNI', 30987517, 'gabrielp1689@gmail.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Valentina', 'Gutierrez', 'DNI', 25312978, 'juanschiavoni713@gmail.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Lionel', 'Gomez', 'DNI', 39741852, 'ceronsanti@gmail.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Emiliano', 'Estevanez', 'DNI', 21369819, 'nicodinolfo1889@gmail.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Emiliano', 'Corinoto', 'DNI', 21475619, 'azulyorocompany@gmail.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Maria', 'Diaz', 'DNI', 28753159, 'mailfalso1@test.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Luciano', 'Martínez', 'DNI', 30123456, 'mailfalso2@test.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Federico', 'Pérez', 'DNI', 31567890, 'mailfalso3@test.com', false);
insert into client (name, last_name, category, identification_number, email, is_deleted) values ('Santiago', 'Ramírez', 'DNI', 32654321, 'mailfalso4@test.com', false);

insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password, is_deleted)  values  ('Carlos', 'Acevedo', 'DNI', 34123478, 'carlosg@gmail.com', 'ROLE_MECHANIC', 'San Lorenzo', 1276, 1, 'A', 'mecanico154', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, password, is_deleted)  values  ('Pedro', 'Cabrera', 'DNI', 28173464, 'pedritocabrera@gmail.com', 'ROLE_MECHANIC', 'José Ingenieros', 2547, 'ing464', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password, is_deleted)  values  ('Jesús', 'Olivos', 'DNI', 19765384, 'olivosjesus@gmail.com', 'ROLE_MECHANIC', 'Montevideo', 417, 8, 'C', 'fierrero46', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, password, is_deleted)  values  ('Luis', 'Salinas', 'DNI', 21847033, 'salinasluismecanico@hotmail.com', 'ROLE_MECHANIC', 'Av. Pellegrini', 3126, 'password123', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password, is_deleted)  values  ('Miguel', 'Pedraza', 'DNI', 36482529, 'miguelped@gmail.com', 'ROLE_MECHANIC', 'Córdoba', 1295, 3, 'B', 'pedmig529', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password, is_deleted)  values  ('Andrés', 'López', 'DNI', 34127403, 'andreslopez23@gmail.com', 'ROLE_MECHANIC', 'Sarmiento', 4572, 7, 'C', 'andy123', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, password, is_deleted)  values  ('Hernán', 'Valero', 'DNI', 22796284, 'hernanmartinvalero@gmail.com', 'ROLE_MECHANIC', 'San Juan', 648, 'rosariocentral1889', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, password, is_deleted)  values  ('Diego', 'Serra', 'DNI', 38741369, 'dieguito10serra@hotmail.com', 'ROLE_MECHANIC', 'Entre Ríos', 814, 'bpx843', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password, is_deleted)  values  ('Alberto', 'Torres', 'DNI', 20946273, 'torrestito@yahoo.com', 'ROLE_MECHANIC', 'Ocampos', 2248, 4, 'D', 'taller2248', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password, is_deleted)  values  ('José', 'Giménez', 'DNI', 35852147, 'jose.gimenez@gmail.com', 'ROLE_MECHANIC', 'Urquiza', 3394, 5, 'E', 'josgim875', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password, is_deleted)  values  ('Jimena', 'Escudero', 'DNI', 40129402, 'jime.escudero7@gmail.com', 'ROLE_ADMINISTRATIVE', 'Balcarce', 1542, 2, 'A', 'jime_129402', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password, is_deleted)  values  ('Fernando', 'Bernal', 'DNI', 42673981, 'bernalfernando12@gmail.com', 'ROLE_ADMINISTRATIVE', 'Mitre', 2743, 1, 'B', 'cabj2743', false);
insert into employee (name, last_name, category, identification_number, email, role, street, number, password, is_deleted)  values  ('admin', 'admin', 'DNI', 12123123, 'admin.user@gmail.com', 'ROLE_ADMIN', 'admin', 123, 'adminuser123', false);

INSERT INTO vehicle (brand_id, model, mileage, plate, observations, is_deleted) VALUES (1, 'Corolla', 15000, 'ABC123', 'Sedan en buen estado', false);
INSERT INTO vehicle (brand_id, model, mileage, plate, observations, is_deleted) VALUES (3, 'Civic', 20000, 'DEF456', 'Amortiguadores en dudoso estado', false);
INSERT INTO vehicle (brand_id, model, mileage, plate, observations, is_deleted) VALUES (2, 'Mustang', 30000, 'GHI789', 'Revisar filtro de aire en la proxima visita', false);
INSERT INTO vehicle (brand_id, model, mileage, plate, observations, is_deleted) VALUES (4, 'Impala', 25000, 'JKL012', '', false);
INSERT INTO vehicle (brand_id, model, mileage, plate, observations, is_deleted) VALUES (6, 'X5', 5000, 'MNO345', 'Se cambio aceite, filtro de aceite y cubiertas', false);
INSERT INTO vehicle (brand_id, model, mileage, plate, observations, is_deleted) VALUES (9, 'A4', 10000, 'PQR678', '', false);
INSERT INTO vehicle (brand_id, model, mileage, plate, observations, is_deleted) VALUES (7, 'C-Class', 15000, 'STU901', 'Velocimetro reparado', false);

INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Filtro de Aceite', 12, 'Alemania', false); -- Bosch
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Bujía', 13, 'Japón', false); -- Denso
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Batería', 14, 'USA', false); -- ACDelco
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Amortiguador', 15, 'Canadá', false); -- Magna International
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Inyector', 16, 'USA', false); -- Delphi
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Alternador', 17, 'Francia', false); -- Valeo
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Frenos', 18, 'Alemania', false); -- Continental
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Discos de Freno', 19, 'Italia', false); -- Brembo
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Pastillas de Freno', 20, 'USA', false); -- TRW Automotive
INSERT INTO spare_part (name, brand_id, made_in, is_deleted) VALUES ('Rodamiento', 21, 'Suecia', false); -- SKF

INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (3, 1, 12000.00, 23990.00, 1, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (7, 2, 13540.45, 23990.00, 1, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (10, 3, 15004.39, 30000.00, 2, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (4, 4, 14200.78, 30000.00, 2, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (5, 5, 56254, 74800, 3, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (6, 1, 51247.44, 74800, 3, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (6, 2, 194500, 248926.4, 4, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (4, 3, 194500, 248926.4, 4, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (1, 4, 16745.99, 26759, 5, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (2, 5, 17541.00, 26759, 5, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (8, 1, 315000, 348900, 6, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (6, 2, 203478.44, 248926.4, 7, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (3, 3, 200478.44, 248926.4, 7, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (6, 4, 41050.78, 63857.00, 8, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (3, 5, 16742.13, 24708, 9, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (6, 1, 13542.24, 24708, 9, false);
INSERT INTO inventory (amount, supplier_id, cost_price, sale_price, spare_part_id, is_deleted) values (3, 2, 7456.65, 13300, 10, false);

INSERT INTO pay (date, payment_type_id) VALUES ('2024-05-04', 1);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-05-04', 2);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-05-04', 3);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-05-04', 4);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-05-04', 5);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-05-04', 6);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-06-04', 7);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-06-04', 1);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-06-04', 2);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-06-04', 3);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-06-04', 4);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-06-04', 5);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-06-04', 6);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-06-04', 7);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-07-04', 1);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-07-04', 2);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-07-04', 3);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-07-04', 4);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-07-04', 5);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-07-04', 6);
INSERT INTO pay (date, payment_type_id) VALUES ('2024-07-04', 7);

INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (1, 3, 5, 20000.00, '2024-04-10', NULL, 'TO_DO', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (2, 1, 7, 15000.00, '2024-04-15', NULL, 'IN_PROGRESS', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (3, 4, 2, 30000.00, '2024-04-20', '2024-05-04', 'FINISHED', 1);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (4, 2, 9, 25000.00, '2024-04-25', NULL, 'CANCELLED', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (5, 5, 11, 22000.00, '2024-05-01', '2024-05-04', 'FINISHED', 2);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (6, 3, 4, 18000.00, '2024-05-05', NULL, 'TO_DO', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (7, 6, 6, 21000.00, '2024-05-10', '2024-05-04', 'FINISHED', 3);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (8, 1, 8, 16000.00, '2024-05-15', NULL, 'IN_PROGRESS', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (9, 7, 10, 23000.00, '2024-05-20', '2024-06-04', 'FINISHED', 7);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (10, 2, 12, 20000.00, '2024-05-25', NULL, 'CANCELLED', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (1, 3, 13, 25000.00, '2024-06-01', NULL, 'TO_DO', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (2, 4, 15, 19000.00, '2024-06-05', NULL, 'IN_PROGRESS', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (3, 5, 17, 27000.00, '2024-06-10', '2024-06-04', 'FINISHED', 8);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (4, 6, 19, 22000.00, '2024-06-15', NULL, 'CANCELLED', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (5, 7, 1, 24000.00, '2024-06-20', '2024-07-04', 'FINISHED', 15);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (6, 1, 3, 20000.00, '2024-06-25', NULL, 'TO_DO', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (7, 2, 5, 18000.00, '2024-07-01', NULL, 'IN_PROGRESS', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (8, 3, 7, 30000.00, '2024-07-05', '2024-07-04', 'FINISHED', 16);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (9, 4, 9, 21000.00, '2024-07-10', NULL, 'CANCELLED', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (10, 5, 11, 17000.00, '2024-07-15', NULL, 'TO_DO', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (1, 6, 13, 25000.00, '2024-07-20', '2024-07-04', 'FINISHED', 17);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (2, 7, 15, 22000.00, '2024-07-25', NULL, 'IN_PROGRESS', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (3, 1, 17, 24000.00, '2024-08-01', '2024-07-04', 'FINISHED', 18);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (4, 2, 19, 20000.00, '2024-08-05', NULL, 'CANCELLED', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (5, 3, 2, 19000.00, '2024-08-10', NULL, 'TO_DO', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (6, 4, 4, 22000.00, '2024-08-15', '2024-07-04', 'FINISHED', 19);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (7, 5, 6, 25000.00, '2024-08-20', NULL, 'IN_PROGRESS', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (8, 6, 8, 23000.00, '2024-08-25', NULL, 'CANCELLED', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (9, 7, 10, 24000.00, '2024-09-01', '2024-07-04', 'FINISHED', 20);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (10, 1, 12, 20000.00, '2024-09-05', NULL, 'TO_DO', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (1, 2, 14, 27000.00, '2024-09-10', NULL, 'IN_PROGRESS', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (2, 3, 16, 19000.00, '2024-09-15', '2024-07-04', 'FINISHED', 21);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (3, 4, 18, 23000.00, '2024-09-20', NULL, 'CANCELLED', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (4, 5, 1, 20000.00, '2024-09-25', NULL, 'TO_DO', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (5, 6, 3, 21000.00, '2024-10-01', NULL, 'IN_PROGRESS', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (6, 7, 5, 22000.00, '2024-10-05', '2024-06-04', 'FINISHED', 9);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (7, 1, 7, 18000.00, '2024-10-10', NULL, 'CANCELLED', NULL);
INSERT INTO service (client_id, vehicle_id, service_type_id, price, start_date, final_date, status, pay_id) VALUES (8, 2, 9, 23000.00, '2024-10-15', '2024-06-04', 'FINISHED', 10);

INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (1, 1);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (1, 2);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (2, 2);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (3, 3);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (3, 4);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (4, 4);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (5, 5);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (5, 6);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (6, 6);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (7, 7);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (7, 8);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (8, 8);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (9, 9);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (9, 10);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (10, 10);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (11, 1);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (11, 3);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (12, 2);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (13, 3);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (13, 5);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (14, 4);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (15, 5);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (15, 7);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (16, 6);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (17, 7);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (17, 9);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (18, 8);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (19, 1);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (19, 9);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (20, 10);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (21, 1);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (22, 2);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (23, 3);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (24, 4);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (25, 5);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (26, 6);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (27, 7);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (28, 8);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (29, 9);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (30, 10);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (31, 1);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (32, 2);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (33, 3);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (34, 4);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (35, 5);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (36, 6);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (37, 7);
INSERT INTO REL_SERVICE_EMPLOYEE (FK_SERVICE, FK_EMPLOYEE) VALUES (38, 8);

INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (1, 1);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (1, 2);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (2, 2);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (3, 3);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (3, 4);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (4, 4);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (5, 5);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (5, 6);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (6, 6);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (7, 7);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (7, 8);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (8, 8);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (9, 9);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (9, 10);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (10, 10);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (11, 1);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (11, 3);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (12, 2);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (13, 3);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (13, 5);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (14, 4);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (15, 5);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (15, 7);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (16, 6);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (17, 7);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (17, 9);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (18, 8);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (19, 9);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (19, 1);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (20, 10);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (21, 1);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (22, 2);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (23, 3);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (24, 4);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (25, 5);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (26, 6);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (27, 7);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (28, 8);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (29, 9);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (30, 10);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (31, 1);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (32, 2);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (33, 3);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (34, 4);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (35, 5);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (36, 6);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (37, 7);
INSERT INTO rel_service_spare_parts (FK_SERVICE, FK_SPARE_PART) VALUES (38, 8);