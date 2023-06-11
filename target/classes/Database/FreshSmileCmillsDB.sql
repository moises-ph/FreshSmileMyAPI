-- Eliminar base de datos existente con ese nombre --
DROP DATABASE fresh_smile_cmills;
-- Crear la base de datos
CREATE DATABASE fresh_smile_cmills;

-- Usar la base de datos
USE fresh_smile_cmills;

-- Tabla de paciente --
CREATE TABLE paciente (
                          identificacion_paciente INT(20) PRIMARY KEY,
                          tipo_documento VARCHAR(40),
                          nombre_completo VARCHAR(400),
                          telefono VARCHAR(20),
                          direccion VARCHAR(100),
                          correo VARCHAR(100) unique,
                          contraseña VARCHAR(8),
                          estado BIT(1) DEFAULT 1,
                          fecha_registro DATETIME DEFAULT NOW()
);

-- Tabla de especialistas --
CREATE TABLE especialista (
                              identificacion_especialista INT(20) PRIMARY KEY,
                              tipo_documento VARCHAR(40),
                              nombre_completo VARCHAR(100),
                              telefono VARCHAR(20),
                              direccion VARCHAR(100),
                              especialidad VARCHAR(50),
                              descripcion VARCHAR(512),
                              foto_perfil BLOB,
                              correo VARCHAR(100) unique,
                              contraseña VARCHAR(100),
                              fecha_registro DATETIME DEFAULT NOW()
);

-- Tabla de procedimientos --
CREATE TABLE procedimientos (
                                identificacion_procedimientos INT PRIMARY KEY AUTO_INCREMENT,
                                nombre VARCHAR(100),
                                descripcion VARCHAR(200),
                                costo DECIMAL(10, 3)
);

-- Tabla codigo_administrador
CREATE TABLE codigo_administrador(
                                     id_codigo INT PRIMARY KEY auto_increment,
                                     codigo VARCHAR(10)
);
-- Tabla de citas --
CREATE TABLE citas (
                       identificacion_citas INT PRIMARY KEY AUTO_INCREMENT,
                       numero_documento INT,
                       nombre_completo VARCHAR(400),
                       tipo_documento VARCHAR(100),
                       fecha DATE,
                       hora TIME,
                       id_paciente INT,
                       id_especialista INT,
                       id_procedimiento INT,
                       estado_cita ENUM('Confirmada', 'Realizada', 'Cancelada'),
                       estado BIT(1) DEFAULT 1,
                       fecha_de_creacion DATETIME DEFAULT NOW(),
                       FOREIGN KEY (id_paciente) REFERENCES paciente(identificacion_paciente),
                       FOREIGN KEY (id_especialista) REFERENCES especialista(identificacion_especialista),
                       FOREIGN KEY (id_procedimiento) REFERENCES procedimientos(identificacion_procedimientos)
);

-- Procedimientos de almacenados --
DELIMITER $$
CREATE PROCEDURE ConsultarPacientePorIdentificacion(
    IN p_identificacion INT
)
BEGIN
SELECT * FROM paciente WHERE identificacion_paciente = p_identificacion;
END $$

DELIMITER $$
CREATE PROCEDURE ConsultarPacientePorEmail(
    IN p_correo varchar(100)
)
BEGIN
    SELECT * FROM paciente WHERE correo = p_correo;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE CrearPaciente(
    IN p_identificacion INT,
    IN p_tipo_documento VARCHAR(40),
    IN p_nombre_completo VARCHAR(400),
    IN p_telefono VARCHAR(20),
    IN p_direccion VARCHAR(100),
    IN p_correo VARCHAR(100),
    IN p_contraseña VARCHAR(8)
)
BEGIN
INSERT INTO paciente (identificacion_paciente, tipo_documento, nombre_completo, telefono, direccion, correo, contraseña)
VALUES (p_identificacion, p_tipo_documento, p_nombre_completo, p_telefono, p_direccion, p_correo, p_contraseña);
SELECT 'Paciente creado exitosamente.' AS Mensaje;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE ModificarPaciente(
    IN p_identificacion INT,
    IN p_tipo_documento VARCHAR(40),
    IN p_nombre_completo VARCHAR(400),
    IN p_telefono VARCHAR(20),
    IN p_direccion VARCHAR(100),
    IN p_correo VARCHAR(100),
    IN p_contraseña VARCHAR(8)
)
BEGIN
UPDATE paciente
SET tipo_documento = p_tipo_documento, nombre_completo = p_nombre_completo, telefono = p_telefono,
    direccion = p_direccion, correo = p_correo, contraseña = p_contraseña
WHERE identificacion_paciente = p_identificacion;
SELECT 'Paciente modificado exitosamente.' AS Mensaje;
END $$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE EliminarPaciente(
    IN p_identificacion INT
)
BEGIN
DELETE FROM paciente WHERE identificacion_paciente = p_identificacion;
SELECT 'Paciente eliminado exitosamente.' AS Mensaje;
END $$

DELIMITER $$
CREATE PROCEDURE CambiarEstadoPaciente(
    in p_identificacion INT,
    in new_estado bit
)
BEGIN
UPDATE paciente set estado = new_estado where identificacion_paciente = p_identificacion;
Select "Estado del paciente cambiado correctamente" as Message;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ConsultarEspecialistaPorIdentificacion(
    IN p_identificacion INT
)
BEGIN
SELECT * FROM especialista WHERE identificacion_especialista = p_identificacion;
END $$

DELIMITER $$
CREATE PROCEDURE ConsultarEspecialistaPorEmail(
    IN p_correo varchar(100)
)
BEGIN
    SELECT * FROM especialista WHERE correo = p_correo;
END $$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE CrearEspecialista(
    IN p_identificacion INT,
    IN p_tipo_documento VARCHAR(40),
    IN p_nombre_completo VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_direccion VARCHAR(100),
    IN p_especialidad VARCHAR(50),
    IN p_descripcion VARCHAR(200),
    IN p_foto_perfil BLOB,
    IN p_correo VARCHAR(100),
    IN p_contraseña VARCHAR(100)
)
BEGIN
INSERT INTO especialista (identificacion_especialista, tipo_documento, nombre_completo, telefono, direccion, especialidad, descripcion, foto_perfil, correo, contraseña)
VALUES (p_identificacion, p_tipo_documento, p_nombre_completo, p_telefono, p_direccion, p_especialidad, p_descripcion, p_foto_perfil, p_correo, p_contraseña);
SELECT 'Especialista creado exitosamente.' AS Mensaje;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ModificarEspecialista(
    IN p_identificacion INT,
    IN p_tipo_documento VARCHAR(40),
    IN p_nombre_completo VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_direccion VARCHAR(100),
    IN p_especialidad VARCHAR(50),
    IN p_descripcion VARCHAR(200),
    IN p_foto_perfil BLOB,
    IN p_correo VARCHAR(100),
    IN p_contraseña VARCHAR(100)
)
BEGIN
UPDATE especialista
SET tipo_documento = p_tipo_documento, nombre_completo = p_nombre_completo, telefono = p_telefono,
    direccion = p_direccion, especialidad = p_especialidad, descripcion = p_descripcion,
    foto_perfil = p_foto_perfil, correo = p_correo, contraseña = p_contraseña
WHERE identificacion_especialista = p_identificacion;
SELECT 'Especialista modificado exitosamente.' AS Mensaje;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE EliminarEspecialista(
    IN p_identificacion INT
)
BEGIN
DELETE FROM especialista WHERE identificacion_especialista = p_identificacion;
SELECT 'Especialista eliminado exitosamente.' AS Mensaje;
END $$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ConsultarProcedimientoPorIdentificacion(
    IN p_identificacion INT
)
BEGIN
SELECT * FROM procedimientos WHERE identificacion_procedimientos = p_identificacion;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE CrearProcedimiento(
    IN p_nombre VARCHAR(100),
    IN p_descripcion VARCHAR(200),
    IN p_costo DECIMAL(10, 3)
)
BEGIN
INSERT INTO procedimientos (nombre, descripcion, costo)
VALUES (p_nombre, p_descripcion, p_costo);
SELECT 'Procedimiento creado exitosamente.' AS Mensaje;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ModificarProcedimiento(
    IN p_identificacion INT,
    IN p_nombre VARCHAR(100),
    IN p_descripcion VARCHAR(200),
    IN p_costo DECIMAL(10, 3)
)
BEGIN
UPDATE procedimientos
SET nombre = p_nombre, descripcion = p_descripcion, costo = p_costo
WHERE identificacion_procedimientos = p_identificacion;
SELECT 'Procedimiento modificado exitosamente.' AS Mensaje;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE EliminarProcedimiento(
    IN p_identificacion INT
)
BEGIN
DELETE FROM procedimientos WHERE identificacion_procedimientos = p_identificacion;
SELECT 'Procedimiento eliminado exitosamente.' AS Mensaje;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ConsultarCitaPorIdentificacion(
    IN p_identificacion INT
)
BEGIN
SELECT * FROM citas WHERE identificacion_citas = p_identificacion;
END $$
DELIMITER ;

DELIMITER $$


DELIMITER $$

CREATE PROCEDURE crear_cita(
    IN p_numero_documento INT,
    IN p_nombre_completo VARCHAR(400),
    IN p_tipo_documento VARCHAR(100),
    IN p_fecha DATE,
    IN p_hora TIME,
    IN p_id_paciente INT,
    IN p_id_especialista INT,
    IN p_id_procedimiento INT,
    IN p_estado_cita ENUM('Confirmada', 'Realizada', 'Cancelada')
)
BEGIN
INSERT INTO citas(numero_documento, nombre_completo, tipo_documento, fecha, hora, id_paciente, id_especialista, id_procedimiento, estado_cita)
VALUES(p_numero_documento, p_nombre_completo, p_tipo_documento, p_fecha, p_hora, p_id_paciente, p_id_especialista, p_id_procedimiento, p_estado_cita);
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE modificar_cita(
    IN p_identificacion_citas INT,
    IN p_numero_documento INT,
    IN p_nombre_completo VARCHAR(400),
    IN p_tipo_documento VARCHAR(100),
    IN p_fecha DATE,
    IN p_hora TIME,
    IN p_id_paciente INT,
    IN p_id_especialista INT,
    IN p_id_procedimiento INT,
    IN p_estado_cita ENUM('Confirmada', 'Realizada', 'Cancelada')
)
BEGIN
UPDATE citas
SET numero_documento = p_numero_documento,
    nombre_completo = p_nombre_completo,
    tipo_documento = p_tipo_documento,
    fecha = p_fecha,
    hora = p_hora,
    id_paciente = p_id_paciente,
    id_especialista = p_id_especialista,
    id_procedimiento = p_id_procedimiento,
    estado_cita = p_estado_cita
WHERE identificacion_citas = p_identificacion_citas;
END $$

DELIMITER ;



DELIMITER $$

CREATE PROCEDURE ConsultarCitasFecha(
    IN p_fecha DATE
)
BEGIN
SELECT *
FROM citas
WHERE fecha = p_fecha;
END $$

DELIMITER ;
DELIMITER $$

CREATE PROCEDURE ModificarEstadoCita(
    IN p_id_cita INT,
    IN p_estado_cita ENUM('Confirmada', 'Realizada', 'Cancelada')
)
BEGIN
UPDATE citas
SET estado_cita = p_estado_cita
WHERE identificacion_citas = p_id_cita;
END $$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE ConsultarCitasPaciente(
    IN p_id_paciente INT
)
BEGIN
SELECT * FROM citas
WHERE id_paciente = p_id_paciente;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ConsultarCitasRangoFechas(
    IN p_fecha_inicio DATE,
    IN p_fecha_fin DATE
)
BEGIN
SELECT *
FROM citas
WHERE fecha BETWEEN p_fecha_inicio AND p_fecha_fin;
END $$

DELIMITER ;

DELIMITER $$

DELIMITER $$
CREATE PROCEDURE EliminarCita(
    IN p_identificacion INT
)
BEGIN
DELETE FROM citas WHERE identificacion_citas = p_identificacion;
SELECT 'Cita eliminada exitosamente.' AS Mensaje;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE consultarCodigoAdmin()
begin
SELECT * from Codigo_Administrador;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insertarCodigoAdministrador(
    IN p_codigo VARCHAR(10)
)
BEGIN
INSERT INTO Codigo_Administrador (codigo)
VALUES (p_codigo);
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE eliminarCodigoAdministrador(
    IN p_codigo VARCHAR(10)
)
BEGIN
DELETE FROM Codigo_Administrador
WHERE codigo = p_codigo;
END$$
DELIMITER ;

-- Datos de paciente
INSERT INTO paciente (identificacion_paciente, tipo_documento, nombre_completo, telefono, direccion, correo, contraseña)
VALUES (1094226206, 'Cédula de Ciudadanía', 'Macarena Montes', '3026987459', 'Manzana C Casa #220', 'bailamacarena@gmail.com', '12345678');

-- Datos de especialista
INSERT INTO especialista (identificacion_especialista, tipo_documento, nombre_completo, telefono, direccion, especialidad, descripcion, correo, contraseña)
VALUES (1106987459, 'Cédula de Ciudadanía', 'Monkey D.Luffy', '3204169874','Manzana D Casa #210', 'Ortodoncista', 'El Dr. Luffy es un destacado ortodoncista con una amplia experiencia en el campo de la ortodoncia. Su pasión por la sonrisa y el cuidado dental lo ha llevado a convertirse en un experto en el diagnóstico, prevención y tratamiento de las maloclusiones dentales.', 'luffyreypirata@outlook.com', '12345678');

-- Datos de procedimientos
INSERT INTO procedimientos (nombre, descripcion, costo)
VALUES ('Limpieza dental', 'Procedimiento de limpieza y remoción de placa dental', 50.000);

-- Datos de citas
INSERT INTO citas (numero_documento, tipo_documento, nombre_completo, fecha, hora, id_paciente, id_especialista, id_procedimiento, estado_cita)
VALUES (123456789, 'Cédula de Ciudadanía', 'Juan Pérez', '2023-06-06', '10:00:00', 1094226206, 1106987459, 1, 'Confirmada');

INSERT INTO Codigo_Administrador (codigo)
VALUES ('ABC123');

SELECT * FROM paciente;
SELECT * FROM especialista;
SELECT * FROM procedimientos;
SELECT * FROM citas;

CALL ConsultarPacientePorIdentificacion(1094226206);
CALL CrearPaciente(1163258795, 'Tarjeta de Identidad', 'Juan Perez', '3204698795', 'Calle Principal 123', 'juanito@yahoo.com', '12345678');
CALL ModificarPaciente(1163258795, 'Tarjeta de Identidad', 'Juan Colón', '3204698795', 'Calle Principal 456', 'juanitodino@example.com', '12345678');
CALL EliminarPaciente(1163258795);


CALL ConsultarEspecialistaPorIdentificacion(1106987459);
CALL CrearEspecialista(1166987459, 'Cédula de Ciudadanía', 'Nicole Robin', '3215698748', 'Calle Principal 123', 'Endodoncista', 'Especialista en endodoncia', null, 'aventurasconrobin@gmail.com', '12345678');
CALL ModificarEspecialista(1166987459, 'Cédula de Ciudadanía', 'Nicole Robin', '3002589758', 'Calle Principal 456', 'Ortodoncia', 'Especialista en endodoncia', null, 'robinicole@gmail.com', '12345678');
CALL EliminarEspecialista(1166987459);


CALL ConsultarProcedimientoPorIdentificacion(1);
CALL CrearProcedimiento('Limpieza Dental', 'Procedimiento de limpieza dental', 50.000);
CALL ModificarProcedimiento(1,'Extracción Dental', 'Procedimiento para extraer un diente dañado', 90.000);
CALL EliminarProcedimiento(2);

CALL crear_cita(1094220208, 'Marlin Sanchez', 'Cédula de Ciudadanía', '2023-06-10', '10:00:00', 1094226206, 1106987459, 1, 'Confirmada');
CALL modificar_cita(2, 1094220287, 'Marlin Sanchez', 'Cédula de Ciudadanía', '2023-06-10', '10:00:00', 1094226206, 1106987459, 1, 'Confirmada');
CALL ModificarEstadoCita(1, 'Cancelada');
CALL ConsultarCitasFecha('2023-06-07');
CALL ConsultarCitasRangoFechas('2023-06-01', '2023-06-30');
CALL EliminarCita(1);