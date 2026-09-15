-- =========================================
-- 1. Tabla Empleado
-- =========================================
DROP TABLE IF EXISTS Empleado;
CREATE TABLE Empleado (
    idEmpleado INTEGER PRIMARY KEY,
    -- Ya no AUTOINCREMENT
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    salario REAL,
    fechaContratacion TEXT,
    cargo TEXT,
    telefono TEXT,
    email TEXT
);
-- =========================================
-- 2. Tabla Nomina
--  (Relacionada con Empleado)
-- =========================================
DROP TABLE IF EXISTS Nomina;
CREATE TABLE Nomina (
    idNomina       INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha          TEXT,
    salarioBase    REAL,
    deducciones    REAL,
    bonificaciones REAL,
    idEmpleado     INTEGER, -- FK a Empleado
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado)
);

-- =========================================
-- 3. Tabla ClienteProveedor
-- =========================================
ALTER TABLE Cliente
ALTER COLUMN estado
SET DEFAULT 'inactivo';
ALTER TABLE Cliente
ADD COLUMN estado TEXT;
DROP TABLE IF EXISTS Cliente;
CREATE TABLE Cliente (
    id TEXT PRIMARY KEY,
    -- Ahora se usa como cédula
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    telefono TEXT,
    email TEXT,
    contraseña TEXT NOT NULL,
    -- Nuevo campo para almacenar la contraseña
    saldo REAL,
    tipo_membresia TEXT CHECK(
        tipo_membresia IN ('1 año', '3 meses', '6 meses')
    )
);

-- =========================================
-- 4. Tabla InventarioCompras
--  (Relacionada con ClienteProveedor)
-- =========================================
DROP TABLE IF EXISTS InventarioCompras;
CREATE TABLE InventarioCompras (
    idCompra           INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha              TEXT,
    totalCompras       REAL
);

-- =========================================
-- 5. Tabla Venta
--  (Relacionada con Empleado y ClienteProveedor)
-- =========================================
DROP TABLE IF EXISTS Venta;
CREATE TABLE Venta (
    idVenta            INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha              TEXT,
    total              REAL,
    idEmpleado         INTEGER, -- FK a Empleado (quien realiza la venta)
    idClienteProveedor INTEGER, -- FK a ClienteProveedor (el Cliente)
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado),
    FOREIGN KEY (idClienteProveedor) REFERENCES ClienteProveedor(id)
);

-- =========================================
-- 5.1. DetalleVenta
--  Para almacenar la lista de productosVendidos
-- =========================================
DROP TABLE IF EXISTS DetalleVenta;
CREATE TABLE DetalleVenta (
    idDetalleVenta INTEGER PRIMARY KEY AUTOINCREMENT,
    idVenta        INTEGER NOT NULL,  -- FK a Venta
    idProducto       INTEGER NOT NULL,
    FOREIGN KEY (idVenta) REFERENCES Venta(idVenta),
    FOREIGN KEY (idVenta) REFERENCES Producto(idProducto)
);

-- =========================================
-- 6. Tabla Contabilidad
--  (Podría relacionarse con Venta, Nomina, InventarioCompras
--   según la lógica contable deseada)
-- =========================================
DROP TABLE IF EXISTS Contabilidad;
CREATE TABLE Contabilidad (
    idContabilidad INTEGER PRIMARY KEY AUTOINCREMENT,
    ingresos       REAL,
    egresos        REAL
);

-- =========================================
-- 6.1. Tabla Transaccion
--  Para almacenar la lista de transacciones asociadas
--  a la contabilidad
-- =========================================
DROP TABLE IF EXISTS Transaccion;
CREATE TABLE Transaccion (
    idTransaccion   INTEGER PRIMARY KEY AUTOINCREMENT,
    idContabilidad  INTEGER NOT NULL, -- FK a Contabilidad
    descripcion     TEXT,
    FOREIGN KEY (idContabilidad) REFERENCES Contabilidad(idContabilidad)
);


-- =========================================
-- Tabla Producto
-- =========================================
DROP TABLE IF EXISTS Producto;
CREATE TABLE Producto (
    idProducto INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre          TEXT NOT NULL,
    descripcion     TEXT,
    precioUnitario  REAL NOT NULL,
    stock           INTEGER NOT NULL,
    categoria       TEXT,
    codigoBarras    TEXT UNIQUE
);

-- =========================================
-- Tabla DetalleCompra
-- Relaciona las compras con los productos adquiridos
-- =========================================
DROP TABLE IF EXISTS DetalleCompra;
CREATE TABLE DetalleCompra (
    idDetalleCompra INTEGER PRIMARY KEY AUTOINCREMENT,
    idCompra        INTEGER NOT NULL,  -- FK a InventarioCompras
    idProducto      INTEGER NOT NULL,  -- FK a Producto
    cantidad        INTEGER NOT NULL,
    precioUnitario  REAL NOT NULL,
    FOREIGN KEY (idCompra) REFERENCES InventarioCompras(idCompra),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);

-- =========================================
-- Tabla DetalleVenta (modificada)
-- Relaciona las ventas con los productos vendidos
-- =========================================
DROP TABLE IF EXISTS DetalleVenta;
CREATE TABLE DetalleVenta (
    idDetalleVenta INTEGER PRIMARY KEY AUTOINCREMENT,
    idVenta        INTEGER NOT NULL,  -- FK a Venta
    idProducto     INTEGER NOT NULL,  -- FK a Producto
    cantidad       INTEGER NOT NULL,
    precioUnitario REAL NOT NULL,
    FOREIGN KEY (idVenta) REFERENCES Venta(idVenta),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);


DROP TABLE IF EXISTS Usuario;
<<<<<<< HEAD
CREATE TABLE Usuario (
    idUsuario INTEGER PRIMARY KEY AUTOINCREMENT,
=======

CREATE TABLE Usuario (
    idEmpleado INTEGER PRIMARY KEY, -- actúa como cédula, PK y es único por definición
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3
    nombreUsuario TEXT NOT NULL UNIQUE,
    contraseña TEXT NOT NULL,
    cargo TEXT NOT NULL,
    correo TEXT NOT NULL UNIQUE,
<<<<<<< HEAD
    -- Ejemplos: 'admin', 'vendedor', 'supervisor', 'gerente', etc.
    idEmpleado INTEGER NULL,
    -- FK a la tabla Empleado (campo idEmpleado)
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado)
);
=======
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado)
);





CREATE TABLE Cliente_temp (
    id TEXT PRIMARY KEY,
    nombre TEXT,
    apellido TEXT,
    telefono TEXT,
    email TEXT,
    contraseña TEXT,
    saldo REAL,
    tipo_membresia TEXT,
    estado TEXT DEFAULT 'inactivo'
);


INSERT INTO Cliente_temp (
        id,
        nombre,
        apellido,
        telefono,
        email,
        contraseña,
        saldo,
        tipo_membresia,
        estado
    )
SELECT id,
    nombre,
    apellido,
    telefono,
    email,
    contraseña,
    saldo,
    tipo_membresia,
    COALESCE(estado, 'inactivo')
FROM Cliente;


DROP TABLE Cliente;


ALTER TABLE Cliente_temp
    RENAME TO Cliente;
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3
