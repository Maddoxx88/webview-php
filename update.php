<?php  
if (isset($_GET['word']) || !empty($_GET['word']) || !empty($_GET['antonym'])) {

   $conn = mysqli_connect("localhost", "root", "", "android_php");
   
   if(! $conn ) {
               die('Could not connect: ' . mysql_error());
            }

    $word = $_GET['word'];
    $antonym = $_GET['antonym'];

    $sql = "UPDATE `testdata` SET `Word`= '$word', `Antonym`= '$antonym' WHERE `Word` = '$word' OR `Antonym` = '$antonym'";

    $result = mysqli_query($conn, $sql);
            
        if (!$result) {
        trigger_error('Invalid query: ' . $conn->error);
        }
        else {
          echo "Updated successfully!";
      }     
}

else if ( isset($_GET['word']) && empty($_GET['word']) && empty($_GET['antonym'])) {
   header("location: test3.php");
}
?>
<!DOCTYPE html>
<html>
<body>

<form action="test3.php" method="get">
Word: <input type="text" name="word" /><br> OR <br>
Antonym: <input type="text" name="antonym" /><br>
<button type="submit">Submit</button> 
</form>

</body>
</html>