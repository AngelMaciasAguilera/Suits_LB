<?php 
include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';


$result= array();
$result['notificaciones'] =array();
$emailUser = $_POST['emailUser'];
$query ="SELECT * FROM notificaciones WHERE email = '$emailUser'";
$responce = mysqli_query($conexion,$query);

while($row = mysqli_fetch_array($responce))
{
    $index['mensaje'] =$row['1'];

    array_push($result['notificaciones'], $index);

}
$result["exito"]="1";
echo json_encode($result);

?>