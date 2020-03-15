<?php  
if (isset($_GET['word']) && !empty($_GET['word']) && !empty($_GET['antonym']) ) {

	$conn = mysqli_connect("localhost", "root", "", "android_php");
	
	if(! $conn ) {
               die('Could not connect: ' . mysql_error());
            }

    $word = $_GET['word'];
    $antonym = $_GET['antonym'];

    $sql = "INSERT INTO `testdata`(`Word`, `Antonym`) VALUES ('$word','$antonym')";

    $result = mysqli_query($conn, $sql);
            
		  if (!$result) {
		  trigger_error('Invalid query: ' . $conn->error);
		  }
		  else {
		    echo "Inserted successfully!";
		}     

}

else if ( isset($_GET['word']) && empty($_GET['word']) && empty($_GET['antonym'])) {
	header("location: test.php");
}

?>
<!DOCTYPE html>
<html>
<body>

<form action="test.php" method="get">
Word: <input type="text" name="word" /><br>
Antonym: <input type="text" name="antonym" /><br>
<button type="submit">Submit</button> 
</form>

</body>
</html>