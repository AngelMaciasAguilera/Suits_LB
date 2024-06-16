<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$numPedidos = $_POST['numPedidos'];
$totalFactura = $_POST['totalFactura'];

// aqui escribimos codigo sql
$query ="INSERT INTO `facturas`(`numPedidos`, `precioTotal`) VALUES ('$numPedidos','$totalFactura') ";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "factura insertada";
}else{
    echo "factura no insertada";
}
mysqli_close($conexion);

?>