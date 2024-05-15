<?php 
include 'conexion.php';


$result= array();
$result['productos'] =array();
$email =$_POST['email'];
$query ="SELECT * FROM productos WHERE Email LIKE '$email' ";
$responce = mysqli_query($conexion,$query);

while($row = mysqli_fetch_array($responce))
{
    $index['email'] = $row['0'];
    $index['idProducto'] =$row['1'];
    $index['nombreProducto'] =$row['2'];
    $index['precio'] =$row['3'];
    

    array_push($result['productos'], $index);

}
$result["exito"]="1";
echo json_encode($result);

?>