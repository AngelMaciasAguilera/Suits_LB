<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$adminEmail = $_POST['adminEmail'];
$adminPassword = $_POST['adminPassword'];
$adminName = $_POST['adminName'];
$adminPhone = $_POST['adminPhone'];
$adminAge = $_POST['adminAge'];

$checkQuery = "SELECT * FROM clientes WHERE email = '$adminEmail' AND esAdmin = 'S'";
$checkResult = mysqli_query($conexion, $checkQuery);

if(mysqli_num_rows($checkResult) > 0){
    echo "El administrador ya está insertado";
} else {
    // Si el administrador no existe, insertar los datos
    $query ="INSERT INTO clientes(email,password,nombre,telefono,edad,esAdmin) VALUES ('$adminEmail','$adminPassword' ,'$adminName', '$adminPhone','$adminAge','S')";
    $resultado = mysqli_query($conexion, $query);

    if($resultado){
        echo "datos insertados";
    } else {
        echo "Datos no insertados";
    }
}

mysqli_close($conexion);

?>
