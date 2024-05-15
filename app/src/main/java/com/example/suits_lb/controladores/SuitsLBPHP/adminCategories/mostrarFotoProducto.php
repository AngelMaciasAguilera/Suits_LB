<?php 
include 'conexion.php';

$email =$_POST['email'];
$idProducto =$_POST['idProducto'];
$result= array();
$result['imagenesproducto'] =array();
$query ="SELECT * FROM imagenesproducto WHERE email LIKE '$email' AND idProducto LIKE '$idProducto'";
$response = mysqli_query($conexion,$query);
while($row = mysqli_fetch_array($response))
{
    $index['email'] =$row['0'];
    $index['idProducto'] =$row['1'];
    $index['imagenProducto'] =$row['2'];
    array_push($result['imagenesproducto'], $index);
}
$result["exito"]="1";
echo json_encode($result);

?>