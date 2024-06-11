<?php
include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$query = "SELECT idFactura FROM facturas ORDER BY idFactura DESC LIMIT 1";
$response = mysqli_query($conexion, $query);

if ($row = mysqli_fetch_assoc($response)) {
    echo $row['idFactura'];
} else {
    echo "-1";
}
?>