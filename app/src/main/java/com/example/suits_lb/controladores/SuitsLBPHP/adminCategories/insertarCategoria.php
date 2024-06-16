<?php 

include 'C:\xampp\htdocs\SuitsLBPHP\conexion.php';
$codCategory = $_POST['codCategory'];
$nameCategory = $_POST['nameCategory'];

// Comprobar si el código de categoría ya está insertado
$checkQuery = "SELECT * FROM categorias WHERE codCategoria = '$codCategory'";
$checkResult = mysqli_query($conexion, $checkQuery);

if(mysqli_num_rows($checkResult) > 0){
    echo "El código de categoría ya está insertado";
} else {
    // Si el código de categoría no existe, insertar los datos
    $query = "INSERT INTO categorias(codCategoria,nombreCategoria) VALUES ('$codCategory','$nameCategory')";
    $resultado = mysqli_query($conexion, $query);

    if($resultado){
        echo "categoria insertada";
    } else {
        echo "Categoría no insertada";
    }
}

mysqli_close($conexion);

?>
