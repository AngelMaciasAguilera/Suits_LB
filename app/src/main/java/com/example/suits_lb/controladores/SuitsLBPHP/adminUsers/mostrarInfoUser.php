<?php 
include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$email = $_POST['emailUser'];
$response = array();
$query = "SELECT * FROM clientes WHERE email = '$email'";
$result = mysqli_query($conexion, $query);

if ($row = mysqli_fetch_array($result)) {
    $response['email'] = $row['0'];
    $response['password'] = $row['1'];
    $response['nombre'] = $row['2'];
    $response['telefono'] = $row['3'];
    $response['edad'] = $row['4'];
    $response['esAdmin'] = $row['5'];
    $response['exito'] = "1";
} else {
    $response['mensaje'] = "No se encontró el cliente.";
}

echo json_encode($response);
?>
