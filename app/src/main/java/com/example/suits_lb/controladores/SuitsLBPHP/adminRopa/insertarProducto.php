<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$codRopa = $_POST['codRopa'];
$nomRopa =$_POST['nombreRopa'];
$descripcionRopa = $_POST['descripcionRopa'];
$precioRopa = $_POST['precioRopa'];
$catRopa = $_POST['catRopa'];
$imgRopa = $_POST['imgRopa'];
$ventaDisponibleRopa = $_POST['ventaDisponibleRopa'];


// aqui escribimos codigo sql
$query ="INSERT INTO `ropa`(`codRopa`, `nombre`, `descripcion`, `precio`, `categoria`, `ventaDisponible`, `imgProducto`) VALUES ('$codRopa', 
'$nomRopa', 
'$descripcionRopa',
'$precioRopa',
'$catRopa',
'$ventaDisponibleRopa', 
'$imgRopa'
)";
$resultado =mysqli_query($conexion,$query);

if($resultado){
    echo "ropa insertada";
}else{
    echo "ropa no insertada";
}
mysqli_close($conexion);

?>