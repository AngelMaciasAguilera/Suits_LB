<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';

$estadoPedido = $_POST['estadoPedido'];
$numPedido = $_POST['numPedido'];



$query ="UPDATE pedidos SET estadoPedido ='$estadoPedido' WHERE numPedido LIKE '$numPedido'";

$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "pedido actualizado";
}else{
    echo "error en actualizacion";
}


mysqli_close($conexion);

?>