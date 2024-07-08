insert into payment_type (name, category) values ('Visa', 'DEBIT_CARD');
insert into payment_type (name, category) values ('Visa', 'CREDIT_CARD');
insert into payment_type (name, category) values ('Mastercard', 'DEBIT_CARD');
insert into payment_type (name, category) values ('Mastercard', 'CREDIT_CARD');
insert into payment_type (name, category) values ('American Express', 'CREDIT_CARD');
insert into payment_type (name, category) values ('Efectivo', 'OTHER');
insert into payment_type (name, category) values ('Transferencia', 'OTHER');

insert into brand (name, category) values ('Toyota', 'CAR');
insert into brand (name, category) values ('Ford', 'CAR');
insert into brand (name, category) values ('Honda', 'CAR');
insert into brand (name, category) values ('Chevrolet', 'CAR');
insert into brand (name, category) values ('Nissan', 'CAR');
insert into brand (name, category) values ('BMW', 'CAR');
insert into brand (name, category) values ('Mercedes-Benz', 'CAR');
insert into brand (name, category) values ('Volkswagen', 'CAR');
insert into brand (name, category) values ('Audi', 'CAR');
insert into brand (name, category) values ('Renault', 'CAR');
insert into brand (name, category) values ('Citroen', 'CAR');

insert into brand (name, category) values ('Bosch', 'SPAREPART');
insert into brand (name, category) values ('Denso', 'SPAREPART');
insert into brand (name, category) values ('ACDelco', 'SPAREPART');
insert into brand (name, category) values ('Magna International', 'SPAREPART');
insert into brand (name, category) values ('Delphi', 'SPAREPART');
insert into brand (name, category) values ('Valeo', 'SPAREPART');
insert into brand (name, category) values ('Continental', 'SPAREPART');
insert into brand (name, category) values ('Brembo', 'SPAREPART');
insert into brand (name, category) values ('TRW Automotive', 'SPAREPART');
insert into brand (name, category) values ('SKF', 'SPAREPART');

insert into brand (name, category) values ('CSP1', 'CAR_AND_SPAREPART');
insert into brand (name, category) values ('CSP2', 'CAR_AND_SPAREPART');
insert into brand (name, category) values ('CSP3', 'CAR_AND_SPAREPART');
insert into brand (name, category) values ('CSP4', 'CAR_AND_SPAREPART');
insert into brand (name, category) values ('CSP5', 'CAR_AND_SPAREPART');

insert into supplier (name, phone, email, street, number, is_deleted) values ('Accesorios Autocentro S.R.L.', '3414474715', 'autocentrosrl@gmail.com', 'Corrientes', 579, false);
insert into supplier (name, phone, email, street, number, is_deleted) values ('Tedini Repuestos', '3416708513', 'tedinirepuestos@gmail.com', 'La Paz', 1071, false);
insert into supplier (name, phone, email, street, number, is_deleted) values ('Brachetta Baterías', '3412984499', 'brachettabaterias@gmail.com', 'Blvd. 27 de Febrero', 2427, false);
insert into supplier (name, phone, email, street, number, is_deleted) values ('Suspensión Norte', '3416126448', 'suspensionnorte@gmail.com', 'Bv. Avellaneda', 2028, false);
insert into supplier (name, phone, email, street, number, is_deleted) values ('Auto Luxe', '3415023395', 'autoluxerosario@gmail.com', 'Av. Francia', 955, false);

INSERT INTO type_service(name, description) VALUES ('Cambio de aceite', 'Sustitución del aceite del motor y del filtro para mantener el motor limpio y lubricado.');
INSERT INTO type_service(name, description) VALUES ('Alineación y balanceo', 'Ajuste de los ángulos de las ruedas para asegurar una conducción recta y uniforme.');
INSERT INTO type_service(name, description) VALUES ('Revisión de frenos', 'Inspección y mantenimiento del sistema de frenos, incluyendo pastillas, discos y líquido de frenos.');
INSERT INTO type_service(name, description) VALUES ('Cambio de llantas', 'Reemplazo de llantas desgastadas o dañadas para garantizar una conducción segura.');
INSERT INTO type_service(name, description) VALUES ('Reparación de motor', 'Diagnóstico y reparación de problemas mecánicos en el motor del vehículo.');
INSERT INTO type_service(name, description) VALUES ('Diagnóstico de motor', 'Uso de herramientas de diagnóstico para identificar problemas en el motor y otros sistemas del vehículo.');
INSERT INTO type_service(name, description) VALUES ('Cambio de filtros', 'Reemplazo de filtros de aire, aceite y combustible para mantener la eficiencia del motor.');
INSERT INTO type_service(name, description) VALUES ('Mantenimiento de aire acondicionado', 'Revisión y reparación del sistema de aire acondicionado para asegurar su correcto funcionamiento.');
INSERT INTO type_service(name, description) VALUES ('Revisión de suspensión', 'Inspección y reparación de los componentes de la suspensión para una conducción cómoda y segura.');
INSERT INTO type_service(name, description) VALUES ('Reparación de transmisión', 'Mantenimiento y reparación del sistema de transmisión del vehículo.');
INSERT INTO type_service(name, description) VALUES ('Reemplazo de baterías', 'Sustitución de baterías viejas o defectuosas para asegurar un arranque fiable del motor.');
INSERT INTO type_service(name, description) VALUES ('Reparación de sistemas eléctricos', 'Diagnóstico y reparación de problemas en el sistema eléctrico del vehículo.');
INSERT INTO type_service(name, description) VALUES ('Reparación de escapes', 'Reparación o reemplazo de componentes del sistema de escape para reducir emisiones y ruido.');
INSERT INTO type_service(name, description) VALUES ('Inspección de seguridad', 'Revisión completa del vehículo para asegurar que cumple con los estándares de seguridad.');
INSERT INTO type_service(name, description) VALUES ('Mantenimiento preventivo', 'Servicios regulares para prevenir problemas mayores, incluyendo cambios de aceite, revisiones y ajustes.');
INSERT INTO type_service(name, description) VALUES ('Servicio de emergencia en carretera', 'Asistencia inmediata en caso de averías o emergencias mientras se está en carretera.');
INSERT INTO type_service(name, description) VALUES ('Revisión de luces', 'Inspección y reemplazo de bombillas y componentes del sistema de iluminación.');
INSERT INTO type_service(name, description) VALUES ('Diagnóstico computarizado', 'Uso de herramientas y software avanzados para identificar y solucionar problemas del vehículo.');
INSERT INTO type_service(name, description) VALUES ('Reparación de sistemas de dirección', 'Reparación y mantenimiento del sistema de dirección para asegurar un control preciso del vehículo.');

insert into client (name, last_name, category, identification_number, email) values ('Matías', 'Rodriguez', 'DNI', 20123456, 'niconicodinolfo@gmail.com');
insert into client (name, last_name, category, identification_number, email) values ('Joaquin', 'Fernandez', 'DNI', 30987517, 'gabrielp1689@gmail.com');
insert into client (name, last_name, category, identification_number, email) values ('Valentina', 'Gutierrez', 'DNI', 25312978, 'juanschiavoni713@gmail.com');
insert into client (name, last_name, category, identification_number, email) values ('Lionel', 'Gomez', 'DNI', 39741852, 'ceronsanti@gmail.com');
insert into client (name, last_name, category, identification_number, email) values ('Emiliano', 'Estevanez', 'DNI', 21369819, 'nicodinolfo1889@gmail.com');
insert into client (name, last_name, category, identification_number, email) values ('Emiliano', 'Corinoto', 'DNI', 21475619, 'emilianolbdt@gmail.com');
insert into client (name, last_name, category, identification_number, email) values ('Maria', 'Diaz', 'DNI', 28753159, 'mariadiaz13@gmail.com');
insert into client (name, last_name, category, identification_number, email) values ('Luciano', 'Martínez', 'DNI', 30123456, 'lucianomartinez@gmail.com'); 
insert into client (name, last_name, category, identification_number, email) values ('Federico', 'Pérez', 'DNI', 31567890, 'federicoperez@yahoo.com'); 
insert into client (name, last_name, category, identification_number, email) values ('Santiago', 'Ramírez', 'DNI', 32654321, 'santiagoramirez@hotmail.com');

insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password)  values  ('Carlos', 'Acevedo', 'DNI', 34123478, 'carlosg@gmail.com', 'ROLE_MECHANIC', 'San Lorenzo', 1276, 1, 'A', 'mecanico154');
insert into employee (name, last_name, category, identification_number, email, role, street, number, password)  values  ('Pedro', 'Cabrera', 'DNI', 28173464, 'pedritocabrera@gmail.com', 'ROLE_MECHANIC', 'José Ingenieros', 2547, 'ing464');
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password)  values  ('Jesús', 'Olivos', 'DNI', 19765384, 'olivosjesus@gmail.com', 'ROLE_MECHANIC', 'Montevideo', 417, 8, 'C', 'fierrero46');
insert into employee (name, last_name, category, identification_number, email, role, street, number, password)  values  ('Luis', 'Salinas', 'DNI', 21847033, 'salinasluismecanico@hotmail.com', 'ROLE_MECHANIC', 'Av. Pellegrini', 3126, 'password123');
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password)  values  ('Miguel', 'Pedraza', 'DNI', 36482529, 'miguelped@gmail.com', 'ROLE_MECHANIC', 'Córdoba', 1295, 3, 'B', 'pedmig529');
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password)  values  ('Andrés', 'López', 'DNI', 34127403, 'andreslopez23@gmail.com', 'ROLE_MECHANIC', 'Sarmiento', 4572, 7, 'C', 'andy123');
insert into employee (name, last_name, category, identification_number, email, role, street, number, password)  values  ('Hernán', 'Valero', 'DNI', 22796284, 'hernanmartinvalero@gmail.com', 'ROLE_MECHANIC', 'San Juan', 648, 'rosariocentral1889');
insert into employee (name, last_name, category, identification_number, email, role, street, number, password)  values  ('Diego', 'Serra', 'DNI', 38741369, 'dieguito10serra@hotmail.com', 'ROLE_MECHANIC', 'Entre Ríos', 814, 'bpx843');
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password)  values  ('Alberto', 'Torres', 'DNI', 20946273, 'torrestito@yahoo.com', 'ROLE_MECHANIC', 'Ocampos', 2248, 4, 'D', 'taller2248');
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password)  values  ('José', 'Giménez', 'DNI', 35852147, 'jose.gimenez@gmail.com', 'ROLE_MECHANIC', 'Urquiza', 3394, 5, 'E', 'josgim875');
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password)  values  ('Jimena', 'Escudero', 'DNI', 40129402, 'jime.escudero7@gmail.com', 'ROLE_ADMINISTRATIVE', 'Balcarce', 1542, 2, 'A', 'jime_129402');
insert into employee (name, last_name, category, identification_number, email, role, street, number, floor, department, password)  values  ('Fernando', 'Bernal', 'DNI', 42673981, 'bernalfernando12@gmail.com', 'ROLE_ADMINISTRATIVE', 'Mitre', 2743, 1, 'B', 'cabj2743');
insert into employee (name, last_name, category, identification_number, email, role, street, number, password)  values  ('admin', 'admin', 'DNI', 12123123, 'admin.user@gmail.com', 'ROLE_ADMIN', 'admin', 123, 'adminuser123');

INSERT INTO vehicle (brand_id, model, mileage, plate, observations) VALUES (1, 'Corolla', 15000, 'ABC123', 'Sedan en buen estado');
INSERT INTO vehicle (brand_id, model, mileage, plate, observations) VALUES (3, 'Civic', 20000, 'DEF456', 'Amortiguadores en dudoso estado');
INSERT INTO vehicle (brand_id, model, mileage, plate, observations) VALUES (2, 'Mustang', 30000, 'GHI789', 'Revisar filtro de aire en la proxima visita');
INSERT INTO vehicle (brand_id, model, mileage, plate, observations) VALUES (4, 'Impala', 25000, 'JKL012', '');
INSERT INTO vehicle (brand_id, model, mileage, plate, observations) VALUES (6, 'X5', 5000, 'MNO345', 'Se cambio aceite, filtro de aceite y cubiertas');
INSERT INTO vehicle (brand_id, model, mileage, plate, observations) VALUES (9, 'A4', 10000, 'PQR678', '');
INSERT INTO vehicle (brand_id, model, mileage, plate, observations) VALUES (7, 'C-Class', 15000, 'STU901', 'Velocimetro reparado');

INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Filtro de Aceite', 12, 'Alemania'); -- Bosch
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Bujía', 13, 'Japón'); -- Denso
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Batería', 14, 'USA'); -- ACDelco
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Amortiguador', 15, 'Canadá'); -- Magna International
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Inyector', 16, 'USA'); -- Delphi
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Alternador', 17, 'Francia'); -- Valeo
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Frenos', 18, 'Alemania'); -- Continental
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Discos de Freno', 19, 'Italia'); -- Brembo
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Pastillas de Freno', 20, 'USA'); -- TRW Automotive
INSERT INTO spare_part (name, brand_id, made_in) VALUES ('Rodamiento', 21, 'Suecia'); -- SKF