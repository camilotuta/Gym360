PRAGMA foreign_keys = ON;
INSERT INTO Empleado (
        idEmpleado,
        nombre,
        apellido,
        salario,
        fechaContratacion,
        cargo,
        telefono,
        email
    )
VALUES (
        1,
        'Carlos',
        'Pérez',
        1500.00,
        '2024-01-15',
        'Vendedor',
        '555-1234',
        'carlos.perez@empresa.com'
    ),
    (
        2,
        'María',
        'López',
        1800.50,
        '2023-11-01',
        'Vendedor',
        '555-5678',
        'maria.lopez@empresa.com'
    ),
    (
        3,
        'Javier',
        'García',
        2000.00,
        '2024-05-20',
        'Supervisor',
        '555-8765',
        'javier.garcia@empresa.com'
    ),
    (
        4,
        'Ana',
        'Martínez',
        2200.00,
        '2024-02-10',
        'Gerente',
        '555-4321',
        'ana.martinez@empresa.com'
    ),
    (
        5,
        'Lucía',
        'Rodríguez',
        1700.75,
        '2023-12-01',
        'Vendedor',
        '555-8899',
        'lucia.rodriguez@empresa.com'
    ),
    (
        6,
        'David',
        'Fernández',
        2100.00,
        '2023-09-15',
        'Supervisor',
        '555-1122',
        'david.fernandez@empresa.com'
    ),
    (
        7,
        'Marta',
        'Gómez',
        1900.25,
        '2024-03-01',
        'Vendedor',
        '555-3344',
        'marta.gomez@empresa.com'
    ),
    (
        8,
        'Sofía',
        'Sánchez',
        2500.00,
        '2023-10-10',
        'Gerente',
        '555-5566',
        'sofia.sanchez@empresa.com'
    ),
    (
        9,
        'Raúl',
        'Hernández',
        1600.00,
        '2024-06-05',
        'Vendedor',
        '555-7788',
        'raul.hernandez@empresa.com'
    ),
    (
        10,
        'Elena',
        'Jiménez',
        2300.00,
        '2024-01-25',
        'Supervisora',
        '555-9900',
        'elena.jimenez@empresa.com'
    );
INSERT INTO Nomina (
        idNomina,
        fecha,
        salarioBase,
        deducciones,
        bonificaciones,
        idEmpleado
    )
VALUES (1, '2025-03-01', 1500.00, 100.00, 50.00, 1),
    (2, '2025-03-01', 1800.50, 120.00, 80.00, 2),
    (3, '2025-03-01', 2000.00, 150.00, 100.00, 3),
    (4, '2025-03-01', 2200.00, 200.00, 150.00, 4),
    (5, '2025-03-01', 1700.75, 90.00, 60.00, 5),
    (6, '2025-03-01', 2100.00, 160.00, 120.00, 6),
    (7, '2025-03-01', 1900.25, 110.00, 70.00, 7),
    (8, '2025-03-01', 2500.00, 220.00, 200.00, 8),
    (9, '2025-03-01', 1600.00, 80.00, 40.00, 9),
    (10, '2025-03-01', 2300.00, 180.00, 130.00, 10);
INSERT INTO ClienteProveedor (
        id,
        nombre,
        apellido,
        telefono,
        email,
        tipo,
        saldo
    )
VALUES (
        1,
        'Juan',
        'Torres',
        '555-1010',
        'juan.torres@cliente.com',
        'Cliente',
        350.00
    ),
    (
        2,
        'Laura',
        'Vega',
        '555-2020',
        'laura.vega@cliente.com',
        'Cliente',
        120.50
    ),
    (
        3,
        'Andrés',
        'Castillo',
        '555-3030',
        'andres.castillo@cliente.com',
        'Cliente',
        0.00
    ),
    (
        4,
        'Paula',
        'Maldonado',
        '555-4040',
        'paula.maldonado@cliente.com',
        'Cliente',
        210.75
    ),
    (
        5,
        'Hugo',
        'Díaz',
        '555-5050',
        'hugo.diaz@cliente.com',
        'Cliente',
        999.99
    ),
    (
        6,
        'Distribuciones XYZ',
        '(sin apellido)',
        '555-6060',
        'contacto@xyz.com',
        'Proveedor',
        1200.00
    ),
    (
        7,
        'Suministros ABC',
        '(sin apellido)',
        '555-7070',
        'ventas@suministrosabc.com',
        'Proveedor',
        550.00
    ),
    (
        8,
        'ElectroGlobal',
        '(sin apellido)',
        '555-8080',
        'info@electroglobal.com',
        'Proveedor',
        3000.00
    ),
    (
        9,
        'Papelería Universal',
        '(sin apellido)',
        '555-9090',
        'contact@papeluniversal.com',
        'Proveedor',
        75.00
    ),
    (
        10,
        'TecnoImport',
        '(sin apellido)',
        '555-0101',
        'sales@tecnoimport.com',
        'Proveedor',
        450.00
    );
INSERT INTO InventarioCompras (
        idCompra,
        fecha,
        totalCompras,
        idClienteProveedor
    )
VALUES (1, '2025-02-10', 500.00, 6),
    (2, '2025-02-12', 150.75, 7),
    (3, '2025-02-15', 980.00, 8),
    (4, '2025-02-18', 120.00, 9),
    (5, '2025-02-20', 450.00, 10),
    (6, '2025-03-01', 700.50, 6),
    (7, '2025-03-03', 340.90, 7),
    (8, '2025-03-05', 1000.00, 8),
    (9, '2025-03-06', 200.00, 9),
    (10, '2025-03-07', 650.00, 10);
INSERT INTO Venta (
        idVenta,
        fecha,
        total,
        idEmpleado,
        idClienteProveedor
    )
VALUES (1, '2025-03-10', 300.00, 1, 1),
    (2, '2025-03-10', 120.00, 2, 2),
    (3, '2025-03-11', 450.50, 3, 3),
    (4, '2025-03-12', 1000.00, 4, 4),
    (5, '2025-03-12', 275.75, 5, 5),
    (6, '2025-03-13', 999.99, 6, 1),
    (7, '2025-03-14', 150.00, 7, 2),
    (8, '2025-03-14', 320.00, 8, 3),
    (9, '2025-03-15', 880.00, 9, 4),
    (10, '2025-03-16', 560.25, 10, 5);
INSERT INTO DetalleVenta (idDetalleVenta, idVenta, producto)
VALUES -- Venta 1
    (1, 1, 'Laptop Lenovo'),
    (2, 1, 'Mouse Inalámbrico'),
    -- Venta 2
    (3, 2, 'Teclado Mecánico'),
    (4, 2, 'Mouse Pad'),
    -- Venta 3
    (5, 3, 'Monitor 24"'),
    (6, 3, 'Cable HDMI'),
    -- Venta 4
    (7, 4, 'Impresora Multifunción'),
    (8, 4, 'Cartucho de Tinta'),
    -- Venta 5
    (9, 5, 'Silla de Oficina'),
    (10, 5, 'Alfombrilla para Silla'),
    -- Venta 6
    (11, 6, 'Smartphone Android'),
    (12, 6, 'Funda Protectora'),
    -- Venta 7
    (13, 7, 'Parlantes Bluetooth'),
    (14, 7, 'Tarjeta de Memoria'),
    -- Venta 8
    (15, 8, 'Cámara Web HD'),
    (16, 8, 'Auriculares con Micrófono'),
    -- Venta 9
    (17, 9, 'Disco Duro Externo'),
    (18, 9, 'Cable USB 3.0'),
    -- Venta 10
    (19, 10, 'Router Wi-Fi'),
    (20, 10, 'Adaptador de Red USB');
INSERT INTO Contabilidad (idContabilidad, ingresos, egresos)
VALUES (1, 2000.00, 500.00),
    (2, 1500.00, 300.00),
    (3, 2500.50, 1200.00),
    (4, 500.00, 50.00),
    (5, 3200.00, 1800.00),
    (6, 980.00, 100.00),
    (7, 4000.00, 2500.00),
    (8, 1600.00, 700.00),
    (9, 2100.00, 1000.00),
    (10, 2750.00, 800.00);
INSERT INTO Transaccion (idTransaccion, idContabilidad, descripcion)
VALUES -- Contabilidad 1
    (1, 1, 'Venta a cliente #1'),
    (2, 1, 'Pago de servicio de limpieza'),
    -- Contabilidad 2
    (3, 2, 'Venta a cliente #2'),
    (4, 2, 'Compra de suministros'),
    -- Contabilidad 3
    (5, 3, 'Venta mayorista'),
    (6, 3, 'Pago de alquiler'),
    -- Contabilidad 4
    (7, 4, 'Venta de accesorios'),
    (8, 4, 'Pago de publicidad'),
    -- Contabilidad 5
    (9, 5, 'Cobro de factura pendiente'),
    (10, 5, 'Pago a proveedor #8'),
    -- Contabilidad 6
    (11, 6, 'Venta en línea'),
    (12, 6, 'Compra de papelería'),
    -- Contabilidad 7
    (13, 7, 'Ingreso por servicios técnicos'),
    (14, 7, 'Pago de salarios'),
    -- Contabilidad 8
    (15, 8, 'Venta especial a cliente #5'),
    (16, 8, 'Gastos de transporte'),
    -- Contabilidad 9
    (17, 9, 'Ingreso por consultoría'),
    (18, 9, 'Pago a proveedor #10'),
    -- Contabilidad 10
    (19, 10, 'Cobro de proyecto'),
    (20, 10, 'Pago de impuestos');

-- (Opcional) Reiniciar el contador de ID
ALTER TABLE Usuario AUTO_INCREMENT = 1;
-- Insertar Admins y Empleados
INSERT INTO Usuario (
        nombreUsuario,
        contraseña,
        cargo,
        correo,
        idEmpleado
    )
VALUES (
        'carlos.perez',
        'Carlos360@',
        'empleado',
        'carlos.perez@empresa.com',
        1
    ),
    (
        'maria.lopez',
        'Maria360@',
        'empleado',
        'maria.lopez@empresa.com',
        2
    ),
    (
        'javier.garcia',
        'Javier360@',
        'empleado',
        'javier.garcia@empresa.com',
        3
    ),
    (
        'ana.martinez',
        'Ana360@',
        'admin',
        'ana.martinez@empresa.com',
        4
    ),
    (
        'lucia.rodriguez',
        'Lucia360@',
        'empleado',
        'lucia.rodriguez@empresa.com',
        5
    ),
    (
        'david.fernandez',
        'David360@',
        'empleado',
        'david.fernandez@empresa.com',
        6
    ),
    (
        'marta.gomez',
        'Marta360@',
        'empleado',
        'marta.gomez@empresa.com',
        7
    ),
    (
        'sofia.sanchez',
        'Sofia360@',
        'admin',
        'sofia.sanchez@empresa.com',
        8
    ),
    (
        'raul.hernandez',
        'Raul360@',
        'empleado',
        'raul.hernandez@empresa.com',
        9
    ),
    (
        'elena.jimenez',
        'Elena360@',
        'empleado',
        'elena.jimenez@empresa.com',
        10
    );
-- Insertar Clientes (sin idEmpleado)
INSERT INTO Usuario (nombreUsuario, contraseña, cargo, correo)
VALUES (
        'pedro.gonzalez',
        'Pedro360@',
        'cliente',
        'pedro.gonzalez@empresa.com'
    ),
    (
        'laura.morales',
        'Laura360@',
        'cliente',
        'laura.morales@empresa.com'
    ),
    (
        'andres.castillo',
        'Andres360@',
        'cliente',
        'andres.castillo@empresa.com'
    ),
    (
        'carolina.rivas',
        'Carolina360@',
        'cliente',
        'carolina.rivas@empresa.com'
    );



    INSERT INTO Producto (
        nombre,
        descripcion,
        precioUnitario,
        stock,
        categoria,
        codigoBarras
    )
VALUES (
        'Proteína Whey',
        'Proteína de suero de leche sabor vainilla',
        35.50,
        100,
        'Suplementos',
        '1234567890123'
    ),
    (
        'Creatina Monohidrato',
        'Creatina pura en polvo para aumentar fuerza',
        19.99,
        50,
        'Suplementos',
        '2345678901234'
    ),
    (
        'BCAA 2:1:1',
        'Aminoácidos ramificados para recuperación muscular',
        24.99,
        200,
        'Suplementos',
        '3456789012345'
    ),
    (
        'Guantes de entrenamiento',
        'Guantes para levantar pesas con agarre antideslizante',
        14.99,
        150,
        'Accesorios',
        '4567890123456'
    ),
    (
        'Silla de abdominales',
        'Silla ergonómica para ejercicios de abdominales',
        120.00,
        10,
        'Equipos',
        '5678901234567'
    ),
    (
        'Banda elástica',
        'Banda de resistencia para entrenamiento funcional',
        9.99,
        300,
        'Accesorios',
        '6789012345678'
    ),
    (
        'Cinta de correr',
        'Cinta de correr eléctrica, 12 niveles de velocidad',
        599.99,
        5,
        'Equipos',
        '7890123456789'
    ),
    (
        'Barra olímpica',
        'Barra de acero para levantamiento de pesas',
        199.99,
        20,
        'Equipos',
        '8901234567890'
    ),
    (
        'Zapatillas de running',
        'Zapatillas deportivas para correr, ligeras y cómodas',
        69.99,
        100,
        'Ropa',
        '9012345678901'
    ),
    (
        'Botellas de agua',
        'Botellas deportivas de 750ml, diseño ergonómico',
        6.99,
        500,
        'Accesorios',
        '0123456789012'
    );


    INSERT INTO DetalleCompra (idCompra, idProducto, cantidad, precioUnitario)
VALUES (1, 1, 2, 35.50),
    (1, 3, 1, 24.99),
    (2, 4, 5, 14.99),
    (2, 2, 3, 19.99),
    (3, 5, 1, 120.00),
    (3, 6, 10, 9.99),
    (4, 7, 1, 599.99),
    (4, 8, 2, 199.99),
    (5, 9, 4, 69.99),
    (5, 10, 20, 6.99);



INSERT INTO Usuario (
        idEmpleado,
        nombreUsuario,
        contraseña,
        cargo,
        correo
    )
VALUES (
        1002457890,
        'carlos.perez',
        'Carlos360@',
        'empleado',
        'carlos.perez@empresa.com'
    ),
    (
        1003789123,
        'maria.lopez',
        'Maria360@',
        'empleado',
        'maria.lopez@empresa.com'
    ),
    (
        1004567123,
        'javier.garcia',
        'Javier360@',
        'empleado',
        'javier.garcia@empresa.com'
    ),
    (
        1005678234,
        'ana.martinez',
        'Ana360@',
        'admin',
        'ana.martinez@empresa.com'
    ),
    (
        1006789345,
        'lucia.rodriguez',
        'Lucia360@',
        'empleado',
        'lucia.rodriguez@empresa.com'
    ),
    (
        1007890456,
        'david.fernandez',
        'David360@',
        'empleado',
        'david.fernandez@empresa.com'
    ),
    (
        1008901567,
        'marta.gomez',
        'Marta360@',
        'empleado',
        'marta.gomez@empresa.com'
    ),
    (
        1010012678,
        'sofia.sanchez',
        'Sofia360@',
        'admin',
        'sofia.sanchez@empresa.com'
    ),
    (
        1011123789,
        'raul.hernandez',
        'Raul360@',
        'empleado',
        'raul.hernandez@empresa.com'
    ),
    (
        1012234890,
        'elena.jimenez',
        'Elena360@',
        'empleado',
        'elena.jimenez@empresa.com'
    ),
    (
        1013345901,
        'pedro.gonzalez',
        'Pedro360@',
        'cliente',
        'pedro.gonzalez@empresa.com'
    ),
    (
        1014456012,
        'laura.morales',
        'Laura360@',
        'cliente',
        'laura.morales@empresa.com'
    ),
    (
        1015567123,
        'andres.castillo',
        'Andres360@',
        'cliente',
        'andres.castillo@empresa.com'
    ),
    (
        1016678234,
        'carolina.rivas',
        'Carolina360@',
        'cliente',
        'carolina.rivas@empresa.com'
    );



INSERT INTO Empleado (
        idEmpleado,
        nombre,
        apellido,
        salario,
        fechaContratacion,
        cargo,
        telefono,
        email
    )
VALUES (
        1002457890,
        'Carlos',
        'Perez',
        2500000,
        '2022-05-10',
        'empleado',
        '3001234567',
        'carlos.perez@empresa.com'
    ),
    (
        1003789123,
        'Maria',
        'Lopez',
        2400000,
        '2022-06-15',
        'empleado',
        '3007654321',
        'maria.lopez@empresa.com'
    ),
    (
        1005893211,
        'Javier',
        'Garcia',
        2550000,
        '2021-11-20',
        'empleado',
        '3012345678',
        'javier.garcia@empresa.com'
    ),
    (
        1008234567,
        'Ana',
        'Martinez',
        3500000,
        '2020-02-28',
        'admin',
        '3023456789',
        'ana.martinez@empresa.com'
    ),
    (
        1009345678,
        'Lucia',
        'Rodriguez',
        2450000,
        '2022-01-17',
        'empleado',
        '3034567890',
        'lucia.rodriguez@empresa.com'
    ),
    (
        1010456789,
        'David',
        'Fernandez',
        2600000,
        '2023-03-05',
        'empleado',
        '3045678901',
        'david.fernandez@empresa.com'
    ),
    (
        1011567890,
        'Marta',
        'Gomez',
        2350000,
        '2022-09-09',
        'empleado',
        '3056789012',
        'marta.gomez@empresa.com'
    ),
    (
        1012678901,
        'Sofia',
        'Sanchez',
        3600000,
        '2019-12-12',
        'admin',
        '3067890123',
        'sofia.sanchez@empresa.com'
    ),
    (
        1013789012,
        'Raul',
        'Hernandez',
        2480000,
        '2023-06-21',
        'empleado',
        '3078901234',
        'raul.hernandez@empresa.com'
    ),
    (
        1014890123,
        'Elena',
        'Jimenez',
        2430000,
        '2022-08-08',
        'empleado',
        '3089012345',
        'elena.jimenez@empresa.com'
    );




DELETE FROM Usuario;


INSERT INTO Usuario (
        idEmpleado,
        nombreUsuario,
        contraseña,
        cargo,
        correo
    )
VALUES (
        1002457890,
        'carlos perez',
        'Carlos360@',
        'empleado',
        'carlos.perez@empresa.com'
    ),
    (
        1003789123,
        'maria lopez',
        'Maria360@',
        'empleado',
        'maria.lopez@empresa.com'
    ),
    (
        1004567123,
        'javier garcia',
        'Javier360@',
        'empleado',
        'javier.garcia@empresa.com'
    ),
    (
        1005678234,
        'ana martinez',
        'Ana360@',
        'admin',
        'ana.martinez@empresa.com'
    ),
    (
        1006789345,
        'lucia rodriguez',
        'Lucia360@',
        'empleado',
        'lucia.rodriguez@empresa.com'
    ),
    (
        1007890456,
        'david fernandez',
        'David360@',
        'empleado',
        'david.fernandez@empresa.com'
    ),
    (
        1008901567,
        'marta gomez',
        'Marta360@',
        'empleado',
        'marta.gomez@empresa.com'
    ),
    (
        1010012678,
        'sofia sanchez',
        'Sofia360@',
        'admin',
        'sofia.sanchez@empresa.com'
    ),
    (
        1011123789,
        'raul hernandez',
        'Raul360@',
        'empleado',
        'raul.hernandez@empresa.com'
    ),
    (
        1012234890,
        'elena jimenez',
        'Elena360@',
        'empleado',
        'elena.jimenez@empresa.com'
    ),
    (
        1013345901,
        'pedro gonzalez',
        'Pedro360@',
        'cliente',
        'pedro.gonzalez@empresa.com'
    ),
    (
        1014456012,
        'laura morales',
        'Laura360@',
        'cliente',
        'laura.morales@empresa.com'
    ),
    (
        1015567123,
        'andres castillo',
        'Andres360@',
        'cliente',
        'andres.castillo@empresa.com'
    ),
    (
        1016678234,
        'carolina rivas',
        'Carolina360@',
        'cliente',
        'carolina.rivas@empresa.com'
    );



INSERT INTO ClienteProveedor (
        id,
        nombre,
        apellido,
        telefono,
        email,
        tipo,
        saldo
    )
VALUES (
        '1723456789',
        'María',
        'Gómez',
        '0987654321',
        'maria.gomez@email.com',
        'Cliente',
        120.50
    ),
    (
        '0912345678',
        'Carlos',
        'Pérez',
        '0991122334',
        'carlos.perez@email.com',
        'Cliente',
        0.00
    ),
    (
        '1009876543',
        'Andrea',
        'Martínez',
        '0989988776',
        'andrea.martinez@email.com',
        'Proveedor',
        -250.00
    ),
    (
        '0601122334',
        'Luis',
        'Ramírez',
        '0977432100',
        'luis.ramirez@email.com',
        'Cliente',
        45.75
    ),
    (
        '1503344556',
        'Sofía',
        'Lozano',
        '0983344556',
        'sofia.lozano@email.com',
        'Proveedor',
        -180.00
    ),
    (
        '1102233445',
        'Jorge',
        'Salazar',
        '0961234567',
        'jorge.salazar@email.com',
        'Cliente',
        75.00
    ),
    (
        '0809876543',
        'Daniela',
        'Ríos',
        '0987112233',
        'daniela.rios@email.com',
        'Proveedor',
        -100.00
    ),
    (
        '1301122334',
        'Esteban',
        'Cedeño',
        '0955566778',
        'esteban.cedeno@email.com',
        'Cliente',
        200.00
    ),
    (
        '1712345678',
        'Valeria',
        'Navarrete',
        '0986543210',
        'valeria.navarrete@email.com',
        'Proveedor',
        -320.75
    ),
    (
        '1205566778',
        'Pedro',
        'Mendoza',
        '0969988776',
        'pedro.mendoza@email.com',
        'Cliente',
        0.00
    );




INSERT INTO Cliente(
        id,
        nombre,
        apellido,
        telefono,
        email,
        saldo,
        tipo_membresia
    )
VALUES (
        '1012345678',
        'Juan',
        'Pérez',
        '3001234567',
        'juan.perez@email.com',
        150000,
        '1 año'
    ),
    (
        '1023456789',
        'Ana',
        'Gómez',
        '3002345678',
        'ana.gomez@email.com',
        250000,
        '3 meses'
    ),
    (
        '1034567890',
        'Carlos',
        'Martínez',
        '3003456789',
        'carlos.martinez@email.com',
        80000,
        '6 meses'
    ),
    (
        '1045678901',
        'Laura',
        'López',
        '3004567890',
        'laura.lopez@email.com',
        40000,
        '1 año'
    ),
    (
        '1056789012',
        'Pedro',
        'Sánchez',
        '3005678901',
        'pedro.sanchez@email.com',
        220000,
        '3 meses'
    ),
    (
        '1067890123',
        'María',
        'Ramírez',
        '3006789012',
        'maria.ramirez@email.com',
        180000,
        '6 meses'
    );