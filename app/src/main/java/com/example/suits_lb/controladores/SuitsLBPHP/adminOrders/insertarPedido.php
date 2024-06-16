<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$idNewFactura = $_POST['idNewFactura'];
$emailUser = $_POST['emailUser'];
$codRopaUser = $_POST['codRopaUser'];
$concepto = $_POST['concepto'];
$direccion = $_POST['direccion'];
$estado = $_POST['estado'];
$cantidad = $_POST['cantidad'];
$subtotal = $_POST['subtotal'];


// aqui escribimos codigo sql
$query ="INSERT INTO `pedidos`(`idFactura`, `email`, `codRopa`, `cantidad`, `concepto`, `direccion`, `subtotal`, `estadoPedido`) VALUES ('$idNewFactura','$emailUser','$codRopaUser','$cantidad','$concepto','$direccion','$subtotal','$estado')";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "pedido insertado";
}else{
    echo "pedido no insertado";
}
mysqli_close($conexion);

?>