-- =========================================
-- 1. Tabla Empleado
-- =========================================
DROP TABLE IF EXISTS Empleado;
CREATE TABLE Empleado (
    idEmpleado INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre               TEXT NOT NULL,
    apellido             TEXT NOT NULL,
    salario              REAL,
    fechaContratacion    TEXT,       -- Se puede guardar como 'YYYY-MM-DD' o similar
    cargo                TEXT,
    telefono             TEXT,
    email                TEXT
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
DROP TABLE IF EXISTS ClienteProveedor;
CREATE TABLE ClienteProveedor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre    TEXT NOT NULL,
    apellido  TEXT NOT NULL,
    telefono  TEXT,
    email     TEXT,
    tipo      TEXT,   -- 'Cliente' o 'Proveedor'
    saldo     REAL
);

-- =========================================
-- 4. Tabla InventarioCompras
--  (Relacionada con ClienteProveedor)
-- =========================================
DROP TABLE IF EXISTS InventarioCompras;
CREATE TABLE InventarioCompras (
    idCompra           INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha              TEXT,
    totalCompras       REAL,
    idClienteProveedor INTEGER, -- FK a ClienteProveedor
    FOREIGN KEY (idClienteProveedor) REFERENCES ClienteProveedor(id)
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
    producto       TEXT NOT NULL,
    FOREIGN KEY (idVenta) REFERENCES Venta(idVenta)
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

DROP TABLE IF EXISTS Usuario;
CREATE TABLE Usuario (
    idUsuario INTEGER PRIMARY KEY AUTOINCREMENT,
    nombreUsuario TEXT NOT NULL UNIQUE,
    contraseña TEXT NOT NULL,
    cargo TEXT NOT NULL,
    -- Ejemplos: 'admin', 'vendedor', 'supervisor', 'gerente', etc.
    idEmpleado INTEGER,
    -- FK a la tabla Empleado (campo idEmpleado)
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado)
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
