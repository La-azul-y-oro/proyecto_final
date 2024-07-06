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

insert into supplier (name, phone_number, email, street, number) values ('Accesorios Autocentro S.R.L.', '3414474715', 'autocentrosrl@gmail.com', 'Corrientes', 579);
insert into supplier (name, phone_number, email, street, number) values ('Tedini Repuestos', '3416708513', 'tedinirepuestos@gmail.com', 'La Paz', 1071);
insert into supplier (name, phone_number, email, street, number) values ('Brachetta Baterías', '3412984499', 'brachettabaterias@gmail.com', 'Blvd. 27 de Febrero', 2427);
insert into supplier (name, phone_number, email, street, number) values ('Suspensión Norte', '3416126448', 'suspensionnorte@gmail.com', 'Bv. Avellaneda', 2028);
insert into supplier (name, phone_number, email, street, number) values ('Auto Luxe', '3415023395', 'autoluxerosario@gmail.com', 'Av. Francia', 955);

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

