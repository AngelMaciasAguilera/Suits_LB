<?php 
include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';


$result= array();
$result['categorias'] =array();
$query ="SELECT * FROM categorias";
$responce = mysqli_query($conexion,$query);

while($row = mysqli_fetch_array($responce))
{
    $index['codCategoria'] = $row['0'];
    $index['nombreCategoria'] =$row['1'];

    array_push($result['categorias'], $index);

}
$result["exito"]="1";
echo json_encode($result);

?>