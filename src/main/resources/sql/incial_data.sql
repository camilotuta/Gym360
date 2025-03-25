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
INSERT INTO Usuario (
        idUsuario,
        nombreUsuario,
        contraseña,
        cargo,
        idEmpleado
    )
VALUES (
        1,
        'carlos_perez',
        'pwdCarlos123',
        'vendedor',
        1
    ),
    (
        2,
        'maria_lopez',
        'pwdMaria456',
        'vendedor',
        2
    ),
    (
        3,
        'javier_garcia',
        'pwdJavier789',
        'supervisor',
        3
    ),
    (
        4,
        'ana_martinez',
        'pwdAnaABC',
        'gerente',
        4
    ),
    (
        5,
        'lucia_rodriguez',
        'pwdLuciaDEF',
        'vendedor',
        5
    ),
    (
        6,
        'david_fernandez',
        'pwdDavidGHI',
        'supervisor',
        6
    ),
    (
        7,
        'marta_gomez',
        'pwdMartaJKL',
        'vendedor',
        7
    ),
    (
        8,
        'sofia_sanchez',
        'pwdSofiaMNO',
        'admin',
        8
    ),
    (
        9,
        'raul_hernandez',
        'pwdRaulPQR',
        'vendedor',
        9
    ),
    (
        10,
        'elena_jimenez',
        'pwdElenaSTU',
        'admin',
        10
    );