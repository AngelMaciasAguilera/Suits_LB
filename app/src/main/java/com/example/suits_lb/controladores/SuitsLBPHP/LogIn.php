<?php 
include 'conexion.php';

$email = $_POST['email'];
$password = $_POST['password'];

$result = array();
$result['clientes'] = array();
$query = "SELECT * FROM clientes WHERE email LIKE '$email' AND password LIKE '$password' ";
$response = mysqli_query($conexion, $query);
$row = mysqli_fetch_assoc($response);

if ($row) {
    if ($row['esAdmin'] == 'S') {
        echo "2"; // Es admin
    } else {
        echo "1"; // No es admin
    }
} else {
    echo "0"; // No se encontró ningún registro con los datos proporcionados
}
?>
