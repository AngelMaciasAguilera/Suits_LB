<?php 
include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';


$result= array();
$result['orders'] =array();
$email = $_POST['emailUser'];
$query ="SELECT * FROM pedidos WHERE email = '$email' ;";
$responce = mysqli_query($conexion,$query);

while($row = mysqli_fetch_array($responce))
{
    $index['numPedido'] = $row['0'];
    $index['idFactura'] =$row['1'];
    $index['email'] =$row['2'];
    $index['codRopa'] =$row['3'];
    $index['cantidad'] =$row['4'];
    $index['concepto'] =$row['5'];
    $index['direccion'] =$row['6'];
    $index['subtotal'] =$row['7'];
    $index['estado'] =$row['8'];
    array_push($result['orders'], $index);

}
$result["exito"]="1";
echo json_encode($result);

?>