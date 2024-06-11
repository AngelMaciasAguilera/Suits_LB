<?php 
include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';


$result= array();
$result['clientes'] =array();
$query ="SELECT * FROM clientes WHERE esAdmin LIKE 'N' ";
$responce = mysqli_query($conexion,$query);

while($row = mysqli_fetch_array($responce))
{
    $index['email'] = $row['0'];
    $index['password'] =$row['1'];
    $index['nombre'] =$row['2'];
    $index['telefono'] =$row['3'];
    $index['edad'] =$row['4'];
    $index['esAdmin'] =$row['5'];
    

    array_push($result['clientes'], $index);

}
$result["exito"]="1";
echo json_encode($result);

?>