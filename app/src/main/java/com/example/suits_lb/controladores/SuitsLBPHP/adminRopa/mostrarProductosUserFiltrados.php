<?php 
include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';


$result= array();
$result['productos'] =array();
$categoriaIntroducida = $_POST['categoriaIntroducida'];
$query ="SELECT * FROM ropa WHERE categoria LIKE '$categoriaIntroducida' ;";
$responce = mysqli_query($conexion,$query);

while($row = mysqli_fetch_array($responce))
{
    $index['codRopa'] = $row['0'];
    $index['nombre'] =$row['1'];
    $index['descripcion'] =$row['2'];
    $index['precio'] =$row['3'];
    $index['categoria'] =$row['4'];
    $index['ventaDisponible'] =$row['5'];
    $index['imgProducto'] =$row['6'];
    

    array_push($result['productos'], $index);

}
$result["exito"]="1";
echo json_encode($result);

?>