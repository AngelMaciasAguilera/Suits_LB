<?php

include 'conexion.php';

$email = $_POST['email'];
$password = $_POST['password'];
$nombre = $_POST['nombre'];
$phone = $_POST['phone'];
$edad = $_POST['edad'];

$check_query = "SELECT * FROM clientes WHERE email = '$email'";
$check_result = mysqli_query($conexion, $check_query);

if (mysqli_num_rows($check_result) > 0) {
    echo "El email ya existe";
} else {
    $query = "INSERT INTO clientes(email,password,nombre,telefono,edad,esAdmin) VALUES('$email' ,'$password','$nombre','$phone','$edad','N')";
    $resultado = mysqli_query($conexion, $query);

    if ($resultado) {
        echo "datos insertados";
    } else {
        echo "Error en el registro";
    }
}

mysqli_close($conexion);

?>
